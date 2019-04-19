package com.ibm.diypopups.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.diypopups.model.users;

public interface EndUserRepository extends JpaRepository<users,Integer>{

}
