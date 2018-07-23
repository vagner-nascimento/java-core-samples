package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by William Suane on 11/8/2016.
 */
class ThreadTrabalhadoraExecutor implements Runnable{
    private String num;

    public ThreadTrabalhadoraExecutor(String num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" iniciou: "+num);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finalizou");

    }
}
public class ExecutorTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors()); // Geralmente os processadores suportam até 2 threads ao mesmo tempo, É BOM criar baseado nesta informação
        ExecutorService executorService = Executors.newFixedThreadPool(4); // Seta o limite de threads e só trabalha com esse número de threads simultaneamente
//        ExecutorService executorService = Executors.newCachedThreadPool(); // Não tem limite, cria thread enquanto for pedido, remove as threads inativas a 60 seg ou +
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); // Usa apenas uma thread por vez... as demais tarefas ficam em uma queue FIFO até serem chamadas uma a uma
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        threadPoolExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors() * 2); // Altera a quantidade de threads com o pool em execução. Não funciona com o SingleThreadExecutor
        for (int i = 1; i <= 16; i++) {
            executorService.execute(new ThreadTrabalhadoraExecutor(String.valueOf(i)));
        }
        executorService.shutdown(); // Só executa depois efetivamente quando todas as threads terminarem sua execução
        while(!executorService.isTerminated()){}
        System.out.println(executorService.isTerminated());
        System.out.println("Finalizado");
    }
}
