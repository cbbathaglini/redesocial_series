package br.com.series.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public Database(){

    }

    public void  open_connection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection =  DriverManager.getConnection(DatabaseConfigs.URL, DatabaseConfigs.USERNAME, DatabaseConfigs.PASSWORD);

    }

    public void  close_connection() throws SQLException {
        this.connection.close();
    }

    public Connection getConnection(){
        return this.connection;
    }
}
