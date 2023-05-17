package lab04;

public enum SubmenuOperacoes {
    CADASTRAR_CLIENTE("Cadastrar cliente"),
    //tem que mudar o preco automaticamente: FAZER!!!
    CADASTRAR_VEICULO("Cadastrar veiculo"),
    CADASTRAR_SEGURADORA("Cadastrar seguradra"),
    LISTAR_CLIENTES_POR_SEGURADORA("Listar clientes por seguradora"),
    LISTAR_SINISTROS_POR_SEGURADORA("Listar sinistros por seguradora"),
    LISTAR_SINISTROS_POR_CLIENTE("Listar sinistros por cliente"),
    LISTAR_VEICULO_POR_CLIENTE("Listar veiculo por cliente"),
    LISTAR_VEICULO_POR_SEGURADORA("Listar veiculo por seguradora"),
    EXCLUIR_CLIENTE("Excluir cliente"),
    EXCLUIR_VEICULO("Excluir veiculo"),
    EXCLUIR_SINISTRO("Excluir sinistro"),
    VOLTAR("Voltar");
    
    private final String operacao;

    SubmenuOperacoes(String operacao){
        this.operacao = operacao;
    }

    public String getOperacao(){
        return this.operacao;
    }
    
}
