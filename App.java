/**
 * Class representing the TodoApp application.
 * It is the main entry point for this program.
 */
import java.util.Scanner;

public class App{
    public static void main(String[] args){
        String userChoice;
        TodoList todoList;
        String availableKeys;

        todoList = new TodoList();
        availableKeys = "[1]{1}";

        System.out.println("First run. Type in 1 to add new task");
        userChoice = "1";


        while(userChoice.matches(availableKeys)){
            System.out.println(todoList);
            printMainMenu(todoList);
            userChoice = getInput();

            if (userChoice.equals("1")){
                addItemAction(todoList);
            } else if (userChoice.equals("2")){
                removeItemAction(todoList);
            } else if (userChoice.equals("3")){
                markItemAsDoneAction(todoList);
            }
            availableKeys = "[123]{1}";
        }
    }
    public static void printMainMenu(TodoList todoList){
        if (todoList.getTodoListSize() == 0){
            System.out.println("1. Add item");
        } else {
            System.out.println("1. Add item.\n2. Remove item\n3. Mark item as done");
        }
    }
    public static void addItemAction(TodoList todoList){
        String taskName;
        TodoItem todo;
        System.out.println("Type in task name");
        taskName = getInput();
        todo = new TodoItem(taskName);
        todoList.addTodoItem(todo);
    }
    public static void removeItemAction(TodoList todoList){
        String userChoice;
        TodoItem todoItem;

        System.out.println(todoList);
        System.out.print("Which item do you want to remove?");
        userChoice = getInput();

        todoItem = pickItemAction(userChoice, todoList);
        if (todoItem != null){
            todoList.archiveTodoItem(todoItem);
            System.out.println("OK");
        }
    }
    public static void markItemAsDoneAction(TodoList todoList){
        String userChoice;
        TodoItem todoItem;

        System.out.println(todoList);
        System.out.print("Which item do you want set as done?");
        userChoice = getInput();

        todoItem = pickItemAction(userChoice, todoList);
        if (todoItem != null){
            todoItem.markAsDone();
            System.out.println("OK");
        }
    }
    private static TodoItem pickItemAction(String userChoice, TodoList todoList){
        TodoItem todoItem;
        Integer todoIndex;

        todoItem =  null;

        if (!userChoice.matches("\\d")){
            System.out.println("Input must be a number");
        } else if (Integer.parseInt(userChoice) > todoList.getTodoListSize()){
            System.out.println("Invalid input");
        } else {
            todoIndex = Integer.parseInt(userChoice) - 1;
            todoItem = todoList.getTodoItem(todoIndex);
        }
        return todoItem;
    }
    private static String getInput(){
        Scanner sysIn;
        String userChoice;

        sysIn = new Scanner(System.in);
        userChoice = sysIn.nextLine();
        return userChoice;
    }
}
