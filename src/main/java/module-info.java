module com.example.prism {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.prism to javafx.fxml;
    exports com.example.prism;
    exports com.example.prism.controllers;
    opens com.example.prism.controllers to javafx.fxml;
}