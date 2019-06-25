package com.codigo.core.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.codigo.core.entity.Provincia;

public class ProvinciaRepository extends Conexion<Provincia> {

	@Override
	public boolean insertar(Provincia e) throws Exception {
		boolean resultado = false;
		try {
			cn = obtenerConexion();
			String sql = "INSERT INTO PROVINCIA (nombre) VALUES (?)";
			pr = cn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, e.getNombre());
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
	public Provincia actualizar(Provincia e) throws Exception {
		try {
			cn = obtenerConexion();
			String sql = "UPDATE PROVINCIA SET nombre=? WHERE id=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, e.getNombre().toUpperCase());
			pr.setInt(2, e.getId());
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
			String sql = "DELETE FROM PROVINCIA WHERE id=?";
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
	public Provincia obtener(Provincia e) throws Exception {
		Provincia categoria = null;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM PROVINCIA WHERE id=? ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, e.getId());
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Provincia();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categoria;
	}

	@Override
	public List<Provincia> listar() throws Exception {
		List<Provincia> categorias = new ArrayList<Provincia>();
		Provincia categoria;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM PROVINCIA ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Provincia();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
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
