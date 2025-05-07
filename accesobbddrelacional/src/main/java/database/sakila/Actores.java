package database.sakila;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class Actores {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String sentenciasql = "select * from actor";
        try (Connection conn = DriverManager.getConnection(url, "root", "");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sentenciasql)) {

            while (rs.next()) {
                System.out.print("Id: " + rs.getInt(1));
                System.out.print(" Nombre: " + rs.getString("first_name"));
                System.out.println(" Apellido: " + rs.getString(3));
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
    }
}
