module com.pompy.projektpompy {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.kordamp.ikonli.javafx;
    requires lombok;

    opens com.pompy.projektpompy to javafx.fxml;
    exports com.pompy.projektpompy;
}