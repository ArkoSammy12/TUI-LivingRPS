package xd.arkosammy.rps.util

import kotlin.math.*

class Vec3i(val x: Int, val y: Int) {

    val magnitude: Double = sqrt(this.x.toDouble().pow(2) + this.y.toDouble().pow(2))

    operator fun plus(other: Vec3i) : Vec3i =
        Vec3i(this.x + other.x, this.y + other.y)

    operator fun minus(other: Vec3i) : Vec3i =
        Vec3i(this.x - other.x, this.y - other.y)

    fun distanceTo(other: Vec3i) : Double =
        sqrt((this.x - other.y).toDouble().pow(2.0) + (this.y - other.y).toDouble().pow(2.0))

    fun toNormalized() : Vec2d =
        Vec2d(this.x / magnitude, this.y / magnitude)

    fun scale(scalar: Int) : Vec3i = Vec3i(this.x * scalar, this.y * scalar)

    fun collidesWith(other: Vec3i) : Boolean = this == other

}