package project.task_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    private Long id;
    private String titulo;
    private boolean completada;

    public Task(Long id, String titulo, boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.completada = completada;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
