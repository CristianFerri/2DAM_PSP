package figures

class RectangleFactory(
    private val amplada: Int,
    private val altura: Int,
    private val x: Int,
    private val y: Int,
    private val color: String,
    private val colorVora: String
) : FiguraFactory {
    override fun createFigura(): Figura {
        return Rectangle(amplada, altura, x, y, color, colorVora)
    }
}
