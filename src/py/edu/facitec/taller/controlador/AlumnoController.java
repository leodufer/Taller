package py.edu.facitec.taller.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlumnoController {
	
	@RequestMapping("/alumnos")
	public String index(){
		return "alumnos/index";
	}
}
