package lab03;
import java.util.*;

public class ClientePJ extends Cliente{

    private final String cnpj;
    private Date dataFundacao;

    // Construtor
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String cnpj, Date dataFundacao){
        super(nome, endereco, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }


    public boolean validarCnpj(String cnpj){
        String cnpj_validado = cnpj.replaceAll("[a-zA-Z]", "");
        cnpj_validado = cnpj_validado.replaceAll("[^a-zA-Z0-9]", "");

        // Retorna o numero de caracteres do cnpj
        int cnpj_length = cnpj_validado.length();
        if (cnpj_length != 14){
            return false;
        }

        // Verifica se todos os dígitos são iguais
        int soma = 0;
        for (int i = 0; i < 13; i++){
            if (cnpj_validado.charAt(i) == cnpj_validado.charAt(i+1)) {
                soma++;
            }
        }

        if (soma == 14) {
            return false;
        }

        // Calcula o primeiro digito verificaor
        int soma1 = 0;
        for (int i = 0; i < 12; i++) {
            char digito = cnpj_validado.charAt(i);
            int digito_inteiro = Character.digit(digito, 10);
            if(i >= 4){
                soma1 += digito_inteiro * (13 - i);
            }
            else{
                soma1 += digito_inteiro * (5 - i);
            }
        }
        int digito1 = (soma1%11);
        if(digito1 < 2){
            digito1 = 0;
        }
        else{
            digito1 = 11 - digito1;
        }

        // Calcula o segundo digito verifiador
        int soma2 = 0;
        for (int i = 0; i < 13; i++) {
            char digito = cnpj_validado.charAt(i);
            int digito_inteiro = Character.digit(digito, 10);
            if(i >= 5){
                soma2 += digito_inteiro * (14 - i);
            }
            else{
                soma2 += digito_inteiro * (6 - i);
            }
        }
        int digito2 = (soma2%11);
        if(digito2 < 2){
            digito2 = 0;
        }
        else{
            digito2 = 11 - digito2;
        }

        // Verifica se ambos os digitos verificadores estão corretos
        char digito1_char = cnpj_validado.charAt(12);
        char digito2_char = cnpj_validado.charAt(13);
        int digito1_cnpj = Character.digit(digito1_char, 10);
        int digito2_cnpj = Character.digit(digito2_char, 10);

        if(digito1_cnpj == digito1 && digito2_cnpj == digito2){
            System.out.println("O cnpj é válido!");
            return true;
        }
        else{
            System.out.println("O cnpj NÃO é válido! :(");
            return false;
        }

    }

    @Override
    public String toString(){
        return "Nome: " + this.nome_cliente + "\nEndereco: " + this.endereco_cliente + "\nCNPJ: " + this.cnpj + "\nData de Fundação: " + this.dataFundacao;
    }    
}
