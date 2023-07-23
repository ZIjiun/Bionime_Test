package com.kent.dao;

import com.kent.domain.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseDao extends JpaRepository<Nurse, String> {
}
