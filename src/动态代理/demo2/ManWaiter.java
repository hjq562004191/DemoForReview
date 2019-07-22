package 动态代理.demo2;

public class ManWaiter implements waiter {
    @Override
    public void serve() {
        System.out.println("男服务员服务中");
    }
}
