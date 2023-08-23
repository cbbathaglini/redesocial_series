package br.com.series.model.serie;

public class Serie {
    private Integer id;
    private String nome;
    private Integer num_temporadas;
    private Integer ano_lancamento;

    public Serie(){

    }

    public Serie(Integer id,String nome,Integer num_temporadas,Integer ano_lancamento){
        this.id = id;
        this.nome = nome;
        this.num_temporadas = num_temporadas;
        this.ano_lancamento = ano_lancamento;
    }
    public Serie(String nome,Integer num_temporadas,Integer ano_lancamento){
        this.nome = nome;
        this.num_temporadas = num_temporadas;
        this.ano_lancamento = ano_lancamento;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }


    public String getNome(){
        return this.nome;
    }

    public Integer getNumTemporadas(){
        return this.num_temporadas;
    }

    public Integer getAnoLancamento(){
        return this.ano_lancamento;
    }

    public String toString(){
        return "Serie [id="+this.id+" ,nome="+this.nome+" ,numero_temporadas="+this.num_temporadas+" ,ano="+this.ano_lancamento+"]\n";
    }

}
