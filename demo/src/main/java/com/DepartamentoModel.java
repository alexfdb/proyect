package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class DepartamentoModel extends Database {

    /**
     * Inserta un nuevo departamento en la base de datos.
     * @param departamento departamento a insertar.
     * @return retorna true si el departamento fue insertado.
     */
    public boolean createDepartamento(Departamento departamento) {
        String query = "INSERT INTO departamento (id, nombre) VALUES (?, ?)";
        try (Connection connection = createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, departamento.getId());
            preparedStatement.setString(2, departamento.getNombre());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Muestra los usuarios de un departamento.
     * 
     * @param departamento departamento en el que buscar a los usuarios.
     * @return retorna una lista con los usuarios del departamento.
     */
    public List<User> usuariosDepartamento(Departamento departamento) {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT user.id, user.id_departamento, user.nombre, user.fecha, user.sueldo FROM user INNER JOIN departamento ON departamento.id = user.id_departamento WHERE departamento.id = ? ";
        try (Connection connection = createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, departamento.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int idDepartamento = resultSet.getInt("id_departamento");
                    String nombre = resultSet.getString("nombre");
                    Date fecha = resultSet.getDate("fecha");
                    Float sueldo = resultSet.getFloat("sueldo");
                    users.add(new User(id, idDepartamento, nombre, fecha, sueldo));
                }
                return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Elimina un departamento de la base de datos.
     * @param departamento departamento a eliminar.
     * @return retorna true si el departamento fue eliminado.
     */
    public boolean deleteDepartamento(Departamento departamento) {
        String query = "DELETE FROM departamento WHERE id = ?";
        try (Connection connection = createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, departamento.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}