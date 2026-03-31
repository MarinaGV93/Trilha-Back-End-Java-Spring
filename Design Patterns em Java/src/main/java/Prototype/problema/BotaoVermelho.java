package Prototype.problema;

import Prototype.Botao;
import Prototype.TipoBordaEnum;

public class BotaoVermelho extends Botao {

    public BotaoVermelho(){
        setCor("Vermelho");
        setLargura(30);
        setAltura(100);
        setTipoBorda(TipoBordaEnum.FINA);
    }
}
