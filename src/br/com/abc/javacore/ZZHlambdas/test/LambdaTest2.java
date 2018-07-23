package br.com.abc.javacore.ZZHlambdas.test;

import br.com.abc.javacore.ZZHlambdas.classes.Carro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

import static java.util.Arrays.asList;

/**
 * Created by William Suane on 11/22/2016.
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        // Consumer
        forEach(asList("William", "DevDojo", "facebook.com/devdojobr"), (String s) -> System.out.println(s));
        // Function
        List<Integer> list = map(asList("William", "DevDojo", "facebook.com/devdojobr"), (String s) -> s.length());
        System.out.println(list);

        // USANDO PARA PEGAR UMA LISTA DE ATRIBUTOS DE UMA LISTA DE OBJETOS
        List<Carro> carros = asList(new Carro("Preto", 2011), new Carro("Preto", 2011), new Carro("Preto", 2011));
        List<String> listCores = map(carros, (Carro c) -> c.getCor());
        System.out.println(listCores);

        // PREDICATE PARA TRABALHAR COM TIPOS PRIMITIVOS
        // NÃO É O IDEAL PQ CONSOME UM POUCO MAIS DE MEMÓRIA COM AUTO BOXING E UNBOXING DE WRAPPERS
        Predicate<Integer> pares = (Integer i) -> i % 2 == 0;
        IntPredicate impar = (int i) -> i % 2 == 1; // MELHOR USAR AS INTERFACES PRÓPRIAS PARA ELES
        System.out.println(pares.test(1000));
        System.out.println(impar.test(1000));

        String cor = "VERMELHO"; // EFETIVAMENTE ESTATICO
        Predicate<String> p = (String s) -> listCores.add(s);
        Consumer<String> b = s -> listCores.add(cor);
        b.accept("AMARELO"); // ADICIONA A COR
        System.out.println(b);

        Supplier<String> sup1 = () -> "oi";
        Supplier<Carro> sup2 = () -> new Carro("Preto", 2011);
        System.out.println(sup1);
        System.out.println(sup2.get().getCor());
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T e : list) {
            c.accept(e);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T e : list) {
            result.add(f.apply(e));
        }
        return result;
    }
}
