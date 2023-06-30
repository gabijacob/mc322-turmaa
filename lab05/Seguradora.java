package lab05;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;

public class Seguradora {
    static Scanner scanner = new Scanner(System.in);
    private final String cnpj_seguradora;
	private String nome_seguradora;
    private String telefone_seguradora;
    private String email_seguradora;
    private String endereco_seguradora;
    private ArrayList<Cliente> listaClientes_seguradora;
    private ArrayList<Seguro> listaSeguros_seguradora;


    public Seguradora(String cnpj, String nome, String telefone, String email, String endereco, ArrayList<Cliente> listaClientes,ArrayList<Seguro> listaSeguros_seguradora) {
        this.cnpj_seguradora = cnpj;
        this.nome_seguradora = nome;
        this.telefone_seguradora = telefone;
        this.email_seguradora = email;
        this.endereco_seguradora = endereco;
        this.listaClientes_seguradora = new ArrayList<>();
        this.listaSeguros_seguradora = new ArrayList<>();
    }

    public String getCnpj_seguradora(){
        return this.cnpj_seguradora;
    }

    public String getNome_seguradora() {
        return nome_seguradora;
    }

    public void setNome_seguradora(String nome_seguradora) {
        this.nome_seguradora = nome_seguradora;
    }

    public String getTelefone_seguradora() {
        return telefone_seguradora;
    }

    public void setTelefone_seguradora(String telefone_seguradora) {
        this.telefone_seguradora = telefone_seguradora;
    }

    public String getEmail_seguradora() {
        return email_seguradora;
    }

    public void setEmail_seguradora(String email_seguradora) {
        this.email_seguradora = email_seguradora;
    }

    public String getEndereco_seguradora() {
        return endereco_seguradora;
    }

    public void setEndereco_seguradora(String endereco_seguradora) {
        this.endereco_seguradora = endereco_seguradora;
    }

    public ArrayList<Cliente> getListaClientes_seguradora() {
        return listaClientes_seguradora;
    }

    public void setListaClientes_seguradora(ArrayList<Cliente> listaClientes_seguradora) {
        this.listaClientes_seguradora = listaClientes_seguradora;
    }

    public ArrayList<Seguro> getListaSeguros_seguradora() {
        return listaSeguros_seguradora;
    }

    public void setListaSeguros_seguradora(ArrayList<Seguro> listaSeguros_seguradora) {
        this.listaSeguros_seguradora = listaSeguros_seguradora;
    }

    //função que itera sobre todos os clientes e printa pelo toString
    public void listarClientes(){
        System.out.println("\nLista de clietes da seguradora " + this.nome_seguradora + "\n");
        for(Cliente cliente_iterado: listaClientes_seguradora){
            System.out.println(cliente_iterado.toString());
            System.out.println("\n");
        }
    }

    public void listarSeguros(){
        System.out.println("\nLista de seguros da seguradora " + this.nome_seguradora + "\n");
        for(Seguro seguro_iterado: listaSeguros_seguradora){
            System.out.println(seguro_iterado.toString());
            System.out.println("\n");
        } 
    }

    public boolean gerarSeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, double valorMensal, Veiculo veiculo_seguro, ClientePF cliente_seguro){
        Seguro novo_seguro = new SeguroPF(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal, veiculo_seguro, cliente_seguro);
        listaSeguros_seguradora.add(novo_seguro);
        System.out.println("Seguro de Pessoa Física adicionado com sucesso!");
        return true;
    }

    public boolean gerarSeguroPJ(Date dataInicio, Date dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, double valorMensal, Frota frota, ClientePJ cliente){
        Seguro novo_seguro = new SeguroPJ(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal, frota, cliente);
        listaSeguros_seguradora.add(novo_seguro);
        System.out.println("Seguro de Pessoa Jurídica adicionado com sucesso!");
        return true;
    }

    public boolean cancelarSeguro(Seguro seguro){
        for(Seguro seguro_iterado: listaSeguros_seguradora){
            if(seguro_iterado.getId_seguro() == seguro.getId_seguro()){
                listaSeguros_seguradora.remove(seguro);
            }
        }
        System.out.println("Seguro cancelado com sucesso!");
        return true;
    }

    public boolean cadastrarClientePF(ClientePF cliente){
        listaClientes_seguradora.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
        return true;
    }

    public boolean cadastrar_cliente() throws ParseException {
        SimpleDateFormat formata_data = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Digite 1 se o cliente for Pessoa Física, e 2 se for Pessoa Jurídica.");
        String pessoa_str = scanner.next();
        int pessoa_int = Integer.parseInt(pessoa_str);
        if(pessoa_int == 1){
            System.out.println("Já que o cliente é uma Pessoa Física, comece digitando o cpf.");
            String cpf = scanner.next();
            Validacao.ValidacaoCPF validador = new Validacao.ValidacaoCPF(cpf);
            if(!validador.validaCpf(cpf)){
                System.out.println("Digite um cpf válido.");
                cpf = scanner.next();
            }
            System.out.println("Nome: ");
            String nome = scanner.next();
            System.out.println("Telefone: ");
            String telefone = scanner.next();
            System.out.println("Endereço: ");
            String endereco = scanner.next();
            System.out.println("Email: ");
            String email = scanner.next();
            System.out.println("Gênero: ");
            String genero = scanner.next();
            System.out.println("Educação: ");
            String educacao = scanner.next();
            System.out.println("Data de Nascimento (No formato: DD-MM-AAAA): ");
            String dataNasc = scanner.next();
            Date dateNasc = formata_data.parse(dataNasc);
            System.out.println("Quantos veículos o cliente possui?");
            String numero_veiculos_str = scanner.next();
            int numero_veiculos_int = Integer.parseInt(numero_veiculos_str);
            ArrayList<Veiculo> listaVeiculos = new ArrayList<>();

            while(numero_veiculos_int != 0){
                System.out.println("Vamos cadastrar um veículo.");
                System.out.println("Placa do veículo: ");
                String placa = scanner.next();
                System.out.println("Marca do veículo: ");
                String marca = scanner.next();
                System.out.println("Modelo do veículo: ");
                String modelo = scanner.next();
                System.out.println("Ano de Fabricação do veículo: ");
                String ano_fabricacao_str = scanner.next();
                int ano_fabricacao_int = Integer.parseInt(ano_fabricacao_str);
                Veiculo veiculo = new Veiculo(placa, marca, modelo, ano_fabricacao_int);
                listaVeiculos.add(veiculo);
                numero_veiculos_int--;
            }
            Cliente clientePF = new ClientePF(nome, telefone, endereco, email, cpf, genero, educacao, dateNasc, listaVeiculos);
            listaClientes_seguradora.add(clientePF);
            System.out.println("Cliente adicionado com sucesso!");
            return true; 

        } else if(pessoa_int == 2){
            System.out.println("Já que o cliente é uma Pessoa Jurídica, comece digitando o cnpj.");
            String cnpj = scanner.next();
            if(!Validacao.ValidacaoCNPJ.validaCnpj(cnpj)){
                System.out.println("Digite um cnpj válido!");
                cnpj = scanner.next();
            }
            System.out.println("Nome: ");
            String nome = scanner.next();
            System.out.println("Telefone: ");
            String telefone = scanner.next();
            System.out.println("Endereço: ");
            String endereco = scanner.next();
            System.out.println("Email: ");
            String email = scanner.next();
            System.out.println("Data de Fundação: ");
            String dataFundacao = scanner.next();
            Date dateFundacao = formata_data.parse(dataFundacao);
            System.out.println("Número de funcionários: ");
            String numFuncionarios_str = scanner.next();
            int numFuncionarios_int = Integer.parseInt(numFuncionarios_str);
            System.out.println("Quantas frotas o cliente possui?: ");
            String qnt_frotas_str = scanner.next();
            int qnt_frotas_int = Integer.parseInt(qnt_frotas_str);

            ArrayList<Frota> listaFrotas = new ArrayList<>();
            while(qnt_frotas_int != 0){
                System.out.println("Vamos cadastrar uma frota.");
                System.out.println("Código da Frota: ");
                String code = scanner.next();
                System.out.println("Quantos veículos a frota possui?");
                String numero_veiculos_str = scanner.next();
                int numero_veiculos_int = Integer.parseInt(numero_veiculos_str);
                ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
                while(numero_veiculos_int != 0){
                    System.out.println("Vamos cadastrar um veículo.");
                    System.out.println("Placa do veículo: ");
                    String placa = scanner.next();
                    System.out.println("Marca do veículo: ");
                    String marca = scanner.next();
                    System.out.println("Modelo do veículo: ");
                    String modelo = scanner.next();
                    System.out.println("Ano de Fabricação do veículo: ");
                    String ano_fabricacao_str = scanner.next();
                    int ano_fabricacao_int = Integer.parseInt(ano_fabricacao_str);
                    Veiculo veiculo = new Veiculo(placa, marca, modelo, ano_fabricacao_int);
                    listaVeiculos.add(veiculo);
                    numero_veiculos_int--;
                }
                Frota frota = new Frota(code, listaVeiculos);
                listaFrotas.add(frota);
                qnt_frotas_int--;
            }
            ClientePJ clientePJ = new ClientePJ(nome, telefone, endereco, email, cnpj, dateFundacao, null, numFuncionarios_int);
            listaClientes_seguradora.add(clientePJ);
            System.out.println("Cliente adicionado com sucesso!");
            return true;
        } 
        return false;
    }
    
    public boolean cadastrarVeiculo(){
        System.out.println("Vamos cadastrar um veículo.");
        System.out.println("Placa do veículo: ");
        String placa = scanner.next();
        System.out.println("Marca do veículo: ");
        String marca = scanner.next();
        System.out.println("Modelo do veículo: ");
        String modelo = scanner.next();
        System.out.println("Ano de Fabricação do veículo: ");
        String ano_fabricacao_str = scanner.next();
        int ano_fabricacao_int = Integer.parseInt(ano_fabricacao_str);
        System.out.println("Digite 1 se o cliente ao qual o veículo deseja ser adicionado for Pessoa Física, e 2 se for Pessoa Jurídica.");
        String pessoa_str = scanner.next();
        int pessoa_int = Integer.parseInt(pessoa_str);
        if(pessoa_int == 1){
            System.out.println("Digite o cpf do cliente");
            String cpf = scanner.next();
            ClientePF clientePF = procuraClientePF(cpf);
            clientePF.cadastrarVeiculo(placa, marca, modelo, ano_fabricacao_int);
            SeguroPF seguroPF = procuraSeguroPF(placa);
            double novo_valor_seguro = seguroPF.calcularValor();
            seguroPF.setValorMensal_seguro(novo_valor_seguro);
            System.out.println("Veículo cadastrado com sucesso!");
            return true;
        } else if (pessoa_int == 2){
            System.out.println("Digite o cnpj do cliente");
            String cnpj_cliente = scanner.next();
            ClientePJ clientePJ = procuraClientePJ(cnpj_cliente);
            System.out.println("Digite o código da frota à qual o deseja-se adicionar o veículo.");
            String codigo = scanner.next();
            for(Frota frota_iterada: clientePJ.getListaFrota_cliente()){
                if(frota_iterada.getCode_frota().equals(codigo)){
                    frota_iterada.cadastrarVeiculo(placa, marca, modelo, ano_fabricacao_int);
                    SeguroPJ seguroPJ = procuraSeguroPJ(codigo);
                    double novo_valor_seguro = seguroPJ.calcularValor();
                    seguroPJ.setValorMensal_seguro(novo_valor_seguro);
                    System.out.println("Veículo cadastrado com sucesso!");
                    return true;
                }
            } 
        }
        return false;
    }

    public boolean cadastrarFrota(){
        System.out.println("Digite o código da nova frota: ");
        String code_frota = scanner.next();
        System.out.println("Digite o número de veículos que serão cadastrados na frota: ");
        String num_veiculos_str = scanner.next();
        int num_veiculos_int = Integer.parseInt(num_veiculos_str);
        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
        while(num_veiculos_int > 0){
            System.out.println("Vamos cadastrar um veículo.");
            System.out.println("Placa do veículo: ");
            String placa = scanner.next();
            System.out.println("Marca do veículo: ");
            String marca = scanner.next();
            System.out.println("Modelo do veículo: ");
            String modelo = scanner.next();
            System.out.println("Ano de Fabricação do veículo: ");
            String ano_fabricacao_str = scanner.next();
            int ano_fabricacao_int = Integer.parseInt(ano_fabricacao_str);
            Veiculo veiculo = new Veiculo(placa, marca, modelo, ano_fabricacao_int);
            listaVeiculos.add(veiculo);
            num_veiculos_int--;
        }
        Frota nova_frota = new Frota(code_frota, listaVeiculos);
        System.out.println("Digite o cnpj do cliente ao qual a nova frota pertence: ");
        String cnpj_cliente = scanner.next();
        ClientePJ clientePJ = procuraClientePJ(cnpj_cliente);
        clientePJ.getListaFrota_cliente().add(nova_frota);
        System.out.println("Frota cadastrada com sucesso");
        return true;         
    }

    public ClientePF procuraClientePF(String cpf){
        for(Cliente cliente_iterado : listaClientes_seguradora){
            if(cliente_iterado instanceof ClientePF){
                ClientePF clientePF = (ClientePF)cliente_iterado;
                if(clientePF.getCpf().equals(cpf)){
                    return clientePF;
                }
            }
        }
        return null;
    }

    public ClientePJ procuraClientePJ(String cnpj){
        for(Cliente cliente_iterado : listaClientes_seguradora){
            if(cliente_iterado instanceof ClientePJ){
                ClientePJ clientePJ = (ClientePJ)cliente_iterado;
                if(clientePJ.getCnpj().equals(cnpj)){
                    return clientePJ;
                }
            }
        }
        return null;   
    }

    public SeguroPF procuraSeguroPF(String placa){
        for(Seguro seguro_iterado : listaSeguros_seguradora){
            if(seguro_iterado instanceof SeguroPF){
                SeguroPF seguroPF = (SeguroPF)seguro_iterado;
                if(seguroPF.getVeiculo_seguro().getPlaca().equals(placa)){
                    return seguroPF;
                }
            }
        }
        return null;
    }

    public SeguroPJ procuraSeguroPJ(String codigo_frota){
        for(Seguro seguro_iterado : listaSeguros_seguradora){
            if(seguro_iterado instanceof SeguroPJ){
                SeguroPJ seguroPJ = (SeguroPJ)seguro_iterado;
                if(seguroPJ.getFrota_seguro().getCode_frota().equals(codigo_frota)){
                    return seguroPJ;
                }
            }
        }
        return null;
    }

    public Veiculo procuraVeiculoPJ(String placa){
        System.out.println("CNPJ do cliente: ");
        String cnpj = scanner.next();
        if(procuraClientePJ(cnpj) != null){
            ClientePJ clientePJ = procuraClientePJ(cnpj);
            for(Frota frota_iterada : clientePJ.getListaFrota_cliente()){
                for(Veiculo veiculo_iterado : frota_iterada.getListaVeiculos_frota()){
                    if(veiculo_iterado.getPlaca().equals(placa)){
                        return veiculo_iterado;
                    }
                }
            }
        }
        return null;
    }

    public boolean removerVeiculoPJ(String placa){
        //Excluindo o veiculo da lista de veiculos da frota do clientePJ
        System.out.println("CNPJ do cliente: ");
        String cnpj = scanner.next();
        if(procuraClientePJ(cnpj) != null){
            ClientePJ clientePJ = procuraClientePJ(cnpj);
            for(Frota frota_iterada : clientePJ.getListaFrota_cliente()){
                for(Veiculo veiculo_iterado : frota_iterada.getListaVeiculos_frota()){
                    if(veiculo_iterado.getPlaca().equals(placa)){
                        frota_iterada.getListaVeiculos_frota().remove(veiculo_iterado);
                        System.out.println("Veiculo removido com sucesso!");

                        //Atualizando o valorMensal do Seguro
                        SeguroPJ seguroPJ = procuraSeguroPJ(placa);
                        seguroPJ.setValorMensal_seguro(seguroPJ.calcularValor());
                        return true;
                    }
                }
            }
        }
        return false;       
    }

    public boolean cadastrarClientePJ(ClientePJ cliente){
        listaClientes_seguradora.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
        return true;
    }

    public boolean removerCliente(Cliente cliente){
        if(cliente instanceof ClientePF){
            ClientePF clientePF = (ClientePF)cliente;
            for(Cliente cliente_iterado : listaClientes_seguradora){
                ClientePF clientePF_iterado = (ClientePF)cliente_iterado;
                if(clientePF_iterado.getCpf().equals(clientePF.getCpf())){
                    listaClientes_seguradora.remove(clientePF);
                    System.out.println("Cliente removido com sucesso!");
                    return true;
                }
            }
        } else if (cliente instanceof ClientePJ){
            ClientePJ clientePJ = (ClientePJ)cliente;
            for(Cliente cliente_iterado : listaClientes_seguradora){
                if(cliente_iterado instanceof ClientePJ){
                    ClientePJ clientePJ_iterado = (ClientePJ)cliente_iterado;
                    if(clientePJ_iterado.getCnpj().equals(clientePJ.getCnpj())){
                        listaClientes_seguradora.remove(clientePJ);
                        System.out.println("Cliente removido com sucesso!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removerCliente(){
        System.out.println("Digite 1 se o cliente que deseja ser removido for Pessoa Física, e 2 se for Pessoa Jurídica.");
        String pessoa_str = scanner.next();
        int pessoa_int = Integer.parseInt(pessoa_str);
        if(pessoa_int == 1){
            System.out.println("CPF do cliente: ");
            String cpf = scanner.next();
            for(Cliente cliente_iterado : listaClientes_seguradora){
                if(cliente_iterado instanceof ClientePF){
                    ClientePF clientePF = (ClientePF)cliente_iterado;
                    if(clientePF.getCpf().equals(cpf)){
                        listaClientes_seguradora.remove(clientePF);
                        System.out.println("Cliente removido com sucesso!");
                        return true;
                    }
                }
            }
        } else if (pessoa_int == 2){
            System.out.println("CNPJ do cliente: ");
            String cnpj = scanner.next();
            for(Cliente cliente_iterado : listaClientes_seguradora){
                if(cliente_iterado instanceof ClientePJ){
                    ClientePJ clientePJ = (ClientePJ)cliente_iterado;
                    if(clientePJ.getCnpj().equals(cnpj)){
                        listaClientes_seguradora.remove(clientePJ);
                        System.out.println("Cliente removido com sucesso!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Seguro> getSegurosPorCliente(){
        ArrayList<Seguro> lista_SegurosPorCliente = new ArrayList<>();
        for(Cliente cliente_iterado: listaClientes_seguradora){
            for(Seguro seguro_iterado: listaSeguros_seguradora){
                if(seguro_iterado instanceof SeguroPF){
                    if(cliente_iterado == ((SeguroPF)seguro_iterado).getCliente_seguro()){
                        lista_SegurosPorCliente.add(seguro_iterado);
                    }
                }
                if(seguro_iterado instanceof SeguroPF){
                    if(cliente_iterado == ((SeguroPF)seguro_iterado).getCliente_seguro()){
                        lista_SegurosPorCliente.add(seguro_iterado);
                    }
                }
            }
        }
        return lista_SegurosPorCliente;
    }

    public ArrayList<Sinistro> getSinistrosPorCliente(){
        ArrayList<Sinistro> lista_SinistrosPorCliente = new ArrayList<>();
        for(Cliente cliente_iterado: listaClientes_seguradora){
            for(Seguro seguro_iterado: listaSeguros_seguradora){
                if(seguro_iterado instanceof SeguroPF){
                    if(cliente_iterado == ((SeguroPF)seguro_iterado).getCliente_seguro()){
                        lista_SinistrosPorCliente.addAll(seguro_iterado.getListaSinistros_seguro());
                    }
                }
                if(seguro_iterado instanceof SeguroPJ){
                    if(cliente_iterado == ((SeguroPJ)seguro_iterado).getCliente_seguro()){
                        lista_SinistrosPorCliente.addAll(seguro_iterado.getListaSinistros_seguro());
                    }
                }
            }
        }
        return lista_SinistrosPorCliente;
    }

    public double calcularReceita(){
        double receita = 0;
        for(Seguro seguro_iterado: listaSeguros_seguradora){
            receita += seguro_iterado.getValorMensal_seguro();
        }
        return receita;
    }

    public String toString(){
        String listaClientes_str = "";
        for(Cliente cliente_iterado: listaClientes_seguradora){
            listaClientes_str = listaClientes_str + cliente_iterado.getNome_cliente() + "\n";
        }

        String listaSeguros_str = "";
        for(Seguro seguro_iterado: listaSeguros_seguradora){
            listaSeguros_str = listaSeguros_str + seguro_iterado.getId_seguro() + "\n";
        }

        return "CNPJ: " + this.cnpj_seguradora + "\nNome: " + this.nome_seguradora + "\nTelefone: " + this.telefone_seguradora + "\nEndereço: " + this.endereco_seguradora + "\nEmail: " + this.email_seguradora + "\nLista de Clientes: " + listaClientes_str + "\nLista de Seguros: " + listaSeguros_str;
    }
}