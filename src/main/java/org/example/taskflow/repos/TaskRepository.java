package org.example.taskflow.repos;

import org.example.taskflow.user.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT content FROM tasks WHERE user_id = :userId", nativeQuery = true)
    List<String> findContentByUserId(@Param("userId") Long userId);
}
