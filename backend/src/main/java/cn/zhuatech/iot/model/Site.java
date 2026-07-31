/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.iot.model;
import jakarta.persistence.*;
@Entity @Table(name="iot_site") public class Site extends BaseEntity {
    @Column(nullable=false,unique=true,length=32) private String code; @Column(nullable=false,length=80) private String name;
    @Column(nullable=false,length=60) private String workshop; @Column(nullable=false) private int plannedCapacity; @Column(nullable=false) private boolean active=true;
    protected Site(){} public Site(String code,String name,String workshop,int plannedCapacity){this.code=code;this.name=name;this.workshop=workshop;this.plannedCapacity=plannedCapacity;}
    public String getCode(){return code;} public String getName(){return name;} public String getWorkshop(){return workshop;} public int getPlannedCapacity(){return plannedCapacity;} public boolean isActive(){return active;}
}
