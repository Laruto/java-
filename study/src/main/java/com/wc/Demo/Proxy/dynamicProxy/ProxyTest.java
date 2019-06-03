package com.wc.Demo.Proxy.dynamicProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

//    Class calculatorClass = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);
//    // 得到有参构造器
//    Constructor constructor = calculatorClass.getConstructor(InvocationHandler.class);
//    // 反射创建代理实例
//    Calculator calculatorProxyImpl = (Calculator) constructor.newInstance(new InvocationHandler() {
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            return null;
//        }
//    });

    public static void main(String[] args) throws Throwable {
        CalculatorImpl target = new CalculatorImpl();
        // 传入目标对象
        // 目的： 1. 根据它实现的接口生成代理对象 2. 代理对象调用目标方法对象
        Calculator calculatorProxy = (Calculator) getProxy(target);
        calculatorProxy.add(1, 2);

    }

    private static Object getProxy(final Object target) throws Exception {
        // 参数1： 随便找个类的加载器给它， 参数2：目标对象实现的接口，让代理对象实现相同的接口
        Class proClazz = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        Constructor constructor = proClazz.getConstructor(InvocationHandler.class);
        Object proxy = constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "方法开始执行...");
                Object result = method.invoke(target, args);
                System.out.println(result);
                System.out.println(method.getName() + "方法执行结束");
                return result;
            }
        });
        return proxy;
    }
}
