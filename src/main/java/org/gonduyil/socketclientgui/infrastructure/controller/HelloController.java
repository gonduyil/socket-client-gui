package org.gonduyil.socketclientgui.infrastructure.controller;

import io.socket.client.Socket;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.gonduyil.socketclientgui.biz.model.SocketInstance;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.net.URISyntaxException;

public class HelloController {



    @FXML
    private Label welcomeText;
    @FXML
    private Button connectButton;

    private Boolean open = false;

    public HelloController() {
        EventBus.getDefault().register(this);
    }

    @FXML
    protected void onHelloButtonClick() throws URISyntaxException {
        open = !open;
        Socket socket = SocketInstance.INSTANCE.getSocket();

        if (open) {
            socket.connect();
        } else {
            socket.disconnect();
        }

    }

    @Subscribe()
    public void onMessageEvent(SocketInstance.OpenEvent event) {
        connectButton.setText("断开");
    }

    @Subscribe()
    public void onMessageEvent(SocketInstance.CloseEvent event) {
        connectButton.setText("连接");
    }


}