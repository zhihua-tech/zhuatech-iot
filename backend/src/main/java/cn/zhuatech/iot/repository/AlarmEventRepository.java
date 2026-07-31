/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.iot.repository; import cn.zhuatech.iot.model.AlarmEvent; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface AlarmEventRepository extends JpaRepository<AlarmEvent,Long>{List<AlarmEvent> findTop10ByOrderByIdDesc();long countByResult(AlarmEvent.Result result);}
