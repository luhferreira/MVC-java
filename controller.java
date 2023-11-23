import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
        }
    }

    public List<Task> getIncompleteTasks() {
        List<Task> incompleteTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                incompleteTasks.add(task);
            }
        }
        return incompleteTasks;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}
