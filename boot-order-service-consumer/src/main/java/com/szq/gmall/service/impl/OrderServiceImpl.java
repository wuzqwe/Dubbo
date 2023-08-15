package com.szq.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.szq.gmall.bean.UserAddress;
import com.szq.gmall.service.OrderService;
import com.szq.gmall.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 1.将服务提供者注册到注册中心
 *   01.导入dubbo依赖 引入操作zookeeper的客户端
 *   02.配置服务提供者
 * 2.让服务消费者去注册中心订阅服务提供者
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

// @Resource
        //当zookeeper宕机，我们可以采用Dubbo直连
    //负载均衡 采用roundrobin轮询方式调用 random权重随机
    @Reference(/*url = "127.0.0.1:20882"*/loadbalance = "roundrobin")//远程调用服务
    private UserService userService;

    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id:"+userId);
        //1.查询用户的收获地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress:addressList){
            System.out.println(userAddress.getUserAddress());
        }

        return addressList;
    }
}
