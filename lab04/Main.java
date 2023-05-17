package lab04;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    //Vamos iniciar criando uma lista de seguradoras
    public static ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();

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
		Scanner scanner = new Scanner(System.in);
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
		Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = null;
        scanner = new Scanner(System.in);
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
			case GERAR_SINISTRO:
                try{
                    System.out.println("Digite o nome da seguradora na qual se deseja gerar um seguro: ");
                    String seguradora_solicita = scanner.next();
                    for(Seguradora seguradora_iterada: listaSeguradoras){
                        if(seguradora_iterada.getNome().equals(seguradora_solicita)){
                            seguradora_iterada.gerarSinistro(seguradora_iterada);
                        }
                    }
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }                
                break;
			case TRANSFERIR_SEGURO:
                try{
                    System.out.println("Digite o nome da seguradora do cliente que deseja transferir seus dados segurados");
                    String seguradora_solicita = scanner.next();
                    for(Seguradora seguradora_iterada: listaSeguradoras){
                        if(seguradora_iterada.getNome().equals(seguradora_solicita)){
                            seguradora_iterada.transferirSeguro(seguradora_iterada);
                        }
                    }
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
				break;
			case CALCULAR_RECEITA_SEGURADORA:
                try{
                    System.out.println("Digite o nome da seguradora da qual se deseja calcular a receita: ");
                    String seguradora_solicita = scanner.next();
                    for(Seguradora seguradora_iterada: listaSeguradoras){
                        if(seguradora_iterada.getNome().equals(seguradora_solicita)){
                            seguradora_iterada.calcularReceita();
                        }
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
        Scanner scanner = null;
        switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
            try{
                scanner = new Scanner(System.in);
                System.out.println("Vamos cadastrar um novo cliente no sistema. Para isso, basta informar os dados solicitados.");
                System.out.println("Nome da seguradora que cobrirá o cliente novo: ");
                String nome_seguradora = scanner.next();
                Seguradora seguradora = null;
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    if(seguradora_iterada.getNome().equals(nome_seguradora)){
                        seguradora = seguradora_iterada;
                    }
                }
                seguradora.cadastrarCliente();
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
			break;
		case CADASTRAR_VEICULO:
            try{
                scanner = new Scanner(System.in);
                System.out.println("Vamos cadastrar um novo veículo no sistema. Para isso, basta informar os dados solicitados.");
                System.out.println("Nome do cliente que terá mais um veículo coberto pelo seguro: ");
                String nome_cliente = scanner.next();
                System.out.println("Nome da seguradora que cobrirá o novo veículo: ");
                String nome_seguradora = scanner.next();
                System.out.println("Placa do Veículo: ");
                String placa = scanner.next();
                System.out.println("Marca do Veículo: ");
                String marca = scanner.next();
                System.out.println("Modelo do Veículo: ");
                String modelo = scanner.next();
                System.out.println("Ano de fabricação do veículo: ");
                String ano_fabricacao_str = scanner.next();
                int ano_fabricacao_int = Integer.parseInt(ano_fabricacao_str);
                Veiculo veiculo_novo = new Veiculo(placa, marca, modelo, ano_fabricacao_int);
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    if(seguradora_iterada.getNome().equals(nome_seguradora)){
                        Cliente cliente = seguradora_iterada.procuraCliente(nome_cliente);
                        cliente.adicionaVeiculo(veiculo_novo);
                        double valor_seguro = seguradora_iterada.calcularPrecoSeguraCliente(cliente);
                        cliente.setvalorSeguro(valor_seguro);
                    }
                }
                System.out.println("Veiculo adicionado com sucesso!");
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }			
            break;
		case CADASTRAR_SEGURADORA:
            try{
                scanner = new Scanner(System.in);
                System.out.println("Vamos cadastrar uma nova seguradora no sistema. Para isso, basta informar os dados solicitados.");
                System.out.println("Nome da seguradora: ");
                String nome_seguradora = scanner.next();
                System.out.println("Telefone da seguradora: ");
                String tel_seguradora = scanner.next();
                System.out.println("Email da seguradora: ");
                String email_seguradora = scanner.next();
                System.out.println("Endereço da seguradora: ");
                String endereco_seguradora = scanner.next();
                Seguradora seguradora_nova  = new Seguradora(nome_seguradora, tel_seguradora, email_seguradora, endereco_seguradora, null, null);
                listaSeguradoras.add(seguradora_nova);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }		
            break;
		case LISTAR_CLIENTES_POR_SEGURADORA:
            try{
                scanner = new Scanner(System.in);
                System.out.println("Digite o nome da seguradora cujos clientes querem ser listados: ");
                String nome_seguradora = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    if(seguradora_iterada.getNome().equals(nome_seguradora)){
                        seguradora_iterada.listarClientes(seguradora_iterada);
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
			break;
		case LISTAR_SINISTROS_POR_SEGURADORA:
            try{
                scanner = new Scanner(System.in);
                System.out.println("Digite o nome da seguradora cujos sinistros querem ser listados: ");
                String nome_seguradora = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    if(seguradora_iterada.getNome().equals(nome_seguradora)){
                        seguradora_iterada.listarSinistros(seguradora_iterada);
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
			break;
		case LISTAR_SINISTROS_POR_CLIENTE:
            try{
                scanner = new Scanner(System.in);
                System.out.println("Digite o nome do cliente cujos sinistros querem ser listados: ");
                String nome_cliente = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    for(Cliente cliente_iterado: seguradora_iterada.getListaClientes()){
                        if(cliente_iterado.getNome().equals(nome_cliente)){
                            seguradora_iterada.listarSinistros(seguradora_iterada, cliente_iterado);
                        }
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }		
            break;
        case LISTAR_VEICULO_POR_SEGURADORA:
            try{
                scanner = new Scanner(System.in);
                System.out.println("Digite o nome da seguradora cujos veículos querem ser listados: ");
                String nome_seguradora = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    if(seguradora_iterada.getNome().equals(nome_seguradora)){
                        seguradora_iterada.listarVeiculos();
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }			
            break;
		case EXCLUIR_CLIENTE:
            try{
                scanner = new Scanner(System.in);
                System.out.println("Digite o nome do cliente que deseja excluir: ");
                String nome_cliente = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    for(Cliente cliente_iterado: seguradora_iterada.getListaClientes()){
                        if(cliente_iterado.getNome().equals(nome_cliente)){
                            seguradora_iterada.removerCliente(nome_cliente);
                        }
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }				
            break;
        case EXCLUIR_VEICULO:
            try{
                scanner = new Scanner(System.in);
                System.out.println("Digite a placa do veículo que deseja excluir: ");
                String placa_veiculo = scanner.next();
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    for(Cliente cliente_iterado: seguradora_iterada.getListaClientes()){
                       cliente_iterado.removerVeiculo(placa_veiculo); 
                       double valor_seguro = seguradora_iterada.calcularPrecoSeguraCliente(cliente_iterado);
                       cliente_iterado.setvalorSeguro(valor_seguro);
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }	            
            break;
        case EXCLUIR_SINISTRO:
            try{
                scanner = new Scanner(System.in);
                System.out.println("Digite o ID do sinistro que deseja excluir: ");
                String id_str = scanner.next();
                int id_int = Integer.parseInt(id_str);
                for(Seguradora seguradora_iterada: listaSeguradoras){
                    for(Sinistro sinistro_iterado: seguradora_iterada.getListaSinistros()){
                        if(sinistro_iterado.getId() == id_int){
                            sinistro_iterado.getcliente_sinistro().valorSeguro_cliente = seguradora_iterada.calcularPrecoSeguraCliente(sinistro_iterado.getcliente_sinistro());
                        }
                    }
                    seguradora_iterada.removerSinistro(id_str);
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
        Scanner scanner = new Scanner(System.in);
        //Iterando Veiculos
        Veiculo veiculo1 = new Veiculo("ABC1234", "Volkswagen", "Fusca", 2000);
        Veiculo veiculo2 = new Veiculo("DEF5678", "Hyundai", "HB20", 2001);
        Veiculo veiculo3 = new Veiculo("GHI9101", "Chevrolet", "Onix", 2002);
        Veiculo veiculo4 = new Veiculo("JKL1121", "Fiat", "Palio", 2003);

        //Criando a lista de veículos que será passada para o ClientePF1:
        ArrayList<Veiculo> listaVeiculosPF1 = new ArrayList<Veiculo>();
        listaVeiculosPF1.add(veiculo1);

        ArrayList<Veiculo> listaVeiculosPJ1 = new ArrayList<Veiculo>();
        listaVeiculosPJ1.add(veiculo3);

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

        ClientePF clientePF1 = new ClientePF("Ana", "Rua das Rosas", listaVeiculosPF1, valorseguroPF1, "04420793544", "Feminino", data_licenca1, "Ensino Médio completo", data_nascimento1, "Classe média");
        ClientePJ clientePJ1 = new ClientePJ("Empresa1", "Rua dos Jacarandás", listaVeiculosPJ1, valorseguroPJ1, "11.222.333/0001-81", data_fundacao1, 2);
        
        //Instanciando um objeto de Seguradora
        ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        Seguradora seguradora1 = new Seguradora("Seguradora1", "71988785212", "segura@car.com", "Rua das Gardênias", listaSinistros, listaClientes);
        listaSeguradoras.add(seguradora1);
        
        //Chamando os métodos validarCPF e validarCNPJ
        Validacao.ValidacaoCPF validacao_cpf = new Validacao.ValidacaoCPF(clientePF1.getCpf());
        validacao_cpf.validaCpf(clientePF1.getCpf());
        Validacao.ValidacaoCNPJ validacao_cnpj = new Validacao.ValidacaoCNPJ(clientePJ1.getCnpj());
        validacao_cnpj.validaCnpj(clientePJ1.getCnpj());

        //Adicionando veiculos nos clientes instanciados
        clientePF1.getListaVeiculos_cliente().add(veiculo2);
        clientePJ1.getListaVeiculos_cliente().add(veiculo4);

        //Cadastrando os clientes na seguradora:
        seguradora1.cadastrarCliente(clientePF1);
        seguradora1.cadastrarCliente(clientePJ1);

        //Gerando Sinistros
        String data_sinistro1_str = "13-09-2002";
        String data_sinistro2_str = "14-09-2002";
        Date data_sinistro1_date = formata_data.parse(data_sinistro1_str); 
        Date data_sinistro2_date = formata_data.parse(data_sinistro2_str);
        seguradora1.gerarSinistro(data_sinistro1_date, "Rua das Goiabeiras", seguradora1, veiculo1, clientePF1);
        seguradora1.gerarSinistro(data_sinistro2_date, "Rua das Laranjeiras", seguradora1, veiculo1, clientePF1);

        //Chamando o método toString de todas as classes (e imprimindo as informações)
        System.out.println("\nDADOS DO CLIENTE PESSOA FÍSICA 1:\n");
        System.out.println(clientePF1.toString());
        System.out.println("\nDADOS DO CLIENTE PESSOA JURÍDICA 1: \n");
        System.out.println(clientePJ1.toString());
        System.out.println("\nDADOS DO VEÍCULO 1:\n");
        System.out.println(veiculo1.toString());
        System.out.println("\nDADOS DOS SINISTROS DA SEGURADORA 1:");
        seguradora1.listarSinistros(seguradora1);
        System.out.println("\n");


        //Chamando os métodos listarClientes, visulizarSinistro, litarSinistros e calcularReceita da classe Seguradora
        seguradora1.listarClientes(seguradora1);
        System.out.println("\n");
        seguradora1.visualizarSinistro(clientePF1.getNome());
        seguradora1.listarSinistros(seguradora1);
        System.out.print(seguradora1.calcularReceita());
        
        //Atualizando o valorSeguro usando o calcularPrecoSeguroCliente:
        for(Cliente cliente_iterado: seguradora1.getListaClientes()){
            cliente_iterado.setvalorSeguro(seguradora1.calcularPrecoSeguraCliente(cliente_iterado));
        }

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

        //Removendo o ClientePF e o ClientePJ
        seguradora1.removerCliente(clientePF1.getNome());
        seguradora1.removerCliente(clientePJ1.getNome());
        scanner.close();
	}
}