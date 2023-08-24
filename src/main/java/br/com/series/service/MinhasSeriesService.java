package br.com.series.service;

import br.com.series.model.Situacao;
import br.com.series.model.Usuario;
import br.com.series.model.minhasseries.MinhasSeries;
import br.com.series.model.serie.Serie;
import br.com.series.repository.MinhasSeriesRepository;
import br.com.series.view.MinhasSeriesView;

import java.util.List;

public class MinhasSeriesService {

    public MinhasSeriesRepository minhasSeriesRepository;
    public MinhasSeriesView minhasSeriesView;

    public MinhasSeriesService(){
        this.minhasSeriesRepository = new MinhasSeriesRepository();
        this.minhasSeriesView = new MinhasSeriesView();
    }

    public MinhasSeries adicionar() {
        try {

            Usuario usuario = new Usuario();
            usuario.setId(1); //pegar pela sessão futuramente

            MinhasSeries minhasSeries = this.minhasSeriesView.informarIdSituacao();
            minhasSeries.setUsuario(usuario);
            minhasSeries.setFavorita(false);
            minhasSeries = this.minhasSeriesRepository.adicionar(minhasSeries);

            return minhasSeries;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void remover() {
        try {

            Usuario usuario = new Usuario();
            usuario.setId(1); //pegar pela sessão futuramente

            //[TODO] verificar se id que vai ser informado existe
            MinhasSeries minhasSeries = this.minhasSeriesView.informarIdMinhasSeries();
            this.minhasSeriesRepository.remover(minhasSeries);

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public List<MinhasSeries> listarMinhasSeries() {
        try {

            Usuario usuario = new Usuario();
            usuario.setId(1); //pegar pela sessão futuramente

            List<MinhasSeries> minhasSeriesList = this.minhasSeriesRepository.listarMinhasSeries(usuario);

            return minhasSeriesList;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


    public Serie alterarFavorita(Boolean favorita) {
        try {
            //checar se já não tem 5 séries favoritas
            Usuario usuario = new Usuario();
            usuario.setId(1); //pegar pela sessão futuramente
            int numeroSeriesFavoritas = this.minhasSeriesRepository.quantidadeSeriesFavoritas(usuario);

            if (numeroSeriesFavoritas >= 5) {
                throw new Exception("O número de séries favoritas é igual a 5. Para adicionar mais séries você precisa remover uma de sua lista de séries favoritas");
            }


            Serie serie = this.minhasSeriesView.informarIdSeries();
            // checar se ela está na lista de séries da pessoa para setar
            MinhasSeries minhasSeries = new MinhasSeries(usuario, serie, null,favorita);
            this.minhasSeriesRepository.alterarFavorita(minhasSeries);
            return new Serie();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public List<MinhasSeries> listarMinhasSeriesFavoritas() {
        try {
            Usuario usuario = new Usuario();
            usuario.setId(1); //pegar pela sessão futuramente

            MinhasSeries minhasSeries = new MinhasSeries(usuario, null,null, true);

            return this.minhasSeriesRepository.listarMinhasSeriesFavoritas(minhasSeries);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
