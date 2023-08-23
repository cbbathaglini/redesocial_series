package br.com.series.model.serie;

public enum FiltrosProcuraSerie {
    NOME(1),
    NUMERO_TEMPORADAS(2);

    private Integer position;

    private FiltrosProcuraSerie(Integer position){
        this.position = position;
    }

    public Integer getPosition(){
        return this.position;
    }

    public static FiltrosProcuraSerie getFiltro(Integer position){
        for (FiltrosProcuraSerie filtro : FiltrosProcuraSerie.values()){
            if (filtro.getPosition() == position){
                return filtro;
            }
        }
        throw new IllegalArgumentException("Posição inválida no filtor de procura");
    }
}
