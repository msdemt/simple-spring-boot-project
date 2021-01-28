package org.msdemt.proguard_demo.dao.repository;

import org.msdemt.proguard_demo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository<T, ID>
 *   参数1：T:当前需要映射的实体
 *   参数2：ID:当前映射的实体中的OID的类型
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
