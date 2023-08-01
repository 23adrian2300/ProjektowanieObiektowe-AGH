package agh.patterns.Command;


public class Editor {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Editor(String text) {
        this.text = text;
    }

    public String getSelection(){
        return text;
    }

    public void deleteSelection(){
        System.out.println(text + " is deleted");
        text = "";
    }

    public void replaceSelection(String toReplace){
        System.out.println("Replaced " + text + " to " + toReplace);
        text = toReplace;
    }

}