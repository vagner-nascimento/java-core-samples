package br.com.abc.javacore.ZZDthreads.test;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by William Suane on 10/19/2016.
 */
//Class thread safe significa que os métodos da classe são sincronizados, e não que o acesso externo aos métodos será.
class ListaNomes {
/*
    // Desta forma pode dar erro porque embora a lista seja sync os métodos da classe que va rodar assync não são
    // assim ele pode tentar excluir um item que não existe entre o verificar o size e remover o objeto, lançando uma IndexOutOfBoundException
    private List<String> nomes = Collections.synchronizedList(new LinkedList<>());

    public void add(String nome) {
        nomes.add(nome);
    }

    public void removerPrimeiro() {
        if (nomes.size() > 0) {
            System.out.println(nomes.remove(0));
        }
    }
*/

    // Assim garante a sincronia tranalhando com a lista, seja ela sync ou não. Os métodos da classe que roda assync estão sync.
    private List<String> nomes = new LinkedList<>();

    public synchronized void add(String nome) {
        nomes.add(nome);
    }

    public synchronized void removerPrimeiro() {
        if (nomes.size() > 0) {
            System.out.println(nomes.remove(0));
        }
    }
}

public class ThreadSafeTest {
    public static void main(String[] args) {
        final ListaNomes nome = new ListaNomes();
        nome.add("William Suane");
        class RemovedorDeNomes implements Runnable {
            public void run() {
                nome.removerPrimeiro();
            }
        }
        new Thread(new RemovedorDeNomes()).start();
        new Thread(new RemovedorDeNomes()).start();
    }
}
