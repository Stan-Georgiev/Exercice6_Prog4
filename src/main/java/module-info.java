module cstjean.prog4.exercice6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens cstjean.prog4.exercice6 to javafx.fxml;
    exports cstjean.prog4.exercice6;
}