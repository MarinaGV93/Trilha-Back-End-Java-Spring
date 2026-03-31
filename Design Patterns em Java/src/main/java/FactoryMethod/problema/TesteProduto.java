package FactoryMethod.problema;

import FactoryMethod.ProdutoDigital;
import FactoryMethod.ProdutoFisico;

public class TesteProduto {
    public static void main(String[] args) {

        //Chamar os produtos manualmente
        ProdutoFisico produtoFisico = new ProdutoFisico();
        produtoFisico.setPossuiDimensoesFisicas(true);

        ProdutoDigital produtoDigital = new ProdutoDigital();
        produtoDigital.setPossuiDimensoesFisicas(false);
    }
}
