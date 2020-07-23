package com.tlh.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback ="paymentGlobalFallBackMethod")
public class HystrixPaymentService {

    /**
     * 正常方法
     *
     * @param id
     * @return
     */
    @HystrixCommand
    public String paymentOK(Integer id) {
        return "线程名：" + Thread.currentThread().getName() + ";paymentOk" + ",id:" + id;
    }

    /**
     * 演示耗时方法
     *
     * @param id
     * @return
     */
    //参考：https://github.com/Netflix/Hystrix/tree/master/hystrix-contrib/hystrix-javanica#configuration
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallBackHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })
    public String paymentTimeOut(Integer id) {
        Integer time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程名：" + Thread.currentThread().getName() + ";paymentTimeOut" + ",id:" + id;
    }

    public String paymentTimeOutFallBackHandler(Integer id) {
        return "线程名：" + Thread.currentThread().getName() + ";paymentTimeOutFallBackHandler" + ",id:" + id;
    }

    public String paymentGlobalFallBackMethod() {
        return "线程名：" + Thread.currentThread().getName() + ";paymentGlobalFallBackMethod";
    }

}
