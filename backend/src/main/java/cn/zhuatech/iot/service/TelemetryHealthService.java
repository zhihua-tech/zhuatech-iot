/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.iot.service;
import jakarta.validation.constraints.*; import org.springframework.stereotype.Service; import java.util.ArrayList; import java.util.List;
@Service public class TelemetryHealthService {
    public Result evaluate(Request r){
        double availability=r.expectedMessages()==0?0:Math.min(100,r.receivedMessages()*100.0/r.expectedMessages());
        double errorRate=r.receivedMessages()==0?100:r.errorMessages()*100.0/r.receivedMessages();
        double latencyScore=Math.max(0,100-r.averageLatencyMs()/20.0);
        double score=availability*.45+Math.max(0,100-errorRate)*.20+latencyScore*.15+r.batteryPercent()*.10+r.signalStrength()*.10;
        if(r.lastSeenMinutes()>30)score=Math.min(score,35); score=Math.max(0,Math.min(100,score));
        String status=r.lastSeenMinutes()>30||r.receivedMessages()==0?"OFFLINE":score<60||r.batteryPercent()<10||errorRate>10?"CRITICAL":score<85||r.averageLatencyMs()>1000||r.signalStrength()<40?"DEGRADED":"HEALTHY";
        List<String> actions=new ArrayList<>(); if(r.lastSeenMinutes()>30)actions.add("检查设备供电、网络与网关连接"); if(errorRate>5)actions.add("分析遥测解析和协议错误"); if(r.batteryPercent()<20)actions.add("安排电池更换或充电"); if(r.signalStrength()<40)actions.add("优化现场信号覆盖");
        return new Result(round(availability),round(errorRate),round(score),status,actions);
    }
    private double round(double v){return Math.round(v*100)/100.0;}
    public record Request(@NotBlank String deviceId,@Min(0) int expectedMessages,@Min(0) int receivedMessages,@Min(0) int errorMessages,
        @Min(0) int averageLatencyMs,@Min(0) @Max(100) int batteryPercent,@Min(0) @Max(100) int signalStrength,@Min(0) int lastSeenMinutes){}
    public record Result(double availabilityPercent,double errorRatePercent,double healthScore,String status,List<String> actions){}
}

