package eoi.main.alumno;

public class Alumno {
	String DNI;
	String nombre;
	String apellidos;
	int edad;
	
	Alumno(){
	
	}
public Alumno( String DNI, String nombre, String apellidos,int edad) {
	this.DNI = DNI;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.edad = edad;
}
public String getDNI() {
	return DNI;
}
public void setDNI(String dNI) {
	DNI = dNI;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}

}