package classes;

import java.math.BigDecimal;

public class Banco {
    Conta[] contas = new Conta[100];
    int totalContas = 0;

    public void cadastrarConta(Conta conta) {
        contas[totalContas] = conta;
        totalContas ++;
    }

    public Conta buscarConta(int numero) {
        for (int i = 0; i < totalContas; i++) {
            if (contas[i].numeroConta == numero) {
                return contas[i];
            }
        }
        return null;
    }

    public void listarContas() {
        for (int i = 0; i < totalContas; i++) {
            if (contas[i].ativa) {
                contas[i].exibir();
                System.out.println("----------------");
            }
        }
    }

    public boolean removerConta(int numero) {
        for (int i = 0; i < totalContas; i++) {
            if (contas[i].numeroConta == numero) {
                if (contas[i].saldo.compareTo(BigDecimal.ZERO) == 0) {
                    for (int j = i; j < totalContas - 1; j++) {
                        contas[j] = contas[j + 1];
                    }
                    totalContas--;
                    return true;
                }
            }
        }
        return false;
    }
}
