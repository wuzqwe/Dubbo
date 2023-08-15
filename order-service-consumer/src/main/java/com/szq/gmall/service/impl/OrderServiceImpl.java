package com.szq.gmall.service.impl;

import com.szq.gmall.bean.UserAddress;
import com.szq.gmall.service.OrderService;
import com.szq.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private UserService userService;

    public void initOrder(String userId) {
        System.out.println("用户id:"+userId);
        //1.查询用户的收获地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress:addressList){
            System.out.println(userAddress.getUserAddress());
        }
    }
}
