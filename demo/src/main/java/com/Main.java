package com;

import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserModel userModel = new UserModel();
        DepartamentoModel departamentoModel = new DepartamentoModel(); // Asumiendo que tienes un modelo para departamentos

        // Crear un departamento
        Departamento dep = new Departamento(4, "Recursos");
        departamentoModel.createDepartamento(dep); // Este método debes tenerlo implementado

        // Crear usuarios dentro del departamento
        User user1 = new User(1, 4, "Ana Torres", Date.valueOf("1990-05-20"), 3500.75f);
        User user2 = new User(2, 4, "Marta López", Date.valueOf("1992-11-01"), 3100.50f);
        userModel.createUser(user1);
        userModel.createUser(user2);

        // Mostrar usuarios del departamento
        System.out.println("Usuarios del departamento " + dep.getNombre() + ":");
        List<User> usuarios = departamentoModel.usuariosDepartamento(dep);
        for (User u : usuarios) {
            System.out.println(u);
        }

        // Limpiar base de datos (opcional)
        userModel.deleteUser(user1);
        userModel.deleteUser(user2);
        // departamentoModel.deleteDepartamento(dep); // si tienes este método

        System.out.println("Prueba finalizada.");

        departamentoModel.deleteDepartamento(dep);
    }

}