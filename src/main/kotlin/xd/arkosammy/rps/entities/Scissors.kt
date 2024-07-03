package xd.arkosammy.rps.entities

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.TextColor
import xd.arkosammy.rps.util.Vec2d

class Scissors(pos: Vec2d, velocity: Vec2d = Vec2d(0.0, 0.0), acceleration: Vec2d = Vec2d(0.0, 0.0)) : RPSEntity(MASS, pos, velocity, acceleration) {

    override fun isNeutralTo(other: RPSEntity): Boolean =
        when (other) {
            is Scissors -> true
            is Rock, is Paper -> false
        }

    override fun isRepelledBy(other: RPSEntity): Boolean =
        when (other) {
            is Rock -> true
            is Scissors, is Paper -> false
        }

    override fun getGraphic(): TextCharacter =
        TextCharacter.fromCharacter('V', TextColor.ANSI.BLUE, TextColor.ANSI.BLACK)[0]

    override fun copy(): RPSEntity = Scissors(this.pos, this.velocity, this.acceleration)

    companion object {

        const val MASS: Double = 1.0

    }


}