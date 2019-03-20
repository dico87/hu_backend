package org.dico.rh.repositories.jpa;

import org.dico.rh.models.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, String> {

}
