package br.com.abc.javacore.ZZAGenerics.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by William Suane on 9/13/2016.
 */

abstract class Animal {
    public abstract void consulta();
}

class Cachorro extends Animal implements Comparable {

    @Override
    public void consulta() {
        System.out.println("Consultando cachorro");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Gato extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando gato");
    }
}

public class WildCardTest {
    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};
//        consultarAnimais(cachorros);
//        consultarAnimais(gatos);
        List<Cachorro> cachorroList = new ArrayList<>();
        cachorroList.add(new Cachorro());
        List<Gato> gatoList = new ArrayList<>();
        gatoList.add(new Gato());

        consultarAnimaisList(cachorroList);
        consultarAnimaisList(gatoList);
        ordernarLista(cachorroList);
    }

    public static void consultarAnimais(Animal[] animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }
//        animals[1] = new Gato();
    }
    //type erasure | ?
    //List<? extends Animal> : Com EXTENDS vc diz para o java que não vai adicionar nenhum objeto na lista
    public static void consultarAnimaisList(List<? extends Animal> animals){
        for (Animal animal : animals) {
            animal.consulta();
        }
    }
    //Com SUPER vc diz que a lista pode adicionar a classe especificada
    public static void consultarCachorrosList(List<? super Cachorro> cachorroList){
        Cachorro c1 = new Cachorro();
        Animal c2 = new Cachorro();
        Object o = new Cachorro();

        //NÃO FUNCIONAM
        //cachorroList.add(c2);
        //cachorroList.add(o);

        cachorroList.add(c1);
        cachorroList.add(new Cachorro());
    }

    public static void ordernarLista(List<? extends Comparable> lista){
        Collections.sort(lista);
    }

}
