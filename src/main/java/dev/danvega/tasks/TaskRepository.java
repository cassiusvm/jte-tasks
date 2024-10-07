package dev.danvega.tasks;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public TaskRepository() {

    }

    public List<Task> findAll() {
        return tasks;
    }

    public void create(Task task) {
        tasks.add(task);
    }

    public boolean remove(String id) {
        return tasks.removeIf(task -> task.id().equals(id));
    }

    @PostConstruct
    private void init() {
        tasks.addAll(List.of(
                new Task(UUID.randomUUID().toString(),"Complete project proposal"),
                new Task(UUID.randomUUID().toString(),"Review code changes"),
                new Task(UUID.randomUUID().toString(),"Attend team meeting"),
                new Task(UUID.randomUUID().toString(),"Update documentation"),
                new Task(UUID.randomUUID().toString(),"Fix reported bugs"),
                new Task(UUID.randomUUID().toString(),"Prepare presentation slides"),
                new Task(UUID.randomUUID().toString(),"Respond to client emails"),
                new Task(UUID.randomUUID().toString(),"Run unit tests"),
                new Task(UUID.randomUUID().toString(),"Refactor legacy code"),
                new Task(UUID.randomUUID().toString(),"Plan next sprint")
        ));
    }
}
