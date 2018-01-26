package spring.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanFactory {

	private static ApplicationContext beanFactory;

	public static void main(String[] args) {
		
		beanFactory = new FileSystemXmlApplicationContext("C:/Users/p.raturi/Downloads/SpringWorkspace/SpringMVC/spring.xml");
		Triangle triangle = (Triangle) beanFactory.getBean("triangle");
		triangle.drawing();
	}

}
