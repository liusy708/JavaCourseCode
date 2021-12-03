import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import scannable.School;

public class SpringDemo {

    public static void main(String[] args) {

        // 方法一：通过xml配置装配bean
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student123 = (Student) context.getBean("student123");

        System.out.println(student123.toString());
        student123.print();

        // 方法二：通过自动扫描组件。在bean.xml 文件中配置：<context:component-scan base-package="scannable" />
        School school1 = context.getBean(School.class);
        school1.print();

        // 方法三：通过java @Configuration 类中使用注解定义Bean
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
        Klass klass = context2.getBean(Klass.class);
        klass.print();

        // 方法四：通过工厂方法创建
        ApplicationContext context3 = new ClassPathXmlApplicationContext("factory-beans.xml");
        Student student102 = context3.getBean(Student.class);
        System.out.println(student102.toString());
    }
}