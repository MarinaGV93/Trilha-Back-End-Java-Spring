package E_se_algo_falhar.repository;

import E_se_algo_falhar.modelos.contratos.Contrato;
import E_se_algo_falhar.repository.interfaces.ContratoRepository;

public class ContratoRepositoryBD implements ContratoRepository {
    @Override
    public void salvar(Contrato contrato) {
        System.out.println("Contrato salvo no banco de dados: " + contrato);
    }
}
