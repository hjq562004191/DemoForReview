package 动态代理.demo2;

import org.junit.Test;

public class demo2 {
    @Test
    public void fun2() {
        ProxyFactory factory = new ProxyFactory();
        factory.setTargetObject(new ManWaiter());
        factory.setBeforeAdvice(new BeforeAdvice() {
            @Override
            public void before() {
                System.out.println("欢迎光临");
            }
        });
        factory.setAfterAdvice(new AfterAdvice() {
            @Override
            public void after() {
                System.out.println("谢谢惠顾");
            }
        });

        waiter waiter = (waiter) factory.creatProxy();
        waiter.serve();
    }
}
