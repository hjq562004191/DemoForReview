package 动态代理.demo;

public class ManWaiter implements waiter {
    @Override
    public void serve() {
        System.out.println("男服务员服务中");
    }
}
