package FactoryMethod.solucao;

import FactoryMethod.Produto;
import FactoryMethod.ProdutoDigital;
import FactoryMethod.ProdutoFisico;
import FactoryMethod.TipoProdutoEnum;

//Responsavel por fornecer uma instancia de um produto
public class ProdutoFactory {
    public static Produto getInstance(
            //Recebe varios tipos de produtos
            TipoProdutoEnum tipoProdutoEnum) {
        switch (tipoProdutoEnum) {

            //Se fisico
            case FISICO:
                ProdutoFisico produtoFisico = new ProdutoFisico();
                produtoFisico.setPossuiDimensoesFisicas(true);
                return produtoFisico;

                //Se digital
            case DIGITAL:
                ProdutoDigital produtoDigital = new ProdutoDigital();
                produtoDigital.setPossuiDimensoesFisicas(false);
                return produtoDigital;

                //Se for outro tipo

            default:
                //Exceção
                throw new IllegalArgumentException("Tipo de produto inválidos");
        }
    }
}
