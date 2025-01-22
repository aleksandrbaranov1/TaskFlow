package org.example.taskflow.repos;

import org.example.taskflow.user.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    //ewwfwef

}
