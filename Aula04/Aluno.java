package Aula04;

import java.time.LocalDate;

public class Aluno {

    private String ra;
    private String nome;
    private int anoNasc;

    public Aluno(String ra, String nome, int anoNasc) {
        this.ra      = ra;
        this.nome    = nome;
        this.anoNasc = anoNasc;
    }

    public Aluno() {
        this("", "", 0);
    }

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public int getIdade() {
        return LocalDate.now().getYear() - anoNasc;
    }

    @Override
    public String toString() {
        return "Aluno{ra='" + ra + "', nome='" + nome + "', anoNasc=" + anoNasc + ", idade=" + getIdade() + "}";
    }
}
