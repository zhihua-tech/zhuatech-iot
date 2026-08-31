/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.iot.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceEnrollmentSecurityService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.uniqueIdentityVerified()) blockers.add("设备唯一身份未验证");
        if (!request.certificateValid()) blockers.add("设备证书无效");
        if (!request.firmwareSigned()) blockers.add("固件未通过可信签名验证");
        if (!request.secureBootEnabled()) blockers.add("设备未启用安全启动");
        if (!request.transportEncrypted()) blockers.add("遥测传输未启用加密");
        if (request.openCriticalVulnerabilities() > 0) blockers.add("设备存在未关闭的严重漏洞");
        if (!blockers.isEmpty()) {
            actions.add("拒绝生产接入并将设备保留在隔离网络");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.ownerAssigned() || !request.networkSegmentAssigned() || !request.firmwareBaselineCurrent()) {
            if (!request.ownerAssigned()) actions.add("指定设备业务与运维责任人");
            if (!request.networkSegmentAssigned()) actions.add("分配最小权限网络分区");
            if (!request.firmwareBaselineCurrent()) actions.add("升级到批准的固件安全基线");
            return new Assessment(Decision.QUARANTINE, blockers, actions);
        }
        actions.add("签发生产接入策略并记录设备可信基线");
        return new Assessment(Decision.PROVISION, blockers, actions);
    }

    public record Request(@NotBlank String deviceId, boolean uniqueIdentityVerified,
                          boolean certificateValid, boolean firmwareSigned,
                          boolean secureBootEnabled, boolean transportEncrypted,
                          @Min(0) int openCriticalVulnerabilities, boolean ownerAssigned,
                          boolean networkSegmentAssigned, boolean firmwareBaselineCurrent) {}
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    public enum Decision { PROVISION, QUARANTINE, BLOCKED }
}
