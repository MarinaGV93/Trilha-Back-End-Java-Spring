package tech.ada.java.curso_spring.api.Amizade;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.query.Page;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.ada.java.curso_spring.api.usuario.Usuario;
import tech.ada.java.curso_spring.api.usuario.UsuarioService;
import tech.ada.java.curso_spring.api.exception.AmizadeInvalidadeBusinessException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class AmizadeService {

    //Dependências
    private final AmizadeRepository repository;
    private final UsuarioService usuarioService;
    private final ModelMapper modelMapper; //Para fazer conversões da entidade para o DTO

    public Page<AmizadeDTO> listarTodos(Pageable pageable) {
        //Faz a conversão
        Page<Amizade> usuarios = this.repository.findAll(pageable);
        return new PageImpl<>(usuarios.getContent().stream().map(this::convertToDto).toList());
    }

    public AmizadeDTO convertToDo(Amizade amizade) {
        return this.modelMapper.map(amizade, AmizadeDTO.class);
    }

    public AmizadeDTO criarAmizade(@NotNull UUID usuarioA, UUID usuarioB) {

        //Se forem iguais
        if (usuarioA.equals(usuarioB)) {

            //Lança uma exceção
            throw new AmizadeInvalidaBusinessException("É preciso indicar dois usuários diferentes");
        }
        Usuario usuarioEntityA = this.usuarioService.buscarPorUuid(usuarioA);
        Usuario usuarioEntityB = this.usuarioService.buscarPorUuid(usuarioB);
        Amizade amizade = this.repository.save(new Amizade(usuarioEntityA, usuarioEntityB));
        return this.convertToDo(amizade);
    }
}
