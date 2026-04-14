package Princípio_da_Inversão_de_Dependência_D.services;

import Princípio_da_Inversão_de_Dependência_D.modelos.contratos.Contrato;
import Princípio_da_Inversão_de_Dependência_D.repository.ContratoRepositoryArquivo;
import Princípio_da_Inversão_de_Dependência_D.repository.interfaces.ContratoRepository;

public class ContratoService {
    private final ContratoRepository contratoRepository;
    // private final ContratoRepositoryBD contratoRepositoryBD;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
        // this.contratoRepositoryBD = contratoRepositoryBD;
    }

    public void salvarContrato(Contrato contrato){
        contratoRepository.salvar(contrato);
    }

    // public void salvarContratoBD(String contrato){
    //     contratoRepositoryBD.salvar(contrato);
    // }
}
