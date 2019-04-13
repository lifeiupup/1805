package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	@Autowired  //需要模板对象
	private RestTemplate restTemplate;
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		String url = "http://localhost:7900/hello/" + name;  //访问提供者
		//使用Eureka动态列表,通过application.name找到真正提供者地址
		//url = "http://provider-user:7900/hello/" + name;  
		url = "http://provider-user/hello/" + name;  //这里不应该像上面一样使用端口号,使用端口号有可能会报错
		return restTemplate.getForObject(url, String.class);  //调用服务提供者,第二个参数: 必须跟请求者返回值类型一样 (1805provider-user项目下 hello()方法的返回值类型一致)
	}
}
