package com.codigo.core.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.codigo.core.entity.Distrito;
import com.codigo.core.entity.Provincia;

public class DistritoRepository extends Conexion<Distrito> {

	@Override
	public boolean insertar(Distrito e) throws Exception {
		boolean resultado = false;
		try {
			cn = obtenerConexion();
			String sql = "INSERT INTO DISTRITO (nombre,provincia_id) VALUES (?,?)";
			pr = cn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, e.getNombre());
			pr.setInt(2, e.getProvincia().getId());
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
	public Distrito actualizar(Distrito e) throws Exception {
		try {
			cn = obtenerConexion();
			String sql = "UPDATE DISTRITO SET nombre=?,provincia_id=? WHERE id=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, e.getNombre().toUpperCase());
			pr.setInt(2, e.getProvincia().getId());
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
			String sql = "DELETE FROM DISTRITO WHERE id=?";
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
	public Distrito obtener(Distrito e) throws Exception {
		Distrito categoria = null;
		Provincia provincia = null;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM DISTRITO WHERE id=? ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, e.getId());
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Distrito();
				provincia = new Provincia();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
				provincia.setId(rs.getInt("provincia_id"));
				categoria.setProvincia(provincia);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categoria;
	}

	@Override
	public List<Distrito> listar() throws Exception {
		List<Distrito> categorias = new ArrayList<Distrito>();
		Distrito categoria;
		Provincia provincia;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM DISTRITO ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Distrito();
				provincia = new Provincia();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
				provincia.setId(rs.getInt("provincia_id"));
				categoria.setProvincia(provincia);
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
