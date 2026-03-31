package Strategy.solucao;

import Strategy.Funcionario;
import Strategy.TipoContratacaoEnum;

import java.math.BigDecimal;

public class ReajusteAnualSalarioComStrategy {
    public void calculaReajusteAnual(Funcionario funcionario, CalculadorReajusteAnualSalario calculador){

        //O calculador vai calcular o reajuste do funcionario
        calculador.calcularReajusteAnual(funcionario);
    }
}
