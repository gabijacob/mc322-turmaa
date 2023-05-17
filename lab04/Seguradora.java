package lab04;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Seguradora {
	private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    public Seguradora(String nome, String telefone, String email, String endereco, ArrayList<Sinistro> listaSinistros, ArrayList<Cliente> listaClientes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
       
    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    //função que adiciona um Cliente cliente na lista de clientes da seguradora recebendo os inputs do teclado
    public boolean cadastrarCliente(){
        Scanner scanner = null;
        try{
            scanner = new Scanner(System.in);      
            System.out.println("Nome do cliente que terá seus veículos cobertos pelo seguro: ");
            String nome_cliente = scanner.next();
            System.out.println("Endereço do cliente: ");
            String endereco_cliente = scanner.next();
            Cliente cliente_novo = new Cliente(nome_cliente, endereco_cliente, null, 0);
            double valor_seguro_cliente = calcularPrecoSeguraCliente(cliente_novo);
            cliente_novo.setvalorSeguro(valor_seguro_cliente);
            listaClientes.add(cliente_novo);
            System.out.println("Cliente adicionado com sucesso!");
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return true;
    }

    //função que adiciona um Cliente cliente na lista de clientes da seguradora já tendo o objeto cliente
    public boolean cadastrarCliente(Cliente cliente){
        double valor_seguro_cliente = calcularPrecoSeguraCliente(cliente);
        cliente.setvalorSeguro(valor_seguro_cliente);
        listaClientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
        return true;
    }

    //função que remove um cliente da base de dados da seguradora
    public boolean removerCliente(String nome_cliente){
        for(Cliente cliente_iterado: listaClientes){
            if(nome_cliente.equals(cliente_iterado.getNome())){
                listaClientes.remove(cliente_iterado);
                System.out.println("Cliente removido com sucesso!");
                return true;
            }
        }
        return false;
    }

    public boolean removerSinistro(String id_sinistro_str){
        int id_sinistro_int = Integer.parseInt(id_sinistro_str);
        for(Sinistro sinistro_iterado: listaSinistros){
            if(id_sinistro_int == sinistro_iterado.getId()){
                listaSinistros.remove(sinistro_iterado);
                System.out.println("Sinistro removido com sucesso!");
                return true;
            }
        }
        return false;
    }

    //função que itera sobre todos os clientes e printa pelo toString
    public void listarClientes(Seguradora seguradora){
        System.out.println("\nLista de clietes da seguradora " + seguradora.getNome() + "\n");
        for(Cliente cliente_iterado: listaClientes){
            System.out.println(cliente_iterado.toString());
            System.out.println("\n");
        }
    }

    //função que busca um cliente na base de dados da Seguradora
    public Cliente procuraCliente(String nome_cliente){
        for(Cliente cliente: listaClientes){
            if (cliente.getNome().equals(nome_cliente)){
                return cliente;
            }
        }
        return null;
    }

    //função que busca um veículo de um cliente dada sua placa na base de dados da seguradora
    public Veiculo procuraVeiculo(String placa, Cliente cliente){
        for(Veiculo veiculo: cliente.getListaVeiculos_cliente()){
            if(veiculo.getPlaca().equals(placa)){
                return veiculo;
            }
        }
        return null;
    }

    public void listarVeiculos(){
        System.out.println("Os veículos cobertos por essa seguradora possuem as seguintes placas: ");
        for(Cliente cliente_iterado: listaClientes){
            for(Veiculo veiculo_iterado: cliente_iterado.getListaVeiculos_cliente()){
                System.out.println(veiculo_iterado.getPlaca());
            }
        }
    }
    
    //função gerarSinistro para quando os dados serão recebidos do teclado
    public boolean gerarSinistro(Seguradora seguradora) throws ParseException {
        Scanner scanner = null;
        try{
            scanner = new Scanner(System.in);
            SimpleDateFormat formata_data = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Vamos gerar um sinistro. Para isso, digite as seguintes informações: ");
            System.out.println("Data do sinistro: ");
            String data_string = scanner.next();
            Date data_sinistro = formata_data.parse(data_string);
            System.out.println("Endereço: ");
            String endereco = scanner.next();
            System.out.println("Placa do veículo:");
            String placa_veiculo = scanner.next();
            System.out.println("Nome do cliente:");
            String nome_cliente = scanner.next();
            Cliente cliente = procuraCliente(nome_cliente);
            Veiculo veiculo_sinistro = procuraVeiculo(placa_veiculo, cliente);
            Sinistro sinistro = new Sinistro(data_sinistro, endereco, seguradora, veiculo_sinistro, cliente);
            listaSinistros.add(sinistro);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return true; 
    }

    //função gerarSinistro para quando já temos os dados
    public boolean gerarSinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        Sinistro sinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
        listaSinistros.add(sinistro);
        return true; 
    }

    public boolean visualizarSinistro(String nome_cliente){
        for(Sinistro sinistro_iterado: listaSinistros){
            if(sinistro_iterado.getcliente_sinistro().getNome() == nome_cliente)
                System.out.println("Sinistro do cliente " + nome_cliente + "\n");
                System.out.println(sinistro_iterado.toString());
            }
        return true;
    }

    //Lista todos os sinistros da seguradora    
    public void listarSinistros(Seguradora seguradora){
        System.out.println("\nSinistros da seguradora " + seguradora.getNome() + "\n");
        for(Sinistro sinistro_iterado: listaSinistros){
            System.out.println(sinistro_iterado.toString());
        }
    }

    //Lista os sinistros de um cliente escolhido
    public void listarSinistros(Seguradora seguradora, Cliente cliente){
        System.out.println("\nSinistros do cleinte " + cliente.getNome() + "\n");
        for(Sinistro sinistro_iterado: listaSinistros){
            if(sinistro_iterado.getcliente_sinistro().getNome().equals(cliente.getNome())){
                System.out.println(sinistro_iterado.toString());
            }
        }
    }

    public double calcularPrecoSeguraCliente(Cliente cliente){
        double preco;
        double qntd_sinistros = 0;
        for(Sinistro sinistro_iterado: listaSinistros){
            qntd_sinistros ++;
        }
        preco = (cliente.calculaScore(cliente)) * (1 + qntd_sinistros);
        return preco;

    }

    public double calcularReceita(){
        double receita = 0;
        for(Cliente cliente_iterado: listaClientes){
            receita += calcularPrecoSeguraCliente(cliente_iterado);
        }
        return receita;
    }

    //Transferir seguro por informações vindas do teclado
    public boolean transferirSeguro(Seguradora seguradora){
        /* Essa função concatena a lista de veiculos antiga com a que o cliente vai receber do outro
        e remove o cliente que solicita a transferencia da lista de clientes da seguradora */
        Scanner scanner = null;
        try{
            scanner = new Scanner(System.in);
            System.out.println("Vamos transferir o seguro de um cliente para o outro! Para isso, basta digitar os dados solicitados.");
            System.out.println("Nome do cliente que solicita a transferência: ");
            String cliente_solicita_str = scanner.next();
            System.out.println("Nome do cliente que receberá os carros segurados: ");
            String cliente_recebe_str = scanner.next();

            Cliente cliente_solicita = seguradora.procuraCliente(cliente_recebe_str);
            Cliente cliente_recebe = seguradora.procuraCliente(cliente_solicita_str);
            ArrayList<Veiculo> lista_veiculos = new ArrayList<Veiculo>();
            //Adicionando os veiculos que já eram do cliente no novo arraylist de veiculos
            for(Veiculo veiculo: cliente_recebe.getListaVeiculos_cliente()){
                lista_veiculos.add(veiculo);
            }
            //Adicionando os veiculos novos ao arraylist novo
            for(Veiculo veiculo: cliente_solicita.getListaVeiculos_cliente()){
                lista_veiculos.add(veiculo);
            }
            cliente_recebe.setListaVeiculos_cliente(lista_veiculos);
            //Removendo o cliente que solicitou a transferência da lista de clientes
            for(Cliente cliente_iterado: listaClientes){
                if(cliente_iterado.getNome().equals(cliente_solicita.getNome())){
                    listaClientes.remove(cliente_iterado);
                }
            }
            double valor_seguro = seguradora.calcularPrecoSeguraCliente(cliente_recebe);
            cliente_recebe.setvalorSeguro(valor_seguro); 
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        System.out.println("Os dados foram transferidos e o cliente que solicitou da transferência já foi removido do sistema.");
        return true;
    }
    
    //função que transfere o seguro quando já temos os objetos (não recebemos do teclado)
    public boolean transferirSeguro(Cliente cliente_solicita, Cliente cliente_recebe){
        /* Essa função concatena a lista de veiculos antiga com a que o cliente vai receber do outro
        e remove o cliete que solicita a transferencia da lista de clientes da seguradora */

        ArrayList<Veiculo> lista_veiculos = new ArrayList<Veiculo>();
        for(Veiculo veiculo: cliente_recebe.getListaVeiculos_cliente()){
            lista_veiculos.add(veiculo);
        }
        for(Veiculo veiculo: cliente_solicita.getListaVeiculos_cliente()){
            lista_veiculos.add(veiculo);
        }
        cliente_recebe.setListaVeiculos_cliente(lista_veiculos);
        for(Cliente cliente_iterado: listaClientes){
            if(cliente_iterado.getNome().equals(cliente_solicita.getNome())){
                listaClientes.remove(cliente_iterado);
            }
        }
        return true;
    }
}