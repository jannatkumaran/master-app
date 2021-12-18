package com.master.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.master.app.entity.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {
	

}
