package eoi.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import eoi.main.alumno.Alumno;

public class AlumnoRepository {

	public AlumnoRepository() {

	}

	private Connection openConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
		String username = "root";
		String password = "1234";
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			return con;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return con;
		}
	}

	public boolean create(Alumno alum) {
		String insertQuery = "INSERT INTO alumno(Dni, Nombre, Apellidos, Edad) VALUES(?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		int rows = 0;

		// Creamos la conexion
		try {
			con = openConnection();
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, alum.getDNI());
			pst.setString(2, alum.getNombre());
			pst.setString(3, alum.getApellidos());
			pst.setInt(4, alum.getEdad());

			System.out.println("ejecutando la query +" + insertQuery);
			rows = pst.executeUpdate();
			System.out.println("Registros insertados: " + rows);
			pst.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
