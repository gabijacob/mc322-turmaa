package lab05;
import java.util.*;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero_cliente;
    private String educacao_cliente;
    private Date dataNascimento_cliente;
    private ArrayList<Veiculo> listaVeiculos_cliente;

    public ClientePF(String nome, String telefone, String endereco, String email, String cpf, String genero, String educacao,  Date dataNascimento, ArrayList<Veiculo> listaVeiculos){
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.genero_cliente = genero;
        this.educacao_cliente = educacao;
        this.dataNascimento_cliente = dataNascimento;
        this.listaVeiculos_cliente = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public String getGenero_cliente() {
		return genero_cliente;
	}

	public void setGenero_cliente(String genero_cliente) {
		this.genero_cliente = genero_cliente;
	}
	
    public String getEducacao_cliente() {
		return educacao_cliente;
	}

	public void setEducacao_cliente(String educacao_cliente) {
		this.educacao_cliente = educacao_cliente;
	}

    public Date getDataNascimento_cliente() {
        return dataNascimento_cliente;
    }

    public void setDataNascimento_cliente(Date dataNascimento) {
        this.dataNascimento_cliente = dataNascimento;
    }
    
    public ArrayList<Veiculo> getListaVeiculos_cliente() {
        return listaVeiculos_cliente;
    }

    public void setListaVeiculos_cliente(ArrayList<Veiculo> listaVeiculos_cliente) {
        this.listaVeiculos_cliente = listaVeiculos_cliente;
    }

    public boolean cadastrarVeiculo(String placa, String marca, String modelo, int anoFabricação){
        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricação);
        listaVeiculos_cliente.add(veiculo);
        System.out.println("Veiculo adicionado com sucesso!");
        return true;
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

    @Override
    public String toString(){
        String listaVeiculosStr = "";
        for(Veiculo veiculo: listaVeiculos_cliente){
            listaVeiculosStr += veiculo.toString();
        }
        return "Nome: " + this.nome_cliente + "\nTelefone: " + this.telefone_cliente + "\nEndereco: " + this.endereco_cliente + "\nEmail: " + this.email_cliente + "\n:CPF: " + this.cpf + "\nGênero: " + this.genero_cliente + "\nEducação: " + this.educacao_cliente + "\nData de Nacimento: " + this.dataNascimento_cliente + "\n Lista de Veículos: " + listaVeiculosStr;
    }
}