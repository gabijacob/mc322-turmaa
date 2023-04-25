package lab03;

import java.util.*;

public class Cliente {
	protected String nome_cliente;
    protected String endereco_cliente;
    private ArrayList<Veiculo> listaVeiculos_cliente;

    //Constructor
    public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos){
        this.nome_cliente = nome;
        this.endereco_cliente = endereco;  
        this.listaVeiculos_cliente = new ArrayList<>();
    }

	//Getters e setters
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

    public String toString(ArrayList<Veiculo> listaVeiculos_cliente){
        String listaVeiculosStr = "";
        for(Veiculo veiculo: listaVeiculos_cliente){
            listaVeiculosStr += veiculo.toString();
        }
        return "Nome:" + this.nome_cliente + "\nEndereco:" + this.endereco_cliente + "\nVeículos: " + listaVeiculosStr;
    }

}
