/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.iot;
import cn.zhuatech.iot.service.PredictiveMaintenanceService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class PredictiveMaintenanceServiceTests {private final PredictiveMaintenanceService service=new PredictiveMaintenanceService();/**
                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                */
@Test void shutsDownOverheatingVibratingDevice(){var r=service.evaluate(new PredictiveMaintenanceService.Request("D1",1.8,90,80,5,100,90,15));assertEquals("SHUTDOWN",r.status());}/**
                                                                                                                                                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                   */
@Test void acceptsHealthyDevice(){var r=service.evaluate(new PredictiveMaintenanceService.Request("D2",1.0,50,80,0,20,90,90));assertEquals("HEALTHY",r.status());}}
