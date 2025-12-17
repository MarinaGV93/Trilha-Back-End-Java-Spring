package tech.ada.java.curso_spring.api.Amizade;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import tech.ada.java.curso_spring.api.exception.AmizadeInvalidadeBusinessException;
import tech.ada.java.curso_spring.api.usuario.Usuario;
import tech.ada.java.curso_spring.api.usuario.UsuarioService;

@Service
@RequiredArgsConstructor
@Log4j2
public class AmizadeService {

    //Dependências
    private final AmizadeRepository repository;
    private final UsuarioService usuarioService;
    private final ModelMapper modelMapper; //Para fazer conversões da entidade para o DTO

    @Transactional(readOnly = true)
    public Page<AmizadeDTO> listarTodos(@NonNull Pageable pageable) {
        //Faz a conversão
        Page<Amizade> usuarios = this.repository.findAll(pageable);
        List<AmizadeDTO> amizadeDTOList = Objects.requireNonNull(usuarios.getContent().stream().map(this::convertToDo).collect(Collectors.toList()));
        return new PageImpl<>(amizadeDTOList, pageable, usuarios.getTotalElements());
    }

    public AmizadeDTO convertToDo(Amizade amizade) {
        return this.modelMapper.map(amizade, AmizadeDTO.class);
    }

    public AmizadeDTO criarAmizade(UUID usuarioA, UUID usuarioB) {

        //Se forem iguais
        if (usuarioA.equals(usuarioB)) {

            //Lança uma exceção
            throw new AmizadeInvalidadeBusinessException("É preciso indicar dois usuários diferentes");
        }
        Usuario usuarioEntityA = this.usuarioService.buscarPorUuid(usuarioA);
        Usuario usuarioEntityB = this.usuarioService.buscarPorUuid(usuarioB);

        boolean existeAB = this.repository.existsByUsuarioAAndUsuarioB(usuarioEntityA, usuarioEntityB);
        boolean existeBA = this.repository.existsByUsuarioAAndUsuarioB(usuarioEntityB, usuarioEntityA);
        if (existeAB || existeBA) {
            throw new AmizadeInvalidadeBusinessException("Amizade já existe entre esses usuários");
        }

        Amizade amizade = this.repository.save(new Amizade(usuarioEntityA, usuarioEntityB));
        return this.convertToDo(amizade);
    }
}
