package figures

import java.io.File

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Error! Has d'indicar el nom de fitxer d'entrada!")
        return
    }

    val fileName = args[0]
    val escena = readSceneFromFile(fileName)

    escena.renderText()
    escena.renderSVG("${args[0]}.svg")
}

fun readSceneFromFile(fileName: String): Escena {
    val file = File(fileName)
    val lines = file.readLines()

    if (lines.isEmpty()) {
        throw IllegalArgumentException("El fitxer està buit.")
    }

    // Primera línia conté les dimensions del SVG
    val dimensions = lines[0].split(" ")
    if (dimensions[0] != "dimensions") {
        throw IllegalArgumentException("El fitxer ha de començar amb la línia de dimensions.")
    }
    val width = dimensions[1].toInt()
    val height = dimensions[2].toInt()

    val escena = Escena(width, height)

    // Processar les línies restants per crear les figures
    for (line in lines.drop(1)) {
        val parts = line.split(" ")
        when (parts[0]) {
            "cercle" -> {
                val params = parts[1].split(",")
                val x = params[0].toInt()
                val y = params[1].toInt()
                val radi = params[2].toInt()
                val color = params[3]
                val colorVora = params[4]
                val cercle = CercleFactory(radi, x, y, color, colorVora)
                escena.addFigura(cercle)
            }
            "rectangle" -> {
                val params = parts[1].split(",")
                val x = params[0].toInt()
                val y = params[1].toInt()
                val amplada = params[2].toInt()
                val altura = params[3].toInt()
                val color = params[4]
                val colorVora = params[5]
                val rectangulo = RectangleFactory(amplada, altura, x, y, color, colorVora)
                escena.addFigura(rectangulo)
            }
            "linia" -> {
                val params = parts[1].split(",")
                val x1 = params[0].toInt()
                val y1 = params[1].toInt()
                val x2 = params[2].toInt()
                val y2 = params[3].toInt()
                val colorVora = params[4]
                val linia = LiniaFactory(x1, y1, x2, y2, colorVora)
                escena.addFigura(linia)
            }
            "ellipse" -> {
                val params = parts[1].split(",")
                val cx = params[0].toInt()
                val cy = params[1].toInt()
                val rx = params[2].toInt()
                val ry = params[3].toInt()
                val color = params[4]
                val colorVora = params[5]
                val elipse = EllipseFactory(cx, cy, rx, ry, color, colorVora)
                escena.addFigura(elipse)
            }
            "poligon" -> {
                val verticesStr = parts[1].split(";").toMutableList()
                val coloresStr = verticesStr.removeAt(verticesStr.size - 1)
                val vertices = verticesStr.map {
                    val coords = it.split(",")
                    Punt(coords[0].toInt(), coords[1].toInt())
                }

                val colores = coloresStr.split(",")
                val color = colores[0]
                val colorVora = colores[1]

                val poligon = PoligonFactory(vertices, color, colorVora)
                escena.addFigura(poligon)
            }
            else -> {
                println("Tipus de figura desconegut: ${parts[0]}")
            }
        }
    }

    return escena
}
