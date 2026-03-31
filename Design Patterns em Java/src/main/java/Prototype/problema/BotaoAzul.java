package Prototype.problema;

import Prototype.Botao;
import Prototype.TipoBordaEnum;

public class BotaoAzul extends Botao {

    public BotaoAzul(){
        setCor("Azul");
        setLargura(35);
        setAltura(125);
        setTipoBorda(TipoBordaEnum.TRACEJADA);
    }
}
