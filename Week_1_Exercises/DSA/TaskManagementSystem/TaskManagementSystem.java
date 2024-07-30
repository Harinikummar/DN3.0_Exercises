package TaskManagementSystem;

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        Task task1 = new Task(101, "Task 1", "Completed");
        Task task2 = new Task(102, "Task 2", "In process");
        Task task3 = new Task(103, "Task 3", "Pending");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        System.out.println("Traverse tasks:");
        taskList.traverse();

        System.out.println("\nSearch for task with ID 102:");
        Task searchResult = taskList.searchTask(102);
        if (searchResult != null) {
            System.out.println("Found:" + searchResult);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDelete task with ID 101:");
        boolean isDeleted = taskList.deleteTask(101);
        System.out.println("Deleted:" + isDeleted);

        System.out.println("\nTraverse tasks after deletion:");
        taskList.traverse();
    }
}

