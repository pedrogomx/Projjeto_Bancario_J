package classes;

import java.math.BigDecimal;

public class ContaEspecial extends Conta {
    BigDecimal limiteEspecial;

    public ContaEspecial(int numeroConta, int agencia, Titular[] titulares, BigDecimal limiteEspecial) {
        super(numeroConta, agencia, titulares);
        this.limiteEspecial = limiteEspecial;
    }

    @Override
    public boolean sacar(BigDecimal valor) {
        BigDecimal totalDisponivel = saldo.add(limiteEspecial);

        if (totalDisponivel.compareTo(valor) >= 0) {
            saldo = saldo.subtract(valor);
            return true;
        }
        return false;
    }
}