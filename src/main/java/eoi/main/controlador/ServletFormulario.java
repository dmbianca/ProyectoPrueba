package eoi.main.controlador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eoi.main.alumno.Alumno;
import eoi.main.service.AlumnoService;

@WebServlet("/ServletFormulario")
public class ServletFormulario extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/htmlcharset=UTF-8");
		PrintWriter out = response.getWriter();
		
		boolean resultado;
		//Leer los parametros del formulario HTML
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String edad = request.getParameter("edad");
		int edadNum = Integer.parseInt(edad);
		
		//Creamos el objeto alumno con los datos recuperados del formulario
		Alumno alu = new Alumno(dni,nombre,apellidos,edadNum);
		//Creamos un objeto alumnoService
		AlumnoService alum = new AlumnoService();
		//Invocamos al metodo create del objeto alum pasandole el alumno
		resultado = alum.create(alu);
		if(resultado == true) {
			out.print("El alumno se ha insertado correctamente en la base de datos");
		}else {
			out.print("El alta del alumno ha fallado");
		}
		System.out.println("DNI: " + dni);
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellidos: " + apellidos);
		System.out.println("Edad: " + edadNum);
		
	}

}
