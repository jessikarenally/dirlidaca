package com.rest;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.ProblemService;

@RestController
@RequestMapping(value="/problem")
public class ProblemController {
	
	@Autowired
	ProblemService problemService;
	
	@ApiOperation(value = "getProblems", nickname = "getProblems")
	@RequestMapping(method = RequestMethod.GET)
	public String getProblems(){
		return String.format("Todos os problemas");
	}
	
	@ApiOperation(value = "saveProblems", nickname = "saveProblems")
	@RequestMapping(method = RequestMethod.POST)
	public String saveProblem(){
		return String.format("Problem Saved!");
	}
	
	@ApiOperation(value = "getProblem", nickname = "getProblem")
	@RequestMapping(value = "/{problemId}", method = RequestMethod.GET)
	public String getProblem(@PathVariable Long problemId){
		return String.format("Given id problem: %s", problemId);
	}

	@ApiOperation(value="submitSolution", nickname="Submit Solution")
	@RequestMapping(value="/{problemId}/solution", method = RequestMethod.POST)
	public String submitSolution(@PathVariable Long problemId){
		return String.format("Problem's solution submited successfully");
	}
	
	@ApiOperation(value = "getsolution", nickname = "getsolution")
	@RequestMapping(value = "/{problemId}/solution/{solutionId}", method = RequestMethod.GET)
	public String getSolution(@PathVariable Long problemId, @PathVariable Long solutionId){
		return String.format("Id problema passado: %s e id solution: %s", problemId, solutionId);
	}
	
	@ApiOperation(value = "problemId", nickname = "problemId")
	@RequestMapping(value = "/{problemId}/solution", method = RequestMethod.GET)
	public String getSolutions(@PathVariable Long problemId){
		return String.format("Todas as solucoes do problema de id %s", problemId);
	}
	
	@ApiOperation(value = "getTest", nickname = "getTest")
	@RequestMapping(value = "/{problemId}/test/{idtest}", method = RequestMethod.GET)
	public String getTest(@PathVariable Long problemId, @PathVariable Long idtest){
		return String.format("Id problema passado: %s e id test: %s", problemId, idtest);
	}
	
	@ApiOperation(value = "getTest", nickname = "getTest")
	@RequestMapping(value = "/{problemId}/test", method = RequestMethod.GET)
	public String gettests(@PathVariable Long problemId){
		return String.format("Todas os tests do problema de id %s", problemId);
	}
	
	@ApiOperation(value="createTest", nickname="Create Test")
	@RequestMapping(value = "/{problemId}/test", method = RequestMethod.POST)
	public String createTest(@PathVariable Long problemId){
		return String.format("Test to the problem %s successfully created", problemId);
	}
	
	@ApiOperation(value = "getStatistics", nickname = "getStatistics")
	@RequestMapping(value = "/{problemId}/statistics/{statisticsId}", method = RequestMethod.GET)
	public String getStatisticss(@PathVariable Long problemId, @PathVariable Long statisticsId){
		return String.format("Id problema passado: %s e statisticsId: %s", problemId, statisticsId);
	}
	
	@ApiOperation(value = "getStatistics", nickname = "getStatistics")
	@RequestMapping(value = "/{problemId}/statistics", method = RequestMethod.GET)
	public String getStatistics(@PathVariable Long problemId){
		return String.format("All statistics for the problem with id %s", problemId);
	}
}
