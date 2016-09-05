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

import com.model.ProblemTest;
import com.service.TestServiceImpl;

@RestController
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	TestServiceImpl testService;
	
	@ApiOperation(value="getTests", nickname = "getTests")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProblemTest>> getTests(){
		List<ProblemTest> tests = testService.findAll();
		return tests != null ? new ResponseEntity<List<ProblemTest>>(tests,HttpStatus.OK)
				: new ResponseEntity<List<ProblemTest>>(tests,HttpStatus.NOT_FOUND);
		
	}
	
	@ApiOperation(value="getTest", nickname = "getTest")
	@RequestMapping(value="/{testId}", method = RequestMethod.GET)
	public ResponseEntity<ProblemTest> getTestById(@PathVariable Long testId){
		ProblemTest test = testService.findById(testId);
		return test != null? new ResponseEntity<ProblemTest>(test,HttpStatus.OK):
			new ResponseEntity<ProblemTest>(test,HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value="saveTest", nickname = "saveTest")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProblemTest> saveTest(@RequestBody ProblemTest test){
		testService.save(test);
		return new ResponseEntity<ProblemTest>(test, HttpStatus.CREATED);
	}
	
	@ApiOperation(value="", nickname = "")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ProblemTest> updateTest(Long testId, ProblemTest test){
		testService.removeTest(testId);
		testService.save(test);
		return new ResponseEntity<ProblemTest>(test, HttpStatus.OK);
	}
	
	@ApiOperation(value="removeTest", nickname = "removeTest")
	@RequestMapping(value="/{testId}", method = RequestMethod.DELETE)
	public ResponseEntity<ProblemTest> deleteTestById(@PathVariable Long testId){
		testService.removeTest(testId);
		return new ResponseEntity<ProblemTest>(HttpStatus.OK);
	}

	// only for tests purpose
	public void deleteAll() {
		for(ProblemTest t : testService.findAll()){
			testService.removeTest(t.getId());
		}
	}
}