/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.repository; import cn.zhuatech.iot.model.Site; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface SiteRepository extends JpaRepository<Site,Long>{Optional<Site> findByCode(String code);}
