package org.jobhacker.springboot.app.repository;

import org.jobhacker.springboot.app.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
