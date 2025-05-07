package project.task_manager.controller;

import project.task_manager.model.Tarea;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>();

    public TareaController() {
        tareas.add(new Tarea(1L, "Aprender Spring Boot", false));
        tareas.add(new Tarea(2L, "Hacer primer endpoint", true));
    }

    @GetMapping
    public List<Tarea> listarTareas() {
        return tareas;
    }
}
