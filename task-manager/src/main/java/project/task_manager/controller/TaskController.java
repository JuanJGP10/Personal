package project.task_manager.controller;

import project.task_manager.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1L, "Aprender Spring Boot", false));
        tasks.add(new Task(2L, "Hacer primer endpoint", true));
    }

    @GetMapping
    public List<Task> listTasks() {
        return tasks;
    }
}
