package cstjean.prog4.exercice6;

import java.util.ArrayList;
import java.util.List;

public class EditorCaretaker {
    private final List<EditorMemento> history = new ArrayList<>();

    public void save(Editor editor) {
        history.add(editor.createUndo());
    }
    public void restore(Editor editor, int index) {
        editor.restore(history.get(index));
    }

    public void restore(Editor editor) {
        this.restore(editor, history.size() - 1);
    }
}
