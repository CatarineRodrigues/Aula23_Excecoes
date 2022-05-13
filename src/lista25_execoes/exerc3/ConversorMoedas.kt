package lista25_execoes.exerc3

import java.math.BigDecimal
import kotlin.system.exitProcess

class ConversorMoedas {

    fun inicioPrograma() {
        println("Boas vindas ao conversor de moedas")
        val tipoMoeda = pedirTipoMoeda()
        println("Lembrete: Este programa só converte para Real (R$)")
        val valorMoeda = armazenaValorMoeda()
        val valorCotacao = valorContacaoMoedas(tipoMoeda.toString())
        val valorConvertido = converterMoedas(valorMoeda, valorCotacao)
        exibirValorConvertido(tipoMoeda.toString(), valorCotacao, valorMoeda, valorConvertido)
        perguntaRodarNovamente()
    }

    private fun pedirTipoMoeda() {
        var tipoMoedaInvalida = false

        println(MSG_TIPO_MOEDA)
        try {
            val tipoMoeda = readln().lowercase()
            when {
                tipoMoeda != "dólar americano" || tipoMoeda != "dólar canadense" || tipoMoeda != "euro" || tipoMoeda != "libra esterlina" -> {
                    tipoMoedaInvalida = true
                }
            }
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            if (tipoMoedaInvalida) {
                println(MSG_OPCAO_INVALIDA)
            }
            this.pedirTipoMoeda()
        }
    }

    private fun armazenaValorMoeda(): BigDecimal {
        println("Insira o valor a ser convertido: ")
        return try {
            var valorMoeda = readln().toBigDecimal()
            while (valorMoeda <= BigDecimal(0.0)) {
                println("Valor inválido, por favor, tente novamente")
                valorMoeda = readln().toBigDecimal()
            }
            valorMoeda
        } catch (exception: NumberFormatException) {
            println(exception.message)
            println("Para moeda, o valor monetário deve ser um número decimal")
            this.armazenaValorMoeda()
        }
    }

    private fun valorContacaoMoedas(tipoMoeda: String): BigDecimal {
        var valorCotacao: BigDecimal = BigDecimal.ZERO
        when (tipoMoeda) {
            DOLLAR_AMERICANO -> valorCotacao = COTACAO_DOLLAR_AMERICANO.toBigDecimal()
            DOLLAR_CANADENSE -> valorCotacao = COTACAO_DOLLAR_CANADENSE.toBigDecimal()
            EURO -> valorCotacao = COTACAO_EURO.toBigDecimal()
            LIBRA -> valorCotacao = COTACAO_LIBRA_ESTERLINA.toBigDecimal()
        }
        return valorCotacao
    }

    private fun converterMoedas(valorMoeda: BigDecimal, valorCotacao: BigDecimal) = (valorMoeda * valorCotacao)

    private fun exibirValorConvertido(
        tipoMoeda: String,
        valorCotacao: BigDecimal,
        valorMoeda: BigDecimal,
        valorConvertido: BigDecimal
    ) {
        println("A moeda $tipoMoeda na cotação de hoje está em $$valorCotacao, o valor que pediu para converter de $valorMoeda em reais é R$$valorConvertido")
    }

    private fun perguntaRodarNovamente() {
        try {
            println(MSG_DESEJA_NOVA_COTACAO)
            println("1-SIM ou 2-NÃO/SAIR")
            when (readln().uppercase()) {
                "1", "SIM" -> inicioPrograma()
                "2", "NÃO", "NAO", "SAIR" -> {
                    println("Obrigado por usar nosso sistema!")
                    exitProcess(0)
                }
                else -> perguntaRodarNovamente()
            }
        } catch (e: Exception) {
            println(MSG_OPCAO_INVALIDA)
            perguntaRodarNovamente()
        }
    }
}