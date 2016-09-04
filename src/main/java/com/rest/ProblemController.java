package com.rest;

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

import com.model.Problem;
import com.model.ProblemTest;
import com.model.Solution;
import com.service.ProblemServiceImpl;
import com.service.SolutionServiceImpl;
import com.service.TestServiceImpl;

@RestController
@RequestMapping(value="/problem")
public class ProblemController {
	
	@Autowired
	ProblemServiceImpl problemService;
	
	@Autowired
	SolutionServiceImpl solutionService;
	
	@Autowired
	TestServiceImpl testService;
	
	@ApiOperation(value = "getProblems", nickname = "getProblems")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Problem>> getProblems(){
		List<Problem> problems = problemService.findAll();
		return problems != null ? new ResponseEntity<List<Problem>>(problems,HttpStatus.OK)
								: new ResponseEntity<List<Problem>>(problems,HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "saveProblems", nickname = "saveProblems")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Problem> saveProblem(@RequestBody Problem problem){
		problemService.save(problem);
		return new ResponseEntity<Problem>(problem,HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "getProblem", nickname = "getProblem")
	@RequestMapping(value = "/{problemId}", method = RequestMethod.GET)
	public ResponseEntity<Problem> getProblemById(@PathVariable Long problemId){
		Problem problem = problemService.findById(problemId);
		return problem != null ? new ResponseEntity<Problem>(problem, HttpStatus.OK)
								:new ResponseEntity<Problem>(problem, HttpStatus.NOT_FOUND);
	}

	
	//SOLUTIONS
	@ApiOperation(value="submitSolution", nickname="Submit Solution")
	@RequestMapping(value="/{problemId}/solution", method = RequestMethod.POST)
	public ResponseEntity<Solution> submitSolution(@PathVariable Long problemId, @RequestBody Solution solution){
		solutionService.save(solution);
		return new ResponseEntity<Solution>(solution,HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "getsolution", nickname = "getsolution")
	@RequestMapping(value = "/{problemId}/solution/{solutionId}", method = RequestMethod.GET)
	public ResponseEntity<Solution> getSolution(@PathVariable Long problemId, @PathVariable Long solutionId){
		Solution solution = solutionService.getSolution(solutionId);
		return solution != null ? new ResponseEntity<Solution>(solution,HttpStatus.OK)
								: new ResponseEntity<Solution>(solution,HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "problemId", nickname = "problemId")
	@RequestMapping(value = "/{problemId}/solution", method = RequestMethod.GET)
	public ResponseEntity<List<Solution>> getSolutions(@PathVariable Long problemId){
		List<Solution> solutions  = solutionService.getSolutionByProblemId(problemId);
		
		return solutions != null ? new ResponseEntity<List<Solution>>(solutions,HttpStatus.OK)
								 : new ResponseEntity<List<Solution>>(solutions,HttpStatus.NOT_FOUND); 
	}
	
	
	//TESTS
	@ApiOperation(value = "getTest", nickname = "getTest")
	@RequestMapping(value = "/{problemId}/test/{testId}", method = RequestMethod.GET)
	public ResponseEntity<ProblemTest> getTest(@PathVariable Long problemId, @PathVariable Long testId){
		ProblemTest test = testService.findById(testId);
		return new ResponseEntity<ProblemTest>(test, HttpStatus.OK);
	}
	
	@ApiOperation(value = "getTests", nickname = "getTests")
	@RequestMapping(value = "/{problemId}/test", method = RequestMethod.GET)
	public ResponseEntity<List<ProblemTest>> getTests(@PathVariable Long problemId){
		List<ProblemTest> tests = testService.findByProblemCode(problemId);
		return new ResponseEntity<List<ProblemTest>>(tests, HttpStatus.OK);
	}
	
	@ApiOperation(value="createTest", nickname="Create Test")
	@RequestMapping(value = "/{problemId}/test", method = RequestMethod.POST)
	public ResponseEntity<ProblemTest> createTest(@PathVariable Long problemId, 
							@RequestBody ProblemTest test){
		test.setProblemCode(problemId);
		testService.save(test);
		
		return new ResponseEntity<ProblemTest>(test, HttpStatus.CREATED);
	}
	
	//STATISTICS
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
	
	//only testing purpose
	public void deleteAll(){
		for (Problem p : problemService.findAll()) {
			problemService.removeProblem(p.getId());
		}
	}
}
