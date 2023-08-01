package agh.patterns.Command.Utils.Commands;

import agh.patterns.Command.Application;
import agh.patterns.Command.Editor;

public class UndoCommand extends Command {
    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        app.undo();
        return false;

    }
}