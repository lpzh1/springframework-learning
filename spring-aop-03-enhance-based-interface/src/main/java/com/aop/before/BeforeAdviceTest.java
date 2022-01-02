package com.aop.before;

import com.aop.service.NaiveWaiter;
import com.aop.service.Waiter;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import static org.testng.Assert.*;

public class BeforeAdviceTest {

    public static void main(String[] args) {
//        before();
        beforeInSpring();
    }

    //    @Test
    public static void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        // ① spring 提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
//        pf.setInterfaces(target.getClass().getInterfaces());
//        pf.setOptimize(true);
        // ② 设置代理目标
        pf.setTarget(target);
        // ③ 为代理目标添加增强
        pf.addAdvice(advice);
        // ④ 生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }


    public static void beforeInSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("before.xml");
        Waiter waiter = (Waiter) context.getBean("waiter");
        waiter.greetTo("John Before");
    }
}

// 运行结果如下：
//How are you！Mr.John. // ① 通过前值增强引入的礼貌用语
//greet to John...
//How are you！Mr.Tom.   // ② 通过前值增强引入的礼貌用语
//serving Tom...