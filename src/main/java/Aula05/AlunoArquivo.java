package Aula05;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AlunoArquivo {
    // Abordagem 1 – Prefixo de tamanho
    public static void gravarEstrategia1(List<Aluno> alunos, String caminho) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(caminho), StandardCharsets.UTF_8))) {

            for (Aluno a : alunos) {
                String ra = a.getRa();
                String nome = a.getNome();
                String anoStr = String.valueOf(a.getAnoNasc());

                gravarCampoE1(bw, ra);
                bw.write(' ');
                gravarCampoE1(bw, nome);
                bw.write(' ');
                gravarCampoE1(bw, anoStr);
                bw.newLine();
            }
        }
    }

    private static void gravarCampoE1(BufferedWriter bw, String valor) throws IOException {
        if (valor.length() > 99) throw new IllegalArgumentException(
                "Campo excede 99 caracteres: " + valor);
        bw.write(String.format("%02d", valor.length()));
        bw.write(valor);
    }

    public static List<Aluno> lerEstrategia1(String caminho) throws IOException {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(caminho), StandardCharsets.UTF_8))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.isBlank()) continue;
                int[] pos = {0};
                String ra     = lerCampoE1(linha, pos); pos[0]++;
                String nome   = lerCampoE1(linha, pos); pos[0]++;
                String anoStr = lerCampoE1(linha, pos);
                alunos.add(new Aluno(ra, nome, Integer.parseInt(anoStr)));
            }
        }
        return alunos;
    }

    private static String lerCampoE1(String linha, int[] pos) {
        int tam = Integer.parseInt(linha.substring(pos[0], pos[0] + 2));
        pos[0] += 2;
        String valor = linha.substring(pos[0], pos[0] + tam);
        pos[0] += tam;
        return valor;
    }

    // Abordagem 2 – Delimitador "|"
    public static void gravarEstrategia2(List<Aluno> alunos, String caminho) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(caminho), StandardCharsets.UTF_8))) {

            for (Aluno a : alunos) {
                String linha = a.getRa() + "|" + a.getNome() + "|" + a.getAnoNasc();
                bw.write(linha);
                bw.newLine();
            }
        }
    }

    public static List<Aluno> lerEstrategia2(String caminho) throws IOException {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(caminho), StandardCharsets.UTF_8))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.isBlank() || linha.startsWith("#")) continue;

                String[] partes = linha.split("\\|", -1);
                if (partes.length != 3) throw new IOException(
                        "Linha mal formada (esperava 3 campos): " + linha);

                String ra   = partes[0];
                String nome = partes[1];
                int anoNasc = Integer.parseInt(partes[2]);
                alunos.add(new Aluno(ra, nome, anoNasc));
            }
        }
        return alunos;
    }

    // Abordagem 3 – JSON (utilizando GSON via AlunoJsonIO)
    public static void gravarEstrategia3(List<Aluno> alunos, String caminho) throws IOException {
        AlunoJsonIO.salvar(alunos, caminho);
    }

    public static List<Aluno> lerEstrategia3(String caminho) throws IOException {
        return AlunoJsonIO.carregar(caminho);
    }
}
