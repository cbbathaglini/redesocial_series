package br.com.series.model.notaserie;

import br.com.series.model.Usuario;
import br.com.series.model.serie.Serie;

public class NotaSerie {

    private Integer id;
    private Usuario usuario;
    private Serie serie;

    private Integer nota;

    private String comentario;

    public NotaSerie(){

    }

    public NotaSerie(Usuario usuario,Serie serie, Integer nota, String comentario){
        this.usuario = usuario;
        this.serie = serie;
        this.nota = nota;
        this.comentario = comentario;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public Serie getSerie(){
        return this.serie;
    }


    public Integer getNota(){
        return this.nota;
    }

    public String getComentario(){
        return this.comentario;
    }

    public String toString(){
        return "NotaSerie [id= "+this.id+
                " ,usuario="+this.usuario+
                " ,serie="+this.usuario+
                " ,nota="+this.nota+
                " ,comentario="+this.comentario+"]\n";
    }
}
