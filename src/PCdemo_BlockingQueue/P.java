package PCdemo_BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class P implements Runnable{
    private static volatile boolean isrunning = true;
    private static BlockingQueue<data> queue = null;
    private static AtomicInteger integer = new AtomicInteger(0);
    public P(BlockingQueue<data> queue1) {
        queue = queue1;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (isrunning) {
            data d = new data(integer.incrementAndGet());
            try {
                Thread.sleep(r.nextInt(1000));
                if (queue.offer(d, 2, TimeUnit.SECONDS)) {
                    System.out.println(d.getNum() + " 放入数据");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void stop(){
        isrunning = false;
    }

}
