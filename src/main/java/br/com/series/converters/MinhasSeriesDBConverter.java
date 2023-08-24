package br.com.series.converters;

import br.com.series.constants.MinhasSeriesDBConstants;
import br.com.series.model.Situacao;
import br.com.series.model.Usuario;
import br.com.series.model.minhasseries.MinhasSeries;
import br.com.series.model.serie.Serie;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MinhasSeriesDBConverter {


    public static MinhasSeries converter(ResultSet resultSet) throws SQLException {

        int idMinhasSeries = resultSet.getInt(MinhasSeriesDBConstants.ID_MINHAS_SERIES);
        Serie serie = SerieDBConverter.converter(resultSet);
        int idUsuario = resultSet.getInt("idUsuario");
        Usuario usuario = new Usuario(idUsuario);

        Situacao situacao = Situacao.valueOf(resultSet.getString(MinhasSeriesDBConstants.SITUACAO));
        Boolean favorita = resultSet.getBoolean(MinhasSeriesDBConstants.FAVORITA);

        return new MinhasSeries(idMinhasSeries, usuario,serie,situacao,favorita);
    }
}
