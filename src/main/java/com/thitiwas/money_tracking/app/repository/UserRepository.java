package com.thitiwas.money_tracking.app.repository;

import com.thitiwas.money_tracking.app.entity.member.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByEmailAndPassword(String email, String password);
}
