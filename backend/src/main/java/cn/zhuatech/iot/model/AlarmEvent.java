/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="iot_alarm_event") public class AlarmEvent extends BaseEntity {
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String alarmEventNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private DeviceTask deviceTask;
    @Column(nullable=false,length=30) private String alarmEventType; @Column(nullable=false) private int sampleQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    protected AlarmEvent(){} public AlarmEvent(String alarmEventNo,DeviceTask deviceTask,String alarmEventType,int sampleQty,int defectQty,Result result,String inspector){this.alarmEventNo=alarmEventNo;this.deviceTask=deviceTask;this.alarmEventType=alarmEventType;this.sampleQty=sampleQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    public String getAlarmEventNo(){return alarmEventNo;} public DeviceTask getDeviceTask(){return deviceTask;} public String getAlarmEventType(){return alarmEventType;} public int getSampleQty(){return sampleQty;} public int getDefectQty(){return defectQty;} public Result getResult(){return result;} public String getInspector(){return inspector;}
}
