package lista25_execoes.exerc1

class CalculoMatematico {

    fun divisao(dividendo: Int, divisor: Int): Int {
        var resultado = 0
        try {
            resultado = dividendo / divisor
        } catch (e: ArithmeticException) {
            println("A operação não pode ser realizada")
            println(e.message)
        }
        return resultado
    }

}