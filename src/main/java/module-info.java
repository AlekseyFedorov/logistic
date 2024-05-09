module ru.ixsys.logistic {
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
    requires java.sql;
    requires java.sql.rowset;

    opens ru.ixsys.logistic to javafx.fxml;
    exports ru.ixsys.logistic;
    exports ru.ixsys.logistic.controllers;
    opens ru.ixsys.logistic.controllers to javafx.fxml;
}