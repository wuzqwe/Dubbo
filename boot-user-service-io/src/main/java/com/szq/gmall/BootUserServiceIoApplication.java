package com.szq.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 1.导入依赖
 *   1、导入dubbo-starter
 *   2.导入dubbo的其他依赖
 *
 *   SpringBoot与dubbo整合的三种方式
 *   1、导入dubbo-starter.在application.properties配置属性 使用@Service【暴露服务】 使用@Reference【引用服务】
 *   2、保留dubbo.xml的配置文件
 *   导入dubbo=starter.使用@ImportResource导入dubbo的配置文件即可
 *   3、使用注解API
 *     将每一个组件手动创建到容器中
 *
 */

//@EnableDubbo //基于Dubbo的注解功能
//@ImportResource(locations = "classpath:provider.xml")
@EnableDubbo(scanBasePackages = "com.szq.gmall")
@SpringBootApplication
//@EnableHystrix//开启服务容错
public class BootUserServiceIoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceIoApplication.class, args);
    }

}
