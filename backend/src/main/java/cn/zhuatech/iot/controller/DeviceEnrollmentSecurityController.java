/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.controller;

import cn.zhuatech.iot.common.ApiResponse;
import cn.zhuatech.iot.service.DeviceEnrollmentSecurityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/iot")
public class DeviceEnrollmentSecurityController {
    private final DeviceEnrollmentSecurityService service;
    public DeviceEnrollmentSecurityController(DeviceEnrollmentSecurityService service) { this.service = service; }

    @PostMapping("/device-enrollment-security")
    public ApiResponse<DeviceEnrollmentSecurityService.Assessment> assess(
        @Valid @RequestBody DeviceEnrollmentSecurityService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
