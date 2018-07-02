package br.com.abc.javacore.Yserializacao.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by William Suane on 8/19/2016.
 */
public class Aluno extends Pessoa implements Serializable {
    private Long id;
    private String nome;
    private transient String password;
    private static String nomeEscola = "DevDojo :)";
    private transient Turma turma;

    public Aluno(Long id, String nome, String password) {
        System.out.println("Dentro do construtor");
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", nomeEscola='" + nomeEscola + '\'' +
                ", turma='" + turma + '\'' +
                '}';
    }

    // Metodo sobrescrito implicitamente, não tem isso na interface.
    private void writeObject(ObjectOutputStream oos){
        try{
            oos.defaultWriteObject(); // RESPEITAR A ORDEM PARA LEITURA E ESCRITA, DEVEM SER IGUAIS
            oos.writeUTF(turma.getNome());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // Metodo sobrescrito implicitamente, não tem isso na interface nem documentação.
    // Usado aqui para incluir a a classe turma  na serialização sem colocar Serealizable na classe
    private void readObject(ObjectInputStream ois){
        try{
            ois.defaultReadObject(); // RESPEITAR A ORDEM PARA LEITURA E ESCRITA, DEVEM SER IGUAIS
            turma = new Turma(ois.readUTF());
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getNomeEscola() {
        return nomeEscola;
    }

    public static void setNomeEscola(String nomeEscola) {
        Aluno.nomeEscola = nomeEscola;
    }
}
