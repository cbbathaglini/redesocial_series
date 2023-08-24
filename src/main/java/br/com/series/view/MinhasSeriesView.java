package br.com.series.view;

import br.com.series.model.Situacao;
import br.com.series.model.minhasseries.MinhasSeries;
import br.com.series.model.serie.Serie;

import java.util.Scanner;

public class MinhasSeriesView {
    private Scanner scanner;

    public MinhasSeriesView(){
        this.scanner = new Scanner(System.in);
    }


    public MinhasSeries informarIdMinhasSeries(){
        MinhasSeries minhasSeries = new MinhasSeries();
        System.out.println("Informe o identificador da sua série:");
        String id = scanner.nextLine();
        minhasSeries.setId(Integer.parseInt(id));
        return minhasSeries;
    }

    public Serie informarIdSeries(){
        Serie serie = new Serie();
        System.out.println("Informe o identificador da série:");
        String id = scanner.nextLine();
        serie.setId(Integer.parseInt(id));
        return serie;
    }
    public MinhasSeries informarIdSituacao(){
        MinhasSeries minhasSeries = new MinhasSeries();
        System.out.println("Informe o identificador da série:");
        String id = scanner.nextLine();

        System.out.println("Informe a situação da série:");
        System.out.println("1 - "+ Situacao.JA_VI.getDescricao());
        System.out.println("2 - "+ Situacao.QUERO_VER.getDescricao());
        System.out.println("3 - "+ Situacao.ESTOU_VENDO.getDescricao());

        Serie serie = new Serie();
        serie.setId(Integer.parseInt(id));
        minhasSeries.setSerie(serie);

        String idSituacao = scanner.nextLine();
        minhasSeries.setSituacao(Situacao.converter(Integer.parseInt(idSituacao)));

        return minhasSeries;
    }
}
