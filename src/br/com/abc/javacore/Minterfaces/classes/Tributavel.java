package br.com.abc.javacore.Minterfaces.classes;

/**
 * Created by William Suane on 5/26/2016.
 */
public interface Tributavel { //Por convenção tente utilizar adjetivo, terminando "el", caso contrário utilize o "I" na frente
    //TODOS OS ATRIBUTOS E MÉTODOS SÃO STÁTICOS E FINAL, são constantes
    public static final double IMPOSTO = 0.2;
    public abstract void calculaImposto();
}
