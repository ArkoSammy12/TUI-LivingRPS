package xd.arkosammy.rps.entities

import com.googlecode.lanterna.TextCharacter
import xd.arkosammy.rps.sim.Constants
import xd.arkosammy.rps.sim.SimState
import xd.arkosammy.rps.util.Vec2d
import xd.arkosammy.screen.ScreenElement
import xd.arkosammy.screen.ScreenElementsSupplier

sealed class RPSEntity(val mass: Double, protected var _pos: Vec2d, protected var velocity: Vec2d = Vec2d(0.0, 0.0), protected var acceleration: Vec2d = Vec2d(0.0, 0.0)) : ScreenElementsSupplier {

    val pos: Vec2d
        get() = this._pos

    fun tick(simState: SimState) {

        var newAcceleration = Vec2d(this.acceleration.x, this.acceleration.y)

        // Calculate attraction for this entity by comparing it with every other entity
        for (entity: RPSEntity in simState.entities) {
            if (this.isNeutralTo(entity)) {
                continue
            }
            val relativeDirection: Vec2d = entity._pos.relativeTo(entity._pos).toNormalized()
            var celerity: Double = Constants.GRAVITATIONAL_CONSTANT * ((this.mass * entity.mass) / (this._pos.squaredDistanceTo(entity._pos)))
            if (this.isRepelledBy(entity)) {
                celerity = -celerity
            }
            val acceleration: Vec2d = relativeDirection.scale(celerity)
            newAcceleration += acceleration
        }

        this.acceleration = newAcceleration
    }

    private fun move(simState: SimState) {

        val newPos : Vec2d = this._pos + this.velocity

        // TODO: Implement out of bounds check
        if (simState.getEntity(newPos) != null) {
            this.velocity = Vec2d(0.0, 0.0)
            return
        }

        this._pos = newPos

    }

    abstract fun isNeutralTo(other: RPSEntity) : Boolean

    abstract fun isRepelledBy(other: RPSEntity) : Boolean

    abstract fun getGraphic() : TextCharacter

    abstract fun copy() : RPSEntity

    override fun get(): List<ScreenElement> {
        return listOf(ScreenElement(this._pos.toRounded(), this.getGraphic()))
    }

}