package com.codigo.core.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Hotel;
import com.codigo.core.entity.TipoHotel;

public class HotelRepository extends Conexion<Hotel> {

	@Override
	public boolean insertar(Hotel e) throws Exception {
		boolean resultado = false;
		try {
			cn = obtenerConexion();
			String sql = "INSERT INTO HOTEL (nombre,precio,ubicacion,tipohotel_id,distritos_id) VALUES (?,?,?,?,?)";
			pr = cn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, e.getNombre());
			pr.setDouble(2, e.getPrecio());
			pr.setString(3, e.getUbicacion());
			pr.setInt(4, e.getTipohotel().getId());
			pr.setInt(5, e.getDistritos().getId());
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
	public Hotel actualizar(Hotel e) throws Exception {
		try {
			cn = obtenerConexion();
			String sql = "UPDATE HOTEL SET nombre=?,precio=?,ubicacion=?,tipohotel_id=?,distritos_id=? WHERE id=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, e.getNombre().toUpperCase());
			pr.setDouble(2, e.getPrecio());
			pr.setString(3, e.getUbicacion().toUpperCase());
			pr.setInt(4, e.getTipohotel().getId());
			pr.setInt(5, e.getDistritos().getId());
			pr.setInt(6, e.getId());
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
			String sql = "DELETE FROM HOTEL WHERE id=?";
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
	public Hotel obtener(Hotel e) throws Exception {
		Hotel categoria = null;
		TipoHotel tipohotel = null;
		Distrito distrito =null;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM HOTEL WHERE id=? ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, e.getId());
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Hotel();
				tipohotel = new TipoHotel();
				distrito = new Distrito();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
				categoria.setPrecio(rs.getDouble("precio"));
				categoria.setUbicacion(rs.getString("ubicacion").toUpperCase());
				tipohotel.setId(rs.getInt("tipohotel_id"));
				categoria.setTipohotel(tipohotel);
				distrito.setId(rs.getInt("distrito_id"));
				categoria.setDistritos(distrito);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categoria;
	}

	@Override
	public List<Hotel> listar() throws Exception {
		List<Hotel> categorias = new ArrayList<Hotel>();
		Hotel categoria;
		TipoHotel tipohotel;
		Distrito distrito;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM HOTEL ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Hotel();
				tipohotel = new TipoHotel();
				distrito = new Distrito();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
				categoria.setPrecio(rs.getDouble("precio"));
				categoria.setUbicacion(rs.getString("ubicacion").toUpperCase());
				tipohotel.setId(rs.getInt("tipohotel_id"));
				categoria.setTipohotel(tipohotel);
				distrito.setId(rs.getInt("distrito_id"));
				categoria.setDistritos(distrito);
				categorias.add(categoria);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categorias;
	}

	public List<Hotel> HotelPorDistrito(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
