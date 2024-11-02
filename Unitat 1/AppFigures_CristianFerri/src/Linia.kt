package figures

class Linia(
    private var x1: Int,
    private var y1: Int,
    private var x2: Int,
    private var y2: Int,
    colorVora: String = "#000000"
) : Figura(Punt(x1, y1), "#000000", colorVora) {

    override fun renderText(): String {
        return "Línea de ($x1, $y1) a ($x2, $y2) con color de borde $colorVora"
    }

    override fun renderXML(): String {
        return """
            <line x1="$x1" y1="$y1" x2="$x2" y2="$y2" stroke="$colorVora" />
        """.trimIndent()
    }
}
