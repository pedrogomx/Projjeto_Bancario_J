package classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Conta {
    protected int numeroConta;
    protected int agencia;
    protected Titular[] titulares;
    protected BigDecimal saldo;
    protected LocalDate dataAbertura;
    protected boolean ativa;

    public Conta(int numeroConta, int agencia, Titular[] titulares) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.titulares = titulares;
        this.saldo = BigDecimal.ZERO;
        this.dataAbertura = LocalDate.now();
        this.ativa = true;
    }

    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    public boolean sacar(BigDecimal valor) {
        if (saldo.compareTo(valor) >= 0) {
            saldo = saldo.subtract(valor);
            return true;
        }
        return false;
    }

    public void exibir() {
        System.out.println("Conta: " + numeroConta);
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo: " + saldo);
        System.out.println("Ativa: " + ativa);

        for (Titular t : titulares) {
            if (t != null) t.exibir();
        }
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public boolean getAtiva(){
        return this.ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}