/**
 * Class representing a single todo item.
 *
 */
public class TodoItem{
    private String name;
    private Boolean isDone;

    public TodoItem(String name){
        this.name = name;
        this.isDone = false;
    }
    public void markAsDone(){
        this.isDone = true;
    }
    public String toString(){
        String mark;

        if (this.isDone){
            mark = "[x]";
        } else {
            mark = "[ ]";
        }
        return String.format("%s %s", mark, this.name);
    }
}
