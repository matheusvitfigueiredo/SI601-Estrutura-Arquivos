package Aula05;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AlunoJsonIO {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvar(List<Aluno> alunos, String nomeArquivo) throws IOException {
        try (Writer writer = Files.newBufferedWriter(Path.of(nomeArquivo),StandardCharsets.UTF_8)) {
            gson.toJson(alunos, writer);
        }
    }
    public static List<Aluno> carregar(String nomeArquivo) throws IOException {
        Type tipoLista = new TypeToken<List<Aluno>>() {}.getType();
        try (Reader reader = Files.newBufferedReader(Path.of(nomeArquivo), StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, tipoLista);
        }
    }
 }