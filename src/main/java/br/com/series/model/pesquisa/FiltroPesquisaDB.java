package br.com.series.model.pesquisa;

public class FiltroPesquisaDB {
    public static String TYPE_STRING = "string";
    public static String TYPE_INTEGER = "integer";
    private String type;
    private Integer position;

    private String value;

    public FiltroPesquisaDB(){

    }
    public FiltroPesquisaDB(String type, Integer position, String value){
        this.type = type;
        this.position = position;
        this.value = value;
    }

    public String getType(){
        return this.type;
    }

    public String getValue(){
        return this.value;
    }

    public Integer getPosition(){
        return this.position;
    }

    public String toString(){
        return "FiltroPesquisaDB [type="+this.type+",position="+this.position+" ,value="+this.value+"]\n";
    }
}
