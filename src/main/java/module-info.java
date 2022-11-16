module org.arobase.pizza {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.arobase.pizza to javafx.fxml;
    exports org.arobase.pizza;
}