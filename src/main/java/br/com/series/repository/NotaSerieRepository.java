package br.com.series.repository;

import br.com.series.config.Database;
import br.com.series.model.notaserie.NotaSerie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotaSerieRepository {
    private Database database = Database.getInstance();


    public NotaSerie cadastrar(NotaSerie notaSerie){
        try{
            String query = " INSERT INTO notas_series (idSerie, idUsuario, nota, comentarios) VALUES (?,?,?,?) ";
            database.open_connection();

            PreparedStatement preparedStatement = database.executarSQL(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, notaSerie.getSerie().getId());
            preparedStatement.setInt(2, notaSerie.getUsuario().getId());
            preparedStatement.setInt(3, notaSerie.getNota());
            preparedStatement.setString(4, notaSerie.getComentario());

            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected > 0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next()){
                    notaSerie.setId( resultSet.getInt(1));
                }
            }

            database.close_connection();
            return notaSerie;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
