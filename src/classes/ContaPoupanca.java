package classes;

public class ContaPoupanca extends Conta {
    int diaAniversario;

    public ContaPoupanca(int numeroConta, int agencia, Titular[] titulares, int diaAniversario) {
        super(numeroConta, agencia, titulares);
        this.diaAniversario = diaAniversario;
    }
}