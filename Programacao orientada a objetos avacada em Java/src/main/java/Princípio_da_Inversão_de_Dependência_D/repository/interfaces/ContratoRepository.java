package Princípio_da_Inversão_de_Dependência_D.repository.interfaces;

import Princípio_da_Inversão_de_Dependência_D.modelos.contratos.Contrato;

public interface ContratoRepository {
    void salvar(Contrato contrato);
}
