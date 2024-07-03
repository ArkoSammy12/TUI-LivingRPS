package xd.arkosammy.rps.entities

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.TextColor
import xd.arkosammy.rps.util.Vec2d

class Paper(pos: Vec2d, velocity: Vec2d = Vec2d(0.0, 0.0), acceleration: Vec2d = Vec2d(0.0, 0.0)) : RPSEntity(MASS, pos, velocity, acceleration) {

    override fun isNeutralTo(other: RPSEntity): Boolean =
        when (other) {
            is Paper -> true
            is Scissors, is Rock -> false
        }

    override fun isRepelledBy(other: RPSEntity): Boolean =
        when (other) {
            is Scissors -> true
            is Paper, is Rock -> false
        }

    override fun getGraphic(): TextCharacter =
        TextCharacter.fromCharacter('P', TextColor.ANSI.YELLOW, TextColor.ANSI.BLACK)[0]

    override fun copy(): RPSEntity = Paper(this.velocity, this.pos, this.acceleration)

    companion object {

        const val MASS: Double = 1.0

    }


}