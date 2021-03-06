// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName")

package godot

import godot.annotation.GodotBaseType
import godot.core.RID
import godot.core.TransferContext
import godot.core.Transform
import godot.core.VariantArray
import godot.core.VariantType.ARRAY
import godot.core.VariantType.BOOL
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import godot.core.VariantType.OBJECT
import godot.core.VariantType.TRANSFORM
import godot.core.VariantType._RID
import godot.util.VoidPtr
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
open class PhysicsShapeQueryParameters : Reference() {
  open var collideWithAreas: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_GET_COLLIDE_WITH_AREAS, BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(value) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_SET_COLLIDE_WITH_AREAS, NIL)
    }

  open var collideWithBodies: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_GET_COLLIDE_WITH_BODIES, BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(value) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_SET_COLLIDE_WITH_BODIES, NIL)
    }

  open var collisionMask: Long
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_GET_COLLISION_MASK, LONG)
      return TransferContext.readReturnValue(LONG, false) as Long
    }
    set(value) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_SET_COLLISION_MASK, NIL)
    }

  open var exclude: VariantArray<Any?>
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_GET_EXCLUDE, ARRAY)
      return TransferContext.readReturnValue(ARRAY, false) as VariantArray<Any?>
    }
    set(value) {
      TransferContext.writeArguments(ARRAY to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_SET_EXCLUDE, NIL)
    }

  open var margin: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_GET_MARGIN, DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(value) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_SET_MARGIN, NIL)
    }

  open var shapeRid: RID
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_GET_SHAPE_RID, _RID)
      return TransferContext.readReturnValue(_RID, false) as RID
    }
    set(value) {
      TransferContext.writeArguments(_RID to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_SET_SHAPE_RID, NIL)
    }

  open var transform: Transform
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_GET_TRANSFORM, TRANSFORM)
      return TransferContext.readReturnValue(TRANSFORM, false) as Transform
    }
    set(value) {
      TransferContext.writeArguments(TRANSFORM to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_SET_TRANSFORM, NIL)
    }

  override fun __new(): VoidPtr =
      TransferContext.invokeConstructor(ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS)

  open fun transform(schedule: Transform.() -> Unit): Transform = transform.apply{
      schedule(this)
      transform = this
  }


  open fun setShape(shape: Resource) {
    TransferContext.writeArguments(OBJECT to shape)
    TransferContext.callMethod(rawPtr,
        ENGINEMETHOD_ENGINECLASS_PHYSICSSHAPEQUERYPARAMETERS_SET_SHAPE, NIL)
  }
}
