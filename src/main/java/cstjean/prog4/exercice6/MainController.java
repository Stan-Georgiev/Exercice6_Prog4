package cstjean.prog4.exercice6;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

public class MainController {

    private final EditorCaretaker caretaker = new EditorCaretaker();
    private final Editor editor = new Editor();

    private final Logger logger = new Logger();
    private final ConsoleLogger cLogger = new ConsoleLogger(Logger.INFO | Logger.WARNING);
    private final FileLogger fLogger = new FileLogger(Logger.WARNING | Logger.ERROR);

    private final PauseTransition pause = new PauseTransition(Duration.millis(500));
    private String lastSaved = "";

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnRedo;

    @FXML
    private TextArea textArea;

    public MainController() {

    }

    @FXML
    public void initialize() {
        logger.addLogger(cLogger);
        logger.addLogger(fLogger);

        pause.setOnFinished(e -> {
            String text = textArea.getText();

            if (!text.equals(lastSaved)) {
                editor.setState(text);
                caretaker.save(editor);
                lastSaved = text;

                updateButtons();

                logger.log(text, Logger.INFO | Logger.WARNING);
                System.out.println("Saved: " + text);
            }
        });

        updateButtons();
    }

    @FXML
    protected void onKeyTyped() {
        pause.playFromStart();
    }

    @FXML
    protected void onUndo() {
        caretaker.undo(editor);
        textArea.setText(editor.getState());

        updateButtons();

        logger.log("UNDO", Logger.INFO);
    }

    @FXML
    protected void onRedo() {
        caretaker.redo(editor);
        textArea.setText(editor.getState());

        updateButtons();

        logger.log("REDO", Logger.WARNING);
    }

    private void updateButtons() {
        btnUndo.setDisable(caretaker.getHistory().size() <= 1);
        btnRedo.setDisable(caretaker.getCurrentIndex() >= caretaker.getHistory().size() - 1);
    }
}