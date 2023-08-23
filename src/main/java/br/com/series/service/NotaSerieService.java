package br.com.series.service;

import br.com.series.model.notaserie.NotaSerie;
import br.com.series.repository.NotaSerieRepository;
import br.com.series.view.NotaSerieView;

public class NotaSerieService {

    private NotaSerieRepository notaSerieRepository;
    private NotaSerieView notaSerieView;
    public NotaSerieService(){
        notaSerieRepository = new NotaSerieRepository();
        notaSerieView = new NotaSerieView();
    }

    public NotaSerie adicionar(){
        NotaSerie notaSerie = notaSerieView.adicionarNotaComentario();
        return notaSerieRepository.cadastrar(notaSerie);
    }
}
