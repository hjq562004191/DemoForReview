package PCdemo_BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<data> queue = new LinkedBlockingDeque<>(10);
        P p = new P(queue);
        P p1 = new P(queue);
        P p2 = new P(queue);
        C c = new C(queue);
        C c1 = new C(queue);
        C c2 = new C(queue);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(p);
        service.execute(p1);
        service.execute(p2);
        service.execute(c);
        service.execute(c1);
        service.execute(c2);
        service.shutdown();
    }
}
