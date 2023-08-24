package br.com.series.model.minhasseries;

import br.com.series.model.Situacao;
import br.com.series.model.Usuario;
import br.com.series.model.serie.Serie;

public class MinhasSeries {

    private Integer id;
    private Usuario usuario;

    private Serie serie;

    private Situacao situacao;
    private Boolean favorita;

    public MinhasSeries()
    {

    }

    public MinhasSeries(Usuario usuario, Serie serie, Situacao situacao, Boolean favorita){
        this.usuario = usuario;
        this.serie = serie;
        this.situacao  = situacao;
        this.favorita = favorita;
    }
    public MinhasSeries(Integer id, Usuario usuario, Serie serie, Situacao situacao, Boolean favorita){
        this.id = id;
        this.usuario = usuario;
        this.serie = serie;
        this.situacao  = situacao;
        this.favorita = favorita;
    }
    public Integer getId(){
        return this.id;
    }
    public Situacao getSituacao(){
        return this.situacao;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public Serie getSerie(){
        return serie;
    }

    public Boolean getFavorita(){
        return this.favorita;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void setSituacao(Situacao situacao){
        this.situacao = situacao;
    }

    public void setFavorita(Boolean favorita){
        this.favorita = favorita;
    }

    public void setSerie(Serie serie){
        this.serie = serie;
    }

    public String toString(){
        return "MinhasSeries [" +
                "id="+this.id+","+
                "usuario="+this.usuario+","+
                "serie="+this.serie+","+
                "serie="+this.situacao+","+
                "favorita="+this.favorita+","
                +"]\n";
    }
}
