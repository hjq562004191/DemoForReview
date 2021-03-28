package 生产者消费者模型;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;                        //内存缓冲区
    private static AtomicInteger count = new AtomicInteger();   //总数，原子操作
    private static final int SLEEP_TIME = 1000;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();

        System.out.println("开始生产 id:" + Thread.currentThread().getId());

        try {
            while (isRunning) {

                Thread.sleep(r.nextInt(SLEEP_TIME));
                data = new PCData(count.incrementAndGet());
                System.out.println(data + "已经放进缓存区");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println(data + "放入缓存失败");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }
}
