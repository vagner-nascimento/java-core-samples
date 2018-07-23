package br.com.abc.javacore.ZZAGenerics.test;

import br.com.abc.javacore.Zcolecoes.classes.Consumidor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by William Suane on 9/12/2016.
 */
public class GenericsTest {
    public static void main(String[] args) {
        // type erasure = verificar o tipo em tempo de compilação
        List<String> lista = new ArrayList<>();
        lista.add("String");
        lista.add("String");
        lista.add("William Suane");

        for (String obj : lista) {
            System.out.println(obj);
        }
        //lista.add(1L); da erro
        add(lista, 1L);

        //Aqui vai dar exception
        for (String obj : lista) {
            System.out.println(obj);
        }
    }

    public static void add(List lista, Long l) {
        lista.add(l); //Aqui ele não sabe que a lista é de Strings
    }
}
