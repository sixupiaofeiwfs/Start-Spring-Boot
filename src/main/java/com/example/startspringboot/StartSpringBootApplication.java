package com.example.startspringboot;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@SpringBootApplication
@RestController
public class StartSpringBootApplication {

    @RequestMapping("/")
    String index(){
        return "welcome to study Spring-Boot";
    }



    public static void main(String[] args) {

       SpringApplication app=new SpringApplication(StartSpringBootApplication.class);

       app.setDefaultProperties(Collections.singletonMap("server.port","8082"));

       app.run(args);




    }

}


/*
* @RestController注解相当于@ResponseBody+@Controller合在一起的作用
*
*1.如果只是使用@RestController注解Controller,则Controller中的方法无法返回页面(html或jsp),
* 配置的视图解析器InternalResourceViewResolver不起作用,返回的内容就是Return里面的内容
*
* 2.@Controller注解的Controller类中的函数可以返回具体的页面,比如直接返回String  Jsp  html等
* 或者可以通过ModelAndView.setViewName()来指定页面名字
* 如果想要返回json数据,则需要在函数上面再添加一个注解@ResponseBody
*
*
*
*
*
*
* @SpringBootApplication注解的代码如下,这下注解中有关SpringBoot的注解只有三个
* 1) SpringBootConfigration
*       等同于@Configration,带有spring的标志,属于spring的一个配置类
* 2) EnableAutoConfigration
*       开启自动配置功能.
* 3) ComponentScan()
*       自动扫描并加载符合条件的组件或bean定义,最终将这些bean定义加载到容器中。
* 实际上@SpringBootApplication这个注解是三个注解的复合解释.
*
*
*
*
*
*修改默认配置的四种方式，这里以端口号为例：将默认的8080端口号改为8081
* 1.修改proprety配置文件
*         打开项目的application.properties文件，添加配置 server.port=8081；
* 2.在启动类中以编程的方式设置特定属性
*         SpringApplication app=new SpringApplication(StartSpringBootApplication.class);
          app.setDefaultProperties(Collections.singletonMap("server.port","8082"));
          app.run(args);
*
*3.通过编程方式自定义嵌入式服务配置
*         创建一个类实现WebServerFactoryCustomizer接口
*
*4.当以jar包的形式打包运行我们的应用程序时，我们可以在命令中设置server.port修改默认的端口，命令如下：
*         java -jar demo.jar  --server.port=8084
*     或
*         java -jar -Dserver.port=8084 demo.jar
*
*
* */