package thinging.in.java;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(exe.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs : results) {
            try {
                // get() blocks until completion
                // get()方法将会阻塞，直到结果准备就绪
                if (fs.isDone()) {
                    System.out.print("Future对象是否已经完成：" + fs.isDone() + "\n");
                    System.out.println(fs.get());
                }else{
                    System.out.print("Future对象是否已经完成：" + fs.isDone() + "\n");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "result of TaskWithResult:" + id;
    }

}