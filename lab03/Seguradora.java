package lab03;
import java.util.*;

public class Seguradora {
	private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    // Construtor
    public Seguradora(String nome, String telefone, String email, String endereco, ArrayList<Sinistro> listaSinistros, ArrayList<Cliente> listaClientes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
    }

    // Getters e setters
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

    public boolean cadastrarCliente(Cliente cliente){
        listaClientes.add(cliente);
        return true;
    }

    public boolean removerCliente(Cliente cliente, ArrayList<Cliente> listaClientes){
        //iterando em todos os clientes
        for(Cliente cliente_iterado: listaClientes){
            String nome_cliente_iterado = cliente_iterado.getNome();
            String nome_cliente = cliente.getNome();
            if(nome_cliente.equals(nome_cliente_iterado)){
                listaClientes.remove(cliente_iterado);
                return true;
            }
        }
        return false;
    }

    public void listarClientes(ArrayList<Cliente> lista_clientes, Seguradora seguradora){
        System.out.println("\nClietes da seguradora " + seguradora.getNome() + "\n");
        for(Cliente cliente_iterado: listaClientes){
        System.out.println(cliente_iterado.toString());
        System.out.println("\n");
        }
    }

    public boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
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
    
    public void listarSinistros(ArrayList<Sinistro> lista_sinistros, Seguradora seguradora){
        System.out.println("\nSinistros da seguradora " + seguradora.getNome() + "\n");
        for(Sinistro sinistro_iterado: listaSinistros){
            System.out.println(sinistro_iterado.toString());
            }
    }
}

