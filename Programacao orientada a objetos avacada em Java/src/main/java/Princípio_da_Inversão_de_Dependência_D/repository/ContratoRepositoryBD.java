package Princípio_da_Inversão_de_Dependência_D.repository;

import Princípio_da_Inversão_de_Dependência_D.modelos.contratos.Contrato;
import Princípio_da_Inversão_de_Dependência_D.repository.interfaces.ContratoRepository;

public class ContratoRepositoryBD implements ContratoRepository {
    @Override
    public void salvar(Contrato contrato) {
        System.out.println("Contrato salvo no banco de dados: " + contrato);
    }
}
