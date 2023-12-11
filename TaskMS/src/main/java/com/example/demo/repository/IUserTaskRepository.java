package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.UserTask;

@Repository
public interface IUserTaskRepository extends CrudRepository<UserTask, Long> {

}
