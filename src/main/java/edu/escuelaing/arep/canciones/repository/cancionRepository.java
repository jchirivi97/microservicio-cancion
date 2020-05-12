package edu.escuelaing.arep.canciones.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.escuelaing.arep.canciones.model.Cancion;

public class cancionRepository {

	private static final String urlDb = "jdbc:postgresql://ec2-3-231-16-122.compute-1.amazonaws.com:5432/d82dgnug27a8v1?user=vebjylzbvbhkrd&password=7c23c795d8069466561a02303eb7027408f04235b2525c347f204f3249664fef";
	private Connection c;
	private Cancion can;

	public void getConnection() {
		try {
			c = DriverManager.getConnection(urlDb);
		} catch (SQLException e) {
		}
	}

	public Cancion getCancion(int id) {

		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			getConnection();
			c.setAutoCommit(false);
			String sql = "select * from cancion where id = ? ";
			pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("rssssssssssss: " + rs);
			c.close();
			if (rs.next()) {
				System.out.println("reproduccion: ");
				can = new Cancion(rs.getInt("id"), rs.getString("nombre"),rs.getString("contenido"));
			}
			pstmt.close();
			rs.close();
			return can;
		} catch (Exception ex) {
			Logger.getLogger(cancionRepository.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}
	
	
	public void saveCancion(int id,String nombre,String contenido){
		PreparedStatement pstmt = null;
    	try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "insert into cancion values(?,?,?)";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, id);
            pstmt.setString(2, contenido);
            pstmt.setString(3, nombre);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            pstmt.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(cancionRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
	}	
	

}
