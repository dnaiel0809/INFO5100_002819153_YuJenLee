module com.example.imagemanagementtool {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.imagemanagementtool to javafx.fxml;
    exports com.example.imagemanagementtool;
}