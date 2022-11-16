module org.arobase.pizza {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.arobase.pizza to javafx.fxml;
    exports org.arobase.pizza;
    exports org.arobase.pizza.vue;
    opens org.arobase.pizza.vue to javafx.fxml;
}