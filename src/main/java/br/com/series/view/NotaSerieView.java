package br.com.series.view;

import br.com.series.model.Usuario;
import br.com.series.model.notaserie.NotaSerie;
import br.com.series.model.serie.Serie;

import java.util.Scanner;

public class NotaSerieView {

    private Scanner scanner;

    public  NotaSerieView(){
        this.scanner = new Scanner(System.in);
    }
    public NotaSerie adicionarNotaComentario(){
        System.out.println("Informe a série:");
        String id =  scanner.nextLine();
        System.out.println("Informe a nota:");
        String nota =  scanner.nextLine();
        System.out.println("Informe o comentário (opcional):");
        String comentario =  scanner.nextLine();
        //Usuario usuario,Serie serie, Integer nota, String comentario){
        Usuario usuario = new Usuario();
        usuario.setId(1);

        Serie serie = new Serie();
        serie.setId(Integer.parseInt(id));
        return new NotaSerie(usuario,
                             serie,
                             Integer.parseInt(nota),
                             comentario);
    }


    public NotaSerie informarSerie(){
        System.out.println("Informe a série:");
        String id =  scanner.nextLine();
        Serie serie = new Serie();
        serie.setId(Integer.parseInt(id));

        NotaSerie notaSerie = new NotaSerie();
        notaSerie.setSerie(serie);
        return notaSerie;
    }
}
