package lab05;
import java.util.*;

public class ClientePJ extends Cliente{

    private final String cnpj;
    private Date dataFundacao_cliente;
    protected ArrayList<Frota> listaFrota_cliente;
    private int qnt_funcionarios_cliente;

    public ClientePJ(String nome, String telefone, String endereco, String email, String cnpj, Date dataFundacao, ArrayList<Frota> listaFrota, int qnt_funcionarios){
        super(nome, telefone, endereco, email);
        this.cnpj = cnpj;
        this.dataFundacao_cliente = dataFundacao;
        this.qnt_funcionarios_cliente = qnt_funcionarios;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao_cliente;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao_cliente = dataFundacao;
    }
    
    public ArrayList<Frota> getListaFrota_cliente() {
        return listaFrota_cliente;
    }

    public void setListaFrota_cliente(ArrayList<Frota> listaFrota_cliente) {
        this.listaFrota_cliente = listaFrota_cliente;
    }

    public int getQnt_funcionarios_cliente() {
        return qnt_funcionarios_cliente;
    }

    public void setQnt_funcionarios_cliente(int qnt_funcionarios_cliente) {
        this.qnt_funcionarios_cliente = qnt_funcionarios_cliente;
    }

    public boolean cadastrarFrota(Frota frota){
        listaFrota_cliente.add(frota);
        System.out.println("Frota cadastrada com sucesso!");
        return true;
    }

    public boolean adicionarVeiculo(Frota frota, String placa, String marca, String modelo, int anoFabricação){
        for(Frota frota_iterada: getListaFrota_cliente()){
            if(frota.getCode_frota() == frota_iterada.getCode_frota()){
                frota.cadastrarVeiculo(placa, marca, modelo, anoFabricação);
            }
        }
        System.out.println("Frota atualizada com sucesso: veículo de placa" + placa + "adicionado com sucesso!");
        return true;
    }

    public boolean removerVeiculo(Frota frota, String placa){
        for(Frota frota_iterada: getListaFrota_cliente()){
            if(frota.getCode_frota() == frota_iterada.getCode_frota()){
                frota.removerVeiculo(placa);
            }
        } 
        return true;
    }

    public boolean removerFrota(Frota frota){
        for(Frota frota_iterada: getListaFrota_cliente()){
            if(frota.getCode_frota() == frota_iterada.getCode_frota()){
                getListaFrota_cliente().remove(frota);
            }
        } 
        return true;
    }

    public boolean getVeiculosPorFrota(){
        for(Frota frota_iterada: listaFrota_cliente){
            for(Veiculo veiculo_iterado: frota_iterada.getListaVeiculos_frota()){
                System.out.println(veiculo_iterado.toString());
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String listaFrotas_str = "";
        for(Frota frota_iterada : listaFrota_cliente){
            listaFrotas_str = listaFrotas_str + frota_iterada.getCode_frota() + "\n";
        }
        return "Nome: " + this.nome_cliente + "\nTelefone: " + this.telefone_cliente + "\nEndereco: " + this.endereco_cliente + "\nEmail: " + this.email_cliente + "\nCNPJ: " + this.cnpj + "\nData de Fundação: " + this.dataFundacao_cliente + "\nFrotas: " + listaFrotas_str;
    }
}