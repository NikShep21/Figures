fun main() {
    val rect = Rect(2, 2, 4, 2)
    val circle = Circle(1, 1, 2)
    val square = Square(-2, -2, 2)
    val figures: Array<Figure> = arrayOf(rect, circle, square)

    println("Initial figures:")
    figures.forEach { println(it) }

    rect.move(1, -1)
    circle.move(1, -1)
    square.move(1, -1)

    rect.resize(2)
    circle.resize(2)
    square.resize(2)

    println("\nAfter move and resize:")
    figures.forEach { println(it) }

    rect.rotate(RotateDirection.Clockwise, 0, 0)
    circle.rotate(RotateDirection.Clockwise, 0, 0)
    square.rotate(RotateDirection.Clockwise, 0, 0)

    println("\nAfter clockwise rotation around (0, 0):")
    figures.forEach { println(it) }

    rect.rotate(RotateDirection.CounterClockwise, 0, 0)
    circle.rotate(RotateDirection.CounterClockwise, 0, 0)
    square.rotate(RotateDirection.CounterClockwise, 0, 0)

    println("\nAfter counterclockwise rotation around (0, 0):")
    figures.forEach { println(it) }

}
