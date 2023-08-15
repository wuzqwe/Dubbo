package com.szq.gmall.config;

import com.alibaba.dubbo.config.*;
import com.szq.gmall.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig {

    //<dubbo:application name="user-service-provider"></dubbo:application>
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("szq-user-service-provider");
        return applicationConfig;
    }

    // <dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    //<dubbo:protocol name="dubbo" port="20880"></dubbo:protocol>
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20881);
        return  protocolConfig;
    }

    // <dubbo:service interface="com.szq.gmall.service.UserService" ref="userServiceImpl"></dubbo:service>
    @Bean
    public ServiceConfig serviceConfig(UserService userService){
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        //配置每一个method的信息
       /* MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);*/

        //将method的设置关联到service配置中
      /*  List<MethodConfig> methods=new ArrayList<>();
        methods.add(methodConfig);
        serviceConfig.setMethods(methods);*/


//        ProviderConfig
//        MonitorConfig
        return serviceConfig;
    }

}
