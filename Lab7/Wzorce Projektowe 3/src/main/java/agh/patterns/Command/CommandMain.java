package agh.patterns.Command;

import agh.patterns.Command.Utils.Commands.CopyCommand;
import agh.patterns.Command.Utils.Commands.CutCommand;
import agh.patterns.Command.Utils.Commands.PasteCommand;
import agh.patterns.Command.Utils.History.CommandHistory;

import java.util.ArrayList;
import java.util.List;

public class CommandMain {
    public static void main(String[] args) {
        CommandHistory commandHistory = new CommandHistory();
        Editor editor1 = new Editor("text1");
        Editor editor2 = new Editor("text2");
        List<Editor> editors = new ArrayList<>();
        editors.add(editor1);
        editors.add(editor2);
        Application app = new Application("clipboard", editors, editor1, commandHistory);

        executeCommands(app);

        printappstate(app);

        executeUndoCommands(app);

        printappstate(app);

        executeEditorsUndoCommands(app);

        printeditorsstate(app);
    }

    private static void executeCommands(Application app) {
        app.executeCommand(new PasteCommand(app, app.getActiveEditor()));
        app.getActiveEditor().replaceSelection("Test2");
        app.executeCommand(new CutCommand(app, app.getActiveEditor()));
        app.getActiveEditor().replaceSelection("Test3");
        app.executeCommand(new CopyCommand(app, app.getActiveEditor()));
    }

    private static void executeUndoCommands(Application app) {
        app.undo();
        app.undo();
    }

    private static void executeEditorsUndoCommands(Application app) {
        app.setActiveEditor(app.getEditors().get(1));
        app.executeCommand(new PasteCommand(app, app.getActiveEditor()));
        app.getActiveEditor().replaceSelection("Test4");
        app.executeCommand(new CopyCommand(app, app.getActiveEditor()));
        app.getActiveEditor().replaceSelection("Test5");
        app.executeCommand(new CutCommand(app, app.getActiveEditor()));
        app.setActiveEditor(app.getEditors().get(0));
    }

    private static void printappstate(Application app) {
        Editor editors = app.getActiveEditor();
        System.out.println("Clipboard: " + app.getClipboard() + "   Selection: " + editors.getSelection());
    }

    private static void printeditorsstate(Application app) {
        List<Editor> editors = app.getEditors();
        for (int i = 0; i < editors.size(); i++) {
            Editor e = editors.get(i);
            app.setActiveEditor(e);
            System.out.println("Editor " + (i + 1) + ":");
            printappstate(app);
        }
        app.setActiveEditor(app.getActiveEditor());
    }
}
