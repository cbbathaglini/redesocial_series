package br.com.series.repository;

import br.com.series.config.Database;
import br.com.series.model.pesquisa.FiltroPesquisaDB;
import br.com.series.model.serie.FiltrosListagemSerie;
import br.com.series.model.serie.FiltrosProcuraSerie;
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

    public List<Serie> listar(FiltrosListagemSerie filtrosSerie){
        try{
            database.open_connection();
            String query = "SELECT * FROM SERIES";

            if (filtrosSerie!= null){
                String order = "";
                if(filtrosSerie.equals(FiltrosListagemSerie.ALFABETICAMENTE_A_Z)) order = " order by nome asc";
                else if(filtrosSerie.equals(FiltrosListagemSerie.ALFABETICAMENTE_Z_A)) order = " order by nome desc";
                else if(filtrosSerie.equals(FiltrosListagemSerie.CRONOLOGICA_MAIS_ANTIGO)) order = " order by ano asc";
                else if(filtrosSerie.equals(FiltrosListagemSerie.CRONOLOGICA_MAIS_RECENTE)) order = " order by ano desc";
                else if(filtrosSerie.equals(FiltrosListagemSerie.NUMERO_TEMPORADAS_MAIOR)) order = " order by numero_temporadas desc";
                else if(filtrosSerie.equals(FiltrosListagemSerie.NUMERO_TEMPORADAS_MENOR)) order = " order by numero_temporadas asc";
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

    public List<Serie> procurar(FiltrosProcuraSerie filtro,String valor){

        try{
            this.database.open_connection();

            String query = "SELECT * FROM SERIES";

            FiltroPesquisaDB filtroBD = new FiltroPesquisaDB();
            if(filtro!=null){
                String filtrar ="", and = "";
                Integer contador = 1;
                if(filtro == FiltrosProcuraSerie.NOME){
                    filtrar += and + " nome like ?";
                    and = " and ";
                    filtroBD = new FiltroPesquisaDB(FiltroPesquisaDB.TYPE_STRING,contador,  "%"+valor+"%");
                    contador++;
                }
                if(filtro == FiltrosProcuraSerie.NUMERO_TEMPORADAS){
                    filtrar += and + " numero_temporadas = ?";
                    and = " and ";
                    filtroBD = new FiltroPesquisaDB(FiltroPesquisaDB.TYPE_INTEGER,contador,valor);
                    contador++;
                }

                query += " where " + filtrar;
            }


            PreparedStatement preparedStatement = this.database.executarSQL(query,null);

            if(FiltroPesquisaDB.TYPE_INTEGER.equals(filtroBD.getType())){
                preparedStatement.setInt(filtroBD.getPosition(),Integer.parseInt(filtroBD.getValue()));
            }
            if(FiltroPesquisaDB.TYPE_STRING.equals(filtroBD.getType())){
                preparedStatement.setString(filtroBD.getPosition(),filtroBD.getValue());
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Serie> serieList = new ArrayList<>();
            while(resultSet.next()){
                int idSerie = resultSet.getInt("idSerie");
                String nome = resultSet.getString("nome");
                int num_temporadas = resultSet.getInt("numero_temporadas");
                int ano = resultSet.getInt("ano");
                serieList.add(new Serie(idSerie,nome, num_temporadas, ano));
            }

            this.database.close_connection();
            return serieList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
