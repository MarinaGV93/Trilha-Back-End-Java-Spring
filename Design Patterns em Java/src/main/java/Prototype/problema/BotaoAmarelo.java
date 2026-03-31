package Prototype.problema;

import Prototype.Botao;
import Prototype.TipoBordaEnum;

public class BotaoAmarelo extends Botao {
    public BotaoAmarelo(){
        setCor("Amarelo");
        setLargura(40);
        setAltura(100);
        setTipoBorda(TipoBordaEnum.TRACEJADA);
    }
}
