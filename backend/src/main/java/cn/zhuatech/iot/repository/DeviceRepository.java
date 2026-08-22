/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.repository; import cn.zhuatech.iot.model.Device; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface DeviceRepository extends JpaRepository<Device,Long>{List<Device> findAllByOrderByCodeAsc();long countByStatus(Device.Status status);}
