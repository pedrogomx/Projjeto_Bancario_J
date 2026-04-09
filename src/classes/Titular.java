package classes;

public class Titular {
    private String nome;
    private String cpf;

    public Titular(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void exibir() {
        System.out.println("Titular: " + nome + " | CPF: " + cpf);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
