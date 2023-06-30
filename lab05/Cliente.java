package lab05;

public abstract class Cliente {
	public String nome_cliente;
    public String telefone_cliente;
    public String endereco_cliente;
    public String email_cliente;

    public Cliente(String nome, String telefone, String endereco, String email){
        this.nome_cliente = nome;
        this.telefone_cliente = telefone;
        this.endereco_cliente = endereco;  
        this.email_cliente = email;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    public String getEndereco_cliente() {
        return endereco_cliente;
    }

    public void setEndereco_cliente(String endereco_cliente) {
        this.endereco_cliente = endereco_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String toString(){
        return "Nome: " + this.nome_cliente + "\nTelefone: " + this.telefone_cliente + "\nEndereco: " + this.endereco_cliente + "\nEmail: " + this.email_cliente;
    }
}