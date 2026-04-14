package E_se_algo_falhar.repository;

import E_se_algo_falhar.modelos.contratos.Contrato;
import E_se_algo_falhar.repository.interfaces.ContratoRepository;

public class ContratoRepositoryArquivo implements ContratoRepository {

    @Override
    public void salvar(Contrato contrato) {
        // try {
            System.out.println("Contrato salvo no arquivo:  " + contrato);
        // } catch (Exception e) {
        //     System.out.println("Erro ao salvar contrato em arquivo: " + e.getMessage());
        // }
    }
}
