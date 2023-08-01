package agh.patterns.Command.Utils.Commands;

import agh.patterns.Command.Application;
import agh.patterns.Command.Editor;

public abstract class Command {

    protected Application app;
    protected Editor editor;
    protected String backup;


    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    public void undo(){
        editor.setText(backup);
    }
    public void saveBackup(){
        backup=editor.getText();
    }

    public abstract boolean execute();

}