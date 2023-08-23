package br.com.series.repository;

import br.com.series.config.Database;
import br.com.series.model.serie.FiltrosSerie;
import br.com.series.model.serie.Serie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SerieRepository {

    private Database database = Database.getInstance();
    private Connection connection;


    public Serie cadastrar(Serie serie){
        try{
            String query = " INSERT INTO SERIES (nome, ano, numero_temporadas) VALUES (?,?,?)";
            database.open_connection();

            PreparedStatement preparedStatement = database.executarSQL(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,serie.getNome());
            preparedStatement.setInt(2,serie.getAnoLancamento());
            preparedStatement.setInt(3,serie.getNumTemporadas());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if(linhasAfetadas>0){
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    serie.setId( generatedKeys.getInt(1));
                }
                generatedKeys.close();
            }

            preparedStatement.close();
            this.database.close_connection();
            return serie;
        }catch (SQLException e){
            System.out.println("Erro: "+ e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  null;
    }

    public List<Serie> listar(FiltrosSerie filtrosSerie){
        try{
            database.open_connection();
            String query = "SELECT * FROM SERIES";

            if (filtrosSerie!= null){
                String order = "";
                if(filtrosSerie.equals(FiltrosSerie.ALFABETICAMENTE_A_Z)) order = " order by nome asc";
                else if(filtrosSerie.equals(FiltrosSerie.ALFABETICAMENTE_Z_A)) order = " order by nome desc";
                else if(filtrosSerie.equals(FiltrosSerie.CRONOLOGICA_MAIS_ANTIGO)) order = " order by ano asc";
                else if(filtrosSerie.equals(FiltrosSerie.CRONOLOGICA_MAIS_RECENTE)) order = " order by ano desc";
                else if(filtrosSerie.equals(FiltrosSerie.NUMERO_TEMPORADAS_MAIOR)) order = " order by numero_temporadas desc";
                else if(filtrosSerie.equals(FiltrosSerie.NUMERO_TEMPORADAS_MENOR)) order = " order by numero_temporadas asc";
                query += order;
            }

            ResultSet resultSet = database.consultarSQL(query);

            List<Serie> serieList = new ArrayList<>();
            while(resultSet.next()){
                int idSerie = resultSet.getInt("idSerie");
                String nome = resultSet.getString("nome");
                int num_temporadas = resultSet.getInt("numero_temporadas");
                int ano = resultSet.getInt("ano");
                serieList.add(new Serie(idSerie,nome, num_temporadas, ano));
            }


            database.close_connection();
            return serieList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
