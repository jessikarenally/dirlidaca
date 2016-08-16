package rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value="/test")
public class TestController {
	
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(method = RequestMethod.GET)
	public String getTests(){
		return "get All tests";
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(value="/{testId}", method = RequestMethod.GET)
	public String getTest(Long testId){
		return "get Test "+testId;
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(method = RequestMethod.POST)
	public String saveTest(){
		return "adding a new test";
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(method = RequestMethod.PUT)
	public String updateTest(Long testId){
		return "editing the test "+testId;
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(method = RequestMethod.DELETE)
	public String removeTest(Long testId){
		return "removing the test "+testId;
	}

}
