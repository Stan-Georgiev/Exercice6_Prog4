package cstjean.prog4.exercice6;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Gestion de l'écran principal.
 *
 * @author TODO
 */
public class MainController {
    EditorCaretaker caretaker = new EditorCaretaker();
    Editor editor = new Editor();


    /**
     * ...
     */
    @FXML
    private Button btnUndo;

    /**
     * ...
     */
    @FXML
    private Button btnRedo;

    /**
     * ...
     */
    @FXML
    private TextArea textArea;

    /**
     * ...
     */
    public MainController() {
        // ...
    }

    /**
     * ...
     */
    @FXML
    protected void onUndo() {
        caretaker.getHistory();
        caretaker.save(editor);
    }

    /**
     * ...
     */
    @FXML
    protected void onRedo() {
        // ...
    }

    /**
     * ...
     */
    @FXML
    protected void onKeyTyped() {
        caretaker.save(editor);
        if (caretaker.getHistory().size() > 0) {
            btnUndo.setDisable(false);
        } else  {
            btnUndo.setDisable(true);
        }
    }
}