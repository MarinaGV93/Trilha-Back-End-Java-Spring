package Adapter.solucao;

import Adapter.problema.JarOperacoesContaCorrente;

import java.math.BigDecimal;

public class ClientJarOperacoesContaCorrenteAdapter {
    private JarOperacoesContaCorrente jarContaAdapter;

    public ClientJarOperacoesContaCorrenteAdapter(JarOperacoesContaCorrente jocc) {
        this.jarContaAdapter = jocc;
    }

    public void saca(BigDecimal valorPretendido){
        jarContaAdapter.saca(valorPretendido);
    }

    public void deposita(BigDecimal valor){
        jarContaAdapter.deposita(valor);
    }
}
