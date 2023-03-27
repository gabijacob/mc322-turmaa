package lab2;

public class Cliente {

    private String nome_cliente;
    private String cpf_cliente;
    private String dataNascimento_cliente;
    private int idade_cliente;
    private String endereco_cliente;

    //Construtor
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco){
        this.nome_cliente = nome;
        this.cpf_cliente = cpf;
        this.dataNascimento_cliente = dataNascimento;
        this.idade_cliente = idade;
        this.endereco_cliente = endereco;
    }

    //Getters e setters
    public String getNome(){
        return nome_cliente;
    }

    public void setNome(String nome){
        this.nome_cliente = nome;
    }

    public String getCpf(){
        return cpf_cliente;
    }

    public void setCpf(String cpf){
        this.cpf_cliente = cpf;
    }

    public String getDataNascimento(){
        return dataNascimento_cliente;
    }

    public void setDataNasciemtno(String dataNascimento){
        this.dataNascimento_cliente = dataNascimento;
    }

    public int getIdade(){
        return idade_cliente;
    }

    public void setIdade(int idade){
        this.idade_cliente = idade;
    }

    public String getEndereco(){
        return endereco_cliente;
    }

    public void setEndereco(String endereco){
        this.endereco_cliente = endereco;
    }

    public boolean validarCpf(String cpf){
            
        // Remove letras
        String cpf_validado = cpf.replaceAll("[a-zA-Z]", "");
        
        // Remove caracteres especiais
        cpf_validado = cpf_validado.replaceAll("[^a-zA-Z0-9]", "");
        
        // Retorna o numero de caracteres do cpf
        int cpf_length = cpf_validado.length();
        if (cpf_length != 11){
            return false;
        }

        // Verifica se todos os dígitos são iguais
        int soma = 0;
        for (int i = 0; i < 10; i++){
            if (cpf_validado.charAt(i) == cpf_validado.charAt(i+1)) {
                soma++;
            }
        }
        if (soma == 11) {
            return false;
        }

        // Calcula o primeiro digito verificaor
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            char digito = cpf_validado.charAt(i);
            int digito_inteiro = Character.digit(digito, 10);
            soma1 += digito_inteiro * (10 - i);
        }
        int digito1 = 11 - (soma1%11);
        if(digito1 == 10 || digito1 == 11){
            digito1 = 0;
        }

        // Calcula o segundo digito verifiador
        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            char digito = cpf_validado.charAt(i);
            int digito_inteiro = Character.digit(digito, 10);
            soma2 += digito_inteiro * (11 - i);
        }
        int digito2 = 11 - (soma2%11);
        if(digito2 == 10 || digito2 == 11){
            digito2 = 0;
        }

        // Verifica se ambos os digitos verificadores estão corretos
        char digito1_char = cpf_validado.charAt(9);
        char digito2_char = cpf_validado.charAt(10);
        int digito1_cpf = Character.digit(digito1_char, 10);
        int digito2_cpf = Character.digit(digito2_char, 10);

        if(digito1_cpf == digito1 && digito2_cpf == digito2){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return "Nome:" + this.nome_cliente + "\nCpf:" + this.cpf_cliente + "\nData de Nascimento:" + this.dataNascimento_cliente + "\nIdade:" + this.idade_cliente + "\nEndereco:" + this.endereco_cliente;
    }
}