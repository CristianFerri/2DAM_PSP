package figures

class Ellipse(
    private var cx: Int,
    private var cy: Int,
    private var rx: Int,
    private var ry: Int,
    color: String = "#000000",
    colorVora: String = "#000000"
) : Figura(Punt(cx, cy), color, colorVora) {

    override fun renderText(): String {
        return "Elipse en ($cx, $cy) con radio x $rx y radio y $ry y color $color"
    }

    override fun renderXML(): String {
        return """
            <ellipse cx="$cx" cy="$cy" rx="$rx" ry="$ry" fill="$color" stroke="$colorVora" />
        """.trimIndent()
    }
}
