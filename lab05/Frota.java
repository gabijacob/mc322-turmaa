package lab05;

import java.util.ArrayList;

public class Frota {
    private String code_frota;
    private ArrayList<Veiculo> listaVeiculos_frota;

    public Frota(String code, ArrayList<Veiculo> listaVeiculos){
        this.code_frota = code;
        this.listaVeiculos_frota = listaVeiculos;
    }

    public String getCode_frota() {
        return code_frota;
    }

    public void setCode_frota(String code_frota) {
        this.code_frota = code_frota;
    }
    
    public ArrayList<Veiculo> getListaVeiculos_frota() {
        return listaVeiculos_frota;
    }

    public void setListaVeiculos_frota(ArrayList<Veiculo> listaVeiculos_frota) {
        this.listaVeiculos_frota = listaVeiculos_frota;
    } 

    public boolean cadastrarVeiculo(String placa, String marca, String modelo, int anoFabricação){
        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricação);
        listaVeiculos_frota.add(veiculo);
        System.out.println("Veiculo adicionado com sucesso!");
        return true;
    }

    public boolean removerVeiculo(String placa){
        for(Veiculo veiculo_iterado: listaVeiculos_frota){
            if(veiculo_iterado.getPlaca().equals(placa)){
                listaVeiculos_frota.remove(veiculo_iterado);
                System.out.println("Veículo removido com sucesso!");
            }
        }
        return true;
    }

    public String toString(){
        String listaVeiculosStr = "";
        for(Veiculo veiculo: listaVeiculos_frota){
            listaVeiculosStr = veiculo.getPlaca() + "\n";
        }
        return "Code: " + this.code_frota + "\nLista de Veículos: " + listaVeiculosStr;
    }
}
