package figures

class LiniaFactory(
    private val x1: Int,
    private val y1: Int,
    private val x2: Int,
    private val y2: Int,
    private val colorVora: String
) : FiguraFactory {
    override fun createFigura(): Figura {
        return Linia(x1, y1, x2, y2, colorVora)
    }
}
