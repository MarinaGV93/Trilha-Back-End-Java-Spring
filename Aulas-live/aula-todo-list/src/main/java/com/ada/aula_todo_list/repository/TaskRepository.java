package com.ada.aula_todo_list.repository;

import com.ada.aula_todo_list.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //Lista de Task
    //SELECT * FROM task WHERE ownerId = 1
    List<Task> findByOwnerId(Long ownerId);

    List<Task> findByParticipantsId(Long participantsId);

    List<Task> findByOwnerIdOrParticipantsId(Long ownerId, Long participantId);

    List<Task> findByDueDate(LocalDateTime dueDate);

}
