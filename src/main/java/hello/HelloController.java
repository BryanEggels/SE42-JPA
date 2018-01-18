package hello;

import Managers.Usermanager;
import Model.User;
import ORM.ORMUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/user")
    public ORMUser getUser(@RequestParam("username") String username){
        Usermanager umgr = new Usermanager();
        return umgr.getUserByName(username);
    }
}


