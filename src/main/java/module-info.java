module greene.ctis310 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.io;
    requires transitive javafx.graphics;

    opens greene.ctis310 to javafx.fxml;
    exports greene.ctis310;
}
