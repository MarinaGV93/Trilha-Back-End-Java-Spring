/*
Vantagem:
    Proteger as regras de negócio
    Executa menos chamadas
    Adapta para uma necessidade que ainda nao foi atendida
 */

package Adapter.solucao;

import Adapter.problema.JarOperacoesContaCorrente;

import java.math.BigDecimal;

public class TesteOperacoesContaCorrenteAdapter {
    public static void main(String[] args) {
        JarOperacoesContaCorrente jarContaAdapter = new JarOperacoesContaCorrente();

        ClientJarOperacoesContaCorrenteAdapter client = new ClientJarOperacoesContaCorrenteAdapter(jarContaAdapter);

        BigDecimal valorPretendidoParaSaque = new BigDecimal(1000);

        client.saca(valorPretendidoParaSaque); // 1ª chamada

        client.deposita(new BigDecimal(500)); // 2ª chamada
    }
}
