package figures

class PoligonFactory(
    private val vertices: List<Punt>,
    private val color: String,
    private val colorVora: String
) : FiguraFactory {
    override fun createFigura(): Figura {
        return Poligon(vertices, color, colorVora)
    }
}
