package br.com.series.model;

public class Usuario {
    private Integer id;
    private String name;
    private String email;

    public Usuario(){}
    public Usuario(Integer id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String toString(){
        return "Usuario [id= "+this.id+
                " ,name="+this.name+
                " ,email="+this.email+
                "]\n";
    }

}
