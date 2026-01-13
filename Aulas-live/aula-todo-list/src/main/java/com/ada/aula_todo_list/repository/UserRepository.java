package com.ada.aula_todo_list.repository;

import com.ada.aula_todo_list.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Camada para fazer uma consulta no banco de dados
@Repository
public interface UserRepository extends JpaRepository<
        //Classe que vai fazer o mapeamento no banco de dados
        User,
        //Tipo do id
        Long> {

}
