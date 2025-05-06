package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class UserModel extends Database {

    /**
     * Inserta un nuevo usuario.
     * 
     * @param user usuario a insertar.
     * @return retorna true si el usuario fue insertado.
     */
    public boolean createUser(User user) {
        String query = "INSERT INTO user(id, id_departamento, nombre, fecha, sueldo) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, user.getIdDepartamento());
            preparedStatement.setString(3, user.getNombre());
            preparedStatement.setDate(4, user.getFecha());
            preparedStatement.setFloat(5, user.getSueldo());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Leer un usuario de la base de datos.
     * @param user usuario a leer.
     * @return retorna el usuario leido.
     */
    public User readUser(User user) {
        String query = "SELECT id, id_departamento, nombre, fecha, sueldo FROM user WHERE id = ?";
        try (Connection connection = createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int idDepartamento = resultSet.getInt("id_departamento");
                    String nombre = resultSet.getString("nombre");
                    Date fecha = resultSet.getDate("fecha");
                    float sueldo = resultSet.getFloat("sueldo");
                    return new User(id,idDepartamento, nombre, fecha, sueldo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Actualiza a un usuario de la base de datos.
     * @param user usuario a actualizar de la base de datos.
     * @param updateUser usuario con los nuevos datos.
     * @return retorna true si el usuario fue actualizado.
     */
    public boolean updateUser(User user) {
        String query = "UPDATE user SET id_departamento = ?, nombre = ?, fecha = ?, sueldo = ? WHERE id = ?";
        try (Connection connection = createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getIdDepartamento());
            preparedStatement.setString(2, user.getNombre());
            preparedStatement.setDate(3, user.getFecha());
            preparedStatement.setFloat(4, user.getSueldo());
            preparedStatement.setInt(5, user.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Elimina un usuario de la base de datos.
     * @param user usuario a eliminar.
     * @return retorna true si el usuario fue eliminado.
     */
    public boolean deleteUser(User user) {
        String query = "DELETE FROM user WHERE id = ?";
        try (Connection connection = createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}