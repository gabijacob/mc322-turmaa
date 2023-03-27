package lab2;
import java.lang.Math;

public class Sinistro {
    private int id_sinitro;
    private String data_sinistro;
    private String endereco_sinistro;

    //construtor
    public Sinistro(String data, String endereco){
        this.id_sinitro = setId();
        this.data_sinistro = data;
        this.endereco_sinistro = endereco;
    }

    //getters e setters

    public int getId(){
        return id_sinitro;
    }

    public int setId(){
        int max = 9999;
        int min = 1;
        int range = max - min + 1;

        // gerando numeros aleatórios de id entre 1 e 9999
        int id = (int)(Math.random() * range) + min;
        return id;
    }

    public String getData(){
        return data_sinistro;
    }

    public void setData(String data){
        this.data_sinistro = data;
    }

    public String getEndereco(){
        return endereco_sinistro;
    }

    public void setEndereco(String endereco){
        this.endereco_sinistro = endereco;
    }
}
