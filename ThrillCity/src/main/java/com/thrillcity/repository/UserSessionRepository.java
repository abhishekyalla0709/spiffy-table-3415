package com.thrillcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thrillcity.model.UserSession;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Integer>{
	
	public UserSession findBySessionId(String sessionid);
	
}
