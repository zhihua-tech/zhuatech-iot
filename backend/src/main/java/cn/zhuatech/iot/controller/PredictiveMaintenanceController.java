/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.controller;
import cn.zhuatech.iot.common.ApiResponse;import cn.zhuatech.iot.service.PredictiveMaintenanceService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/iot/insights/predictive-maintenance") public class PredictiveMaintenanceController {private final PredictiveMaintenanceService service;/**
                                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                              */
public PredictiveMaintenanceController(PredictiveMaintenanceService service){this.service=service;}/**
                                                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                 */
@PostMapping ApiResponse<PredictiveMaintenanceService.Result> evaluate(@Valid @RequestBody PredictiveMaintenanceService.Request request){return ApiResponse.ok(service.evaluate(request));}}
