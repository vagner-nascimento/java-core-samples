package br.com.abc.javacore.Kenum.classes;

/**
 * Created by William Suane on 5/12/2016.
 */
public enum TipoCliente {
    // constant specific class body
    // corpo de classe especifico constante
    PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica") { //RETORNA ESSE ID APENAS PARA ESSA CONTANTE
        public String getId() {
            return "B";
        }
    }, PESSOA_FEIA(3, "Pessoa Feia") {
        public String getId() {
            return "C";
        }
    };

    private int tipo;
    private String nome;

    TipoCliente(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    //RETORNA O MESMO ID PARA TODAS OS AS CONSTANTES, A MENOS QUE ELA TENHA UMA ESPECÍFICA
    public String getId() {
        return "A";
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }
}
