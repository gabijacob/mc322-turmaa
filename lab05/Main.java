package lab05;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    //Vamos iniciar criando uma lista de seguradoras e abrir o scanner
    public static ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
    static Scanner scanner = new Scanner(System.in);


    // Exibe o menu principal
    private static void exibirMenu(){
        MenuOperacoes menuOperacoes[] = MenuOperacoes.values();
		System.out.println("\nMenu principal");
		for(MenuOperacoes op: menuOperacoes) {
			System.out.println(op.ordinal() + " - " + op.getOperacao());
		}
	}

    //Exibe o submenu
    private static void exibirSubmenu(MenuOperacoes menuOperacoes){
        SubmenuOperacoes[] submenu = menuOperacoes.getSubmenu();
		System.out.println(menuOperacoes.getOperacao());
		for(int i = 0; i < submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getOperacao());
		}
	}

    // Lê/seleciona a opção do menu principal
    private static MenuOperacoes lerOpcaoMenuExterno() {
		int op_selecionada;
		MenuOperacoes op_selecionadaConst;
		do {
			System.out.println("Digite uma opção: ");
			op_selecionada = scanner.nextInt();
		}
        while(op_selecionada < 0 || op_selecionada > MenuOperacoes.values().length - 1);
		op_selecionadaConst = MenuOperacoes.values()[op_selecionada];
        
        return op_selecionadaConst;
	}

    // Lê/seleciona a opção do submenu
    private static SubmenuOperacoes lerOpcaoSubmenu(MenuOperacoes op) {
        int op_selecionada_int;
		SubmenuOperacoes op_selecionadaConst;
		try {
            do {                
                System.out.println("Digite uma opcao: "); 
                op_selecionada_int = scanner.nextInt();
            }        
            while(op_selecionada_int < 0 || op_selecionada_int > op.getSubmenu().length - 1);
            op_selecionadaConst = op.getSubmenu()[op_selecionada_int];
            return op_selecionadaConst;
        } catch (NoSuchElementException e) {
            System.out.println("Input error: Insufficient input." + e);
        }
        return null;
	}

    //executar opções do menu externo
	public static void executarOpcaoMenuExterno(MenuOperacoes op) throws ParseException{
        switch(op) {
			case CADASTRAR:
                executarSubmenu(op);
                break;
			case LISTAR:
                executarSubmenu(op);
                break;
			case EXCLUIR:
				executarSubmenu(op);
				break;
			case CALCULAR_RECEITA_SEGURADORA:
                try{
                    System.out.println("Digite o cnpj da seguradora da qual se deseja calcular a receita: ");
                    String seguradora_solicita = scanner.next();
                    if(Validacao.ValidacaoCNPJ.validaCnpj(seguradora_solicita)){
                        for(Seguradora seguradora_iterada: listaSeguradoras){
                            if(seguradora_iterada.getCnpj_seguradora().equals(seguradora_solicita)){
                                seguradora_iterada.calcularReceita();
                            }
                        }
                    } else {
                        System.out.println("Por favor, insira um CNPJ válido.");
                        if(Validacao.ValidacaoCNPJ.validaCnpj(seguradora_solicita)){
                            for(Seguradora seguradora_iterada: listaSeguradoras){
                                if(seguradora_iterada.getCnpj_seguradora().equals(seguradora_solicita)){
                                    seguradora_iterada.calcularReceita();
                                }
                            }
                        } 
                    }                  
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
				break;
            case CALCULAR_VALOR_MENSAL_SEGURO:
                try{
                    System.out.println("Digite o id do seguro do qual deseja calcular o valor mensal: ");
                    String seguro_solicitado = scanner.next();
                    System.out.println("Digite o CNPJ da seguradora a qual o seguro pertence: ");
                    String seguradora_solicitada = scanner.next();
                    if(Validacao.ValidacaoCNPJ.validaCnpj(seguradora_solicitada)){
                        for(Seguradora seguradora_iterada: listaSeguradoras){
                            if(seguradora_iterada.getCnpj_seguradora().equals(seguradora_solicitada)){
                                for(Seguro seguro_iterado : seguradora_iterada.getListaSeguros_seguradora()){
                                    int idSeguro_int = Integer.parseInt(seguro_solicitado) ;
                                    if(seguro_iterado.getId_seguro() == (idSeguro_int)){
                                        if(seguro_iterado instanceof SeguroPF){
                                            seguro_iterado.calcularValor();
                                        }
                                        if(seguro_iterado instanceof SeguroPJ){
                                            seguro_iterado.calcularValor();
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        do{
                            System.out.println("Digite um CNPJ válido!");
                            String seguradora_cnpj = scanner.next();
                            for(Seguradora seguradora_iterada: listaSeguradoras){
                                if(seguradora_iterada.getCnpj_seguradora().equals(seguradora_solicitada)){
                                    for(Seguro seguro_iterado : seguradora_iterada.getListaSeguros_seguradora()){
                                        int idSeguro_int = Integer.parseInt(seguro_solicitado) ;
                                        if(seguro_iterado.getId_seguro() == (idSeguro_int)){
                                            if(seguro_iterado instanceof SeguroPF){
                                                seguro_iterado.calcularValor();
                                            }
                                            if(seguro_iterado instanceof SeguroPJ){
                                                seguro_iterado.calcularValor();
                                            }
                                        }
                                    }
                                }
                            }
                        } while (!Validacao.ValidacaoCNPJ.validaCnpj(seguradora_solicitada));
                    }
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
				break;
			case SAIR:
                break;
		}
	}

    public static void executarOpcaoSubMenu(SubmenuOperacoes opSubmenu) {
        switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
            try{
                System.out.println("Vamos cadastrar um novo cliente no sistema. Para isso, basta informar os dados solicitados.");
                System.out.println("Nome da seguradora que cobrirá o cliente novo: ");
                String nome_seguradora = scanner.next();
                Seguradora seguradora = null;
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    if(seguradora_iterada.getNome_seguradora().equals(nome_seguradora)){
                        seguradora = seguradora_iterada;
                    }
                }
                try {
                    seguradora.cadastrar_cliente();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
			break;
		case CADASTRAR_VEICULO:
            try{
                System.out.println("Vamos cadastrar um novo veículo no sistema. Para isso, basta informar os dados solicitados.");
                System.out.println("CNPJ da seguradora na qual o veículo será adastrado: ");
                String cnpj_seguradora = scanner.next();
                for(Seguradora seguradora_iterada : listaSeguradoras){
                    if(seguradora_iterada.getCnpj_seguradora().equals(cnpj_seguradora)){
                        seguradora_iterada.cadastrarVeiculo();
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }			
            break;
		case CADASTRAR_SEGURADORA:
            try{
                System.out.println("Vamos cadastrar uma nova seguradora no sistema. Para isso, basta informar os dados solicitados.");
                System.out.println("CNPJ da seguradora: ");
                String cnpj_seguradora = scanner.next();
                System.out.println("Nome da seguradora: ");
                String nome_seguradora = scanner.next();
                System.out.println("Telefone da seguradora: ");
                String tel_seguradora = scanner.next();
                System.out.println("Email da seguradora: ");
                String email_seguradora = scanner.next();
                System.out.println("Endereço da seguradora: ");
                String endereco_seguradora = scanner.next();
                Seguradora seguradora_nova  = new Seguradora(cnpj_seguradora, nome_seguradora, tel_seguradora, email_seguradora, endereco_seguradora, null, null);
                listaSeguradoras.add(seguradora_nova);
                System.out.println("Seguradora cadastrada com sucesso!");
                System.out.println("Por padrão, a seguradora é criada sem clientes e sem seguros. Para adicioná-los, basta utilizar o menu.");
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }		
            break;
        case CADASTRAR_SEGURO:
            try{
                System.out.println("Digite o cnpj da seguradora na qual se deseja gerar um seguro: ");
                String cnpj_seguradora = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    if(seguradora_iterada.getCnpj_seguradora().equals(cnpj_seguradora)){
                        SimpleDateFormat formata_data = new SimpleDateFormat("dd-MM-yyyy");
                        System.out.println("Data do início do seguro (no formato DD-MM-AAAA):");
                        String data_inicio = scanner.next();
                        try {
                            Date date_inicio = formata_data.parse(data_inicio);
                            System.out.println("Data do fim do seguro (no formato DD-MM-AAAA):");
                            String data_fim = scanner.next();
                            Date date_fim = formata_data.parse(data_fim);
                            System.out.println("Digite 1 se o seguro for Pessoa Física, e 2 se for Pessoa Jurídica.");
                            String tipo_seguro_str = scanner.next();
                            int tipo_seguro_int = Integer.parseInt(tipo_seguro_str);
                            if(tipo_seguro_int == 1){
                                System.out.println("Vamos cadastrar um seguro para Pessoa Física.");
                                System.out.println("CPF do cliente Pessoa Física ao qual o seguro estará associado: ");
                                String cpf_cliente = scanner.next();
                                System.out.println("Placa do veículo que será segurado: ");
                                String placa_veiculo = scanner.next();
                                for(Cliente cliente_iterado : seguradora_iterada.getListaClientes_seguradora()){
                                    if(cliente_iterado instanceof ClientePF){
                                        ClientePF clientePF = (ClientePF)cliente_iterado;
                                        if(clientePF.getCpf().equals(cpf_cliente)){
                                            for(Veiculo veiculo_iterado : clientePF.getListaVeiculos_cliente()){
                                                if(veiculo_iterado.getPlaca().equals(placa_veiculo)){
                                                    SeguroPF novo_seguro = new SeguroPF(date_inicio, date_fim, seguradora_iterada, null, null, 0, veiculo_iterado, clientePF);
                                                    novo_seguro.setValorMensal_seguro(novo_seguro.calcularValor());
                                                    System.out.println("Seguro cadastrada com sucesso!");
                                                    System.out.println("Por padrão, o seguro é criado sem sinistros ou condutores. Para adicioná-los, basta utilizar o menu.");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }		
            break;
        case CADASTRAR_CONDUTOR:
            try{
                System.out.println("Digite o ID do seguro ao qual deseja adicionar o novo condutor: ");
                String id_seguro_str = scanner.next();
                int id_seguro_int = Integer.parseInt(id_seguro_str);
                System.out.println("Digite o cnpj da seguradora a qual o seguro pertence: ");
                String cnpj_seguradora = scanner.next();
                for(Seguradora seguradora_iterada : listaSeguradoras){
                    if(seguradora_iterada.getCnpj_seguradora().equals(cnpj_seguradora)){
                        for(Seguro seguro : seguradora_iterada.getListaSeguros_seguradora()){
                            if(seguro.getId_seguro() == id_seguro_int){
                                seguro.autorizarCondutor();
                            }
                        }
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
			break;        
		case CADASTRAR_FROTA:
            try{
                System.out.println("Digite o cnpj da seguradora na qual a frota será cadastrada: ");
                String cnpj_seguradora = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    seguradora_iterada.cadastrarFrota();
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
			break;
        case CADASTRAR_SINISTRO:
            try{
                System.out.println("Digite o cnpj da seguradora responável pelo seguro: ");
                String cnpj_seguradora = scanner.next();
                System.out.println("Digite a placa do veículo que sofreu o sinistro: ");
                String placa = scanner.next();
                System.out.println("Digite 1 caso o Seguro seja Pessoa Física, e 2 caso seja Pessoa Jurídica: ");
                String pessoa_str = scanner.next();
                int pessoa_int = Integer.parseInt(pessoa_str);
                if(pessoa_int == 1){
                    for(Seguradora seguradora_iterada : listaSeguradoras){
                        if(seguradora_iterada.getCnpj_seguradora().equals(cnpj_seguradora)){
                            SeguroPF seguroPF = seguradora_iterada.procuraSeguroPF(placa);
                            seguroPF.gerarSinistro(seguroPF);
                            seguroPF.gerarSinistro((Seguro)seguroPF);
                        }
                    }
                } else if (pessoa_int == 2){
                    for(Seguradora seguradora_iterada : listaSeguradoras){
                        if(seguradora_iterada.getCnpj_seguradora().equals(cnpj_seguradora)){
                            SeguroPJ seguroPJ = seguradora_iterada.procuraSeguroPJ(placa);
                            seguroPJ.gerarSinistro((Seguro)seguroPJ);
                        }
                    }    
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
			break;
        case LISTAR_CLIENTES_POR_SEGURADORA:
            try{
                System.out.println("Digite o cnpj da seguradora cujos clientes querem ser listados: ");
                String cnpj_seguradora = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    if(seguradora_iterada.getCnpj_seguradora().equals(cnpj_seguradora)){
                        seguradora_iterada.listarClientes();
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
			break;
		case LISTAR_SEGUROS_POR_SEGURADORA:
            try{
                System.out.println("Digite o cnpj da seguradora cujos seguros querem ser listados: ");
                String cnpj_seguradora = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    if(seguradora_iterada.getCnpj_seguradora().equals(cnpj_seguradora)){
                        seguradora_iterada.listarSeguros();
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
			break;
        case LISTAR_SEGUROS_POR_CLIENTE:
        try{
            System.out.println("Seguros por cliente: ");
            for(Seguradora seguradora_iterada: listaSeguradoras){
                seguradora_iterada.getSegurosPorCliente();
            }
        }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }			
            break;
        case LISTAR_SINISTROS_POR_CLIENTE:
            try{
                System.out.println("Sinistros por cliente: ");
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    seguradora_iterada.getSinistrosPorCliente();
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }		
            break;
		case EXCLUIR_CLIENTE:
            try{
                System.out.println("Digite o cnpj da seguradora à qual o cliente que deseja excluir pertence: ");
                String cnpj_seguradora = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    if(seguradora_iterada.getCnpj_seguradora().equals(cnpj_seguradora)){
                        seguradora_iterada.removerCliente();
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }				
            break;
        case EXCLUIR_VEICULO:
            try{
                System.out.println("Digite a placa do veículo que deseja excluir: ");
                String placa_veiculo = scanner.next();
                System.out.println("Digite 1 se o cliente que possui o carro for Pessoa Física, e 2 se for Pessoa Jurídica.");
                String pessoa_str = scanner.next();
                int pessoa_int = Integer.parseInt(pessoa_str);
                while(pessoa_int != 1 && pessoa_int != 2){
                    System.out.println("Digite um número válido. Digite 1 se o cliente que possui o carro for Pessoa Física, e 2 se for Pessoa Jurídica.");
                    pessoa_str = scanner.next();
                    pessoa_int = Integer.parseInt(pessoa_str);
                }
                if(pessoa_int == 1){
                    System.out.println("CPF do cliente: ");
                    String cpf = scanner.next();
                    for(Seguradora seguradora_iterada: listaSeguradoras){
                        if(seguradora_iterada.procuraClientePF(cpf) != null){
                            //Removendo o veículo da lista de veículos do cliente
                            ClientePF clientePF = seguradora_iterada.procuraClientePF(cpf);
                            clientePF.removerVeiculo(placa_veiculo);

                            //Removendo o seguro referente ao veículo, caso ele exista
                            SeguroPF seguroPF = seguradora_iterada.procuraSeguroPF(placa_veiculo);
                            if(seguroPF != null){   
                                seguradora_iterada.getListaSeguros_seguradora().remove(seguroPF);
                            }
                        }
                    }
                } else if(pessoa_int == 2){
                    System.out.println("Placa do Veiculo a ser removido: ");
                    String placa = scanner.next();
                    System.out.println("CNPJ da segurdora à qual o seguro desse veiculo pertence: ");
                    String cnpj_seguradora = scanner.next();
                    for(Seguradora seguradora_iterada : listaSeguradoras){
                        if(seguradora_iterada.getCnpj_seguradora().equals(cnpj_seguradora)){
                            seguradora_iterada.removerVeiculoPJ(placa);
                        }
                    }
                } 
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }	            
            break;
        case EXCLUIR_SINISTRO:
            try{
                System.out.println("Digite o ID do sinistro que deseja excluir: ");
                String id_sinistro_str = scanner.next();
                System.out.println("Digite o ID do seguro ao qual esse sinistro pertence: ");
                String id_seguro_str = scanner.next();
                int id_seguro_int = Integer.parseInt(id_seguro_str);
                int id_sinistro_int = Integer.parseInt(id_sinistro_str);
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    for(Seguro seguro_iterado: seguradora_iterada.getListaSeguros_seguradora()){
                        if(seguro_iterado.getId_seguro() == id_seguro_int){
                            for(Sinistro sinistro_iterado : seguro_iterado.getListaSinistros_seguro()){
                                if(sinistro_iterado.getId() == id_sinistro_int){
                                    seguro_iterado.getListaSinistros_seguro().remove(sinistro_iterado);
                                }
                            }
                        }
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }         
            break;
        case EXCLUIR_SEGURO:
            try{
                System.out.println("Digite o ID do seguro que deseja excluir: ");
                String id_seguro_str = scanner.next();
                int id_seguro_int = Integer.parseInt(id_seguro_str);
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    for(Seguro seguro_iterado: seguradora_iterada.getListaSeguros_seguradora()){
                        if(seguro_iterado.getId_seguro() == id_seguro_int){
                            seguradora_iterada.cancelarSeguro(seguro_iterado);
                        }
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }         
            break;
        case VOLTAR:
		    break;
		}
	}
	
	//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOperacoes op) {
		SubmenuOperacoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);			executarOpcaoSubMenu(opSubmenu);
		}
        while (opSubmenu != SubmenuOperacoes.VOLTAR);
	}

	public static void main(String[] args) throws ParseException {
        //Iterando Veiculos
        Veiculo veiculo1 = new Veiculo("ABC1234", "Volkswagen", "Fusca", 2000);
        Veiculo veiculo2 = new Veiculo("DEF5678", "Hyundai", "HB20", 2001);
        Veiculo veiculo3 = new Veiculo("GHI9101", "Chevrolet", "Onix", 2002);
        Veiculo veiculo4 = new Veiculo("JKL1121", "Fiat", "Palio", 2003);

        //Criando a listas de frotas que serão passadas para os clientes:
        ArrayList<Veiculo> listaVeiculosPF1 = new ArrayList<Veiculo>();
        listaVeiculosPF1.add(veiculo1);
        ArrayList<Veiculo> listaVeiculosPJ1 = new ArrayList<Veiculo>();
        listaVeiculosPJ1.add(veiculo3);

        Frota frota1 = new Frota("1", listaVeiculosPJ1);
        ArrayList<Frota> listaFrotasPJ1 = new ArrayList<Frota>();
        listaFrotasPJ1.add(frota1);

        //Formatando as datas para iterar um clientePF e um PJ
        SimpleDateFormat formata_data = new SimpleDateFormat("dd-MM-yyyy");
        String data_licenca1_str = "13-09-2002";
        String data_nascimento1_str = "13-09-2002";
        String data_fundacao1_str = "13-09-2002";

        Date data_licenca1 = formata_data.parse(data_licenca1_str);
        Date data_nascimento1 = formata_data.parse(data_nascimento1_str);
        Date data_fundacao1 = formata_data.parse(data_fundacao1_str);

        //Iterando um clientePF e um PJ
        double valorseguroPF1 = 0;
        double valorseguroPJ1 = 0;

        ClientePF clientePF1 = new ClientePF("Ana", "71999999999", "Rua das Rosas", "anarosa@gmail.com", "04420793544", "F", "Ensino Médio completo", data_nascimento1, listaVeiculosPF1);        
        ClientePJ clientePJ1 = new ClientePJ("Empresa1", "71988888888", "Rua dos Jacarandás", "empresa1@gmail.com", "11.222.333/0001-81", data_fundacao1, listaFrotasPJ1, 2);        

        //Instanciando um objeto de Seguradora
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
        Seguradora seguradora1 = new Seguradora("52.608.634/0001-25", "Seguradora1", "71988785212", "segura@car.com", "Rua das Gardênias", listaClientes, listaSeguros);
        listaSeguradoras.add(seguradora1);
        
        //Instanciando os seguros
        String data_inicio1_str = "13-09-2022";
        String data_inicio2_str = "14-09-2022";
        String data_fim1_str = "13-09-2032";
        String data_fim2_str = "14-09-2032";

        Date data_inicio1 = formata_data.parse(data_inicio1_str);
        Date data_inicio2 = formata_data.parse(data_inicio2_str);
        Date data_fim1 = formata_data.parse(data_fim1_str);
        Date data_fim2 = formata_data.parse(data_fim2_str);
        seguradora1.gerarSeguroPF(data_inicio1, data_fim1, seguradora1, null, null, valorseguroPJ1, veiculo4, clientePF1);
        seguradora1.gerarSeguroPJ(data_inicio2, data_fim2, seguradora1, null, null, valorseguroPJ1, frota1, clientePJ1);

        //Criando sinistros
        Seguro seguro1 = seguradora1.getListaSeguros_seguradora().get(0);
        Condutor condutor1 = new Condutor("04420793544", "Bia", "71977777777", "Rua dos Eucaliptos", "biaeucaliptos@gmail.com", data_nascimento1, null);
        Sinistro sinistro1 = new Sinistro(data_fim2, data_fim2_str, condutor1, seguro1);
        seguro1.gerarSinistro(sinistro1);

        //Chamando os métodos validarCPF e validarCNPJ

        Validacao.ValidacaoCPF validadorcpf1 = new Validacao.ValidacaoCPF("480.115.430-16");
        validadorcpf1.validaCpf("480.115.430-16");
        Validacao.ValidacaoCPF validadorcpf2 = new Validacao.ValidacaoCPF("480.115.430-17");
        validadorcpf2.validaCpf("480.115.430-17");
        Validacao.ValidacaoCPF validadorcnpj1 = new Validacao.ValidacaoCPF("52.608.634/0001-25");
        validadorcnpj1.validaCpf("52.608.634/0001-25"); 
        Validacao.ValidacaoCPF validadorcnpj2 = new Validacao.ValidacaoCPF("52.608.634/0001-26");
        validadorcnpj2.validaCpf("52.608.634/0001-26");                

        //Chamando o método toString
        System.out.println("\nDADOS DO CLIENTE PESSOA FÍSICA 1:\n");
        System.out.println(clientePF1.toString());
        System.out.println("\nDADOS DO CLIENTE PESSOA JURÍDICA 1: \n");
        System.out.println(clientePJ1.toString());
        System.out.println("\nDADOS DO VEÍCULO 1:\n");
        System.out.println(veiculo1.toString());
        System.out.println("\nDADOS DO SEGURO PESSOA FÍSICA 1:\n");
        System.out.println(seguradora1.getListaSeguros_seguradora().get(0).toString());
        System.out.println("\nDADOS DO SEGURO PESSOA JURÍDICA 1: \n");
        System.out.println(seguradora1.getListaSeguros_seguradora().get(1).toString());
        System.out.println("\nDADOS DA FROTA 1:\n");
        System.out.println(frota1.toString());
        System.out.println("\nDADOS DO SINISTRO 1:\n");
        System.out.println(sinistro1.toString());
        System.out.println("\nDADOS DO CONDUTOR 1: \n");
        System.out.println(condutor1.toString());
        System.out.println("\nDADOS DA SEGURADORA 1:\n");
        System.out.println(seguradora1.toString());


        //Chamando os principais métodos

        //Cancelando o seguro
        seguradora1.cancelarSeguro(seguro1);

        //Removendo o cliente
        seguradora1.removerCliente(clientePJ1);
        
        //Calculando e printando a receita total da seguradora:
        System.out.print(seguradora1.calcularReceita());

        //Criando e chamando o MenuOperacoes:
        MenuOperacoes op;
		do {
			exibirMenu();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
		}
        while (op != MenuOperacoes.SAIR);
		System.out.println("Fim da execução do menu.");
        scanner.close();
	}
}