package br.com.series.view;

import br.com.series.model.serie.FiltrosListagemSerie;
import br.com.series.model.serie.FiltrosProcuraSerie;
import br.com.series.model.serie.Serie;

import java.util.Scanner;

public class SerieView {

    private Scanner scanner;

    public SerieView(){
        this.scanner = new Scanner(System.in);
    }

    public Serie cadastrar(){
        System.out.println("Informe o nome: ");
        String nome =  scanner.nextLine();
        System.out.println("Informe o número de temporadas: ");
        String temporadas =  scanner.nextLine();
        System.out.println("Informe o ano de lançamento: ");
        String ano_lancamento =  scanner.nextLine();
        return new Serie(nome, Integer.parseInt(temporadas),Integer.parseInt(ano_lancamento));
    }

    public FiltrosListagemSerie filtrosListar(){

        System.out.println("1 - Ordem alfabética (A_z)");
        System.out.println("2 - Ordem alfabética (z_A");
        System.out.println("3 - Ordem cronológica do ano (mais recentes)");
        System.out.println("4 - Ordem cronológica do ano (mais antigas)");
        System.out.println("5 - Ordem quantitiva do número de temporadas (maior quantidade)");
        System.out.println("6 - Ordem quantitiva do número de temporadas (menor quantidade)");
        System.out.println("Informe uma das opções acima: ");
        String posicao =  scanner.nextLine();

        return FiltrosListagemSerie.getFiltro(Integer.parseInt(posicao));

    }

    public FiltrosProcuraSerie procurarFiltro(){

        System.out.println("1 - Por nome");
        System.out.println("2 - Por número de temporadas");
        System.out.println("3 - Pelo ano");
        System.out.println("Informe uma das opções acima: ");
        String posicao =  scanner.nextLine();

        return FiltrosProcuraSerie.getFiltro(Integer.parseInt(posicao));

    }

    public String procurar(){

        System.out.println("Informe o valor que deseja pesquisar:");
        return  scanner.nextLine();

    }

}
