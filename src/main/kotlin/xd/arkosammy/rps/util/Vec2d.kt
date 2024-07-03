package xd.arkosammy.rps.util

import kotlin.math.*

data class Vec2d(val x: Double, val y: Double) {

    val magnitude: Double = sqrt(this.x.pow(2) + this.y.pow(2))

    operator fun plus(other: Vec2d) : Vec2d =
        Vec2d(this.x + other.x, this.y + other.y)

    operator fun minus(other: Vec2d) : Vec2d =
        Vec2d(this.x - other.x, this.y - other.y)

    fun distanceTo(other: Vec2d) : Double =
        sqrt((this.x - other.y).pow(2.0) + (this.y - other.y).pow(2.0))

    fun squaredDistanceTo(other: Vec2d) : Double =
        (this.x - other.x).pow(2.0) + (this.y - other.y).pow(2.0)

    fun toNormalized() : Vec2d =
        Vec2d(this.x / magnitude, this.y / magnitude)

    fun toPolar() : Polar2d =
        Polar2d(this.magnitude, Angle(tan(y / x)))

    fun scale(scalar: Double) : Vec2d = Vec2d(this.x * scalar, this.y * scalar)

    fun toFloored() : Vec3i = Vec3i(floor(this.x).toInt(), floor(this.y).toInt())

    fun toRounded() : Vec3i = Vec3i(round(this.x).toInt(), round(this.y).toInt())

    fun collidesWith(other: Vec2d) : Boolean = this.toRounded() == other.toRounded()

    fun relativeTo(other: Vec2d) : Vec2d = Vec2d(this.x - other.x, this.y - other.y)

}