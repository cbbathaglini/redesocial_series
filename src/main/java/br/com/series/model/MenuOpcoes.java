package br.com.series.model;

public enum MenuOpcoes {
    CADASTRAR_SERIE("1"),
    LISTAR_SERIES("2"),
    PROCURAR_SERIE("3"),
    SAIR("13");

    private String option;


    private MenuOpcoes(String option) {
        this.option = option;
    }

    public String getOption(){
        return String.valueOf(option);
    }


}
