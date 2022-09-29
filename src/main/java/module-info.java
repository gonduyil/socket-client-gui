module org.gonduyil.socketclientgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires socket.io.client;
    requires lombok;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.apache.httpcomponents.core5.httpcore5;
    requires fastjson;


    opens org.gonduyil.socketclientgui to javafx.fxml;
    exports org.gonduyil.socketclientgui;
    exports org.gonduyil.socketclientgui.biz.model;
}