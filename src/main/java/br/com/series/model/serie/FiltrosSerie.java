package br.com.series.model.serie;

public enum FiltrosSerie {
    ALFABETICAMENTE_A_Z(1),
    ALFABETICAMENTE_Z_A(2),
    CRONOLOGICA_MAIS_RECENTE(3),
    CRONOLOGICA_MAIS_ANTIGO(4),
    NUMERO_TEMPORADAS_MAIOR(5),
    NUMERO_TEMPORADAS_MENOR(6);

    public Integer posicao;

    private FiltrosSerie(Integer posicao){ this.posicao = posicao;}

    public Integer getPosicao(){
        return posicao;
    }
    public static FiltrosSerie getFiltro(Integer posicao){
        for(FiltrosSerie filtro: FiltrosSerie.values()){
            if(filtro.posicao == posicao){
                return filtro;
            }
        }
        throw new IllegalArgumentException("Filtro inválido");
    }

}
