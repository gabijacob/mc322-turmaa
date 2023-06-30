package lab05;

public enum MenuOperacoes {
    CADASTRAR("Cadastrar", new SubmenuOperacoes[]{
        SubmenuOperacoes.CADASTRAR_CLIENTE,
        SubmenuOperacoes.CADASTRAR_VEICULO,
        SubmenuOperacoes.CADASTRAR_SEGURADORA,
        SubmenuOperacoes.CADASTRAR_SEGURO,
        SubmenuOperacoes.CADASTRAR_CONDUTOR,
        SubmenuOperacoes.CADASTRAR_FROTA,
        SubmenuOperacoes.CADASTRAR_SINISTRO,
        SubmenuOperacoes.VOLTAR
    }),
    LISTAR("Listar", new SubmenuOperacoes[]{
        SubmenuOperacoes.LISTAR_CLIENTES_POR_SEGURADORA,
        SubmenuOperacoes.LISTAR_SEGUROS_POR_SEGURADORA,
        SubmenuOperacoes.LISTAR_SEGUROS_POR_CLIENTE,
        SubmenuOperacoes.LISTAR_SINISTROS_POR_CLIENTE,
        SubmenuOperacoes.VOLTAR
    }),
    EXCLUIR("Excluir", new SubmenuOperacoes[]{
        SubmenuOperacoes.EXCLUIR_CLIENTE,
        SubmenuOperacoes.EXCLUIR_VEICULO,
        SubmenuOperacoes.EXCLUIR_SINISTRO,
        SubmenuOperacoes.EXCLUIR_SEGURO,
        SubmenuOperacoes.VOLTAR

    }),
    CALCULAR_RECEITA_SEGURADORA("Calcular receita da seguradora", new SubmenuOperacoes[] {SubmenuOperacoes.VOLTAR}),
    CALCULAR_VALOR_MENSAL_SEGURO("Calcular valor mensal do seguro", new SubmenuOperacoes[] {SubmenuOperacoes.VOLTAR}),
    SAIR("Sair", new SubmenuOperacoes[]{});

    public final String operacao;
    private final SubmenuOperacoes[] submenu;

    MenuOperacoes(String operacao, SubmenuOperacoes[] submenu){
        this.operacao = operacao;
        this.submenu = submenu;
    }

    public String getOperacao(){
        return this.operacao;
    }

    public SubmenuOperacoes[] getSubmenu(){
        return submenu;
    }
}