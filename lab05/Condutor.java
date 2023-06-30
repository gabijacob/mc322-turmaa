package lab05;

import java.util.*;
import java.time.*;

public class Condutor {
    private final String cpf_condutor;
    private String nome_condutor;
    private String telefone_condutor;
    private String endereco_condutor;
    public String email_condutor;
    public Date dataNasc_condutor;
    public ArrayList<Sinistro> listaSinistros_condutor;

    public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNasc, ArrayList<Sinistro> listaSinistros) {
        this.cpf_condutor = cpf;
        this.nome_condutor = nome;
        this.telefone_condutor = telefone;
        this.endereco_condutor = endereco;
        this.email_condutor = email;
        this.dataNasc_condutor = dataNasc;
        this.listaSinistros_condutor = listaSinistros;
    }

    public String getCpf_condutor(){
        return cpf_condutor;
    }

    public String getNome_condutor() {
        return nome_condutor;
    }

    public void setNome_condutor(String nome_condutor) {
        this.nome_condutor = nome_condutor;
    }

    public String getTelefone_condutor() {
        return telefone_condutor;
    }

    public void setTelefone_condutor(String telefone_condutor) {
        this.telefone_condutor = telefone_condutor;
    }

    public String getEndereco_condutor() {
        return endereco_condutor;
    }

    public void setEndereco_condutor(String endereco_condutor) {
        this.endereco_condutor = endereco_condutor;
    }

    public String getEmail_condutor() {
        return email_condutor;
    }

    public void setEmail_condutor(String email_condutor) {
        this.email_condutor = email_condutor;
    }

    public Date getDataNasc_condutor() {
        return dataNasc_condutor;
    }

    public void setDataNasc_condutor(Date dataNasc_condutor) {
        this.dataNasc_condutor = dataNasc_condutor;
    }

    public ArrayList<Sinistro> getListaSinistros_condutor() {
        return listaSinistros_condutor;
    }

    public void setListaSinistros_condutor(ArrayList<Sinistro> listaSinistros_condutor) {
        this.listaSinistros_condutor = listaSinistros_condutor;
    }
    
    public boolean adicionarSinistro(Sinistro sinistro){
        listaSinistros_condutor.add(sinistro);
        System.out.println("Sinistro adicionado com sucesso na lista de sinistros do condutor " + this.nome_condutor);
        return true;
    }

    public String toString(){
        String listaSinistros_str = "";
        for(Sinistro sinistro_iterado : listaSinistros_condutor){
            listaSinistros_str = sinistro_iterado.getId() + "\n";
        }
        return "CPF: " + this.cpf_condutor + "\nNome/: " + this.nome_condutor + "\nTelefone: " + this.telefone_condutor + "\nEndereço: " + this.endereco_condutor + "\nEmail: " + this.email_condutor + "\nData de Nascimento: " + this.dataNasc_condutor + "\nLista de Sinistros: " + listaSinistros_str;
    }
}
