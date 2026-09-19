/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.controller; import cn.zhuatech.iot.common.ApiResponse; import cn.zhuatech.iot.dto.IotDto.*; import cn.zhuatech.iot.service.IotService; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin") @PreAuthorize("hasAnyRole('DEVICE_MANAGER','QUALITY','ADMIN')") public class IoTAdminController {private final IotService iot;/**
                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                             */
public IoTAdminController(IotService iot){this.iot=iot;}/**
                                                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                     */
@GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(iot.adminDashboard());}/**
                                                                                                                                                                                                                                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                      */
@GetMapping("/work-orders") public ApiResponse<List<DeviceTaskView>> orders(){return ApiResponse.ok(iot.deviceTasks());}}
