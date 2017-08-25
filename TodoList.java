/**
 * Class representing a todo list.
 * TodoList object should aggregate TodoItem objects.
 */
import java.util.ArrayList;
import java.lang.StringBuilder;

public class TodoList{
    private ArrayList<TodoItem> todoItemsCollection;

    public TodoList(){
        this.todoItemsCollection = new ArrayList<TodoItem>();
    }
    public void addTodoItem(TodoItem todo){
        this.todoItemsCollection.add(todo);
    }
    public void archiveTodoItem(TodoItem todo){
        this.todoItemsCollection.remove(todo);
    }
    public int getTodoListSize(){
        return this.todoItemsCollection.size();
    }
    public TodoItem getTodoItem(int index){
        return this.todoItemsCollection.get(index);
    }
    public String toString(){
        StringBuilder builder;
        String line;
        int orderNumber;

        builder = new StringBuilder();

        orderNumber = 1;
        for(TodoItem todo : this.todoItemsCollection){
            line = String.format("%d. %s\n", orderNumber, todo);
            builder.append(line);
            orderNumber++;
        }
        return builder.toString();
    }
}
