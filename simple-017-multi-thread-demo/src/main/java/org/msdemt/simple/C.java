package org.msdemt.simple;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

/**
 * 多线程实现方式3
 * 实现 Callable 接口并重写 call 方法，使用 Callable 接口实现类作为参数构造 FutureTask 实例，
 * 因为 FutureTask 实现了 Runnable 方法，所以 FutureTask 实例作为 Thread 的参数构造 Thread 实例，然后调用 Thread 的 run 方法启动线程
 *
 * 注意： futureTask.get() 会阻塞线程，导致该测试单线程运行
 */
public class C implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "...start");

        sleep(10000);

        System.out.println(Thread.currentThread().getName() + "...end");
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + "...start");
        for (int i = 0; i < 10; i++) {
            C c = new C();
            FutureTask futureTask = new FutureTask(c);
            Thread thread = new Thread(futureTask);
            thread.start();
            //Object o = futureTask.get();
            //System.out.println("return value: " + o);
        }
        System.out.println(Thread.currentThread().getName() + "...end");
    }
}

//注释掉 futureTask.get() 后的运行结果
/*
main...start
Thread-0...start
Thread-1...start
Thread-2...start
Thread-3...start
main...end
Thread-4...start
Thread-5...start
Thread-9...start
Thread-7...start
Thread-8...start
Thread-6...start
Thread-8...end
Thread-3...end
Thread-1...end
Thread-2...end
Thread-0...end
Thread-9...end
Thread-5...end
Thread-6...end
Thread-4...end
Thread-7...end
 */

//打开 futureTask.get() 后的运行结果
/*
main...start
Thread-0...start
Thread-0...end
return value: Thread-0
Thread-1...start
Thread-1...end
return value: Thread-1
Thread-2...start
Thread-2...end
return value: Thread-2
Thread-3...start
Thread-3...end
return value: Thread-3
Thread-4...start
Thread-4...end
return value: Thread-4
Thread-5...start
Thread-5...end
return value: Thread-5
Thread-6...start
Thread-6...end
return value: Thread-6
Thread-7...start
Thread-7...end
return value: Thread-7
Thread-8...start
Thread-8...end
return value: Thread-8
Thread-9...start
Thread-9...end
return value: Thread-9
main...end
 */



