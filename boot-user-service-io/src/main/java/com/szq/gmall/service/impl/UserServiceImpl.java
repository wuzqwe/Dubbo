package com.szq.gmall.service.impl;


import com.szq.gmall.bean.UserAddress;
import com.szq.gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@com.alibaba.dubbo.config.annotation.Service(/*timeout = 1000*/) //暴露服务
@Service
public class UserServiceImpl implements UserService {

//	@HystrixCommand
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("userServiceImol...0");
		// TODO Auto-generated method stub
		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
		/*try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		/*if (Math.random()>0.5){
			throw new RuntimeException();
		}*/
		return Arrays.asList(address1,address2);
	}

}
