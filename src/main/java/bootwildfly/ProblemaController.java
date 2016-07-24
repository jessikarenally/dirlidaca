package bootwildfly;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemaController {
	
	@RequestMapping(value = "problema}", method = RequestMethod.GET)
	public String getProblemas(){
		return String.format("Todos os problemas");
	}
	
	@RequestMapping(value = "problema/{idProblema}", method = RequestMethod.GET)
	public String getProblema(@PathVariable Long idProblema){
		return String.format("Id problema passado: %s", idProblema);
	}

	@RequestMapping(value = "problema/{idProblema}/solucao/{idSolucao}", method = RequestMethod.GET)
	public String getSolucao(@PathVariable Long idProblema, @PathVariable Long idSolucao){
		return String.format("Id problema passado: %s e id solucao: %s", idProblema, idSolucao);
	}
	
	@RequestMapping(value = "problema/{idProblema}/solucao", method = RequestMethod.GET)
	public String getSolucoes(@PathVariable Long idProblema){
		return String.format("Todas as solucoes do problema de id %s", idProblema);
	}
	
	@RequestMapping(value = "problema/{idProblema}/teste/{idTeste}", method = RequestMethod.GET)
	public String getTeste(@PathVariable Long idProblema, @PathVariable Long idTeste){
		return String.format("Id problema passado: %s e id teste: %s", idProblema, idTeste);
	}
	
	@RequestMapping(value = "problema/{idProblema}/teste", method = RequestMethod.GET)
	public String getTestes(@PathVariable Long idProblema){
		return String.format("Todas os testes do problema de id %s", idProblema);
	}
	
	@RequestMapping(value = "problema/{idProblema}/estatistica/{idEstatistica}", method = RequestMethod.GET)
	public String getEstatisticas(@PathVariable Long idProblema, @PathVariable Long idEstatistica){
		return String.format("Id problema passado: %s e idEstatistica: %s", idProblema, idEstatistica);
	}
	
	@RequestMapping(value = "problema/{idProblema}/estatistica", method = RequestMethod.GET)
	public String getEstatistica(@PathVariable Long idProblema){
		return String.format("Todas os testes do problema de id %s", idProblema);
	}
}
