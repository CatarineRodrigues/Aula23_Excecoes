package lista25_execoes.exerc3

import java.math.BigDecimal
import java.math.BigInteger


/*
g. Após a conversão o sistema deve mostrar a mensagem: “A [MOEDA] na cotação de hoje [DIA ATUAL]
está em [VALOR DA COTAÇÃO], o valor que pediu para converter de [VALOR INSERIDO] em reais é
R$[VALOR CONVERTIDO]”.
h. Por fim, o programa deve perguntar se a pessoa deseja fazer outra conversão.
i. Se sim, o programa reinicia.
ii. Se não, o programa encerra.*/

class ConversorMoedas {
    private var tipoMoeda = ""
    private var valorMoeda: BigDecimal = BigDecimal.ZERO
    private var valorConvertido: BigDecimal = BigDecimal.ZERO
    private var valorCotacao: BigDecimal = BigDecimal.ZERO

    fun inicioPrograma() {
        println("Boas vindas ao conversor de moedas")
        println("Qual moeda deseja converter?\n Dólar americano, Dólar canadense, Euro ou Libra Esterlina?")
        try {
            tipoMoeda = readln().lowercase()
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            println("Tipo de moeda inválido")
        }
        println("Lembrete: Este programa só converte para Real (R$)")
        println("Insira o valor a ser convertido: ")
        try {
            valorMoeda = readln().toBigDecimal()
            while (valorMoeda <= BigDecimal(0.0)) {
                println("Valor inválido, por favor, tente novamente")
                valorMoeda = readln().toBigDecimal()
            }
        } catch (exception: NumberFormatException) {
            println(exception.message)
            println("Para moeda, o valor monetário deve ser um número decimal")
        }
        conversor()
        println(
            "A moeda $tipoMoeda na cotação de hoje [DIA ATUAL] está em [VALOR DA COTAÇÃO], " +
                    "o valor que pediu para converter de $valorMoeda em reais é R$$valorConvertido"
        )
    }

    fun conversor(): BigDecimal {
        when (tipoMoeda) {
            "Dólar americano" -> valorCotacao = BigDecimal(5.14)
            "dólar canadense" -> valorCotacao = BigDecimal(3.96)
            "euro" -> valorCotacao = BigDecimal(5.41)
            "libra esterlina" -> valorCotacao = BigDecimal(6.29)
        }
        valorConvertido = (valorMoeda * valorCotacao)

        return valorConvertido
    }

}/*

f. Após as entradas, o sistema deve fazer a devida conversão da moeda escolhida para Real (R$) de
acordo com a cotação do dia. Você pode pegar o valor do dia no google e deixar estática em alguma
parte da aplicação.
*/