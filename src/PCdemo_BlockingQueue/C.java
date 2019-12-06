package PCdemo_BlockingQueue;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class C implements Runnable{

    private static volatile boolean isrunning = true;

    private static BlockingQueue<data> queue;

    public C(BlockingQueue<data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (isrunning){
            if (!queue.isEmpty()){
                try {
                    Thread.sleep(r.nextInt(1000));
                    data d = queue.take();
                    int re = d.getNum()*d.getNum();
                    System.out.println(MessageFormat.format("{0}*{1}={2}",
                            d.getNum(),d.getNum(),re));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void stop(){
        isrunning = false;
    }
}
