module nl.inholland.javafx.endassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens nl.inholland.javafx.endassignment to javafx.fxml;
    exports nl.inholland.javafx.endassignment;
}