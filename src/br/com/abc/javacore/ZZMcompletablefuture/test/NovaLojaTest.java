package br.com.abc.javacore.ZZMcompletablefuture.test;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Desconto;
import br.com.abc.javacore.ZZMcompletablefuture.classes.Loja;
import br.com.abc.javacore.ZZMcompletablefuture.classes.NovaLoja;
import br.com.abc.javacore.ZZMcompletablefuture.classes.Orcamento;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by William Suane on 2/8/2017.
 */
public class NovaLojaTest {
    public static void main(String[] args) {
        List<NovaLoja> lojas = NovaLoja.lojas();
//        lojas.stream().forEach(novaLoja -> System.out.println(novaLoja.getPreco()));
        acharPrecos(lojas);
    }

    private static List<String> acharPrecos(List<NovaLoja> lojas) {
        System.out.println("Stream sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.stream()
                .map(NovaLoja::getPreco)
                .map(Orcamento::parse)
                .map(Desconto::calcularDesconto)
                .collect(Collectors.toList());
        System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

}
