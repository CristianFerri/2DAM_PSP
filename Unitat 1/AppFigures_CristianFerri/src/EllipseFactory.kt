package figures

class EllipseFactory(
    private val cx: Int,
    private val cy: Int,
    private val rx: Int,
    private val ry: Int,
    private val color: String,
    private val colorVora: String
) : FiguraFactory {
    override fun createFigura(): Figura {
        return Ellipse(cx, cy, rx, ry, color, colorVora)
    }
}
