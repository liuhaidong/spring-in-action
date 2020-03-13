package com.arkdex.springinaction.collectionmap;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxyMain {

    public CGlibProxyMain() {
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Ticker.class);
        enhancer.setInterfaces(new Class<?>[]{ITicker.class});
        enhancer.setCallback(new MethodInterceptor()  {
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                    throws Throwable {
                return  proxy.invokeSuper(obj, args);
            }
        });
        ITicker proxy = (ITicker) enhancer.create();
       System.out.println(proxy.getPrice());
    }
}
