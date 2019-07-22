package 动态代理;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
        @Test
        public void test(){
            Person woman = new Woman();

            Person person =(Person) Proxy.newProxyInstance(woman.getClass().getClassLoader(),
                    woman.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            //增强sleep方法
                            if ("sleep".equals(method.getName())) {
                                System.out.println("大字睡姿.....");
                                return null;
                            }
                            return method.invoke(woman, args);
                        }
                    });
            person.eat();
            person.sleep();
            String s = person.run("快步跑");
            System.out.println(s);
        }

        interface Person{
            void eat();
            void sleep();
            String run(String state);
        }

        class Woman implements Person{

            @Override
            public void eat() {
                System.out.println("小口吃...");
            }

            @Override
            public void sleep() {
                System.out.println("淑女睡...");
            }

            @Override
            public String run(String state) {
                return "Woman" + state + "......";
            }
        }
}
