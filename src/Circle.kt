class Circle(
    var x: Int = 0,
    var y: Int = 0,
    var radius: Int = 1
) : Movable, Transforming, Figure(0) {

    init {
        require(radius > 0) { "Radius must be positive" }
    }

    override fun area(): Float {
        return (Math.PI * radius * radius).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) { "Zoom must be positive" }
        radius *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val oldX = x
        val oldY = y

        if (direction == RotateDirection.Clockwise) {
            x = centerX + oldY - centerY
            y = centerY - oldX + centerX
        } else {
            x = centerX - oldY + centerY
            y = centerY + oldX - centerX
        }
    }

    override fun toString(): String {
        return "Circle: x=$x, y=$y, radius=$radius, area=${area()}"
    }
}
