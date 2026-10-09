class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Transforming, Figure(0) {
    var color: Int = -1

    lateinit var name: String
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    init {
        require(width > 0) { "Width must be positive" }
        require(height > 0) { "Height must be positive" }
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun area(): Float {
        return (width*height).toFloat()
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) { "Zoom must be positive" }
        width *= zoom
        height *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val oldX = x
        val oldY = y
        val oldWidth = width
        val oldHeight = height

        if (direction == RotateDirection.Clockwise) {
            x = centerX + oldY - centerY
            y = centerY - oldX - oldWidth + centerX
        } else {
            x = centerX - oldY - oldHeight + centerY
            y = centerY + oldX - centerX
        }

        width = oldHeight
        height = oldWidth
    }

    override fun toString(): String {
        return "Rect: x=$x, y=$y, width=$width, height=$height, area=${area()}"
    }
}
