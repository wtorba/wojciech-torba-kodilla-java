package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskList;
import org.springframework.data.repository.CrudRepository;

public interface TaskListDao extends CrudRepository<TaskList, Integer> {
}