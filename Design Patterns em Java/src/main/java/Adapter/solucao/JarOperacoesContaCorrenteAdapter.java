package Adapter.solucao;

import Adapter.problema.JarOperacoesContaCorrente;
import java.math.BigDecimal;

public class JarOperacoesContaCorrenteAdapter {

    //Fazer composição para simular o uso do jar
    private JarOperacoesContaCorrente jarConta;

    public JarOperacoesContaCorrenteAdapter(JarOperacoesContaCorrente jarConta) {
        this.jarConta = jarConta;
    }

    public void saca(BigDecimal valorPretendido){
        //Validar o saldo
        if (jarConta.validaSaldo(valorPretendido)){
            //Sacar
            jarConta.saca(valorPretendido);
        } else {
            throw new IllegalArgumentException("Valor para saque maior que o saldo");
        }
    }

    public void deposita(BigDecimal valor){
        jarConta.deposita(valor);
    }
}
