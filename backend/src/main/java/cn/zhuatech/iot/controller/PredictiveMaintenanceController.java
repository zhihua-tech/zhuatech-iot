/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.iot.controller;
import cn.zhuatech.iot.common.ApiResponse;import cn.zhuatech.iot.service.PredictiveMaintenanceService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/iot/insights/predictive-maintenance") public class PredictiveMaintenanceController {private final PredictiveMaintenanceService service;public PredictiveMaintenanceController(PredictiveMaintenanceService service){this.service=service;}@PostMapping ApiResponse<PredictiveMaintenanceService.Result> evaluate(@Valid @RequestBody PredictiveMaintenanceService.Request request){return ApiResponse.ok(service.evaluate(request));}}
