package lab05;
import java.lang.Math;
import java.util.*;

public class Sinistro {
	private final int id_sinitro;
    private Date data_sinistro;
    private String endereco_sinistro;
    private Condutor condutor_sinistro;
    private Seguro seguro_sinistro;

    public Sinistro(Date data, String endereco, Condutor condutor, Seguro seguro){
        this.id_sinitro = setId();
        this.data_sinistro = data;
        this.endereco_sinistro = endereco;
        this.condutor_sinistro = condutor;
        this.seguro_sinistro = seguro;
    }

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

    public Date getData(){
        return data_sinistro;
    }

    public void setData(Date data){
        this.data_sinistro = data;
    }

    public String getEndereco(){
        return endereco_sinistro;
    }

    public void setEndereco(String endereco){
        this.endereco_sinistro = endereco;
    }

    public Condutor getCondutor_sinistro() {
        return condutor_sinistro;
    }

    public void setCondutor_sinistro(Condutor condutor_sinistro) {
        this.condutor_sinistro = condutor_sinistro;
    }

    public Seguro getSeguro_sinistro() {
        return seguro_sinistro;
    }

    public void setSeguro_sinistro(Seguro seguro_sinistro) {
        this.seguro_sinistro = seguro_sinistro;
    }

    public String toString(){
        return "ID: " + this.id_sinitro + "\nData: " + this.data_sinistro + "\nEndereço: " + this.endereco_sinistro + "\nCPF do condutor: " + this.condutor_sinistro.getCpf_condutor() + "\nID do Seguro: " + this.seguro_sinistro.getId_seguro();
    }
}