/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="iot_telemetry_record") public class TelemetryRecord extends BaseEntity {
    @ManyToOne(optional=false,fetch=FetchType.LAZY) private DeviceTask deviceTask; @Column(nullable=false,length=50) private String operationName; @Column(nullable=false) private int goodQty; @Column(nullable=false) private int defectQty;
    @Column(nullable=false,length=50) private String operatorName; @Column(nullable=false) private LocalDateTime reportedAt; @Column(length=200) private String remark;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected TelemetryRecord(){} /**
                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                   */
public TelemetryRecord(DeviceTask deviceTask,String operationName,int goodQty,int defectQty,String operatorName,String remark){this.deviceTask=deviceTask;this.operationName=operationName;this.goodQty=goodQty;this.defectQty=defectQty;this.operatorName=operatorName;this.reportedAt=LocalDateTime.now();this.remark=remark;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public DeviceTask getDeviceTask(){return deviceTask;} /**
                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                           */
public String getOperationName(){return operationName;} /**
                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                   */
public int getGoodQty(){return goodQty;} /**
                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                            */
public int getDefectQty(){return defectQty;} /**
                                                                                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                         */
public String getOperatorName(){return operatorName;} /**
                                                                                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                               */
public LocalDateTime getReportedAt(){return reportedAt;}
}
