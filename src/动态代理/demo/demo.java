package 动态代理.demo;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class demo {
    @Test
    public void fun() {
        waiter ManWaiter = new ManWaiter();

        ClassLoader loader = this.getClass().getClassLoader();
        Class[] interfaces = {waiter.class};
        InvocationHandler handler = new WaiterInvocationHandler(ManWaiter);

        waiter waiterProxy = (waiter) Proxy.newProxyInstance(loader, interfaces, handler);
        waiterProxy.serve();
    }
}

class WaiterInvocationHandler implements InvocationHandler {
    private waiter waiter;

    public WaiterInvocationHandler(waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("欢迎光临");
        this.waiter.serve();
        System.out.println("谢谢惠顾");
        return null;
    }
}

