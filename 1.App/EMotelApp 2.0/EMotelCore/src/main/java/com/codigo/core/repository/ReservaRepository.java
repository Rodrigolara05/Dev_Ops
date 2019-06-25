package com.codigo.core.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.codigo.core.entity.Administrador;
import com.codigo.core.entity.Hotel;
import com.codigo.core.entity.Reserva;
import com.codigo.core.entity.Restaurante;

public class ReservaRepository extends Conexion<Reserva> {

	@Override
	public boolean insertar(Reserva e) throws Exception {
		boolean resultado = false;
		try {
			cn = obtenerConexion();
			String sql = "INSERT INTO RESERVA (restaurante_id,hotel_id,administrador_id,diasreserva,costototal,fechareserva) VALUES (?,?,?,?,?,?)";
			pr = cn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setInt(1, e.getRestaurante().getId());
			pr.setInt(2, e.getHotel().getId());
			pr.setInt(3, e.getAdministrador().getId());
			pr.setInt(4, e.getDiasreserva());
			pr.setDouble(5, e.getCostototal());
			
			java.sql.Date sqlStartDate = new java.sql.Date(e.getFechareserva().getTime());
			
			pr.setDate(6,sqlStartDate);
			pr.executeUpdate();
			rs = pr.getGeneratedKeys();
			rs.next();
			resultado = true;
		} 
		catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}	
		finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return resultado;
	}

	@Override
	public Reserva actualizar(Reserva e) throws Exception {
		try {
			cn = obtenerConexion();
			String sql = "UPDATE RESERVA SET restaurante_id=?,hotel_id=?,administrador_id=?,diasreserva=?,costototal=?,fechareserva=? WHERE id=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, e.getRestaurante().getId());
			pr.setInt(2, e.getHotel().getId());
			pr.setInt(3, e.getAdministrador().getId());
			pr.setInt(4, e.getDiasreserva());
			pr.setDouble(5, e.getCostototal());
			
			java.sql.Date sqlStartDate = new java.sql.Date(e.getFechareserva().getTime());
			
			pr.setDate(6,sqlStartDate);
			pr.setInt(7, e.getId());
			pr.executeUpdate();
		} finally {
			pr.close();
			cn.close();
		}
		return e;
	}

	@Override
	public boolean eliminar(int id) throws Exception {
		boolean resultado = false;
		try {
			cn = obtenerConexion();
			String sql = "DELETE FROM RESERVA WHERE id=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, id);
			pr.executeUpdate();
			resultado = true;
		} finally {
			pr.close();
			cn.close();
		}
		return resultado;
	}

	@Override
	public Reserva obtener(Reserva e) throws Exception {
		Reserva categoria = null;
		Restaurante restaurante = null;
		Hotel hotel = null;
		Administrador administrador = null;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM RESERVA WHERE id=? ORDER BY fechareserva";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, e.getId());
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Reserva();
				restaurante = new Restaurante();
				hotel = new Hotel();
				administrador = new Administrador();
				categoria.setId(rs.getInt("id"));
				restaurante.setId(rs.getInt("restaurante_id"));
				categoria.setRestaurante(restaurante);	
				hotel.setId(rs.getInt("hotel_id"));
				categoria.setHotel(hotel);	
				administrador.setId(rs.getInt("administrador_id"));
				categoria.setAdministrador(administrador);
				categoria.setDiasreserva(rs.getInt("diasreserva"));
				categoria.setCostototal(rs.getDouble("costototal"));
				java.sql.Date sqlStartDate = new java.sql.Date(rs.getDate("fechareserva").getTime());
				categoria.setFechareserva(sqlStartDate);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categoria;
	}

	@Override
	public List<Reserva> listar() throws Exception {
		List<Reserva> categorias = new ArrayList<Reserva>();
		Reserva categoria;
		Restaurante restaurante;
		Hotel hotel;
		Administrador administrador;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM RESERVA ORDER BY fechareserva";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Reserva();
				restaurante = new Restaurante();
				hotel = new Hotel();
				administrador = new Administrador();
				categoria.setId(rs.getInt("id"));
				restaurante.setId(rs.getInt("restaurante_id"));
				categoria.setRestaurante(restaurante);	
				hotel.setId(rs.getInt("hotel_id"));
				categoria.setHotel(hotel);	
				administrador.setId(rs.getInt("administrador_id"));
				categoria.setAdministrador(administrador);
				categoria.setDiasreserva(rs.getInt("diasreserva"));
				categoria.setCostototal(rs.getDouble("costototal"));
				java.sql.Date sqlStartDate = new java.sql.Date(rs.getDate("fechareserva").getTime());
				categoria.setFechareserva(sqlStartDate);
				categorias.add(categoria);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categorias;
	}

	public List<Reserva> buscarPorParametro(int id, int id2) {
		return null;
	}

}
