public class Virtual_Threads {
/*
Representam uma mudança significativa no modelo de concorrência do Java.
Uma thread virtual é uma thread gerenciada pela JVM e não pelo SO diretamente. É mais leve, o que permite criar um número muito maior de threads, sem consumir tantos recursos.
Cada thread virtual só vai alocar uma thread do SO quando ela estiver em execução. Se não tiver em execução, economiza recursos durante a sua ociosidade

Threads nativas:
    Gerenciadas pelo SO
    Possuem alto custo para criação e destruição
    A criação de muitas threads pode sobrecarregar o SO

Virtual Threads:
    Gerenciadas pela JVM
    Criadas com baixo custo de recursos
    Permitem crias milhares ou até milhões de threads sem sobrecarregar o SO

    Vantagens:
        Escalabilidade
        Otimização de recursos
        Facilidade no uso de threads
 */
/*

public class ExemploVirtualThreads {
    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
             //Criar thread virtual
            Thread.ofVirtual().start(() -> {
                try{
                    //Executar
                    System.out.println("Executando Thread: " + Thread.currentThread()
                            //imprimindo o nome dela
                            //.getName()
                    );

                    //"Dormir" em 1s
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //Disparar o sinal de interrupção
                    Thread.currentThread().interrupt();
                }
            });
        }

        try {
            //Para aguardar a execução das 100 threads
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
 */
}
