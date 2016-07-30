package bootwildfly;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {
	
	@ApiOperation(value = "getProblems", nickname = "getProblems")
	@RequestMapping(value = "problem", method = RequestMethod.GET)
	public String getProblems(){
		return String.format("Todos os problemas");
	}
	
	@ApiOperation(value = "saveProblems", nickname = "saveProblems")
	@RequestMapping(value = "problem", method = RequestMethod.POST)
	public String saveProblem(){
		return String.format("Problem Saved!");
	}
	
	@ApiOperation(value = "getProblem", nickname = "getProblem")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "Problem id", required = true, dataType = "long", paramType = "query")
      })
	@RequestMapping(value = "problem/{problemId}", method = RequestMethod.GET)
	public String getProblem(@PathVariable Long problemId){
		return String.format("Given id problem: %s", problemId);
	}

	@ApiOperation(value = "getsolution", nickname = "getsolution")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "Problem id", required = true, dataType = "long", paramType = "query"),
        @ApiImplicitParam(name = "id", value = "Solution id", required = true, dataType = "long", paramType = "query")
      })
	@RequestMapping(value = "problem/{problemId}/solution/{solutionId}", method = RequestMethod.GET)
	public String getSolution(@PathVariable Long problemId, @PathVariable Long solutionId){
		return String.format("Id problema passado: %s e id solution: %s", problemId, solutionId);
	}
	
	@ApiOperation(value = "problemId", nickname = "problemId")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "problemId", value = "Problem id", required = true, dataType = "long", paramType = "query")
      })
	@RequestMapping(value = "problem/{problemId}/solution", method = RequestMethod.GET)
	public String getSolutions(@PathVariable Long problemId){
		return String.format("Todas as solucoes do problema de id %s", problemId);
	}
	
	@ApiOperation(value = "getTest", nickname = "getTest")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "problemId", value = "Problem id", required = true, dataType = "long", paramType = "query"),
        @ApiImplicitParam(name = "idtest", value = "Test", required = true, dataType = "long", paramType = "query")
      })
	@RequestMapping(value = "problem/{problemId}/test/{idtest}", method = RequestMethod.GET)
	public String getTest(@PathVariable Long problemId, @PathVariable Long idtest){
		return String.format("Id problema passado: %s e id test: %s", problemId, idtest);
	}
	
	@ApiOperation(value = "getTest", nickname = "getTest")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "problemId", value = "Problem id", required = true, dataType = "long", paramType = "query")
      })
	@RequestMapping(value = "problem/{problemId}/test", method = RequestMethod.GET)
	public String gettests(@PathVariable Long problemId){
		return String.format("Todas os tests do problema de id %s", problemId);
	}
	
	@ApiOperation(value = "getStatistics", nickname = "getStatistics")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "problemId", value = "Problem id", required = true, dataType = "long", paramType = "query"),
        @ApiImplicitParam(name = "statisticsId", value = "Statistic id", required = true, dataType = "long", paramType = "query")
      })
	@RequestMapping(value = "problem/{problemId}/statistics/{statisticsId}", method = RequestMethod.GET)
	public String getStatisticss(@PathVariable Long problemId, @PathVariable Long statisticsId){
		return String.format("Id problema passado: %s e statisticsId: %s", problemId, statisticsId);
	}
	
	@ApiOperation(value = "getStatistics", nickname = "getStatistics")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "Problem id", required = true, dataType = "long", paramType = "query")
      })
	@RequestMapping(value = "problem/{problemId}/statistics", method = RequestMethod.GET)
	public String getStatistics(@PathVariable Long problemId){
		return String.format("All statistics for the problem with id %s", problemId);
	}
}
