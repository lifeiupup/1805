package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication //标识是一个springboot项目
@EnableEurekaClient //标识是一个 Eureka 客户端
public class ConsumerRunApp {
	
	@Bean  			//初始化模板对象  (@Bean是一个方法级别上的注解,跟配置spring上下文中 <bean id="bb"  class="xxx.xx.x"></bean> 一样,这样配置,spirng就会帮你返回RestTemplate对象了)
	@LoadBalanced	//实现负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerRunApp.class, args);
		
		
	}

}
