package 静态代理;

public class realrole implements Proxy {
    @Override
    public void todo() {
        System.out.println("真实角色...");
    }
}
