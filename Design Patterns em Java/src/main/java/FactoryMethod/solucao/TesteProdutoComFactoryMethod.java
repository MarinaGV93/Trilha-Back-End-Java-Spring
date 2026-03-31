/*
Vantagem:
    "Virtualiza" um construtor (Static Factory Method / Mét odo de fabrica de objetos). Uma fábrica de instancias.
    Deixa a responsabilidade de instanciar o objeto para a fábrica (factory).
 */

package FactoryMethod.solucao;

import FactoryMethod.Produto;
import FactoryMethod.TipoProdutoEnum;

public class TesteProdutoComFactoryMethod {
    public static void main(String[] args) {
        Produto produtoDigital = ProdutoFactory.getInstance(TipoProdutoEnum.DIGITAL);

        Produto produtoFisico = ProdutoFactory.getInstance(TipoProdutoEnum.FISICO);

        System.out.println("Produto digital: " + produtoDigital);
        System.out.println("Produto físico: " + produtoFisico);
    }
}
