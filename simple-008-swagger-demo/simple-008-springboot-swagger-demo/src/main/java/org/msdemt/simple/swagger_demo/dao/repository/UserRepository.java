package org.msdemt.simple.swagger_demo.dao.repository;

import org.msdemt.simple.swagger_demo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
