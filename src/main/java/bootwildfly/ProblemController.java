package bootwildfly;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {
	
	@RequestMapping(value = "problem}", method = RequestMethod.GET)
	public String getProblems(){
		return String.format("Todos os problemas");
	}
	
	@RequestMapping(value = "problem/{problemId}", method = RequestMethod.GET)
	public String getProblem(@PathVariable Long problemId){
		return String.format("Given id problem: %s", problemId);
	}

	@RequestMapping(value = "problem/{problemId}/solution/{solutionId}", method = RequestMethod.GET)
	public String getsolution(@PathVariable Long problemId, @PathVariable Long solutionId){
		return String.format("Id problema passado: %s e id solution: %s", problemId, solutionId);
	}
	
	@RequestMapping(value = "problem/{problemId}/solution", method = RequestMethod.GET)
	public String getSolucoes(@PathVariable Long problemId){
		return String.format("Todas as solucoes do problema de id %s", problemId);
	}
	
	@RequestMapping(value = "problem/{problemId}/test/{idtest}", method = RequestMethod.GET)
	public String gettest(@PathVariable Long problemId, @PathVariable Long idtest){
		return String.format("Id problema passado: %s e id test: %s", problemId, idtest);
	}
	
	@RequestMapping(value = "problem/{problemId}/test", method = RequestMethod.GET)
	public String gettests(@PathVariable Long problemId){
		return String.format("Todas os tests do problema de id %s", problemId);
	}
	
	@RequestMapping(value = "problem/{problemId}/statistics/{statisticsId}", method = RequestMethod.GET)
	public String getstatisticss(@PathVariable Long problemId, @PathVariable Long idstatistics){
		return String.format("Id problema passado: %s e idstatistics: %s", problemId, idstatistics);
	}
	
	@RequestMapping(value = "problem/{problemId}/statistics", method = RequestMethod.GET)
	public String getstatistics(@PathVariable Long problemId){
		return String.format("Todas os tests do problema de id %s", problemId);
	}
}
