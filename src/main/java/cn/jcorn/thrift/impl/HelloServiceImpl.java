package cn.jcorn.thrift.impl;

import cn.jcorn.thrift.api.HelloWorldService;

public class HelloServiceImpl implements HelloWorldService.Iface {
    @Override
    public String sayHello(String name){
        return "Hello " + name;
    }
}
