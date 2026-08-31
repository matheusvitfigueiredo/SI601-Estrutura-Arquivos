package Aula04;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final int ESTRATEGIA = 3;
    public static void main(String[] args) {

        List<Aluno> original = Arrays.asList(
                new Aluno("2300001", "Ana Souza", 2003),
                new Aluno("2300002", "Bruno Lima", 2002),
                new Aluno("2200010", "Carla Mendes", 2001),
                new Aluno("2100099", "Diego Ferreira", 2000),
                new Aluno("2400005", "Erica Nascimento", 2004)
        );

        String arquivo;
        String titulo;
        switch (ESTRATEGIA) {
            case 1 -> {
                arquivo = "alunos_estrategia1.txt";
                titulo  = "Estratégia 1 – Prefixo de tamanho (2 dígitos por campo)";
            }
            case 2 -> {
                arquivo = "alunos_estrategia2.txt";
                titulo  = "Estratégia 2 – Delimitador \"|\"";
            }
            case 3 -> {
                arquivo = "alunos_estrategia3.txt";
                titulo  = "Estratégia 3 – JSON (chave-valor)";
            }
            default -> {
                System.err.println("Estratégia inválida! Escolha 1, 2 ou 3.");
                return;
            }
        }
        System.out.println("  " + titulo);
        System.out.println("\n[Lista original]");
        original.forEach(System.out::println);

        try {
            switch (ESTRATEGIA) {
                case 1 -> AlunoArquivo.gravarEstrategia1(original, arquivo);
                case 2 -> AlunoArquivo.gravarEstrategia2(original, arquivo);
                case 3 -> AlunoArquivo.gravarEstrategia3(original, arquivo);
            }
            System.out.println("\nGravado em: " + arquivo);
        } catch (IOException e) {
            System.err.println("Erro ao gravar: " + e.getMessage());
            return;
        }

        List<Aluno> lidos;
        try {
            lidos = switch (ESTRATEGIA) {
                case 1 -> AlunoArquivo.lerEstrategia1(arquivo);
                case 2 -> AlunoArquivo.lerEstrategia2(arquivo);
                case 3 -> AlunoArquivo.lerEstrategia3(arquivo);
                default -> throw new IOException("Estratégia inválida.");
            };
            System.out.println("Lido de: " + arquivo);
        } catch (IOException e) {
            System.err.println("Erro ao ler: " + e.getMessage());
            return;
        }

        System.out.println("\n[Lista lida do arquivo]");
        lidos.forEach(System.out::println);
        System.out.println("\n[Verificação de integridade]");
        boolean ok = original.size() == lidos.size();
        if (ok) {
            for (int i = 0; i < original.size(); i++) {
                Aluno o = original.get(i), l = lidos.get(i);
                if (!o.getRa().equals(l.getRa())
                 || !o.getNome().equals(l.getNome())
                 || o.getAnoNasc() != l.getAnoNasc()) {
                    ok = false;
                    System.out.println("  ✘ Diferença no registro " + i + ": esperado " + o + ", obtido " + l);
                }
            }
        }
        System.out.println(ok ? "Todos os " + original.size() + " registros conferem!" : "Foram encontradas diferenças.");
        System.out.println("\n[Idades calculadas]");
        lidos.forEach(a -> System.out.printf("  %-20s → %d anos%n", a.getNome(), a.getIdade()));
    }
}
