package br.com.series.repository;

import br.com.series.config.Database;
import br.com.series.model.Usuario;
import br.com.series.model.notaserie.NotaSerie;
import br.com.series.model.pesquisa.FiltroPesquisaDB;
import br.com.series.model.serie.Serie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<NotaSerie> listar(NotaSerie notaSerie){
        try{
            database.open_connection();
            String query = "SELECT * FROM notas_series, series where notas_series.idSerie = series.idSerie";

            FiltroPesquisaDB filtroPesquisaDB = null;
            if(notaSerie!=null){
                String conditions = "";
                if (notaSerie.getSerie()!=null && notaSerie.getSerie().getId()!=null){
                    conditions += " notas_series.idSerie = ? ";
                    filtroPesquisaDB = new FiltroPesquisaDB(FiltroPesquisaDB.TYPE_INTEGER, 1,notaSerie.getSerie().getId().toString());
                }
                if(!"".equals(conditions)) query += " and " + conditions;
            }
            PreparedStatement preparedStatement = database.executarSQL(query,null);
            if (filtroPesquisaDB!= null) {
                if(filtroPesquisaDB.getType() == FiltroPesquisaDB.TYPE_INTEGER){
                    preparedStatement.setInt(filtroPesquisaDB.getPosition(), Integer.parseInt(filtroPesquisaDB.getValue()));
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            List<NotaSerie> notaSerieList = new ArrayList<>();
            while(resultSet.next()){

                int idNotaSerie = resultSet.getInt("idNotasSeries");
                int idUsuario = resultSet.getInt("idUsuario");
                int nota = resultSet.getInt("nota");
                String comentarios = resultSet.getString("comentarios");

                int idSerie = resultSet.getInt("idSerie");
                String nome = resultSet.getString("nome");
                int ano = resultSet.getInt("ano");
                int numero_temporadas = resultSet.getInt("ano");


                Serie serie = new Serie(idSerie,nome,numero_temporadas,ano);
                Usuario usuario = new Usuario(idUsuario,null,null);
                notaSerieList.add(new NotaSerie(idNotaSerie,usuario,serie,nota,comentarios));

            }

            preparedStatement.close();
            database.close_connection();
            return notaSerieList;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public float mediaNota(NotaSerie notaSerie){
        try{
            database.open_connection();
            String query = "SELECT avg(nota) as media FROM notas_series";

            FiltroPesquisaDB filtroPesquisaDB = null;
            if(notaSerie!=null){
                String conditions = "";
                if (notaSerie.getSerie()!=null && notaSerie.getSerie().getId()!=null){
                    conditions += " idSerie = ? ";
                    filtroPesquisaDB = new FiltroPesquisaDB(FiltroPesquisaDB.TYPE_INTEGER, 1,notaSerie.getSerie().getId().toString());
                }
                if(!"".equals(conditions)) query += " where " + conditions;
            }
            PreparedStatement preparedStatement = database.executarSQL(query,null);
            if (filtroPesquisaDB!= null) {
                if(filtroPesquisaDB.getType() == FiltroPesquisaDB.TYPE_INTEGER){
                    preparedStatement.setInt(filtroPesquisaDB.getPosition(), Integer.parseInt(filtroPesquisaDB.getValue()));
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            float mediaNota = -1;
            while(resultSet.next()){
                mediaNota = resultSet.getFloat("media");
            }

            preparedStatement.close();
            database.close_connection();
            return mediaNota;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
