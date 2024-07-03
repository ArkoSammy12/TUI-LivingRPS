package xd.arkosammy.rps.entities

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.TextColor
import xd.arkosammy.rps.util.Vec2d

class Rock(pos: Vec2d, velocity: Vec2d = Vec2d(0.0, 0.0), acceleration: Vec2d = Vec2d(0.0, 0.0)) : RPSEntity(MASS, pos, velocity, acceleration) {

    override fun isNeutralTo(other: RPSEntity): Boolean =
        when (other) {
            is Rock -> true
            is Paper, is Scissors -> false
        }

    override fun isRepelledBy(other: RPSEntity): Boolean =
        when (other) {
            is Paper -> true
            is Rock, is Scissors -> false
        }

    override fun getGraphic(): TextCharacter =
        TextCharacter.fromCharacter('O', TextColor.ANSI.RED, TextColor.ANSI.BLACK)[0]

    override fun copy(): RPSEntity = Rock(this.pos, this.velocity, this.acceleration)

    companion object {

        const val MASS: Double = 1.0

    }


}