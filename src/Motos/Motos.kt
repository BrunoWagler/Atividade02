package Motos

class Motos(
    var modelo: String,
    var anoMotos: Int,
    var cor: String,
    var velocidade_maxima: Int,
    var valorMoto: Double
) {
    override fun toString(): String {
        return "Modelo: $modelo, Ano: $anoMotos, Cor: $cor, Velocidade Máxima: $velocidade_maxima km/h, Valor: R$ $valorMoto"
    }
}
