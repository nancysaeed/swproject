package io.javasprings.springbootEval;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@Configuration
@ComponentScan
@RestController
public class Controller {
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String sayHello()
	{
		return "Hello Worled";
	}

}
