package com;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public abstract class Database {

    private static final String DB_PATH = "src/main/resources/data.db";
    private static final File DB_FILE = new File(DB_PATH);

    /**
     * Constructor general.
     */
    protected Database() {
        try {
            if (!DB_FILE.exists() || !DB_FILE.isFile()) {
                throw new SQLException("No existe la base de datos: " + DB_PATH);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea una nueva conexion con la base de datos.
     * 
     * @return retorna la nueva conexion.
     */
    public Connection createConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}