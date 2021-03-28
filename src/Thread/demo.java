package Thread;

import java.util.Random;

/**
 * @Author JQiang
 * @create 2021/3/28 10:32
 */
public class demo {
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000-finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("这是一个线程"+" " + finalI);
                }
            }).run();
        }
    }
}
