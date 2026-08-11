/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.iot.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
@Service public class PredictiveMaintenanceService {
 public Result evaluate(Request r){int score=0;List<String> signals=new ArrayList<>();if(r.vibrationRatio()>=1.5){score+=50;signals.add("振动显著超过健康基线");}else if(r.vibrationRatio()>=1.2){score+=25;signals.add("振动趋势上升");}if(r.temperatureCelsius()>=r.temperatureLimit()){score+=45;signals.add("设备温度超过阈值");}score+=Math.min(30,r.errorEvents24Hours()*5);if(r.daysSinceMaintenance()>=r.maintenanceIntervalDays()){score+=25;signals.add("预防性维护周期已到期");}if(r.batteryLevel()<20){score+=20;signals.add("设备电量过低");}score=Math.min(100,score);String status=score>=80?"SHUTDOWN":score>=35?"SCHEDULE":"HEALTHY";if(signals.isEmpty())signals.add("遥测指标处于健康基线内");return new Result(score,status,signals);}
 public record Request(@NotBlank String deviceId,@DecimalMin("0") double vibrationRatio,double temperatureCelsius,double temperatureLimit,@Min(0) int errorEvents24Hours,@Min(0) int daysSinceMaintenance,@Min(1) int maintenanceIntervalDays,@Min(0) @Max(100) int batteryLevel){}
 public record Result(int maintenanceRisk,String status,List<String> signals){}
}
