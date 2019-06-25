package com.codigo.core.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.codigo.core.entity.TipoHotel;

public class TipoHotelRepository extends Conexion<TipoHotel> {

	@Override
	public boolean insertar(TipoHotel e) throws Exception {
		boolean resultado = false;
		try {
			cn = obtenerConexion();
			String sql = "INSERT INTO TIPOHOTEL (nombre,descripcion) VALUES (?,?)";
			pr = cn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, e.getNombre());
			pr.setString(2, e.getDescripcion());
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
	public TipoHotel actualizar(TipoHotel e) throws Exception {
		try {
			cn = obtenerConexion();
			String sql = "UPDATE TipoHotel SET nombre=?,descripcion=? WHERE id=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, e.getNombre().toUpperCase());
			pr.setString(2, e.getDescripcion().toUpperCase());
			pr.setInt(3, e.getId());
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
			String sql = "DELETE FROM TIPOHOTEL WHERE id=?";
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
	public TipoHotel obtener(TipoHotel e) throws Exception {
		TipoHotel categoria = null;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM TIPOHOTEL WHERE id=? ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, e.getId());
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new TipoHotel();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
				categoria.setDescripcion(rs.getString("descripcion").toUpperCase());
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categoria;
	}

	@Override
	public List<TipoHotel> listar() throws Exception {
		List<TipoHotel> categorias = new ArrayList<TipoHotel>();
		TipoHotel categoria;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM TIPOHOTEL ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new TipoHotel();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
				categoria.setNombre(rs.getString("descripcion").toUpperCase());
				categorias.add(categoria);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categorias;
	}

}
