package br.com.fiap.calmeter.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.calmeter.models.Alimento;
import br.com.fiap.calmeter.models.Meta;
import br.com.fiap.calmeter.models.Refeicao;
import br.com.fiap.calmeter.repositories.AlimentoRepository;
import br.com.fiap.calmeter.repositories.MetaRepository;
import br.com.fiap.calmeter.repositories.RefeicaoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    MetaRepository repoMeta;

    @Autowired
    RefeicaoRepository repoRefeicao;

    @Autowired
    AlimentoRepository repoAlimento;
    
    @Override
    public void run(String... args) throws Exception {
        Refeicao ref1 = new Refeicao(1L, "Café da madrugada", LocalDate.now(), null);
        Refeicao ref2 = new Refeicao(2L, "Café da tarde", LocalDate.now(), null);
        Refeicao ref3 = new Refeicao(3L, "Café das 15:46", LocalDate.now(), null);

        List<Alimento> alimentos1 = List.of(
            new Alimento(1L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(2L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(3L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(4L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(5L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(6L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(7L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(8L, "Porção de batata frita", "500g de batata frita", 5000)
        );
        List<Alimento> alimentos2 = List.of(
            new Alimento(9L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(10L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(11L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(12L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(13L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(14L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(15L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(16L, "Porção de arroz", "300g de arroz branco", 1000)
        );
        List<Alimento> alimentos3 = List.of(
            new Alimento(17L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(18L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(19L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(20L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(21L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(22L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(23L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(24L, "Almoção brabo", "TUDO que tinha no self service", 99999)
        );

        repoMeta.saveAll(List.of(
            new Meta(1L, 3000, LocalDate.now(), LocalDate.now().plusDays(7)),
            new Meta(2L, 4000, LocalDate.now(), LocalDate.now().plusDays(7)),
            new Meta(3L, 5000, LocalDate.now(), LocalDate.now().plusDays(7)),
            new Meta(4L, 6000, LocalDate.now(), LocalDate.now().plusDays(7)),
            new Meta(5L, 7000, LocalDate.now(), LocalDate.now().plusDays(7)),
            new Meta(6L, 8000, LocalDate.now(), LocalDate.now().plusDays(7)),
            new Meta(7L, 9000, LocalDate.now(), LocalDate.now().plusDays(7)),
            new Meta(8L, 10000, LocalDate.now(), LocalDate.now().plusDays(7))
        ));

        repoAlimento.saveAll(List.of(
            new Alimento(1L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(2L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(3L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(4L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(5L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(6L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(7L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(8L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(9L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(10L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(11L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(12L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(13L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(14L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(15L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(16L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(17L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(18L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(19L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(20L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(21L, "Almoção brabo", "TUDO que tinha no self service", 99999),
            new Alimento(22L, "Porção de arroz", "300g de arroz branco", 1000),
            new Alimento(23L, "Porção de batata frita", "500g de batata frita", 5000),
            new Alimento(24L, "Almoção brabo", "TUDO que tinha no self service", 99999)
        ));

        ref1.setAlimentos(alimentos1);
        ref2.setAlimentos(alimentos2);
        ref3.setAlimentos(alimentos3);

        repoRefeicao.saveAll(List.of(
            ref1, ref2, ref3
        ));
    }
}
