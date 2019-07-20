package com.gwg.springcloud.provider;

import com.gwg.springcloud.zuul.common.Result;
import com.gwg.springcloud.model.User;
import com.gwg.springcloud.remote.IHelloRemote;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在实际项目中，都是使用声明式调用服务。而不会在客服端和服务端存储2份相同的model和api定义。
 * Restful接口的第二种写法,在使用Eureka时候推荐。因为这样可以将Eureka服务提供方(IHelloRemote)单独抽象到一个模块中,
 * 这样做，Eureka服务提供方方便实现并且可以提供resful服务和Eureka使用方仅需要依赖就可以使用了，
 * 否则服务提供方与服务访问方都需要改动。
 */
@RestController
public class HelloController implements IHelloRemote {


    public Result printUserInfo(@PathVariable("name") String name, @PathVariable("age") int age) {
        String message = "姓名: " + name+", 年龄:"+ age;
        try{
            //测试网关ribbon ReadTimeout
            Thread.sleep(7000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("printUserInfo : "+message);
        return Result.success();
    }

    public Result addUser(@RequestBody User user) {
        String message = "姓名: " + user.getName()+", 年龄:"+ user.getAge();
        System.out.println("addUser : "+message);
        return Result.success();
    }

    public Result info() {
        return Result.success();
    }
}
