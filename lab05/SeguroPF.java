package lab05;

import java.util.*;
import java.time.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SeguroPF extends Seguro{
    private Veiculo veiculo_seguro;
    private ClientePF cliente_seguro;
    static Scanner scanner = new Scanner(System.in);
    
    public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, double valorMensal, Veiculo veiculo_seguro, ClientePF cliente_seguro) {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores);
        this.veiculo_seguro = veiculo_seguro;
        this.cliente_seguro = cliente_seguro;
    }

    public Veiculo getVeiculo_seguro() {
        return veiculo_seguro;
    }

    public void setVeiculo_seguro(Veiculo veiculo_seguro) {
        this.veiculo_seguro = veiculo_seguro;
    }

    public Cliente getCliente_seguro() {
        return cliente_seguro;
    }

    public void setCliente_seguro(ClientePF cliente_seguro) {
        this.cliente_seguro = cliente_seguro;
    }

    @Override
    public boolean autorizarCondutor(){
        SimpleDateFormat formata_data = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Vamos cadastrar um condutor!");
        System.out.println("CPF: ");
        String cpf = scanner.next();
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Telefone: ");
        String telefone = scanner.next();
        System.out.println("Endereço: ");
        String endereco = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Data de Nascimento (No formato: DD-MM-AAAA): ");
        String dataNasc = scanner.next();
        try {
            Date dateNasc = formata_data.parse(dataNasc);
            Condutor condutor = new Condutor(cpf, nome, telefone, endereco, email, dateNasc, null);
            System.out.println("Por padrão, a lista de sinistros se inicia zerada. Caso deseje cadastrar um sinistro, basta utilizar o menu.");
            getListaCondutores_seguro().add(condutor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Condutor cadastrado com sucesso!");
        return true;
    }
    
    @Override
    public boolean autorizarCondutor(Condutor condutor){
        getListaCondutores_seguro().add(condutor);
        System.out.println("Condutor autorizado com sucesso!");

        return true;
    }

    @Override
    public boolean desautorizarCondutor(Condutor condutor){
        for(Condutor condutor_iterado : getListaCondutores_seguro()){
            if(condutor.getCpf_condutor() == condutor_iterado.getCpf_condutor()){
                getListaCondutores_seguro().remove(condutor);
            }
        }
        System.out.println("Condutor desautorizado com sucesso!");
        return true;
    }

    @Override
    public boolean gerarSinistro(Sinistro sinistro){
        listaSinistros_seguro.add(sinistro);
        System.out.println("Sinistro gerado com sucesso!");
        return true;
    }

    @Override
    public boolean gerarSinistro(Seguro seguro){
        SimpleDateFormat formata_data = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Data do sinistro (No formato: DD-MM-AAAA): ");
        String data_sinistro = scanner.next();
        try {
            Date dateNasc = formata_data.parse(data_sinistro);
            System.out.println("Endereço: ");
            String endereco = scanner.next();
            System.out.println("Digite o cnpj da condutor responsável pelo sinistro: ");
            String cnpj_condutor = scanner.next();
            Condutor condutor = procuraCondutor(cnpj_condutor);
            Sinistro sinistro = new Sinistro(dateNasc, endereco, condutor, seguro);
            listaSinistros_seguro.add(sinistro);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Sinistro gerado com sucesso!");
        return true;
    }

    @Override
    public double calcularValor(){
        // Calculando a idade do cliente para descobrir qual o fator idade que será usado na fórmula que calcula do valor do seguro:
        double valor;
        int idade;
        ClientePF cliente = (ClientePF)cliente_seguro;
        if(cliente_seguro != null){
            LocalDate data_nasciemtnoLD = LocalDate.ofInstant((cliente).getDataNascimento_cliente().toInstant(), ZoneId.systemDefault());        
            LocalDate hoje = LocalDate.now();
            idade = Period.between(data_nasciemtnoLD, hoje).getYears();
            double qnt_veiculos = 0;
            for(Veiculo veiculo_iterado: cliente.getListaVeiculos_cliente()){
                qnt_veiculos ++;
            }

            double qnt_sinistros_cliente = 0;
            for(Sinistro sinistro: listaSinistros_seguro){
                qnt_sinistros_cliente++;
            }

            double qnt_sinistros_condutor = 0;
            for(Condutor condutor: listaCondutores_seguro){
                for(Sinistro sinistro: condutor.getListaSinistros_condutor()){
                    qnt_sinistros_condutor++;
                }
            }

            if((18 < idade) && (idade < 30)){
                valor = CalcSeguro.VALOR_BASE.get_fator() * CalcSeguro.FATOR_18_30.get_fator() * (1 + (1/qnt_veiculos)) * (2 + qnt_sinistros_cliente) * (5 + qnt_sinistros_condutor);
                return valor;
            } 

            else if((30 <= idade) && (idade < 60)){
                valor = CalcSeguro.VALOR_BASE.get_fator() * CalcSeguro.FATOR_30_60.get_fator() * (1 + (1/qnt_veiculos)) * (2 + qnt_sinistros_cliente) * (5 + qnt_sinistros_condutor);
                return valor;
            }

            else if((60 <= idade) && (idade < 90)){
                valor = CalcSeguro.VALOR_BASE.get_fator() * CalcSeguro.FATOR_60_90.get_fator() * (1 + (1/qnt_veiculos)) * (2 + qnt_sinistros_cliente) * (5 + qnt_sinistros_condutor);
                return valor;
                }
            }
        return 0;
    }

    @Override
    public String toString(){
        String listaSinistros_str = "";
        for(Sinistro sinistro_iterarado: listaSinistros_seguro){
            listaSinistros_str += sinistro_iterarado.getId() + "\n";
        }

        String listaCondutores_str = "";
        for(Condutor condutor_iterado: listaCondutores_seguro){
            listaCondutores_str += condutor_iterado.getCpf_condutor() + "\n";
        }
        return "ID do seguro: " + this.id_seguro + "\nData de início do seguro: " + this.dataInicio_seguro + "\nData do fim do seguro: " + this.dataFim_seguro + "\nSeguradora: " + this.seguradora_seguro.getNome_seguradora() + "\nLista de sinistros: " + listaSinistros_str + "\nLista de Condutores: " + listaCondutores_str + "\nVeículo: " + this.veiculo_seguro.getPlaca() + "\nCliente: " + this.cliente_seguro.getCpf();
    }
}
