package org.msdemt.simple;

import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadTest {
    static
    class T extends Thread {
        @Override
        public void run() {
            System.out.println("继承Thread的任务");
        }
    }

    static
    class R implements Runnable {
        private Data data;

        public R() {
        }

        public R(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            System.out.println("实现Runnable的任务");
            if (data != null) {
                data.setName("abc");
            }
        }
    }

    static
    class C implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("实现Callable的任务");
            return "success";
        }
    }

    static
    class Data {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main1(String[] args) {
        /*new T().start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("Thread匿名内部类的任务");
            }
        }.start();

        new Thread(new R()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable匿名内部类的任务");
            }
        }).start();

        new Thread(() -> System.out.println("Runnable的lambda简化后的任务")).start();

        FutureTask futureTask = new FutureTask<>(new C());
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        //使用线程池执行实现Runnable接口的任务，任务没有返回值
        executorService.execute(new R());

        //使用线程池执行实现Runnable接口的任务，任务执行成功后，返回值为null
        Future<?> future = executorService.submit(new R());
        try {
            System.out.println("future 执行结果：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //使用线程池执行实现Callable接口的任务，可以接收到任务返回值
        Future future1 = executorService.submit(new C());
        try {
            System.out.println("future1 执行结果：" + future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Data data = new Data();
        Future<Data> future2 = executorService.submit(new R(data), data);
        try {
            System.out.println("future2 执行结果：" + future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();*/
    }

    public static void main2(String[] args) {
        Runnable r1 = () -> {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                System.out.println("r1 ---> " + count++);
            }
        };
        Runnable r2 = () -> {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                //Thread.yield();
                System.out.println("r2 ---> " + count++);
            }
        };

        Thread t1 = new Thread(r1);
        t1.setPriority(Thread.NORM_PRIORITY);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
    }

    public static void main3(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("thread running ...");
            }
        });
        //true 将该线程设置为守护线程，主线程结束后，守护线程也会终止运行
        //false 默认值，线程为非守护线程，主线程结束后，该线程还会继续运行
        thread.setDaemon(true);
        thread.start();
        System.out.println("主线程结束运行");
    }

    public static void main4(String[] args) {
        try {
            //休眠2秒，休眠过程可被中断，中断后抛出 InterruptedException
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            //使用TimeUnit的api可替代Thread.sleep
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main5(String[] args) {
        Integer r = 0;
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程运行结束");
        });

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程运行结束");
    }

    //对象的成员变量
    private static int count = 0;
    private static Object lock = new Object();

    public static void main6(String[] args) throws InterruptedException {
        //t1线程对count加1执行5000次
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    count++;
                }
            }
        });
        //t2线程对count减1执行5000次
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    count--;
                }
            }
        });

        t1.start();
        t2.start();

        //主线程等待t1和t2执行完
        t1.join();
        t2.join();
        //输出最后的结果
        System.out.printf("count = %d", count);
    }

    public static void main7(String[] args) {
        Lock lock = new ReentrantLock(); //可以使用自己实现的Lock接口实现类，也可以使用 jdk 提供的同步组件
        lock.lock(); //不要将锁的获取放在 try 语句块中，因为如果放在try中，若获取锁时发生异常，会执行finally中的释放锁操作，此时没有锁，就会抛出异常

        try {

        } finally {
            lock.unlock();
        }
    }

    static final Object lock1 = new Object();

    public static void main8(String[] args) {

        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("t1开始执行");
                try {
                    lock1.wait(); //同步代码块内部才可以调用
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1继续执行核心逻辑");
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("t2开始执行");
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2继续执行核心逻辑");
            }
        }, "t2").start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("开始唤醒");

        synchronized (lock1) {
            lock1.notifyAll(); //同步代码块内才能调用
        }
    }


    public static void main9(String[] args) {
        MessageQueue queue = new MessageQueue(2);

        //三个生产者想队列里存值
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                queue.put(new Message(id, "值：" + id));
            }, "生产者" + i).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //一个消费者不停从队列中取值
        new Thread(() -> {
            while (true) {
                queue.take();
            }
        }, "消费者").start();
    }

    //消息队列被生产者和消费者持有
    static class MessageQueue {

        private LinkedList<Message> list = new LinkedList<>();

        //容量
        private int capacity;

        public MessageQueue(int capacity) {
            this.capacity = capacity;
        }

        /**
         * 生产者生产
         *
         * @param message
         */
        public void put(Message message) {
            synchronized (list) {
                while (list.size() == capacity) {
                    System.out.println("队列已满，生产者等待");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.addLast(message);
                System.out.printf("生产者消息：{%s}\n", message);
                //生产后通知消费者
                list.notifyAll();
            }
        }

        /**
         * 消费者消费
         *
         * @return
         */
        public Message take() {
            synchronized (list) {
                while (list.isEmpty()) {
                    System.out.println("队列已空，消费者等待");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message message = list.removeFirst();
                System.out.printf("消费消息：{%s}\n", message);
                list.notifyAll(); //消费后通知生产者
                return message;
            }
        }
    }

    static class Message {
        private int id;
        private Object value;

        public Message(int id, Object value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "id=" + id +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main10(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("t1 park");
            LockSupport.park(); //t1线程1s后挂起
            System.out.println("t1 resume");
        }, "t1");
        t1.start();

        try {
            Thread.sleep(1000); //主线程睡眠2s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("unpark");
        LockSupport.unpark(t1);
    }

    public static void main11(String[] args) {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        //构造三个条件变量
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        //开启三个线程
        new Thread(() -> {
            awaitSignal.print("a", a, b);
        }).start();
        new Thread(() -> {
            awaitSignal.print("b", b, c);
        }).start();
        new Thread(() -> {
            awaitSignal.print("c", c, a);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        awaitSignal.lock();

        try {
            a.signal();
        } finally {
            awaitSignal.unlock();
        }

    }

    static class AwaitSignal extends ReentrantLock {
        //循环次数
        private int loopNumber;

        public AwaitSignal(int loopNumber) {
            this.loopNumber = loopNumber;
        }

        /**
         * @param print   输出的字符
         * @param current 当前条件变量
         * @param next    下一个条件变量
         */
        public void print(String print, Condition current, Condition next) {
            for (int i = 0; i < loopNumber; i++) {
                lock();
                try {
                    current.await();
                    System.out.println(print);

                    next.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    unlock();
                }
            }
        }
    }

    static class Beer {
    }

    static class Story {
    }

    static Beer beer = new Beer();
    static Story story = new Story();

    public static void main12(String[] args) {
        new Thread(() -> {
            synchronized (beer) {
                System.out.println("我有酒，给我故事");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (story) {
                    System.out.println("小王开始喝酒讲故事");
                }
            }
        }, "小王").start();

        new Thread(() -> {
            synchronized (story) {
                System.out.println("我有故事，给我酒");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (beer) {
                    System.out.println("老王开始喝酒讲故事");
                }
            }
        }, "老王").start();
    }

    public Lock lock2 = new ReentrantLock();
    public Condition condition = lock2.newCondition();

    public static void main13(String[] args) {
        MultiThreadTest multiThreadTest = new MultiThreadTest();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            multiThreadTest.conditionWait();
        });
        executorService.execute(() -> {
            multiThreadTest.conditionSignal();
        });
    }

    private void conditionWait() {
        lock2.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到了锁");
            System.out.println(Thread.currentThread().getName() + "等待信号");
            condition.await();
            System.out.println(Thread.currentThread().getName() + "拿到了信号");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }
    }

    private void conditionSignal() {
        lock2.lock();
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "拿到了锁");
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "发出了信号");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }
    }

    static boolean run = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (run){
                System.out.println("t1 is running");
            }
        });
        t1.start();

        Thread.sleep(1000);

        run = false;

        if(run == true){

        }

        /*Thread t2 = new Thread(() -> {
            while (run){
                System.out.println("t2 is running");
            }
        });
        t2.start();*/
    }


}
