package agh.patterns.Command.Utils.Commands;

import agh.patterns.Command.Application;
import agh.patterns.Command.Editor;

public class CopyCommand extends Command {
    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        app.setClipboard(editor.getSelection());
        return false;
    }
}