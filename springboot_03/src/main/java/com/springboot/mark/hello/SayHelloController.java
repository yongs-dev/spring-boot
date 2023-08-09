package com.springboot.mark.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @ResponseBody
    @RequestMapping("say-hello")
    public String sayHello() {
        return "Hello World";
    }

    @ResponseBody
    @RequestMapping("say-hello-html")
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My html page</title>");
        sb.append("</head>");
        sb.append("<body>My html page with body</body>");
        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
}
