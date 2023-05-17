package lab04;

public class Validacao {

    public static class ValidacaoCPF{
        private String cpf;
        
        public ValidacaoCPF(String cpf){
            this.cpf = cpf;
        }

        public boolean validaCpf(String cpf){
                
            // Remove letras e caracteres especiais
            String cpf_validado = cpf.replaceAll("[a-zA-Z]", "");
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
    }

    public static class ValidacaoCNPJ{
        private String cnpj;
        
        public ValidacaoCNPJ(String cnpj){
            this.cnpj = cnpj;
        }

        public boolean validaCnpj(String cnpj){
            String cnpj_validado = cnpj.replaceAll("[a-zA-Z]", "");
            cnpj_validado = cnpj_validado.replaceAll("[^a-zA-Z0-9]", "");
    
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
    }

    public static class ValidacaoNome{
        private String nome;
        
        public ValidacaoNome(String nome){
            this.nome = nome;
        }

        public boolean validaNome(String nome){
            return nome.matches("^[a-zA-Z]*$");
        }
    }   
}