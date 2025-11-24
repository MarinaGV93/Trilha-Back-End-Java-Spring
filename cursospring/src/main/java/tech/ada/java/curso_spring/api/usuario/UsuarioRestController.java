package tech.ada.java.curso_spring.api.usuario;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import tech.ada.java.curso_spring.api.exception.NaoEncontradoException;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {

    // Lista de usuarios
    private final List<Usuario> usuarioList = new ArrayList<>();

    private final UsuarioJpaRepository repository;

    //Injetar a dependencia no construtor
    public  UsuarioRestController(UsuarioJpaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/dummy")
    public Usuario dummyUsuario() {
        return new Usuario(UUID.randomUUID(), "Marina", "marinasgv@hotmail.com", LocalDate.now());
    }
    // CRUD = Create, Read, Update,      Delete
    // HTTP = POST,   GET,  PUT, PATCH,  DELETE

    @GetMapping
    public List<Usuario> listarTodos() {
        return this.repository
                //SELECT * (vai buscar todos os registros que estiverem na tabela)
                .findAll();
    }


    //{será como uma variavel (@PathVariable). Precisa ser o mesmo nome de @PathVariable}
    @GetMapping("/{uuid}")
    public Usuario buscarUsuario(@PathVariable UUID uuid) {
        return this.repository.findAllByUuid(uuid)

//        return usuarioList.stream().filter(usuario ->
//                usuario.getUuid().equals(uuid)).findFirst()
//                //Quando nao encontra um objeto, lança uma exceção genérica
                .orElseThrow(() -> new NaoEncontradoException("Não foi possível encontrar o usuário"));
    }

    @PostMapping("/")
    public Usuario criarUsuario
        //O que tiver no corpo da requisição, vai transformar de JSON para Java
    (@RequestBody
     //Validação de erro
     @Valid
     Usuario usuario) {
        return this.repository.save(usuario);
//        this.usuarioList.add(usuario);
//        return usuario;
    }

    @GetMapping("/create-dummy")
    public Usuario createUsuario() {
        return new Usuario(UUID.randomUUID(), "Dummy", "dummy@hotmail.com", LocalDate.now());
    }

    @PutMapping("{uuid}")
    public Usuario atualizarUsuario(@PathVariable UUID uuid, @RequestBody
    //Validação de erro
    @Valid
    Usuario usuarioNovo) {
        //Verifica se o Uuid existe
        Usuario usuario = this.buscarUsuario(uuid);
//        this.usuarioList.set(this.usuarioList.indexOf(usuario), usuarioNovo);
//        return usuarioNovo;

        //Reaproveita o Uuid
        usuarioNovo.setId(usuario.getId());

        //Salva
        return this.repository.save(usuarioNovo);
    }

    @PatchMapping("/{uuid}/alterar-nome")
    public Usuario alterarNome(@PathVariable UUID uuid, @RequestBody Usuario usuarioAlterado) {
        //Buscar o usuario
        Usuario usuario = this.buscarUsuario(uuid);

        //Alterar o nome
        usuario.setNome(usuarioAlterado.getNome());
//        this.usuarioList.set(this.usuarioList.indexOf(usuario), usuarioAlterado);
//        return usuarioAlterado;
        this.usuarioList.set(this.usuarioList.indexOf(usuario), usuarioAlterado);
        return usuarioAlterado;
    }

    @Transactional //Abre uma transação para ele poder realizar o delete. Se não existir esse uuid, precisa desfazer
    @DeleteMapping("{uuid}")
    public void deletarUsuario(@PathVariable UUID uuid) {
//        this.usuarioList.removeIf(usuario -> usuario.getUuid().equals(uuid));
        this.repository.deleteByUuid(uuid);
    }

//Exception Handless
    //  Vai definir um metodo com essa anotação e no momento que acontecer aquela exceção no escopo desse controlador, ela vai ser capturada

//@ResponseStatus(HttpStatus.BAD_REQUEST)
//@ExceptionHandler(MethodArgumentNotValidException.class)
//public Map<String, String> handleValidationExceptions(@NotNull MethodArgumentNotValidException ex){
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            //Vai ver o campo que tem o erro
//            String fieldName = ((FieldError) error).getField();
//
//            //Vai ver qual a mensagem de erro
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//}
}
