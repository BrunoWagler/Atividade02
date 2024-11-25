package Carros

class Carros(
    var modeloCarro: String,
    var quantidadeportas: Int,
    var cambio: Boolean,
    var corCarro: String,
    var direcaoHidraulica: Boolean,
    var valorCarro: Double
) {
    override fun toString(): String {
        val cambioTipo = if (cambio) "Automático" else "Convencional"
        val direcaoTipo = if (direcaoHidraulica) "Sim" else "Não"
        return "Modelo: $modeloCarro, Portas: $quantidadeportas, Câmbio: $cambioTipo, Cor: $corCarro, Direção Hidráulica: $direcaoTipo, Valor: R$ $valorCarro"
    }
}
