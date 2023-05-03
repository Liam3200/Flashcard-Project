module greene.ctis310 {
    requires javafx.controls;
    requires javafx.fxml;

    opens greene.ctis310 to javafx.fxml;
    exports greene.ctis310;
}
