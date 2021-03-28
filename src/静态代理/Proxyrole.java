package 静态代理;

public class Proxyrole implements Proxy {
    private Proxy real;

    public Proxyrole(Proxy realrole) {
        real = realrole;
    }

    @Override
    public void todo() {
        dobefore();
        real.todo();
        doafter();
    }

    private void doafter() {
        System.out.println("善后处理");
    }

    private void dobefore() {
        System.out.println("一个好的开端.");
    }
}
