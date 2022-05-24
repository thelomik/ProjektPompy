module com.pompy.projektpompy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.pompy.projektpompy to javafx.fxml;
    exports com.pompy.projektpompy;
}