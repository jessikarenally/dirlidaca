package rest;

import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class DirliController {
	
	@RequestMapping("hello")
    public String sayHello(){
        return ("Hello, Welcome to Dirli - A Submission System");
    }
}
