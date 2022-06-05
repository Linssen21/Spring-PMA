package com.sbtutorial.pma.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sbtutorial.pma.entities.UserAccount;

@Repository
public interface UserAccountRepository  extends CrudRepository<UserAccount, Long>{

}
