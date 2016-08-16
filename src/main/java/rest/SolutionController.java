package rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value="/solution")
public class SolutionController {
	
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(method = RequestMethod.GET)
	public String getSolutions(){
		return "get All solutions";
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(value="/{solutionId}", method = RequestMethod.GET)
	public String getSolution(Long solutionId){
		return "get solution"+solutionId;
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(value="/{solutionId}", method = RequestMethod.PUT)
	public String updateSolution(Long solutionId){
		return "editing solution"+solutionId;
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(value="/{solutionId}", method = RequestMethod.DELETE)
	public String removeSolution(Long solutionId){
		return "removing solution"+solutionId;
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(method = RequestMethod.POST)
	public String saveSolution(){
		return "adding solution";
	}

}
