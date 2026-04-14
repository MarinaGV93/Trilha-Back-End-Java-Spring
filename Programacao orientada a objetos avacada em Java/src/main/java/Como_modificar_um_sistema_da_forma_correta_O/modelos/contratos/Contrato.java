package Como_modificar_um_sistema_da_forma_correta_O.modelos.contratos;

import java.util.ArrayList;
import java.util.List;

public class Contrato {

    private static int contadorNumeroContrato = 0;
    public Integer numeroContrato;
    protected List<String> pessoasEnvolvidas;

    public Contrato(List<String> pessoasEnvolvidas) {
        this.numeroContrato = ++contadorNumeroContrato;
        this.pessoasEnvolvidas = new ArrayList<String>();
    }
}
