package br.com.series.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private static Database databaseInstance;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;

    public Database(){

    }

    //Singleton
    public static Database getInstance(){
        if(databaseInstance == null){
            databaseInstance = new Database();
        }
        return databaseInstance;
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


    public PreparedStatement  executarSQL(String query,Integer statement) throws SQLException {
        if(statement!= null) {
            this.preparedStatement = this.connection.prepareStatement(query, statement);
        }else{
            this.preparedStatement = this.connection.prepareStatement(query);
        }
        return this.preparedStatement;

    }

    public ResultSet  consultarSQL(String query) throws SQLException {
        this.statement  = this.connection.createStatement();
        return this.statement.executeQuery(query);

    }
}
