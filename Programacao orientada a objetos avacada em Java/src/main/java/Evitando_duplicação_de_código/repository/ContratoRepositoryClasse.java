package Evitando_duplicação_de_código.repository;

import Evitando_duplicação_de_código.excecao.ContratoInvalidoException;
import Evitando_duplicação_de_código.modelos.contratos.Contrato;
import Evitando_duplicação_de_código.repository.interfaces.ContratoRepository;
import Evitando_duplicação_de_código.repository.interfaces.ContratoValidator;

public class ContratoRepositoryClasse implements ContratoRepository, ContratoValidator {
    @Override
    public void salvar(Contrato contrato) {
        // if (contrato == null || contrato.getPessoasEnvolvidas().size() < 3){
        //     throw new ContratoInvalidoException(contrato);
        // }
        System.out.println("Contrato salvo: " + contrato);
    }
}
