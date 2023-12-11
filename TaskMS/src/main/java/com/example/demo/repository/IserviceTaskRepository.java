package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.ServiceTask;

@Repository
public interface IserviceTaskRepository extends CrudRepository<ServiceTask, Long>{

}
