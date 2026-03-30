package cstjean.prog4.exercice6;

public class Editor {
    private String state = "";

    public String getState() {
        return state;

    }

    public void setState(String state) {
        this.state = state;

    }

    public EditorMemento createMemento() {
        return new EditorMemento(state);

    }

    public void setMemento(EditorMemento editorMemento) {
        state = editorMemento.getState();

    }

    public EditorMemento createUndo() {
        return new EditorMemento("");
    }

    public void restore(EditorMemento bookMemento) {
        //isbn = EditorMemento.getIsbn();
        //title = EditorMemento.getTitle();
        //author = EditorMemento.getAuthor();
    }
}
