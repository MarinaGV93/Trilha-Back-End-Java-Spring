package tech.ada.java.curso_spring.api.Amizade;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@RestController
@RequestMapping("/amizades")
@RequiredArgsConstructor
public class AmizadeRestController {

    //Vai ter a regra de negócio
    private final AmizadeService service;

    @GetMapping
    public Page<AmizadeDTO> listarTodos(Pageable pageable) {
        return this.service.listarTodos(pageable);
    }

    @PostMapping("/{usuarioA}/{usuarioB}")
    public AmizadeDTO criarAmizade(@PathVariable UUID usuarioA, @PathVariable UUID usuarioB) {
        return this.service.criarAmizade(usuarioA, usuarioB);
    }
}
