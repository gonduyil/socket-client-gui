package org.gonduyil.socketclientgui;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.socket.client.IO;
import io.socket.client.Socket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.apache.hc.core5.net.URIBuilder;
import org.gonduyil.socketclientgui.biz.model.ConnectParams;
import org.gonduyil.socketclientgui.infrastructure.UriUtil;

import java.net.URISyntaxException;

public class HelloController {


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws URISyntaxException {
        String domian = "http://ailearn-instruction-proxy-svr.ailearn.ink?";


        ConnectParams connectParams = ConnectParams.builder()
                .withSystemId(Long.valueOf("110110110"))
                .withTty(1).withLoginType(1).withUserType(1).withToken("WhoAllowedYouPass").withRole("S").withDeviceVersion("1").withAppVersion("1")
                .build();

        String uri = UriUtil.javaObjectToUriString(connectParams);
        System.out.println("uri: " + uri);

        Socket socket = IO.socket(domian + uri, new IO.Options());

        welcomeText.setText("Welcome to JavaFX Application!");
    }

    /**
     * 建立链接
     *
     * @param actionEvent
     */
    public void onCollectButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("test");
    }
}