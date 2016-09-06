package com.rest.solution;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.solution.Solution;
import com.service.solution.SolutionServiceImpl;

@Api
@RestController
@RequestMapping(value="/solution")
public class SolutionController {
	
	@Autowired
	SolutionServiceImpl solutionService;
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(method = RequestMethod.GET)
	public String getSolutions(){
		return "get All solutions";
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(value="/{solutionId}", method = RequestMethod.GET)
	public ResponseEntity<Solution> getSolution(@PathVariable Long solutionId){
		Solution solution = solutionService.getSolution(solutionId);
		return solution != null ? new ResponseEntity<Solution>(solution,HttpStatus.OK)
								: new ResponseEntity<Solution>(solution,HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(value="/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<Solution>> getUserSolutions(@PathVariable Long userId){
		List<Solution> userSolutions = solutionService.getSolutionsByUserId(userId);
		return new ResponseEntity<List<Solution>>(userSolutions, HttpStatus.OK);
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(value="/{solutionId}", method = RequestMethod.PUT)
	public ResponseEntity<Solution> updateSolution(@PathVariable Long solutionId, @RequestBody Solution solution){
		solutionService.update(solution);
		return new ResponseEntity<Solution>(solution,HttpStatus.OK);
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(value="/{solutionId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removeSolution(@PathVariable Long solutionId){
		solutionService.removeSolution(solutionId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
