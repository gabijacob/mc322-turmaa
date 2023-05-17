package lab04;
import java.util.*;
import java.time.*;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero_cliente;
    private Date dataLicenca_cliente;
    private String educacao_cliente;
    private Date dataNascimento_cliente;
    private String classeEconomica_cliente;

    public ClientePF(String nome, String endereco, ArrayList<Veiculo> listaVeiculos,  double valorSeguro, String cpf, String genero, Date dataLicenca, String educacao,  Date dataNascimento, String classeEconomica){
        super(nome, endereco, listaVeiculos, valorSeguro);
        this.cpf = cpf;
        this.genero_cliente = genero;
        this.dataLicenca_cliente = dataLicenca;
        this.educacao_cliente = educacao;
        this.dataNascimento_cliente = dataNascimento;
        this.classeEconomica_cliente = classeEconomica;
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

    public Date getDataLicenca_cliente() {
		return dataLicenca_cliente;
	}

	public void setDataLicenca_cliente(Date dataLicenca_cliente) {
		this.dataLicenca_cliente = dataLicenca_cliente;
	}
	
    public String getEducacao_cliente() {
		return educacao_cliente;
	}

	public void setEducacao_cliente(String educacao_cliente) {
		this.educacao_cliente = educacao_cliente;
	}

    public Date getDataNascimento() {
        return dataNascimento_cliente;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento_cliente = dataNascimento;
    }

	public String getClasseEconomica_cliente() {
		return classeEconomica_cliente;
	}

	public void setClasseEconomica_cliente(String classeEconomica_cliente) {
		this.classeEconomica_cliente = classeEconomica_cliente;
	}

    public double calculaScore(ClientePF cliente){
        double score;
        int idade;
        LocalDate data_nasciemtnoLD = LocalDate.ofInstant(cliente.dataNascimento_cliente.toInstant(), ZoneId.systemDefault());        
        LocalDate hoje = LocalDate.now();
        idade = Period.between(data_nasciemtnoLD, hoje).getYears();
        int qnt_carros = 0;
        for(Veiculo veiculo_iterado: cliente.getListaVeiculos_cliente()){
            qnt_carros ++;
        }

        if((18 < idade) && (idade < 30)){
            score = CalcSeguro.VALOR_BASE.get_fator() * CalcSeguro.FATOR_18_30.get_fator() * qnt_carros;
            return score;
        } 

        else if((30 <= idade) && (idade < 60)){
            score = CalcSeguro.VALOR_BASE.get_fator() * CalcSeguro.FATOR_30_60.get_fator() * qnt_carros;
            return score;
        }

        else if((60 <= idade) && (idade < 90)){
            score = CalcSeguro.VALOR_BASE.get_fator() * CalcSeguro.FATOR_60_90.get_fator() * qnt_carros;
            return score;
        }
        return 0;
    }

    @Override
    public String toString(ArrayList<Veiculo> listaVeiculos_cliente){
        String listaVeiculosStr = "";
        for(Veiculo veiculo: listaVeiculos_cliente){
            listaVeiculosStr += veiculo.toString();
        }
        return "Nome: " + this.nome_cliente + "\nEndereco: " + this.endereco_cliente + "\n Lista de Veículos: " + listaVeiculosStr + "\nValor do Seguro: " + this.valorSeguro_cliente + "\nGênero: " + this.genero_cliente + "\nData da Licença: " + this.dataLicenca_cliente + "\nEducação: " + this.educacao_cliente + "\nData de Nacimento: " + this.dataNascimento_cliente + "\nClasse Econômica: " + this.classeEconomica_cliente;
    }
}