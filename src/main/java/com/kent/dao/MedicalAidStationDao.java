package com.kent.dao;

import com.kent.domain.MedicalAidStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAidStationDao extends JpaRepository<MedicalAidStation, Integer> {

}
