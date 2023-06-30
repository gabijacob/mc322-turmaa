package lab05;

public enum SubmenuOperacoes {
    CADASTRAR_CLIENTE("Cadastrar cliente"),
    CADASTRAR_VEICULO("Cadastrar veiculo"),
    CADASTRAR_SEGURADORA("Cadastrar seguradra"),
    CADASTRAR_SEGURO("Cadastrar seguro"),
    CADASTRAR_CONDUTOR("Cadastrar condutor"),
    CADASTRAR_FROTA("Cadastrar frota"),
    CADASTRAR_SINISTRO("Cadastrar sinistro"),
    LISTAR_CLIENTES_POR_SEGURADORA("Listar clientes por seguradora"),
    LISTAR_SEGUROS_POR_SEGURADORA("Listar seguros por seguradora"),
    LISTAR_SEGUROS_POR_CLIENTE("Listar seguros por cliente"),
    LISTAR_SINISTROS_POR_CLIENTE("Listar sinistros por cliente"),
    EXCLUIR_CLIENTE("Excluir cliente"),
    EXCLUIR_VEICULO("Excluir veiculo"),
    EXCLUIR_SINISTRO("Excluir sinistro"),
    EXCLUIR_SEGURO("Excluir seguro"),
    VOLTAR("Voltar");
    
    private final String operacao;

    SubmenuOperacoes(String operacao){
        this.operacao = operacao;
    }

    public String getOperacao(){
        return this.operacao;
    }  
}