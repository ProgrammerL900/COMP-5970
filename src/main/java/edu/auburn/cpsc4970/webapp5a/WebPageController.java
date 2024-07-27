package edu.auburn.cpsc4970.webapp5a;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //annotation indicates this class handles URL request
public class WebPageController {

    @GetMapping("/login") //method will be call for any web requests
    public String index(Model model) {
        return "login";
    }
/*
Method returns us to the index.html page when the login request is sent back.
HTML form tag specifies the URL handler
 */
    @GetMapping("/login_handler") //another URL handler to handle login submits
    public String loginHandler(Model model) {
        return "index";
    }
}


