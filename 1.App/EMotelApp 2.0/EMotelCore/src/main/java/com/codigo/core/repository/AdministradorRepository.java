package com.codigo.core.repository;


import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


import com.codigo.core.entity.Administrador;
import com.codigo.core.entity.Rol;

public class AdministradorRepository extends Conexion<Administrador> {

	@Override
	public boolean insertar(Administrador e) throws Exception {
		boolean resultado = false;
		try {
			cn = obtenerConexion();
			String sql = "INSERT INTO USUARIO (nombre,apellido,correo,fecha,password,rol_id) VALUES (?,?,?,?,?,?)";
			pr = cn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, e.getNombre());
			pr.setString(2, e.getApellido());
			pr.setString(3, e.getCorreo());
			java.sql.Date sqlStartDate = new java.sql.Date(e.getFecha().getTime());
			pr.setDate(4,sqlStartDate);
			pr.setString(5, e.getPassword());
			pr.setInt(6, e.getRol().getId());
			
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
	public Administrador actualizar(Administrador e) throws Exception {
		try {
			cn = obtenerConexion();
			String sql = "UPDATE USUARIO SET nombre=?,apellido=?,correo=?,fecha=?,password=?,rol_id=? WHERE id=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, e.getNombre().toUpperCase());
			pr.setString(2, e.getApellido().toUpperCase());
			pr.setString(3, e.getCorreo().toUpperCase());
			java.sql.Date sqlStartDate = new java.sql.Date(e.getFecha().getTime());
			pr.setDate(4, sqlStartDate);
			pr.setString(5, e.getPassword().toUpperCase());
			pr.setInt(6, e.getRol().getId());
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
			String sql = "DELETE FROM USUARIO WHERE id=?";
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
	public Administrador obtener(Administrador e) throws Exception {
		Administrador categoria = null;
		Rol rol = null;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM USUARIO WHERE id=? ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, e.getId());
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Administrador();
				rol = new Rol();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
				categoria.setApellido(rs.getString("apellido").toUpperCase());
				categoria.setCorreo(rs.getString("correo").toUpperCase());
				java.sql.Date sqlStartDate = new java.sql.Date(rs.getDate("fecha").getTime());
				categoria.setFecha(sqlStartDate);
				categoria.setPassword(rs.getString("password").toUpperCase());
				rol.setId(rs.getInt("rol_id"));
				categoria.setRol(rol);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categoria;
	}

	
	
	@Override
	public List<Administrador> listar() throws Exception {
		List<Administrador> categorias = new ArrayList<Administrador>();
		Administrador categoria;
		Rol rol;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM USUARIO ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				categoria = new Administrador();
				rol = new Rol();
				categoria.setId(rs.getInt("id"));
				categoria.setNombre(rs.getString("nombre").toUpperCase());
				categoria.setApellido(rs.getString("apellido").toUpperCase());
				categoria.setCorreo(rs.getString("correo").toUpperCase());
				java.sql.Date sqlStartDate = new java.sql.Date(rs.getDate("fecha").getTime());
				categoria.setFecha(sqlStartDate);
				categoria.setPassword(rs.getString("password").toUpperCase());
				rol.setId(rs.getInt("rol_id"));
				categoria.setRol(rol);
				categorias.add(categoria);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return categorias;
	}
	//buscarPorCorreo
	
	public Administrador buscarPorCorreo(String correo,String password) throws Exception {
			Administrador categoria = null;
			Rol rol = null;
			try {
				cn = obtenerConexion();
				String sql = "SELECT * FROM USUARIO WHERE correo=? and password=?";
				pr = cn.prepareStatement(sql);
				pr.setString(1, correo);
				pr.setString(2, password);
				rs = pr.executeQuery();
				while (rs.next()) {
					categoria = new Administrador();
					rol = new Rol();
					categoria.setId(rs.getInt("id"));
					categoria.setNombre(rs.getString("nombre").toUpperCase());
					categoria.setApellido(rs.getString("apellido").toUpperCase());
					categoria.setCorreo(rs.getString("correo").toUpperCase());
					java.sql.Date sqlStartDate = new java.sql.Date(rs.getDate("fecha").getTime());
					categoria.setFecha(sqlStartDate);
					categoria.setPassword(rs.getString("password").toUpperCase());
					rol.setId(rs.getInt("rol_id"));
					categoria.setRol(rol);
				}
				
			}catch (Exception e) {
				System.out.print(e.getMessage());
			} finally {
				rs.close();
				pr.close();
				cn.close();
			}
			return categoria;
	}
}
