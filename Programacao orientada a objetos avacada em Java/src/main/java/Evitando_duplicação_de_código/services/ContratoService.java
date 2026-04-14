package Evitando_duplicação_de_código.services;

import Evitando_duplicação_de_código.excecao.ContratoInvalidoException;
import Evitando_duplicação_de_código.modelos.contratos.Contrato;
import Evitando_duplicação_de_código.repository.interfaces.ContratoRepository;
import Evitando_duplicação_de_código.repository.interfaces.ContratoValidator;

public class ContratoService {
    private final ContratoRepository contratoRepository;
    private final ContratoValidator contratoValidator;

    public ContratoService(ContratoRepository contratoRepository, ContratoValidator contratoValidator) {
        this.contratoRepository = contratoRepository;
        this.contratoValidator = contratoValidator;
    }

    public void salvarContrato(Contrato contrato){
        try {
            contratoValidator.validarContrato(contrato);
            if (contrato == null){
                throw new ContratoInvalidoException("Contrato inválido", contrato);
            }
            contratoRepository.salvar(contrato);
        } catch (Exception e){
            System.out.println("Erro ao salvar contrato: " + e.getMessage());
        }
    }
}
