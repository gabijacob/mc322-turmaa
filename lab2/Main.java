package lab2;

public class Main {
    public static void main(String[] args){

        // Instancia todas as classes criadas
        Cliente cliente1 = new Cliente("ana", "04420793540", "13092000", 22, "rua do jacaranda");
        Veiculo veiculo1 = new Veiculo("FGH1234", "Hyundai", "hb20");
        Seguradora seguradora1 = new Seguradora("safecar", "71988785210", "safecar@safecar.com", "rua das rosas");
        Sinistro sinistro1 = new Sinistro("13092010", "rua dos cajueiros");
    
        // Instancia os métodos da classe Cliente para cliente1

        String nome_cliente1 = cliente1.getNome();
        String cpf_cliente1 = cliente1.getCpf();
        String nasc_cliente1 = cliente1.getDataNascimento();
        int idade_cliente1 = cliente1.getIdade();
        String endereco_cliente1 = cliente1.getEndereco();

        System.out.println("INFORMAÇÕES DO CLIENTE:");
        System.out.println(cliente1.toString());

        // Mudando as informações da cliente cliente1 com os setters e imprimindo novamente

        cliente1.setNome("bia");
        cliente1.setCpf("0000000000");
        cliente1.setDataNasciemtno("14092002");
        cliente1.setIdade(23);
        cliente1.setEndereco("rua das laranjeiras");

        //fazendo o get novamente para atualizar os dados do cleinte1, e depois imprimindo
        
        nome_cliente1 = cliente1.getNome();
        cpf_cliente1 = cliente1.getCpf();
        nasc_cliente1 = cliente1.getDataNascimento();
        idade_cliente1 = cliente1.getIdade();
        endereco_cliente1 = cliente1.getEndereco();

        System.out.println("\nINFORMAÇÕES DO CLIENTE:");
        System.out.println(cliente1.toString());
        
        // Testando o ValidarCpf

        if(cliente1.validarCpf(cpf_cliente1)){
            System.out.println("\nVALIDAÇÃO DO CPF: O cpf é válido!");
        }
        else{
            System.out.println("\nVALIDAÇÃO DO CPF: O cpf NÃO é válido :(");
        }
        System.out.print("\n");

        //Instancia os métodos da classe Veiculo
        
        String placa_veiculo1 = veiculo1.getPlaca();
        String marca_veiculo1 = veiculo1.getMarca();
        String modelo_veiculo1 = veiculo1.getModelo();

        System.out.println("INFORMAÇÕES DO VEICULO:");
        System.out.print("Placa:");
        System.out.println(placa_veiculo1);
        System.out.print("Marca:");
        System.out.println(marca_veiculo1);
        System.out.print("Modelo:");
        System.out.println(modelo_veiculo1);
        System.out.print("\n");

        veiculo1.setPlaca("IJK5678");
        veiculo1.setMarca("Volkswagen");
        veiculo1.setModelo("fusca");

        placa_veiculo1 = veiculo1.getPlaca();
        marca_veiculo1 = veiculo1.getMarca();
        modelo_veiculo1 = veiculo1.getModelo();

        System.out.println("INFORMAÇÕES DO VEICULO:");
        System.out.print("Placa:");
        System.out.println(placa_veiculo1);
        System.out.print("Marca:");
        System.out.println(marca_veiculo1);
        System.out.print("Modelo:");
        System.out.println(modelo_veiculo1);
        System.out.print("\n");

        //Instancia os métodos da classe Seguradora

        String nome_seguradora1 = seguradora1.getNome();
        String telefone_seguradora1 = seguradora1.getTelefone();
        String email_seguradora1 = seguradora1.getEmail();
        String endereco_seguradora1 = seguradora1.getEndereco();

        System.out.println("INFORMAÇÕES DA SEGURADORA:");
        System.out.print("Nome:");
        System.out.println(nome_seguradora1);
        System.out.print("Telefone:");
        System.out.println(telefone_seguradora1);
        System.out.print("Email:");
        System.out.println(email_seguradora1); 
        System.out.print("Endereco:");
        System.out.println(endereco_seguradora1);
        System.out.print("\n");

        seguradora1.setNome("notsafecar");
        seguradora1.setTelefone("71988785212");
        seguradora1.setEmail("notsafecar@notsafecar.com");
        seguradora1.setEndereco("rua das cerejeiras");

        nome_seguradora1 = seguradora1.getNome();
        telefone_seguradora1 = seguradora1.getTelefone();
        email_seguradora1 = seguradora1.getEmail();
        endereco_seguradora1 = seguradora1.getEndereco();

        System.out.println("INFORMAÇÕES DA SEGURADORA:");
        System.out.print("Nome:");
        System.out.println(nome_seguradora1);
        System.out.print("Telefone:");
        System.out.println(telefone_seguradora1);
        System.out.print("Email:");
        System.out.println(email_seguradora1); 
        System.out.print("Endereco:");
        System.out.println(endereco_seguradora1);
        System.out.print("\n");

        //Instancia os métodos da classe Sinistro

        int id_sinistro1 = sinistro1.getId();
        String data_sinistro1 = sinistro1.getData();
        String endereco_sinistro1 = sinistro1.getEndereco();

        System.out.println("INFORMAÇÕES DA SEGURADORA:");
        System.out.print("Id:");
        System.out.println(id_sinistro1);
        System.out.print("Data:");
        System.out.println(data_sinistro1);
        System.out.print("Endereco:");
        System.out.println(endereco_sinistro1);
        System.out.print("\n");

        sinistro1.setId();
        sinistro1.setData("14092020");
        sinistro1.setEndereco("rua das figueiras");

        id_sinistro1 = sinistro1.getId();
        data_sinistro1 = sinistro1.getData();
        endereco_sinistro1 = sinistro1.getEndereco();

        System.out.println("INFORMAÇÕES DA SEGURADORA:");
        System.out.print("Id:");
        System.out.println(id_sinistro1);
        System.out.print("Data:");
        System.out.println(data_sinistro1);
        System.out.print("Endereco:");
        System.out.println(endereco_sinistro1);
        System.out.print("\n");
    }  
}
