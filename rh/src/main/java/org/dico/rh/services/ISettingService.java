package org.dico.rh.services;

import java.util.List;

import org.dico.rh.models.Setting;

public interface ISettingService {

	/**
	 * Obtiene la configuración
	 * 
	 * @return Lista de {@link org.dico.rh.models.Setting}
	 * @throws Exception Error en el servicio
	 */
	public List<Setting> get() throws Exception;

	/**
	 * Obtiene una configuracion por su llave
	 * 
	 * @param key Llave
	 * @return {@link org.dico.rh.models.Setting}
	 * @throws Exception Error en el servicio
	 */
	public Setting get(String key) throws Exception;

	/**
	 * Actualiza una configuracion existente
	 * 
	 * @param setting {@link org.dico.rh.models.Setting}
	 * @throws Exception Error en el servicio
	 */
	public Setting update(Setting setting) throws Exception;
}
