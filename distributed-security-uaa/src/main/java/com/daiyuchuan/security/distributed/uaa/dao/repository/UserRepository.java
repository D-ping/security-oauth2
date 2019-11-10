package com.daiyuchuan.security.distributed.uaa.dao.repository;

import com.daiyuchuan.security.distributed.uaa.model.UserDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDo,Long> {

    UserDo findUserDoByUsername(String username);
}
