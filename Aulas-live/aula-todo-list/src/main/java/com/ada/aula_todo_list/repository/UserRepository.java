package com.ada.aula_todo_list.repository;

import com.ada.aula_todo_list.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Camada para fazer uma consulta no banco de dados
@Repository
public interface UserRepository extends JpaRepository<
        //Classe que vai fazer o mapeamento no banco de dados
        User,
        //Tipo do id
        Long> {

}
