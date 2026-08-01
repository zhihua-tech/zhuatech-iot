/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.iot.controller;
import cn.zhuatech.iot.common.ApiResponse; import cn.zhuatech.iot.service.TelemetryHealthService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/admin") public class TelemetryHealthController {private final TelemetryHealthService service; public TelemetryHealthController(TelemetryHealthService service){this.service=service;} @PostMapping("/telemetry-health") public ApiResponse<TelemetryHealthService.Result> evaluate(@Valid @RequestBody TelemetryHealthService.Request request){return ApiResponse.ok(service.evaluate(request));}}
