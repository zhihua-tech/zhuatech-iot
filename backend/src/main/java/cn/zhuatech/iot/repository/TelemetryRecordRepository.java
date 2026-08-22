/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.repository; import cn.zhuatech.iot.model.TelemetryRecord; import org.springframework.data.jpa.repository.JpaRepository;
public interface TelemetryRecordRepository extends JpaRepository<TelemetryRecord,Long>{}
