package org.dico.rh.services;

import java.util.List;

import org.dico.rh.models.User;

public interface IUserService {

	/**
	 * Obtiene los usuarios de la aplicacion
	 * 
	 * @return Lista de {@link org.dico.rh.models.User}
	 * @throws Exception Error en el servicio
	 */
	public List<User> get() throws Exception;

	/**
	 * Busca un usuario por id
	 * 
	 * @param id Id usuario
	 * @return {@link org.dico.rh.models.User}
	 * @throws Exception Error en el servicio
	 */
	public User get(int id) throws Exception;
	
	/**
	 * Busca por usuario
	 * @param username Usuario
	 * @return {@link org.dico.rh.models.User}, null en caso de no encontrarse
	 * @throws Exception Error en el servicio
	 */
	public User getByUserName(String username) throws Exception;

	/**
	 * Crea un usuario
	 * 
	 * @param user {@link org.dico.rh.models.User}
	 * @throws Exception Error en el servicio
	 */
	public User insert(User user) throws Exception;
	
	/**
	 * Actualiza un usuario
	 * 
	 * @param user {@link org.dico.rh.models.User}
	 * @throws Exception Error en el servicio
	 */
	public User update(User user) throws Exception;
}
