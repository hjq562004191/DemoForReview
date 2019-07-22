package 静态代理;

import org.junit.Test;

public class demo {
    @Test
    public void fun(){
        Proxy real = new realrole();

        Proxyrole proxy = new Proxyrole(real);

        proxy.todo();
    }
}
