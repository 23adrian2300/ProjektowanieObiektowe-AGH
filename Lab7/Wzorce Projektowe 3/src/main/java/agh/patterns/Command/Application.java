package agh.patterns.Command;


import agh.patterns.Command.Utils.Commands.*;
import agh.patterns.Command.Utils.History.CommandHistory;

import java.util.List;

public class Application {

    private String clipboard;
    private List<Editor> editors;
    private Editor activeEditor;
    private CommandHistory history;

    public Application(String clipboard, List<Editor> editors, Editor activeEditor, CommandHistory history) {
        this.clipboard = clipboard;
        this.editors = editors;
        this.activeEditor = activeEditor;
        this.history = history;
    }

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    public List<Editor> getEditors() {
        return editors;
    }

    public void setEditors(List<Editor> editors) {
        this.editors = editors;
    }

    public Editor getActiveEditor() {
        return activeEditor;
    }

    public void setActiveEditor(Editor activeEditor) {
        this.activeEditor = activeEditor;
    }

    public CommandHistory getHistory() {
        return history;
    }

    public void setHistory(CommandHistory history) {
        this.history = history;
    }

    public void createUI() {

        executeCommand(new CopyCommand(this, activeEditor));

        executeCommand(new CutCommand(this, activeEditor));

        executeCommand(new PasteCommand(this, activeEditor));

        executeCommand(new UndoCommand(this, activeEditor));

    }

    public void executeCommand(Command command) {

        if (command.execute())
            history.push(command);
    }


    public void undo() {

        Command command = history.pop();
        if (command != null)
            command.undo();
    }

}