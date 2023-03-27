package lab2;

public class Veiculo {
    private String placa_veiculo;
    private String marca_veiculo;
    private String modelo_veiculo;

    //Construtor
    public Veiculo(String placa, String marca, String modelo){
        this.placa_veiculo = placa;
        this.marca_veiculo = marca;
        this.modelo_veiculo = modelo;
    }

    // Getters e setters
    public String getPlaca(){
        return placa_veiculo;
    }

    public void setPlaca(String placa){
        this.placa_veiculo = placa;
    }

    public String getMarca(){
        return marca_veiculo;
    }

    public void setMarca(String marca){
        this.marca_veiculo = marca;
    }

    public String getModelo(){
        return modelo_veiculo;
    }

    public void setModelo(String modelo){
        this.modelo_veiculo = modelo;
    }
}
