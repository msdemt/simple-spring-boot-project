package org.msdemt.simple;

import java.util.concurrent.Callable;

public class Test {

    static final class RunnableAdapter<T> implements Callable<T> {
        final Runnable task;
        final T result;
        RunnableAdapter(Runnable task, T result) {
            this.task = task;
            this.result = result;
        }
        public T call() {
            task.run();
            System.out.println(result);
            return result;
        }
    }

    public static void main(String[] args) {
        Data data = new Data();
        System.out.println(data);
        RunnableAdapter<Data> dataRunnableAdapter = new RunnableAdapter<>(new Task1(data), data);
        System.out.println(dataRunnableAdapter.call().getName());
    }

}

class Task1 implements Runnable {
    Data data;

    public Task1(Data data) {
        this.data = data;
        System.out.println(data);
    }

    public void run() {
        System.out.println("This is ThreadPoolExetor#submit(Runnable task, T result) method.");
        data.setName("kevin");
        System.out.println(data);
    }
}



