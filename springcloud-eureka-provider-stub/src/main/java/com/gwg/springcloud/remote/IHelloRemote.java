package com.gwg.springcloud.remote;

import com.gwg.springcloud.zuul.common.Result;
import com.gwg.springcloud.model.User;
import com.gwg.springcloud.remote.fallback.IHelloFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//声明式服务
@FeignClient(name="product",  fallbackFactory = IHelloFallback.class) //服务的名称，这个必须与应用名称spring.application.name一致
public interface IHelloRemote {

    @RequestMapping(value = "/user/{name}/{age}", method = RequestMethod.GET)
    Result printUserInfo(@PathVariable("name") String name, @PathVariable("age") int age);

    @RequestMapping(value="/add", method = RequestMethod.POST)
    Result addUser(@RequestBody User user);

    /*打印出微服务信息*/
    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public  Result  info();

}
