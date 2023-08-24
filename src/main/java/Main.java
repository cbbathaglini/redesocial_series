import br.com.series.model.MenuOpcoes;
import br.com.series.model.Usuario;
import br.com.series.model.minhasseries.MinhasSeries;
import br.com.series.model.notaserie.NotaSerie;
import br.com.series.model.serie.Serie;
import br.com.series.service.MinhasSeriesService;
import br.com.series.service.NotaSerieService;
import br.com.series.service.SerieService;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        options();
    }

    public static void options() throws SQLException, ClassNotFoundException {


        Scanner in = new Scanner(System.in);
        String option = "-1";

        //fixando o  usuário
        Usuario usuario = new Usuario(1,"euaqui","euaqui@email.com");

        SerieService serieService = new SerieService();
        NotaSerieService notaSerieService = new NotaSerieService();
        MinhasSeriesService minhasSeriesService = new MinhasSeriesService();

        List<MinhasSeries> minhasSeriesList = new ArrayList<>();
        while(!"12".equals(option)){
            all_options();
            System.out.println("Informe uma opção: ");
            option = in.nextLine();
            switch (option) {
                case "1": //cadastrar uma série
                    serieService.cadastrar();
                    break;

                case "2":
                    List<Serie> serieList = serieService.listar();
                    System.out.println(serieList);
                    break;


                case "3":
                    List<Serie>  seriesProcuradas = serieService.procurar();
                    System.out.println(seriesProcuradas);
                    break;

                case "4":
                    NotaSerie notaSerie = notaSerieService.adicionar();
                    System.out.println(notaSerie);
                    break;

                case "5":
                    float mediaNotas = notaSerieService.visualizarMedia();
                    System.out.println("Média das notas: " + mediaNotas);
                    break;

                case "6":
                    List<NotaSerie> notaSerieList = notaSerieService.visualizarComentariosNotas();
                    if(notaSerieList.size() > 0) {
                        System.out.println("Nome série: " + notaSerieList.get(0).getSerie().getNome());
                        System.out.println("---------------");

                        for (NotaSerie item : notaSerieList) {
                            System.out.println("Nota: " + item.getNota());
                            System.out.println("Comentário: " + item.getComentario());
                            System.out.println("---------------");
                        }
                    }

                    break;

                case "7": //Listar minha lista de séries
                    minhasSeriesList = minhasSeriesService.listarMinhasSeries();
                    System.out.println(minhasSeriesList);
                    break;

                case "8": //Adicionar série na minha lista de séries
                    minhasSeriesService.adicionar();
                    minhasSeriesList = minhasSeriesService.listarMinhasSeries();
                    System.out.println(minhasSeriesList);
                    break;

                case "9": //REMOVER série na minha lista de séries
                    minhasSeriesService.remover();
                    minhasSeriesList = minhasSeriesService.listarMinhasSeries();
                    System.out.println(minhasSeriesList);
                    break;

                case "....":
                    break;

                case "12":
                    System.out.println("Finalizando...");
                    System.exit(1);
                    break;
            }
        }
    }

    public static void all_options(){
        System.out.println("------------------------------------------");
        System.out.println(" 1 - Cadastrar uma série");
        System.out.println(" 2 - Listar séries");
        System.out.println(" 3 - Procurar série");
        System.out.println(" 4 - Adicionar uma nota e um comentário para a série");
        System.out.println(" 5 - Visualizar média das notas de uma série");
        System.out.println(" 6 - Visualizar notas e comentários de uma série");
        System.out.println(" 7 - Listar minha lista de séries");
        System.out.println(" 8 - Adicionar série na minha lista de séries");
        System.out.println(" 9 - Remover série da minha lista de séries");
        System.out.println(" 10 - Adicionar série na minha lista de séries favoritas");
        System.out.println(" 11 - Remover série da minha lista de séries");
        System.out.println(" 12 - Alterar situação de uma das minhas séries");
        System.out.println(" 13 - Sair");
        System.out.println("------------------------------------------");
    }


}