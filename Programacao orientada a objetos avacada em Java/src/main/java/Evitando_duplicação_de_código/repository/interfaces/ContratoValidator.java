package Evitando_duplicação_de_código.repository.interfaces;

import Evitando_duplicação_de_código.excecao.ContratoInvalidoException;
import Evitando_duplicação_de_código.modelos.contratos.Contrato;

public interface ContratoValidator {
    default void validarContrato(Contrato contrato) throws ContratoInvalidoException {
        if (contrato == null
                || contrato.getPessoasEnvolvidas().size() < 3
        ){
            throw new ContratoInvalidoException("Contrato inválido", contrato);
        }
    }
}
