/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.dto;
import jakarta.validation.constraints.*; import java.time.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public final class IotDto { /**
                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                             */
private IotDto(){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Metric(String label,String value,String hint,String tone){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record DeviceTaskView(Long id,String orderNo,String productCode,String productName,String site,String workshop,int plannedQty,int completedQty,int defectQty,LocalDate dueDate,String status,String batchNo,int progress){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record DeviceView(String code,String name,String site,String status,int oee,LocalDateTime lastHeartbeat){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record AlarmEventView(String alarmEventNo,String orderNo,String productName,String alarmEventType,int sampleQty,int defectQty,String result,String inspector){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Dashboard(List<Metric> metrics,List<DeviceTaskView> deviceTasks,List<DeviceView> device,List<AlarmEventView> alarmEvents){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ReportRequest(@NotBlank String operationName,@Positive int goodQty,@PositiveOrZero int defectQty,@Size(max=200) String remark){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ReportResult(String orderNo,int completedQty,int defectQty,int progress,String status){}
}
