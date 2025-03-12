package assignment12_03_2025;
import java.util.*;

class Task implements Comparable<Task> {
    String name;
    int priority;
    int duration;

    public Task(String name, int priority, int duration) {
        this.name = name;
        this.priority = priority;
        this.duration = duration;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "[Priority " + priority + "] " + name + " (Duration: " + duration + " mins)";
    }
}

public class TaskScheduler {
    private PriorityQueue<Task> taskQueue;
    private Queue<Task> pendingQueue;

    public TaskScheduler() {
        taskQueue = new PriorityQueue<>();
        pendingQueue = new LinkedList<>();
    }

    public void addTask(String name, int priority, int duration) {
        Task task = new Task(name, priority, duration);
        taskQueue.add(task);
    }

    public void processTask() {
        if (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Processing Task: " + task);
        } else if (!pendingQueue.isEmpty()) {
            Task pendingTask = pendingQueue.poll();
            System.out.println("Processing Task: " + pendingTask);
        } else {
            System.out.println("No tasks to process.");
        }
    }

    public void moveToPending(String taskName) {
        Iterator<Task> iterator = taskQueue.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.name.equals(taskName)) {
                iterator.remove();
                pendingQueue.add(task);
                System.out.println("Delaying Task: " + taskName);
                return;
            }
        }
        System.out.println("Task not found: " + taskName);
    }

    public void displayTasks() {
        System.out.println("\nScheduled Tasks (sorted by priority):");
        if (taskQueue.isEmpty()) {
            System.out.println("(No priority tasks)");
        } else {
            int i = 1;
            for (Task task : new ArrayList<>(taskQueue)) {
                System.out.println(i++ + ". " + task);
            }
        }

        System.out.println("\nPending Tasks (FIFO Order):");
        if (pendingQueue.isEmpty()) {
            System.out.println("(No pending tasks)");
        } else {
            int i = 1;
            for (Task task : pendingQueue) {
                System.out.println(i++ + ". " + task.name + " (Priority: " + task.priority + ", Duration: " + task.duration + " mins)");
            }
        }
    }
}
