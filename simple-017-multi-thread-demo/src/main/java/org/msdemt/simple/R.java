package org.msdemt.simple;

import static java.lang.Thread.sleep;

/**
 * 多线程实现方式2
 * 实现 Runnable 接口，重写 run 方法，将 Runnable 接口的实现类作为构造参数传入 Thread 类的构造器中，然后执行 Thread 类的 run 方法启动线程
 */
public class R implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "...start");
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "...end");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "...start");
        for (int i = 0; i < 10; i++) {
            R r = new R();
            Thread thread = new Thread(r);
            thread.start();
        }
        System.out.println(Thread.currentThread().getName() + "...end");
    }
}

/*
main...start
Thread-0...start
Thread-2...start
main...end
Thread-1...start
Thread-3...start
Thread-4...start
Thread-5...start
Thread-6...start
Thread-7...start
Thread-8...start
Thread-9...start
Thread-8...end
Thread-7...end
Thread-9...end
Thread-6...end
Thread-5...end
Thread-4...end
Thread-3...end
Thread-2...end
Thread-1...end
Thread-0...end
 */


