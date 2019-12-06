package PCdemo_Semaphore;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PandC {
    private static Semaphore empty = new Semaphore(10);
    private static Semaphore full = new Semaphore(0);
    private static Queue<Data> queue = new LinkedList<>();
    private static volatile boolean isrunning = true;
    private static volatile Integer integer = new Integer(0);

    class P extends Thread {
        @Override
        public void run() {
            Random random = new Random();
            while (isrunning) {
                try {
                    empty.acquire();
                    Thread.sleep(random.nextInt(1000));
                    Data data = new Data(integer++);
                    System.out.println("add " + data.getNum());
                    queue.add(data);
                    full.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class C extends Thread{
        @Override
        public void run() {
            Random random = new Random();
            while (isrunning) {
                try {
                    full.acquire();
                    Thread.sleep(random.nextInt(1000));
                    Data data = queue.poll();
                    System.out.println("get "+data.getNum() + "  此时队列还有" + queue.size());
                    empty.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PandC pc = new PandC();
        P p = pc.new P();
        C c = pc.new C();
        P c1 = pc.new P();
        p.start();
        c.start();
        c1.start();
    }
}
