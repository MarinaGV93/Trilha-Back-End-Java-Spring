package Strategy.solucao;

import Strategy.Funcionario;

import java.math.BigDecimal;

public class CalculadorReajusteAnualSalarioCooperativa implements CalculadorReajusteAnualSalario{
    @Override
    public void calcularReajusteAnual(Funcionario funcionario) {

        //Colocar a estrategia de reajuste para CLT
        BigDecimal salario = funcionario.getSalario();

        //Pega o salario e multiplica por 10%
        funcionario.setSalario(salario.add(salario.multiply(new BigDecimal("0.07"))));
    }
}
