package org.gonduyil.socketclientgui.biz.model;

public record RegisterReq (Long userId,
                           String role,
                           String deviceVersion,
                           String token,
                           Integer tty
                           ){
}
