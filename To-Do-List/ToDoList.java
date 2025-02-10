import java.util.ArrayList;
import java.util.Scanner;

class Task {

    private String task;

    public Task(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task: " + task;
    }
}

public class ToDoList {
    public static ArrayList<Task> lists = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Enter your task");
            System.out.println("2. View your tasks");
            System.out.println("3. Update your task");
            System.out.println("4. Delete your task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTask();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Bye! Have a nice day.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addTask() {
        System.out.print("Enter your task: ");
        String task = scanner.nextLine();

        lists.add(new Task(task));
        System.out.println("New task has been created.");
    }

    public static void viewTask() {
        if (lists.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nList of Tasks:");
        for (int i = 0; i < lists.size(); i++) {
            System.out.println((i + 1) + ". " + lists.get(i));
        }
    }

    public static void updateTask() {
        if (lists.isEmpty()) {
            System.out.println("No tasks to update.");
            return;
        }

        viewTask();

        System.out.print("Enter the index of the task to update: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= lists.size()) {
            System.out.println("Invalid index. Please try again.");
            return;
        }

        Task task = lists.get(index);

        System.out.print("Enter the new task: ");
        String newTask = scanner.nextLine();

        if (!newTask.isEmpty()) {
            task.setTask(newTask);
            System.out.println("Task has been updated.");
        } else {
            System.out.println("Task update cancelled. No changes made.");
        }
    }

    public static void deleteTask() {
        if (lists.isEmpty()) {
            System.out.println("No tasks to delete.");
            return;
        }

        viewTask();

        System.out.print("Enter the index of the task to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= lists.size()) {
            System.out.println("Invalid index. Please try again.");
            return;
        }

        lists.remove(index);
        System.out.println("Task has been deleted.");
    }
}
