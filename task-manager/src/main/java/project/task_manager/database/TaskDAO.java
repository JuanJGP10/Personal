package project.task_manager.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import project.task_manager.TaskManagerApplication;
import project.task_manager.model.Task;

public class TaskDAO implements Dao<Task> {

    private DataSource dataSource;

    private static TaskDAO instance = null;

    // Evita la instanciación directa
    public static TaskDAO getInstance() {
        if (instance == null)
            instance = new TaskDAO();
        return instance;
    }

    public TaskDAO() {
        Properties data = new Properties();
        try (InputStream inputStream = TaskManagerApplication.class
                .getResourceAsStream("database/db_config.properties")) {
            data.load(inputStream);
        } catch (Exception e) {
            e.getMessage();
        }

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource
                .setUrl("jdbc:mysql://" + data.getProperty("db.servidor") + ":3306/"
                        + data.getProperty("db.basedatos"));
        basicDataSource.setUsername(data.getProperty("db.username"));
        basicDataSource.setUsername(data.getProperty("db.password"));
        this.dataSource = basicDataSource;
    }

    @Override
    public List<Task> obtainTasks() {
        List<Task> taskList = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery("select * from tasks")) {
            while (result.next()) {
                long id = result.getLong(1);
                String title = result.getString("title");
                boolean completed = result.getBoolean("completed");

                Task task = new Task(id, title, completed);
                taskList.add(task);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return taskList;
    }

    @Override
    public Optional<Task> obtainTask(long id) {
        try (Connection con = dataSource.getConnection();
                PreparedStatement statement = con.prepareStatement("select * from tasks where id = ?")) {
            statement.setLong(1, id);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {

                    String title = result.getString("title");
                    boolean completed = result.getBoolean("completed");

                    Task task = new Task(id, title, completed);
                    return Optional.of(task);
                }
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        return Optional.empty();
    }

    @Override
    public void addTask(Task t) {
        try (Connection con = dataSource.getConnection();
                PreparedStatement statement = con
                        .prepareStatement("insert into tasks(title, completed) values (?,?)")) {
            statement.setString(1, t.getTitulo());
            statement.setBoolean(2, t.isCompletada());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void deleteTask(Task t) {
        try (Connection con = dataSource.getConnection();
                PreparedStatement statement = con
                        .prepareStatement("delete from tasks where id = ?")) {
            statement.setLong(1, t.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateTask(Task t) {
        try (Connection con = dataSource.getConnection();
                PreparedStatement statement = con
                        .prepareStatement("update tasks set title = ?, completed = ?, where id = ?")) {
            statement.setLong(3, t.getId());
            statement.setString(1, t.getTitulo());
            statement.setBoolean(2, t.isCompletada());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
