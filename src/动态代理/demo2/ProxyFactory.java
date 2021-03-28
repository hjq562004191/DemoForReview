package 动态代理.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object targetObject;//目标对象
    private BeforeAdvice beforeAdvice;
    private AfterAdvice afterAdvice;

    public Object creatProxy() {
        ClassLoader loader = this.getClass().getClassLoader();
        Class[] interfaces = targetObject.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*
                 * 在调用代理对象的方法时会执行这里的内容
                 * */
                //执行前置增强
                if (beforeAdvice != null) {
                    beforeAdvice.before();
                }
                Object result = method.invoke(targetObject, args);//执行目标对象的目标方法
                //执行后置增强
                if (afterAdvice != null) {
                    afterAdvice.after();
                }
                return result;
            }
        };
        Object proxyObject = Proxy.newProxyInstance(loader, interfaces, handler);
        return proxyObject;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }
}
