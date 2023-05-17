package lab04;

import java.util.*;

public class Cliente {
	protected String nome_cliente;
    protected String endereco_cliente;
    private ArrayList<Veiculo> listaVeiculos_cliente;
    protected double valorSeguro_cliente;

    public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, double valorSeguro){
        this.nome_cliente = nome;
        this.endereco_cliente = endereco;  
        this.listaVeiculos_cliente = new ArrayList<>();
        this.valorSeguro_cliente = valorSeguro;
    }

    public String getNome(){
        return nome_cliente;
    }

    public void setNome(String nome){
        this.nome_cliente = nome;
    }

    public String getEndereco(){
        return endereco_cliente;
    }

    public void setEndereco(String endereco){
        this.endereco_cliente = endereco;
    }

    public ArrayList<Veiculo> getListaVeiculos_cliente() {
        return listaVeiculos_cliente;
    }

    public void setListaVeiculos_cliente(ArrayList<Veiculo> listaVeiculos_cliente) {
        this.listaVeiculos_cliente = listaVeiculos_cliente;
    }

    public void adicionaVeiculo(Veiculo veiculo){
        listaVeiculos_cliente.add(veiculo);
    }

    public double getvalorSeguro() {
        return valorSeguro_cliente;
    }

    public void setvalorSeguro(double valorSeguro) {
        valorSeguro_cliente = valorSeguro;
    }

    public double calculaScore(Cliente cliente){
        return 0;
    }

    public boolean removerVeiculo(String placa){
        for(Veiculo veiculo_iterado: listaVeiculos_cliente){
            if(veiculo_iterado.getPlaca().equals(placa)){
                listaVeiculos_cliente.remove(veiculo_iterado);
                System.out.println("Veículo removido com sucesso!");
            }
        }
        return true;
    }

    public String toString(ArrayList<Veiculo> listaVeiculos_cliente){
        String listaVeiculosStr = "";
        for(Veiculo veiculo: listaVeiculos_cliente){
            listaVeiculosStr += veiculo.toString();
        }
        return "Nome:" + this.nome_cliente + "\nEndereco:" + this.endereco_cliente + "\nVeículos: " + listaVeiculosStr + "\nValor do Seguro:" + valorSeguro_cliente;
    }
}