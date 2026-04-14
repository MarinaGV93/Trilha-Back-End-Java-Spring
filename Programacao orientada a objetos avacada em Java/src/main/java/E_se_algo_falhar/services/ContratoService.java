package E_se_algo_falhar.services;

import E_se_algo_falhar.excecao.ContratoInvalidoException;
import E_se_algo_falhar.modelos.contratos.Contrato;
import E_se_algo_falhar.repository.interfaces.ContratoRepository;

public class ContratoService {
    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public void salvarContrato(Contrato contrato){
        try {
            if (contrato == null){
                throw new ContratoInvalidoException(contrato);
            }
            contratoRepository.salvar(contrato);
        } catch (Exception e){
            System.out.println("Erro ao salvar contrato: " + e.getMessage());
        }
    }
}
