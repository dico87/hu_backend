package org.dico.rh.services;

import java.util.List;

import org.dico.rh.models.Setting;
import org.dico.rh.repositories.jpa.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService implements ISettingService {

	@Autowired
	private SettingRepository settingRepository;	
	
	@Override
	public List<Setting> get() throws Exception {
		return settingRepository.findAll();
	}

	@Override
	public Setting get(String key) throws Exception {
		return settingRepository.findById(key).orElse(null);
	}

	@Override
	public Setting update(Setting setting) throws Exception {
		if(settingRepository.existsById(setting.getKey())) {
			settingRepository.save(setting);
			return setting;
		}
		return null;
	}

}
