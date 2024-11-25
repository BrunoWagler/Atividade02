import Carros.Carros
import Motos.Motos

fun main() {
    val listaMotos = mutableListOf<Motos>()
    val listaCarros = mutableListOf<Carros>()

    while (true) {
        println("Menu:")
        println("1 - Criar e inserir carro")
        println("2 - Criar e inserir moto")
        println("3 - Mostrar todos os carros de cor azul")
        println("4 - Mostrar todas as motos de cor rosa")
        println("5 - Mostrar o carro mais caro")
        println("6 - Mostrar a moto mais cara")
        println("7 - Alterar o valor de um carro")
        println("8 - Remover uma moto da lista")
        println("9 - Sair")
        val opcao = readLine()?.toIntOrNull()

        when (opcao) {
            1 -> {
                println("Digite o modelo do carro:")
                val modelo = readLine() ?: ""
                println("Digite a quantidade de portas:")
                val quantidadePortas = readLine()?.toIntOrNull() ?: 0
                println("Digite o tipo de cambio (true para automático/false para convencional):")
                val cambio = readLine()?.toBoolean() ?: false
                println("Digite a cor do carro:")
                val cor = readLine() ?: ""
                println("O carro tem direção hidráulica (true para sim/false para não)?")
                val direcaoHidraulica = readLine()?.toBoolean() ?: false
                println("Digite o valor do carro:")
                val valor = readLine()?.toDoubleOrNull() ?: 0.0
                listaCarros.add(Carros(modelo, quantidadePortas, cambio, cor, direcaoHidraulica, valor))
            }
            2 -> {
                println("Digite o modelo da moto:")
                val modelo = readLine() ?: ""
                println("Digite o ano de fabricação:")
                val anoFabricacao = readLine()?.toIntOrNull() ?: 0
                println("Digite a cor da moto:")
                val cor = readLine() ?: ""
                println("Digite a velocidade máxima:")
                val velocidadeMaxima = readLine()?.toIntOrNull() ?: 0
                println("Digite o valor da moto:")
                val valor = readLine()?.toDoubleOrNull() ?: 0.0
                listaMotos.add(Motos(modelo, anoFabricacao, cor, velocidadeMaxima, valor))
            }
            3 -> {
                val carrosAzuis = listaCarros.filter { it.corCarro.equals("azul", ignoreCase = true) }
                if (carrosAzuis.isEmpty()) {
                    println("Nenhum carro de cor azul encontrado.")
                } else {
                    carrosAzuis.forEach { println(it) }
                }
            }
            4 -> {
                val motosRosas = listaMotos.filter { it.cor.equals("rosa", ignoreCase = true) }
                if (motosRosas.isEmpty()) {
                    println("Nenhuma moto de cor rosa encontrada.")
                } else {
                    motosRosas.forEach { println(it) }
                }
            }
            5 -> {
                val carroMaisCaro = listaCarros.maxByOrNull { it.valorCarro }
                if (carroMaisCaro != null) {
                    println("Carro mais caro: $carroMaisCaro")
                } else {
                    println("Nenhum carro encontrado.")
                }
            }
            6 -> {
                val motoMaisCara = listaMotos.maxByOrNull { it.valorMoto }
                if (motoMaisCara != null) {
                    println("Moto mais cara: $motoMaisCara")
                } else {
                    println("Nenhuma moto encontrada.")
                }
            }
            7 -> {
                println("Digite o modelo do carro que deseja alterar o valor:")
                val modelo = readLine() ?: ""
                val carro = listaCarros.find { it.modeloCarro.equals(modelo, ignoreCase = true) }
                if (carro != null) {
                    println("Digite o novo valor:")
                    val novoValor = readLine()?.toDoubleOrNull()
                    if (novoValor != null) {
                        carro.valorCarro = novoValor
                        println("Valor do carro atualizado com sucesso.")
                    } else {
                        println("Valor inválido.")
                    }
                } else {
                    println("Carro não encontrado.")
                }
            }
            8 -> {
                println("Digite o modelo da moto que deseja remover:")
                val modelo = readLine() ?: ""
                val motoRemovida = listaMotos.removeIf { it.modelo.equals(modelo, ignoreCase = true) }
                if (motoRemovida) {
                    println("Moto removida com sucesso.")
                } else {
                    println("Moto não encontrada.")
                }
            }
            9 -> {
                println("Saindo do sistema...")
                break
            }
            else -> println("Opção inválida, tente novamente.")
        }
    }
}
