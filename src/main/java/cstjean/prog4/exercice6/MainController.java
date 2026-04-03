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
        caretaker.undo(editor);
        textArea.setText(editor.getState());

        btnUndo.setDisable(caretaker.getCurrentIndex() <= 0);
        btnRedo.setDisable(false);
    }

    /**
     * ...
     */
    @FXML
    protected void onRedo() {
        caretaker.redo(editor);
        textArea.setText(editor.getState());

        btnRedo.setDisable(caretaker.getCurrentIndex() >= caretaker.getHistory().size() - 1);
        btnUndo.setDisable(false);
    }

    /**
     * ...
     */
    @FXML
    protected void onKeyTyped() {
        String text = textArea.getText();

        if (text.endsWith(" ") || text.endsWith("\n")) {
            editor.setState(text);
            caretaker.save(editor);

            btnUndo.setDisable(caretaker.getCurrentIndex() <= 0);
            btnRedo.setDisable(true);

            System.out.println("Saved: " + text);
        }
    }
}