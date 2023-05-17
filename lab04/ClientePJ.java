package lab04;
import java.util.*;

public class ClientePJ extends Cliente{

    private final String cnpj;
    private Date dataFundacao;
    private int qnt_funcionarios;

    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, double valorSeguro, String cnpj, Date dataFundacao, int qnt_funcionarios){
        super(nome, endereco, listaVeiculos, valorSeguro);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qnt_funcionarios = qnt_funcionarios;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getqnt_funcionarios() {
        return qnt_funcionarios;
    }

    public void setqnt_funcionarios(int qnt_funcionarios) {
        this.qnt_funcionarios = qnt_funcionarios;
    }

    public double calculaScore(ClientePJ cliente){
        int qnt_carros = 0;
        double score;
        for(Veiculo veiculo_iterado: cliente.getListaVeiculos_cliente()){
            qnt_carros ++;
        }
        score = CalcSeguro.VALOR_BASE.get_fator() * (1 + (cliente.getqnt_funcionarios())/100) * qnt_carros;
        return score;
    }

    @Override
    public String toString(ArrayList<Veiculo> listaVeiculos_cliente){
        String listaVeiculosStr = "";
        for(Veiculo veiculo: listaVeiculos_cliente){
            listaVeiculosStr += veiculo.toString();
        }
        return "Nome: " + this.nome_cliente + "\nEndereco: " + this.endereco_cliente + "\nLista de Veículos" + listaVeiculosStr + "\nValor do Seguro: " + this.valorSeguro_cliente + "\nCNPJ: " + this.cnpj + "\nData de Fundação: " + this.dataFundacao;
    }
}