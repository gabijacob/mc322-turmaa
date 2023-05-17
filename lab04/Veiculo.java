package lab04;

public class Veiculo {
	
	private String placa_veiculo;
    private String marca_veiculo;
    private String modelo_veiculo;
    private int anoFabricacao_veiculo;

    //Construtor
    public Veiculo(String placa, String marca, String modelo, int anoFabricacao){
        this.placa_veiculo = placa;
        this.marca_veiculo = marca;
        this.modelo_veiculo = modelo;
        this.anoFabricacao_veiculo = anoFabricacao;
    }

    // Getters e setters
    public String getPlaca(){
        return placa_veiculo;
    }

    public void setPlaca(String placa){
        this.placa_veiculo = placa;
    }

	public String getMarca() {
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
    
    public int getAnoFabricacao() {
		return anoFabricacao_veiculo;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao_veiculo = anoFabricacao;
	}
	
	public String toString() {
		return "Placa: " + this.placa_veiculo + "\nMarca: " + this.marca_veiculo + "\nModelo: " + this.modelo_veiculo + "\nAno de Fabricação: " + this.anoFabricacao_veiculo;
	}    
}
