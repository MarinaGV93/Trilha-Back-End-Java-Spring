package Aulas;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Data_e_Hora {

/*
Usar java.time

Principais classes:

    LocalDate: 2025-03-17 (data)
    LocalTime: 15:30 (hora)
    LocalDateTime: 2025-03-17T15:30 (data e hora)
    ZonedDateTime: 2025-03-17T15:30+01:00[Europe/Paris] (data, hora e fuso horário)
 */

    public class ExemploDataHora {
        public static void main(String[] args){
            //Usar .construtor
            LocalDate dataAtual = LocalDate.now();
            System.out.println(dataAtual);

            LocalDateTime dataHoraAtual = LocalDateTime.now();
            System.out.println(dataHoraAtual);
        }
    }

/*
Representações temporais

    ZonedDateTime: Representação de data e hora com timezones, que segue o padrão ISO 8601
    Duration: Representa um intervalo de tempo em termos de segundos e nanossegundos
    Period: Representa um intervalo de tempo em termos de anos, meses e dias
 */

    public class ExemploZonedDateTime {
        public static void main(String[] args){

            ZonedDateTime zonedDateTime  = ZonedDateTime.now();
            System.out.println(zonedDateTime);

            Duration duration = Duration
                    //Indica a quantidade de horas daquela duração
                    .ofHours(6);
            System.out.println(duration);
            System.out.println(zonedDateTime
                    //Somar horas
                    .plus(duration));

            LocalDate dataNascimento = LocalDate.of(1993, 9, 21);


            Period period = Period
                    //Calcular a diferença
                    .between(dataNascimento, LocalDate.now());
            System.out.println(period.getYears());
        }
    }

/*
Cálculos com tempo
    Duration e Period podem ser usadas para calcular.
    Duration = ideal para medir intervalos de tempo em segundo e nanosegundos.
    Period = mais adequado para calcular intervalos em anos, meses e dias.
 */

    public class ExemploCalculosTempo {
        public static void main(String[] args){
            LocalDateTime agora = LocalDateTime.now();
            LocalDateTime futuro = agora
                    //Somar 10 dias
                    .plusDays(10);

            Duration duracao = Duration.between(agora, futuro);
            System.out.println(duracao.toDays());

            LocalDate dataHoje = LocalDate.now();

            //Ultimo dia do ano
            LocalDate dataFim = LocalDate.of(2025, 12, 31);
            Period period = Period.between(dataHoje, dataFim);
            System.out.println(period.getMonths());

            //Irá quebrar
            //System.out.println(duracao.between(dataHoje, dataFim).toDays());
            //Diferença entre dias, minutos, segundos ...
            System.out.println(ChronoUnit.DAYS.between(dataHoje, dataFim));
        }
    }

/*
Tempo computacional
    Representa a precisao de milisegundos ou nanossegundos

    Instant: Representa um ponto específico no tempo (um instante) e é baseado no número de segundos desde a era Unix (1970-01-01T00:00:00Z)
    Duration: Para medir a diferença entre dois instantes de tempo.
 */

    public class ExemploInstant {
        public static void main(String[] args) throws InterruptedException {
            Instant inicio = Instant.now();

            //Pause por algum tempo, mas nao tem uma garantia desse tempo
            Thread.sleep(2000);

            Instant fim = Instant.now();
            Duration duracao = Duration.between(inicio, fim);
            System.out.println(duracao
                    //Milisegundos
                    .toMillis());
        }
    }
}
