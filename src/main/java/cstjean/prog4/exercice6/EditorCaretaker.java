package cstjean.prog4.exercice6;

import java.util.ArrayList;
import java.util.List;

public class EditorCaretaker {
    private final List<EditorMemento> history = new ArrayList<>(19);
    private int currentIndex = -1;

    public void save(Editor editor) {
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }

        if (history.size() == 20) {
            history.remove(0);
            currentIndex--;
        }

        history.add(editor.createMemento());
        currentIndex++;
    }

    public void undo(Editor editor) {
        if (currentIndex > 0) {
            currentIndex--;
            editor.restore(history.get(currentIndex));
        }
    }

    public void redo(Editor editor) {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            editor.restore(history.get(currentIndex));
        }
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
    public void restore(Editor editor, int index) {
        editor.restore(history.get(index));
    }

    public void restore(Editor editor) {
        this.restore(editor, history.size() - 1);
    }

    public List<EditorMemento> getHistory() {
        return history;
    }
}
