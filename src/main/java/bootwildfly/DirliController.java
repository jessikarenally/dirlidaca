package bootwildfly;

import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class DirliController {
	
	@RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello(){
        return ("Hello, Welcome to Dirli - A Submission System");
    }
}
