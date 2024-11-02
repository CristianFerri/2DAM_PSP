package figures

class Rectangle(
    private var amplada: Int,
    private var altura: Int,
    x: Int = 0,
    y: Int = 0,
    color: String = "#000000",
    colorVora: String = "#000000"
) : Figura(Punt(x, y), color, colorVora) {

    override fun renderText(): String {
        return "Rectángulo en (${posicio.x}, ${posicio.y}) de amplada $amplada y altura $altura y color $color"
    }

    override fun renderXML(): String {
        return """
            <rect x="${posicio.x}" y="${posicio.y}" width="$amplada" height="$altura" fill="$color" stroke="$colorVora" />
        """.trimIndent()
    }
}
