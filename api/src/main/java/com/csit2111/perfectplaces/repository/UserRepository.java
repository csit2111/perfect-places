package com.csit2111.perfectplaces.repository;

import com.csit2111.perfectplaces.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
