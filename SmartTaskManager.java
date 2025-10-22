import java.util.*;

class Task implements Comparable<Task> {
    String title;
    int priority; // 1=High, 2=Medium, 3=Low

    Task(String title, int priority) {
        this.title = title;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    public String toString() {
        String p = switch (priority) {
            case 1 -> "High";
            case 2 -> "Medium";
            default -> "Low";
        };
        return title + " (" + p + ")";
    }
}

public class SmartTaskManager {
    public static void main(String[] args) {
        PriorityQueue<Task> tasks = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task\n2. View Next Task\n3. View All Tasks\n4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    System.out.print("Priority (1=High, 2=Medium, 3=Low): ");
                    int p = sc.nextInt();
                    tasks.add(new Task(title, p));
                    System.out.println("Task added!");
                }
                case 2 -> {
                    if (tasks.isEmpty()) System.out.println("No tasks pending!");
                    else System.out.println("Next Task: " + tasks.poll());
                }
                case 3 -> {
                    if (tasks.isEmpty()) System.out.println("No tasks!");
                    else {
                        System.out.println("All Tasks (by priority):");
                        tasks.stream().sorted().forEach(System.out::println);
                    }
                }
                case 4 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
