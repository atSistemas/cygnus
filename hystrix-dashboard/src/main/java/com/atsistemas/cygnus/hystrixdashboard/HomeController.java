package com.atsistemas.cygnus.hystrixdashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dani
 *
 */
@Controller
public class HomeController {
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:hystrix";
    }
}
