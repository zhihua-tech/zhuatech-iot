/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class DeviceEnrollmentSecurityServiceTest {
    private final DeviceEnrollmentSecurityService service = new DeviceEnrollmentSecurityService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void provisionsTrustedGovernedDevice() {
        var result = service.assess(new DeviceEnrollmentSecurityService.Request(
            "DEV-001", true, true, true, true, true, 0, true, true, true));
        assertThat(result.decision()).isEqualTo(DeviceEnrollmentSecurityService.Decision.PROVISION);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUntrustedVulnerableDevice() {
        var result = service.assess(new DeviceEnrollmentSecurityService.Request(
            "DEV-002", false, false, false, false, false, 3, true, true, true));
        assertThat(result.decision()).isEqualTo(DeviceEnrollmentSecurityService.Decision.BLOCKED);
        assertThat(result.blockers()).hasSize(6);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void quarantinesGovernanceGaps() {
        var result = service.assess(new DeviceEnrollmentSecurityService.Request(
            "DEV-003", true, true, true, true, true, 0, false, false, false));
        assertThat(result.decision()).isEqualTo(DeviceEnrollmentSecurityService.Decision.QUARANTINE);
        assertThat(result.actions()).hasSize(3);
    }
}
