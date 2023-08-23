package br.com.series.service;

import br.com.series.model.serie.FiltrosListagemSerie;
import br.com.series.model.serie.FiltrosProcuraSerie;
import br.com.series.model.serie.Serie;
import br.com.series.repository.SerieRepository;
import br.com.series.view.SerieView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerieService {

    private SerieRepository serieRepository;
    private SerieView serieView;
    private Scanner scanner;
    public  SerieService() throws SQLException, ClassNotFoundException {
        this.serieRepository = new SerieRepository();
        this.serieView = new SerieView();
        this.scanner = new Scanner(System.in);
    }
    public  Serie cadastrar(){
        Serie serie = this.serieView.cadastrar();
        //[TODO] fazer validações da série
        this.serieRepository.cadastrar(serie);

        System.out.println("Série cadastrada com sucesso");
        return serie;
    }

    public  List<Serie> listar(){
        List<Serie> serieList = new ArrayList<>();
        FiltrosListagemSerie filtrosSerie = serieView.filtrosListar();
        return this.serieRepository.listar(filtrosSerie);
    }

    public List<Serie> procurar(){
        FiltrosProcuraSerie filtro = this.serieView.procurarFiltro();
        String valor = this.serieView.procurar();

        return this.serieRepository.procurar(filtro,valor);
    }


}
