package xd.arkosammy.rps.util

import kotlin.math.cos
import kotlin.math.sin

class Polar2d(val magnitude: Double, val angle: Angle) {

    fun toCartesian() : Vec2d = Vec2d(magnitude * cos(angle.radians), magnitude * sin(angle.radians))

    operator fun plus(other: Polar2d) : Polar2d = (this.toCartesian() + other.toCartesian()).toPolar()
    operator fun minus(other: Polar2d) : Polar2d = (this.toCartesian() - other.toCartesian()).toPolar()

}