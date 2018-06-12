package yongsik.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import yongsik.springframework.controllers.ConstructorInjectedController;
import yongsik.springframework.controllers.GetterInjectedController;
import yongsik.springframework.controllers.MyController;
import yongsik.springframework.controllers.PropertyInjectedController;

@SpringBootApplication
@ComponentScan(basePackages = {"yongsik.services", "yongsik.springframework"})
public class DiDemoApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		MyController controller = (MyController) ctx.getBean("myController");
		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
	}
	
}
