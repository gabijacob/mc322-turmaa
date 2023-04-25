package lab03;
import java.util.*;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero_cliente;
    private Date dataLicenca_cliente;
    private String educacao_cliente;
    private Date dataNascimento_cliente;
    private String classeEconomica_cliente;

    public ClientePF(String nome, String endereco, ArrayList<Veiculo> listaVeiculos,  String cpf, String genero, Date dataLicenca, String educacao,  Date dataNascimento, String classeEconomica){
        super(nome, endereco, listaVeiculos);
        this.cpf = cpf;
        this.genero_cliente = genero;
        this.dataLicenca_cliente = dataLicenca;
        this.educacao_cliente = educacao;
        this.dataNascimento_cliente = dataNascimento;
        this.classeEconomica_cliente = classeEconomica;
    }

    public String getCpf() {
        return cpf;
    }

    public String getGenero_cliente() {
		return genero_cliente;
	}

	public void setGenero_cliente(String genero_cliente) {
		this.genero_cliente = genero_cliente;
	}

    public Date getDataLicenca_cliente() {
		return dataLicenca_cliente;
	}

	public void setDataLicenca_cliente(Date dataLicenca_cliente) {
		this.dataLicenca_cliente = dataLicenca_cliente;
	}
	
    public String getEducacao_cliente() {
		return educacao_cliente;
	}

	public void setEducacao_cliente(String educacao_cliente) {
		this.educacao_cliente = educacao_cliente;
	}

    public Date getDataNascimento() {
        return dataNascimento_cliente;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento_cliente = dataNascimento;
    }

	public String getClasseEconomica_cliente() {
		return classeEconomica_cliente;
	}

	public void setClasseEconomica_cliente(String classeEconomica_cliente) {
		this.classeEconomica_cliente = classeEconomica_cliente;
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
            System.out.println("O cpf é válido!");
            return true;
        }
        else{
            System.out.println("O cpf NÃO válido! :(");
            return false;
        }
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome_cliente + "\nEndereco: " + this.endereco_cliente + "\nGênero: " + this.genero_cliente + "\nData da Licença: " + this.dataLicenca_cliente + "\nEducação: " + this.educacao_cliente + "\nData de Nacimento: " + this.dataNascimento_cliente + "\nClasse Econômica: " + this.classeEconomica_cliente;
    }
}