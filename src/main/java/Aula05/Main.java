package Aula05;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String arquivo = "alunos.json";

        List<Aluno> original = Arrays.asList(
                new Aluno("196220", "Nelson Modenez Neto", 2005),
                new Aluno("173012", "Gabriel Gaudio Saraiva", 2002),
                new Aluno("288824", "Adriano Baumgarte Bassani Filho", 2001),
                new Aluno("185720", "Julyo Elias Hidalgo Da Silva", 2000),
                new Aluno("194774", "Matheus Vitório Figueiredo De Oliveira", 2006),
                new Aluno("173888", "Carlos Alberto Sardenha Filho", 2004),
                new Aluno("246507", "Hans William Hamann", 2005)
        );

        System.out.println("=== Estrutura de Arquivos: JSON com GSON ===");
        System.out.println("\n[Lista original]");
        original.forEach(System.out::println);

        // // Gravação em JSON
        try {
            AlunoJsonIO.salvar(original, arquivo);
            System.out.println("\nGravado em: " + arquivo);
        } catch (IOException e) {
            System.err.println("Erro ao gravar: " + e.getMessage());
            return;
        }

        // Leitura do JSON
        List<Aluno> lidos;
        try {
            lidos = AlunoJsonIO.carregar(arquivo);
            System.out.println("Lido de: " + arquivo);
        } catch (IOException e) {
            System.err.println("Erro ao ler: " + e.getMessage());
            return;
        }

        System.out.println("\n[Lista lida do arquivo JSON]");
        lidos.forEach(System.out::println);

        // Verificação de integridade
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

        // Idades calculadas
        System.out.println("\n[Idades calculadas]");
        lidos.forEach(a -> System.out.printf("%-40s → %d anos%n", a.getNome(), a.getIdade()));
    }
}
