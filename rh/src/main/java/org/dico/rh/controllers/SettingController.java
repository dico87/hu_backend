package org.dico.rh.controllers;

import java.util.List;

import org.dico.rh.models.Setting;
import org.dico.rh.services.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settings")
public class SettingController {

	@Autowired
	private SettingService settingService;
	
	@GetMapping
	public ResponseEntity<List<Setting>> get() throws Exception {
		List<Setting> records = settingService.get();
		return records.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(records);
	}

	@GetMapping("/{key}")
	public ResponseEntity<Setting> get(@PathVariable("key") String key) throws Exception {
		Setting record = settingService.get(key);
		return record == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(record);
	}

	@PutMapping
	public ResponseEntity<Setting> update(@RequestBody Setting setting) throws Exception {
		setting = settingService.update(setting);
		return setting == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(setting);
	}
}
