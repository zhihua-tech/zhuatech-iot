/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.config;

import cn.zhuatech.iot.model.*;
import cn.zhuatech.iot.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seed(SiteRepository sites, DeviceTaskRepository tasks, DeviceRepository devices,
                           AlarmEventRepository alarms, UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (sites.count() > 0) return;
            Site factory = sites.save(new Site("SITE-SH-01", "上海智能工厂", "制造事业部", 3600));
            Site warehouse = sites.save(new Site("SITE-WH-02", "华东中心仓", "供应链中心", 1800));
            Site energy = sites.save(new Site("SITE-EN-01", "能源动力站", "设备保障部", 960));

            DeviceTask t1 = tasks.save(new DeviceTask("TASK-260801-018", "RULE-VIB-04", "关键电机振动巡检", factory, 120, 86, 3, LocalDate.now().plusDays(1), DeviceTask.Status.RUNNING, "EDGE-A1"));
            DeviceTask t2 = tasks.save(new DeviceTask("TASK-260801-021", "FW-GW-2.7", "仓库网关固件升级", warehouse, 48, 32, 1, LocalDate.now().plusDays(2), DeviceTask.Status.RUNNING, "EDGE-W2"));
            DeviceTask t3 = tasks.save(new DeviceTask("TASK-260802-006", "CAL-METER", "蒸汽流量计远程校准", energy, 26, 0, 0, LocalDate.now().plusDays(3), DeviceTask.Status.RELEASED, "EDGE-E1"));
            DeviceTask t4 = tasks.save(new DeviceTask("TASK-260731-015", "SYNC-TIME", "产线终端时钟同步", factory, 180, 180, 2, LocalDate.now(), DeviceTask.Status.COMPLETED, "EDGE-A1"));

            devices.saveAll(List.of(
                new Device("DEV-CNC-027", "五轴加工中心采集器", factory, Device.Status.RUNNING, 96),
                new Device("DEV-GW-WH02", "仓储 LoRaWAN 网关", warehouse, Device.Status.RUNNING, 91),
                new Device("DEV-MTR-018", "蒸汽主管流量计", energy, Device.Status.ALARM, 63),
                new Device("DEV-ENV-064", "库区温湿度终端", warehouse, Device.Status.IDLE, 78)
            ));
            alarms.saveAll(List.of(
                new AlarmEvent("ALM-260801-032", t1, "振动越限", 6, 1, AlarmEvent.Result.FAILED, "边缘规则引擎"),
                new AlarmEvent("ALM-260801-011", t2, "设备离线", 3, 0, AlarmEvent.Result.PASSED, "平台巡检"),
                new AlarmEvent("ALM-260731-018", t4, "时钟漂移", 8, 0, AlarmEvent.Result.PASSED, "平台巡检"),
                new AlarmEvent("ALM-260802-003", t3, "校准待确认", 2, 0, AlarmEvent.Result.PENDING, "陆承")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "陆承", UserAccount.Role.FIELD_ENGINEER, "SITE-SH-01"),
                new UserAccount("planner", demo, "沈清和", UserAccount.Role.DEVICE_MANAGER, null),
                new UserAccount("quality", demo, "周妍", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
