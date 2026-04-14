package Evitando_duplicação_de_código.excecao;

import Evitando_duplicação_de_código.modelos.contratos.Contrato;

public class ContratoInvalidoException extends RuntimeException{
    public ContratoInvalidoException(String contratoInválido, Contrato contrato) {
        super("[ERRO] Contrato inválido! Contrato = " + contrato);
    }
}
