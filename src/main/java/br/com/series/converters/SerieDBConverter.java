package br.com.series.converters;

import br.com.series.constants.SerieDBConstants;
import br.com.series.model.serie.Serie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SerieDBConverter {
    public static Serie converter(ResultSet resultSet) throws SQLException {
        int idSerie = resultSet.getInt(SerieDBConstants.ID_SERIE);
        String nome = resultSet.getString(SerieDBConstants.NOME);
        int ano = resultSet.getInt(SerieDBConstants.ANO);
        int numero_temporadas= resultSet.getInt(SerieDBConstants.NUMERO_TEMPORADAS);
        return new Serie(idSerie,nome, ano, numero_temporadas);
    }

}
