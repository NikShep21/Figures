class Square(
    var x: Int,
    var y: Int,
    var side: Int
) : Movable, Transforming, Figure(0) {

    init {
        require(side > 0) { "Side must be positive" }
    }

    override fun area(): Float {
        return (side * side).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) { "Zoom must be positive" }
        side *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val oldX = x
        val oldY = y

        if (direction == RotateDirection.Clockwise) {
            x = centerX + oldY - centerY
            y = centerY - oldX - side + centerX
        } else {
            x = centerX - oldY - side + centerY
            y = centerY + oldX - centerX
        }
    }

    override fun toString(): String {
        return "Square: x=$x, y=$y, side=$side, area=${area()}"
    }
}
