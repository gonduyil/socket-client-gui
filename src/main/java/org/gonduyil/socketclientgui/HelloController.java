package org.gonduyil.socketclientgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import org.gonduyil.socketclientgui.biz.model.ConnectParams;

import java.net.URISyntaxException;

public class HelloController {



    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws URISyntaxException {
        String url = "";
        Socket socket = IO.socket(url, new IO.Options());


        ConnectParams connectParams = ConnectParams.builder()
                .withSystemId(Long.valueOf("110110110"))
                .withTty(1).withLoginType(1).withUserType(1).withToken("").withRole("S").withDeviceVersion("1").withAppVersion("1")
                .build();


        welcomeText.setText("Welcome to JavaFX Application!");
    }
}