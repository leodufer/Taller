package py.edu.facitec.taller.modelo;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Materia
 *
 */
@Entity

public class Materia implements Serializable {

	   
	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;
	private Integer hora;
	private static final long serialVersionUID = 1L;
  
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public Integer getHora() {
		return this.hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}
	@Override
	public boolean equals(Object obj) {
		Materia m = (Materia)obj;
		if(this.id==m.getId())
		return true;
		else
		return false;
	}
}
