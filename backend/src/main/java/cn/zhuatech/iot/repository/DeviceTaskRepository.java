/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.iot.repository; import cn.zhuatech.iot.model.DeviceTask; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface DeviceTaskRepository extends JpaRepository<DeviceTask,Long>{List<DeviceTask> findAllByOrderByDueDateAsc();List<DeviceTask> findBySiteCodeOrderByDueDateAsc(String code);long countByStatus(DeviceTask.Status status);}
