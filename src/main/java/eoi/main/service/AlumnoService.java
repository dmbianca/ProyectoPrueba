package eoi.main.service;

import eoi.main.alumno.Alumno;
import eoi.main.repository.AlumnoRepository;

public class AlumnoService {
	AlumnoRepository repository;
	
	public AlumnoService() {
		this.repository = new AlumnoRepository();
	}
	public boolean create(Alumno alum) {
		return repository.create(alum);
	}
}
