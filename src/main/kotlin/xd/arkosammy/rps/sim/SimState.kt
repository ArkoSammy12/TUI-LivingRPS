package xd.arkosammy.rps.sim

import xd.arkosammy.rps.entities.RPSEntity
import xd.arkosammy.rps.util.Vec2d
import xd.arkosammy.screen.ScreenElement
import xd.arkosammy.screen.ScreenElementsSupplier

class SimState : ScreenElementsSupplier {

    val entities: List<RPSEntity>
        get() = this.readOnlyBuffer.map { entity -> entity.copy() }.toList()

    private var readOnlyBuffer: MutableList<RPSEntity> = mutableListOf()
    private var writeBuffer: MutableList<RPSEntity> = mutableListOf()

    fun refresh() {
        readOnlyBuffer.clear()
        readOnlyBuffer.addAll(writeBuffer.map { entity -> entity.copy() }.toList())
    }

    fun getEntity(pos: Vec2d) : RPSEntity? {
        for (entity: RPSEntity in this.readOnlyBuffer) {
            if (entity.pos.toRounded() == pos.toRounded()) {
                return entity
            }
        }
        return null
    }

    fun update(function: (SimState, RPSEntity) -> Unit) {
        for (entity: RPSEntity in this.writeBuffer) {
            function(this, entity)
        }
    }

    override fun get(): List<ScreenElement> {
        val screenElements: MutableList<ScreenElement> = mutableListOf()
        for (entity: RPSEntity in this.readOnlyBuffer) {
            screenElements += entity.get()
        }
        return screenElements.toList()
    }

}



