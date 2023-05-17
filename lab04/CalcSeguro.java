package lab04;

public enum CalcSeguro {
    VALOR_BASE (100.0),
    FATOR_18_30 (1.2),
    FATOR_30_60 (1.0),
    FATOR_60_90 (1.5);

    final double fator;
    final double valor_base = 100.0;

    CalcSeguro(double fator) {
        this.fator = fator;
    }

    public double get_fator(){
        return fator;
    }
}
