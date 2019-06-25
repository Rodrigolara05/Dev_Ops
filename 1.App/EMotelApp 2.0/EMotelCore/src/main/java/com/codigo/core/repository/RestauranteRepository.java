package com.codigo.core.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Restaurante;

public class RestauranteRepository extends Conexion<Restaurante> {

	@Override
	public boolean insertar(Restaurante e) throws Exception {
		boolean resultado = false;
		try {
			cn = obtenerConexion();
			String sql = "INSERT INTO RESTAURANTE (nombre,precio,descripcion,ubicacion,distrito_id) VALUES (?,?,?,?,?)";
			pr = cn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, e.getNombre());
			pr.setDouble(2, e.getPrecio());
			pr.setString(3, e.getDescripcion());
			pr.setString(4, e.getUbicacion());
			pr.setInt(5, e.getDistrito().getId());
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
	public Restaurante actualizar(Restaurante e) throws Exception {
		try {
			cn = obtenerConexion();
			String sql = "UPDATE RESTAURANTE SET nombre=?,precio=?,descripcion=?,ubicacion=?,distrito_id=? WHERE id=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, e.getNombre().toUpperCase());
			pr.setDouble(2, e.getPrecio());
			pr.setString(3, e.getDescripcion().toUpperCase());
			pr.setString(4, e.getUbicacion().toUpperCase());
			pr.setInt(5, e.getDistrito().getId());
			
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
			String sql = "DELETE FROM RESTAURANTE WHERE id=?";
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
	public Restaurante obtener(Restaurante e) throws Exception {
		Restaurante categoria = null;
		Distrito distrito = null;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM RESTAURANTE WHERE id=? ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, e.getId());
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Restaurante();
				distrito = new Distrito();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
				categoria.setPrecio(rs.getDouble("precio"));
				categoria.setDescripcion(rs.getString("descripcion").toUpperCase());
				categoria.setUbicacion(rs.getString("ubicacion").toUpperCase());
				distrito.setId(rs.getInt("distrito_id"));
				categoria.setDistrito(distrito);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categoria;
	}

	@Override
	public List<Restaurante> listar() throws Exception {
		List<Restaurante> categorias = new ArrayList<Restaurante>();
		Restaurante categoria;
		Distrito distrito;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM RESTAURANTE ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Restaurante();
				distrito = new Distrito();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
				categoria.setPrecio(rs.getDouble("precio"));
				categoria.setDescripcion(rs.getString("descripcion").toUpperCase());
				categoria.setUbicacion(rs.getString("ubicacion").toUpperCase());
				distrito.setId(rs.getInt("distrito_id"));
				categoria.setDistrito(distrito);
				categorias.add(categoria);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categorias;
	}

	public List<Restaurante> RestaurantePorDistrito(int id) throws Exception {
		List<Restaurante> lista = new ArrayList<Restaurante>();
		
		try {
			
			lista = this.listar();
		}
		finally {
			
		}
		return lista;
	}

}
