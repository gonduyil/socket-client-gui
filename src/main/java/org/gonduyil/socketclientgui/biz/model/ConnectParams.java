package org.gonduyil.socketclientgui.biz.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class ConnectParams {

    private Long systemId;

    private Integer tty;

    private Integer loginType;

    private Integer userType;

    private String token;

    private String role;

    private String deviceVersion;

    private String appVersion;

}
