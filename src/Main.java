import classes.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        int opcao;

        do {
            System.out.println("\n1 - Cadastrar Conta");
            System.out.println("2 - Listar Contas");
            System.out.println("3 - Buscar Conta");
            System.out.println("4 - Remover Conta");
            System.out.println("5 - Depositar");
            System.out.println("6 - Sacar");
            System.out.println("7 - Encerrar Conta");
            System.out.println("8 - Sair");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("1 - Especial | 2 - Poupança");
                    int tipo = sc.nextInt();

                    System.out.print("Número: ");
                    int numero = sc.nextInt();

                    System.out.print("Agência: ");
                    int agencia = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    Titular[] titulares = new Titular[1];
                    titulares[0] = new Titular(nome, cpf);

                    if (tipo == 1) {
                        System.out.print("Limite: ");
                        BigDecimal limite = sc.nextBigDecimal();

                        banco.cadastrarConta(
                                new ContaEspecial(numero, agencia, titulares, limite));
                    } else {
                        System.out.print("Dia aniversário: ");
                        int dia = sc.nextInt();

                        banco.cadastrarConta(
                                new ContaPoupanca(numero, agencia, titulares, dia));
                    }
                    break;

                case 2:
                    banco.listarContas();
                    break;

                case 3:
                    System.out.print("Número: ");
                    Conta c = banco.buscarConta(sc.nextInt());
                    if (c != null) c.exibir();
                    else System.out.println("Conta não encontrada");
                    break;

                case 4:
                    System.out.print("Número: ");
                    if (banco.removerConta(sc.nextInt()))
                        System.out.println("Removida");
                    else
                        System.out.println("Não pode remover");
                    break;

                case 5:
                    System.out.print("Número: ");
                    Conta cDep = banco.buscarConta(sc.nextInt());
                    if (cDep != null) {
                        System.out.print("Valor: ");
                        cDep.depositar(sc.nextBigDecimal());
                    }
                    break;

                case 6:
                    System.out.print("Número: ");
                    Conta cSaq = banco.buscarConta(sc.nextInt());
                    if (cSaq != null) {
                        System.out.print("Valor: ");
                        if (!cSaq.sacar(sc.nextBigDecimal()))
                            System.out.println("Saldo insuficiente");
                    }
                    break;

                case 7:
                    System.out.print("Número: ");
                    Conta cEnc = banco.buscarConta(sc.nextInt());
                    if (cEnc != null && cEnc.getSaldo().compareTo(BigDecimal.ZERO) == 0) {
                        cEnc.setAtiva(false);
                        System.out.println("Conta encerrada");
                    } else {
                        System.out.println("Não pode encerrar");
                    }
                    break;

            }

        } while (opcao != 8);

        sc.close();
    }
}