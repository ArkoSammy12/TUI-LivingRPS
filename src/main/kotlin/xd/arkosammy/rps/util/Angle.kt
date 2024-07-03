package xd.arkosammy.rps.util

@JvmInline
value class Angle(val degrees: Double) {

    val radians: Double
        get() = Math.toRadians(degrees)

    operator fun plus(other: Angle) : Angle = Angle((this.degrees + other.degrees) % 360)
    operator fun minus(other: Angle) : Angle = Angle((this.degrees - other.degrees) % 360)


}