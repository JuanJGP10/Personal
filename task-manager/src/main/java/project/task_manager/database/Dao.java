package project.task_manager.database;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> obtainTasks();

    Optional<T> obtainTask(long id);

    void addTask(T t);

    void deleteTask(T t);

    void updateTask(T t);
}
