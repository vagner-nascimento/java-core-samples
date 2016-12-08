package br.com.abc.javacore.ZZJoptional.test;

import br.com.abc.javacore.ZZJoptional.classes.Carro;
import br.com.abc.javacore.ZZJoptional.classes.Pessoa;
import br.com.abc.javacore.ZZJoptional.classes.Seguradora;

import java.util.Optional;

/**
 * Created by William Suane on 12/7/2016.
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora("DevDojo Seguros");
        Carro carro = new Carro(seguradora, "Audi");
        Pessoa p = new Pessoa(carro, "Carlos");
        obterNomeSeguradora(Optional.ofNullable(p));
    }

    public static String obterNomeSeguradora(Optional<Pessoa> p) {
        return p.flatMap(Pessoa::getCarro)
                .flatMap(Carro::getSeguradora)
                .map(Seguradora::getNome)
                .orElse("Não existe seguradora");

    }


}
