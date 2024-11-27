package in.andra.today_news.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @GetMapping("/hello")
    public String check() {
        return "Hello World";
    }

    @GetMapping("/")
    public String getCheckout() {
        // User user;
        // UserServiceImpl.createUser(user)
        return "you are in the default page of the api call";
    }


}
