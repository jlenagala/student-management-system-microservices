package com.janani.sms.securityservice.repository;

import com.janani.sms.securityservice.model.ERole;
import com.janani.sms.securityservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
