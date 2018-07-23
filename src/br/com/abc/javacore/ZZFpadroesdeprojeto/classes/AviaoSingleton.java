package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by William Suane on 11/11/2016.
 */
public class AviaoSingleton {
    // EAGER INITIALIZATION (Iniciar objetos staticos direto na declaração do mesmo): Por mais que não se use este objeto, mesmo assim ele sempre será instanciado
//    private static final AviaoSingleton INSTANCE = new AviaoSingleton();
    private static AviaoSingleton INSTANCE;
    private Set<String> assentosDisponiveis;
    // Lazy INITIALIZATION
    // Também dá para sincronizar diretamente o método, porém perde desempenho por causa do Lock, sendo que se não estiver null não precisa sincronizar, pode só retornar
    public static AviaoSingleton getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (AviaoSingleton.class) { //Sicroniza somente a classe para criar somente uma, dexando-a thread safe
                if (INSTANCE == null) {
                    INSTANCE = new AviaoSingleton();
                }
            }
        }
        return INSTANCE;
    }

    private AviaoSingleton() {
        this.assentosDisponiveis = new HashSet<>();
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }

    public boolean bookAssento(String assento) {
        return assentosDisponiveis.remove(assento);
    }

}
