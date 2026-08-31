# 企业级 IoT 设备安全接入

[知华科技（上海如静知华信息科技有限公司）](https://www.zhuatech.cn/)为 IoT 开源版增加零信任式设备接入门禁。

`POST /api/enterprise/iot/device-enrollment-security` 校验设备身份、证书、固件签名、安全启动、传输加密、严重漏洞、责任人、网络分区和固件基线，返回 `PROVISION / QUARANTINE / BLOCKED`。

生产应用应对接企业 PKI、设备证书轮换、漏洞情报、网络准入控制和审计平台，并在设备状态变化时重新评估。
