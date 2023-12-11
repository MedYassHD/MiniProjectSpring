package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.TaskTable;

@Repository
public interface ITaskTableRepository extends CrudRepository<TaskTable, Long> {

}
