/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.iot;
import cn.zhuatech.iot.service.PredictiveMaintenanceService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class PredictiveMaintenanceServiceTests {private final PredictiveMaintenanceService service=new PredictiveMaintenanceService();@Test void shutsDownOverheatingVibratingDevice(){var r=service.evaluate(new PredictiveMaintenanceService.Request("D1",1.8,90,80,5,100,90,15));assertEquals("SHUTDOWN",r.status());}@Test void acceptsHealthyDevice(){var r=service.evaluate(new PredictiveMaintenanceService.Request("D2",1.0,50,80,0,20,90,90));assertEquals("HEALTHY",r.status());}}
