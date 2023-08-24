package br.com.series.repository;

import br.com.series.config.Database;
import br.com.series.converters.MinhasSeriesDBConverter;
import br.com.series.converters.SerieDBConverter;
import br.com.series.model.Usuario;
import br.com.series.model.minhasseries.MinhasSeries;
import br.com.series.model.serie.Serie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MinhasSeriesRepository {
    private Database database = Database.getInstance();

    public int quantidadeSeriesFavoritas(Usuario usuario){
        try{
            this.database.open_connection();
            String query = " SELECT count(*) as quantidade FROM MINHAS_SERIES WHERE favorita = ? AND idUsuario = ?";
            PreparedStatement preparedStatement = this.database.executarSQL(query,null);
            preparedStatement.setBoolean(1,true);
            preparedStatement.setInt(2,usuario.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            int quantidade = 0;
            if(resultSet.next()){
                quantidade = resultSet.getInt("quantidade");
            }

            preparedStatement.close();
            this.database.close_connection();
            return quantidade;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public MinhasSeries adicionar(MinhasSeries minhasSeries){

        try {
            this.database.open_connection();
            String query = " INSERT INTO MINHAS_SERIES (idUsuario, idSerie, situacao, favorita) VALUES (?,?,?,?) ";
            PreparedStatement preparedStatement = this.database.executarSQL(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,minhasSeries.getUsuario().getId());
            preparedStatement.setInt(2, minhasSeries.getSerie().getId());
            preparedStatement.setString(3, minhasSeries.getSituacao().toString());
            preparedStatement.setBoolean(4, minhasSeries.getFavorita());
            int linhasAfetadas = preparedStatement.executeUpdate();
            if(linhasAfetadas>0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next()) {
                    minhasSeries.setId(resultSet.getInt(1));
                }
            }
            preparedStatement.close();
            this.database.close_connection();
            return minhasSeries;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public List<MinhasSeries> listarMinhasSeries(Usuario usuario){
        List<MinhasSeries> minhasSeriesList = new ArrayList<>();
        try{
            String query = " SELECT * FROM MINHAS_SERIES, SERIES WHERE MINHAS_SERIES.idSerie = SERIES.idSerie AND MINHAS_SERIES.idUsuario = ?";
            this.database.open_connection();
            PreparedStatement preparedStatement = this.database.executarSQL(query,null);
            preparedStatement.setInt(1, usuario.getId());
            ResultSet resultSet = preparedStatement.executeQuery();


            while(resultSet.next()){
                MinhasSeries minhasSeries = MinhasSeriesDBConverter.converter(resultSet, true, true);
                minhasSeriesList.add(minhasSeries);
            }

            this.database.close_connection();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  minhasSeriesList;
    }

    public void remover( MinhasSeries minhasSeries){

        try{
            String query = " DELETE FROM MINHAS_SERIES WHERE MINHAS_SERIES.idMinhasSeries = ?";

            this.database.open_connection();
            PreparedStatement preparedStatement = this.database.executarSQL(query,null);
            preparedStatement.setInt(1, minhasSeries.getId());
            int linhasAfetadas = preparedStatement.executeUpdate();


            this.database.close_connection();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public MinhasSeries alterarFavorita( MinhasSeries minhasSeries){

        try{
            String query = " UPDATE MINHAS_SERIES SET MINHAS_SERIES.favorita = ? where MINHAS_SERIES.idSerie = ?";

            this.database.open_connection();
            PreparedStatement preparedStatement = this.database.executarSQL(query,null);
            preparedStatement.setBoolean(1, minhasSeries.getFavorita());
            preparedStatement.setInt(2, minhasSeries.getSerie().getId());
            int linhasAfetadas = preparedStatement.executeUpdate();

            if(linhasAfetadas == 0){
                throw new Exception("A série informada não consta na lista de séries do usuário");
            }
            this.database.close_connection();
            return  minhasSeries;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<MinhasSeries> listarMinhasSeriesFavoritas(MinhasSeries minhasSeries){
        try{
            String query = "SELECT * FROM minhas_series, series " +
                    " where " +
                    " minhas_series.idSerie = series.idSerie and" +
                    " minhas_series.idUsuario = ? and" +
                    " minhas_series.favorita = ?";

            this.database.open_connection();

            PreparedStatement preparedStatement = this.database.executarSQL(query,null);
            preparedStatement.setInt(1, minhasSeries.getUsuario().getId());
            preparedStatement.setBoolean(2, minhasSeries.getFavorita());
            ResultSet resultSet = preparedStatement.executeQuery();

            List<MinhasSeries> minhasSeriesList = new ArrayList<>();
            while(resultSet.next()){
                minhasSeriesList.add(MinhasSeriesDBConverter.converter(resultSet,true,true));
            }
            this.database.close_connection();
            return minhasSeriesList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public MinhasSeries consultarByIdSerie(MinhasSeries minhasSeries){
        try{
            this.database.open_connection();
            String query = " SELECT * FROM MINHAS_SERIES WHERE MINHAS_SERIES.idSerie = ?";
            PreparedStatement preparedStatement = this.database.executarSQL(query,null);
            preparedStatement.setInt(1, minhasSeries.getSerie().getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                minhasSeries = MinhasSeriesDBConverter.converter(resultSet,false,false);
            }

            this.database.close_connection();
            return minhasSeries;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarSituacao(MinhasSeries minhasSeries){
        try{
            String query = "UPDATE MINHAS_SERIES SET situacao = ? where idSerie =?";
            this.database.open_connection();
            PreparedStatement preparedStatement = this.database.executarSQL(query,null);
            preparedStatement.setString(1, minhasSeries.getSituacao().toString());
            preparedStatement.setInt(2, minhasSeries.getSerie().getId());
            int linhasAfetadas = preparedStatement.executeUpdate();

            this.database.close_connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
