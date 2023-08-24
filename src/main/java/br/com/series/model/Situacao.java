package br.com.series.model;

import br.com.series.model.minhasseries.MinhasSeries;

public enum Situacao {
    JA_VI(1,"Já vi"),
    QUERO_VER(2,"Quero ver"),
    ESTOU_VENDO(3,"Estou vendo");

    private Integer posicao;
    private String descricao;

    private Situacao(Integer posicao,String descricao){
        this.posicao = posicao;
        this.descricao= descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public Integer getPosicao(){
        return this.posicao;
    }

    public static Situacao converter(Integer posicao){
        for (Situacao item: Situacao.values()) {
            if (posicao == item.getPosicao()){
                return  item;
            }
        }
        throw  new IllegalArgumentException("Valor informado é inválido");
    }
}
