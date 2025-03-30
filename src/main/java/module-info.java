module com.aipo.tcgcollector {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sdk;
    requires java.net.http;
    requires com.google.gson;

    opens com.aipo.tcgcollector to javafx.fxml;
    exports com.aipo.tcgcollector;
    exports com.aipo.tcgcollector.controllers;
    exports com.aipo.tcgcollector.services;
    opens com.aipo.tcgcollector.controllers to javafx.fxml;
}