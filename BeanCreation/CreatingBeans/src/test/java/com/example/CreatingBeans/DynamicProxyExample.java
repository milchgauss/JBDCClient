package com.example.CreatingBeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class DynamicProxyExample implements InvocationHandler {

    //Logs the activity of our dynamic proxy example
    private static Logger LOGGed= LoggerFactory.getLogger(DynamicProxyExample.class);

    // The standard method of Invocation Handler below:
    // As a test, all this proxy does is retrieve the name
    //of the method called in the proxy instance.

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOGGed.info("You called this: Test:",method.getName());
        return "A random string!";
    }

    // Typically, a new proxy instance would be defined in a different class.

    Map proxyInstance= (Map) Proxy.newProxyInstance(
            DynamicProxyExample.class.getClassLoader(),
            new Class[]{Map.class},
            new DynamicProxyExample()
    );
}
