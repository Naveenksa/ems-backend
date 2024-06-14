package com.naveen.emsbackend.repository;

import com.naveen.emsbackend.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegiRepos extends JpaRepository<UserRegistration,Long> {

    UserRegistration findByuserNameAndPassword(String username,String password);
}
