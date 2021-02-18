package org.msdemt.simple;

/**
 * 多线程实现方式1
 * 继承 Thread 类，重写 run 方法，调用 start 方法启动线程
 *
 * 注意：子线程可以在主线程结束后继续运行
 */
public class T extends Thread{

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
            T t = new T();
            t.start();
        }
        System.out.println(Thread.currentThread().getName() + "...end");
    }
}

/*
main...start
main...end
Thread-0...start
Thread-1...start
Thread-2...start
Thread-3...start
Thread-4...start
Thread-5...start
Thread-6...start
Thread-7...start
Thread-8...start
Thread-9...start
Thread-0...end
Thread-3...end
Thread-1...end
Thread-7...end
Thread-8...end
Thread-9...end
Thread-6...end
Thread-5...end
Thread-4...end
Thread-2...end
*/
