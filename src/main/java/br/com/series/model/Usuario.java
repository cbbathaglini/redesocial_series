package br.com.series.model;

public class Usuario {
    private Integer id;
    private String name;
    private String email;

    public Usuario(Integer id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId(){
        return this.id;
    }

}
