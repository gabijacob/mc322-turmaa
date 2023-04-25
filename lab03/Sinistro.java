package lab03;
import java.lang.Math;

public class Sinistro {
	private final int id_sinitro;
    private String data_sinistro;
    private String endereco_sinistro;
    private Seguradora seguradora_sinistro;
    private Veiculo veiculo_sinistro;
    private Cliente cliente_sinistro;

    //construtor
    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        this.id_sinitro = setId();
        this.data_sinistro = data;
        this.endereco_sinistro = endereco;
        this.seguradora_sinistro = seguradora;
        this.veiculo_sinistro = veiculo;
        this.cliente_sinistro = cliente;
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

    public Seguradora getSeguradora_sinistro() {
        return seguradora_sinistro;
    }

    public void setSeguradora_sinistro(Seguradora seguradora_sinistro) {
        this.seguradora_sinistro = seguradora_sinistro;
    }
    
    public Veiculo getVeiculo_sinistro() {
        return veiculo_sinistro;
    }

    public void setVeiculo_sinistro(Veiculo veiculo_sinistro) {
        this.veiculo_sinistro = veiculo_sinistro;
    }

    public Cliente getcliente_sinistro() {
        return cliente_sinistro;
    }

    public void setcliente_sinistro(Cliente cliente_sinistro) {
        this.cliente_sinistro = cliente_sinistro;
    }

    public String toString(){
        return "ID: " + this.id_sinitro + "\nData: " + this.data_sinistro + "\nEndereço: " + this.endereco_sinistro + "\nNome da Seguradora: " + this.seguradora_sinistro.getNome() + "\nVeículo: " + this.veiculo_sinistro + "\nNome do Cliente: " + this.cliente_sinistro.getNome();
    }

}
