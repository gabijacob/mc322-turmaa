package lab03;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws ParseException {

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
        ClientePF clientePF1 = new ClientePF("Ana", "Rua das Rosas", listaVeiculosPF1, "04420793544", "Feminino", data_licenca1, "Ensino Médio completo", data_nascimento1, "Classe média");
        ClientePJ clientePJ1 = new ClientePJ("Empresa1", "Rua dos Jacarandás", listaVeiculosPJ1, "11.222.333/0001-81", data_fundacao1);
        
        //Instanciando um objeto de Seguradora e cadastrando um ClientePF e um ClientePJ (na Seguradora)
        ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        Seguradora seguradora1 = new Seguradora("Seguradora1", "71988785212", "segura@car.com", "Rua das Gardênias", listaSinistros,listaClientes);
        seguradora1.cadastrarCliente(clientePF1);
        seguradora1.cadastrarCliente(clientePJ1);
        
        //Chamando os métodos validarCPF e validarCNPJ
        clientePF1.validarCpf(clientePF1.getCpf());
        clientePJ1.validarCnpj(clientePJ1.getCnpj());

        //Adicionando veiculos nos clientes instanciados
        ArrayList<Veiculo> lista_veiculosPF1_iterado = clientePF1.getListaVeiculos_cliente();
        lista_veiculosPF1_iterado.add(veiculo2);
        clientePF1.setListaVeiculos_cliente(lista_veiculosPF1_iterado);

        ArrayList<Veiculo> lista_veiculosPJ1_iterado = clientePJ1.getListaVeiculos_cliente();
        lista_veiculosPF1_iterado.add(veiculo4);
        clientePJ1.setListaVeiculos_cliente(lista_veiculosPJ1_iterado);

        //Gerando um Sinistro
        String data_sinistro1_str = "13-09-2002";
        seguradora1.gerarSinistro(data_sinistro1_str, "Rua das Goiabeiras", seguradora1, veiculo1, clientePF1);

        //Chamando o método toString de todas as classes (e imprimindo as informações)
        System.out.println("\nDADOS DO CLIENTE PESSOA FÍSICA:\n");
        System.out.println(clientePF1.toString());
        System.out.println("\nDADOS DO CLIENTE PESSOA JURÍDICA: \n");
        System.out.println(clientePJ1.toString());
        System.out.println("\nDADOS DO VEÍCULO:\n");
        System.out.println(veiculo1.toString());
        System.out.println("\nDADOS DOS SINISTROS:");
        seguradora1.listarSinistros(seguradora1.getListaSinistros(), seguradora1);
        System.out.println("\n");


        //Chamando os métodos listarClientes, visulizarSinistro e litarSinistros da classe Seguradora
        seguradora1.listarClientes(seguradora1.getListaClientes(), seguradora1);
        System.out.println("\n");
        seguradora1.visualizarSinistro(clientePF1.getNome());
        seguradora1.listarSinistros(seguradora1.getListaSinistros(), seguradora1);

        //Implementando e chamando o método que lê daodos usando System.In para criar um novo cliente
        Scanner scan = null;
        try {
            scan = new Scanner(System.in);
            System.out.println("Vamos cadastrar um novo Veiculo!");
            System.out.println("Qual a placa do veículo?");
            String placa_veiculo5 = scan.next();
            System.out.println("Qual a marca do veículo?");
            String marca_veiculo5 = scan.next();
            System.out.println("Qual a modelo do veículo?");
            String modelo_veiculo5 = scan.next();
            System.out.println("Qual o ano de fabricação do veículo?");
            String ano_fabricacao_veiculo5_str = scan.next();

            try{
                int ano_fabricacao_veiculo5 = Integer.parseInt(ano_fabricacao_veiculo5_str);
                Veiculo veiculo5 = new Veiculo(placa_veiculo5, marca_veiculo5, modelo_veiculo5, ano_fabricacao_veiculo5);
                //Imprimindo o veículo criado pelos dados lidos
                System.out.println(veiculo5.toString());
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }

        }

        finally {
            if(scan!=null)
                scan.close();
        }

        //Removendo o ClientePF e o ClientePJ
        seguradora1.removerCliente(clientePF1, listaClientes);
        seguradora1.removerCliente(clientePJ1, listaClientes);
	}
}