package org.gonduyil.socketclientgui.biz.model;

import com.alibaba.fastjson.JSON;
import io.socket.client.IO;
import io.socket.client.Manager;
import io.socket.client.Socket;
import javafx.application.Platform;
import org.gonduyil.socketclientgui.infrastructure.util.UriUtil;
import org.greenrobot.eventbus.EventBus;

import java.net.URISyntaxException;

public enum SocketInstance {
    INSTANCE;

    private final Socket socket;
    SocketInstance() {
        String domian = "http://ailearn-instruction-proxy-svr.ailearn.ink?";

        ConnectParams connectParams = ConnectParams.builder()
                .withSystemId(Long.valueOf("110110110"))
                .withTty(1).withLoginType(1).withUserType(1).withToken("WhoAllowedYouPass").withRole("S").withDeviceVersion("1").withAppVersion("1")
                .build();

        String uri = null;
        try {
            uri = UriUtil.javaObjectToUriString(connectParams);
            String url = domian + uri;
            System.out.println(url);
            this.socket = IO.socket(url, new IO.Options());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        socket.on("connect", args -> {
            Platform.runLater(() -> EventBus.getDefault().post(new OpenEvent()));

        });

        socket.on(Manager.EVENT_CLOSE, args -> {
            // 用来解决非fx线程调用fx相关事件问题.
            Platform.runLater(() -> EventBus.getDefault().post(new CloseEvent()));
        });

        socket.on(Manager.EVENT_PING, args -> {
            System.out.println("ping:"+ JSON.toJSONString(args));
        });
        socket.on(Manager.EVENT_PONG, args -> {
            System.out.println("pong:"+ JSON.toJSONString(args));
        });
    }

    public Socket getSocket() {
        return socket;
    }

    public static class OpenEvent {

    }

    public static class CloseEvent {

    }

}
