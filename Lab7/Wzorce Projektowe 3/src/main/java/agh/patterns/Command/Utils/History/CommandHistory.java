package agh.patterns.Command.Utils.History;


import agh.patterns.Command.Utils.Commands.Command;


import java.util.Stack;

public class CommandHistory {

    private final Stack<Command> history=new Stack<>();

    public void push(Command c){
        history.push(c);
    }

    public Command pop(){
        if (!history.isEmpty()) {
            return history.pop();
        } else {
            return null;
        }
    }
}