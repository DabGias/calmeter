package br.com.fiap.calmeter.global;

import java.util.List;
import java.util.Optional;

import br.com.fiap.calmeter.models.Alimento;
import br.com.fiap.calmeter.models.Meta;
import br.com.fiap.calmeter.models.Refeicao;

public abstract class Finder {
    public static Optional<Meta> finderMeta(Long id, List<Meta> lista) {
        Optional<Meta> element = lista.stream().filter((e) -> {
            return e.getId().equals(id);
        }).findFirst();

        return element;
    }

    public static Optional<Alimento> finderAlimento(Long id, List<Alimento> lista) {
        Optional<Alimento> element = lista.stream().filter((e) -> {
            return e.getId().equals(id);
        }).findFirst();

        return element;
    }

    public static Optional<Refeicao> finderRefeicao(Long id, List<Refeicao> lista) {
        Optional<Refeicao> element = lista.stream().filter((e) -> {
            return e.getId().equals(id);
        }).findFirst();

        return element;
    }
}
