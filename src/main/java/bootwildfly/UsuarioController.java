package bootwildfly;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
	
	@RequestMapping(value = "usuario}", method = RequestMethod.POST)
	public String login(){
		return String.format("Logado");
	}
	
	@RequestMapping(value = "usuario/{idUsuario}", method = RequestMethod.GET)
	public String getUsuario(@PathVariable Long idUsuario){
		return String.format("Id usuario passado: %s", idUsuario);
	}

	@RequestMapping(value = "usuario/{idUsuario}", method = RequestMethod.DELETE)
	public String deleteUsuario(@PathVariable Long idUsuario){
		return String.format("Id usuario passado: %s", idUsuario);
	}
	
	@RequestMapping(value = "usuario/{idUsuario}", method = RequestMethod.PUT)
	public String setUsuario(@PathVariable Long idUsuario){
		return String.format("Id idUsuario passado: %s", idUsuario);
	}

}
