package figures

class Poligon(
    private var vertices: List<Punt>,
    color: String = "#000000",
    colorVora: String = "#000000"
) : Figura(vertices[0], color, colorVora) {

    override fun renderText(): String {
        val verticesStr = vertices.joinToString("; ") { "(${it.x}, ${it.y})" }
        return "Polígono con vértices: $verticesStr y color $color"
    }

    override fun renderXML(): String {
        var myString = "";
        val pointsStr = vertices.joinToString(" ") { "${it.x},${it.y}" }

        for (p in vertices) {

        }

        return """
            <polygon points="$pointsStr" fill="$color" stroke="$colorVora" />
        """.trimIndent()
    }
}
