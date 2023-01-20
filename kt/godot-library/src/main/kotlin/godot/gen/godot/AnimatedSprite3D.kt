// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.StringName
import godot.core.VariantType.BOOL
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import godot.core.VariantType.OBJECT
import godot.core.VariantType.STRING_NAME
import godot.core.memory.TransferContext
import godot.signals.Signal0
import godot.signals.signal
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit

/**
 * 2D sprite node in 3D world, that can use multiple 2D textures for animation.
 *
 * Tutorials:
 * [$DOCS_URL/tutorials/2d/2d_sprite_animation.html]($DOCS_URL/tutorials/2d/2d_sprite_animation.html)
 *
 * [godot.AnimatedSprite3D] is similar to the [godot.Sprite3D] node, except it carries multiple textures as animation [frames]. Animations are created using a [godot.SpriteFrames] resource, which allows you to import image files (or a folder containing said files) to provide the animation frames for the sprite. The [godot.SpriteFrames] resource can be configured in the editor via the SpriteFrames bottom panel.
 *
 * After setting up [frames], [play] may be called. It's also possible to select an [animation] and toggle [playing], even within the editor.
 *
 * To pause the current animation, set [playing] to `false`. Alternatively, setting [speedScale] to `0` also preserves the current frame's elapsed time.
 */
@GodotBaseType
public open class AnimatedSprite3D : SpriteBase3D() {
  /**
   * Emitted when [frame] changed.
   */
  public val frameChanged: Signal0 by signal()

  /**
   * Emitted when the animation reaches the end, or the start if it is played in reverse. If the animation is looping, this signal is emitted at the end of each loop.
   */
  public val animationFinished: Signal0 by signal()

  /**
   * The [godot.SpriteFrames] resource containing the animation(s).
   */
  public var frames: SpriteFrames?
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_GET_SPRITE_FRAMES, OBJECT)
      return TransferContext.readReturnValue(OBJECT, true) as SpriteFrames?
    }
    set(`value`) {
      TransferContext.writeArguments(OBJECT to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_SET_SPRITE_FRAMES, NIL)
    }

  /**
   * The current animation from the `frames` resource. If this value changes, the `frame` counter is reset.
   */
  public var animation: StringName
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_GET_ANIMATION,
          STRING_NAME)
      return TransferContext.readReturnValue(STRING_NAME, false) as StringName
    }
    set(`value`) {
      TransferContext.writeArguments(STRING_NAME to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_SET_ANIMATION,
          NIL)
    }

  /**
   * The displayed animation frame's index.
   */
  public var frame: Long
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_GET_FRAME, LONG)
      return TransferContext.readReturnValue(LONG, false) as Long
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_SET_FRAME, NIL)
    }

  /**
   * The animation speed is multiplied by this value. If set to a negative value, the animation is played in reverse. If set to `0`, the animation is paused, preserving the current frame's elapsed time.
   */
  public var speedScale: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_GET_SPEED_SCALE,
          DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_SET_SPEED_SCALE,
          NIL)
    }

  /**
   * If `true`, the [animation] is currently playing. Setting this property to `false` pauses the current animation. Use [stop] to stop the animation at the current frame instead.
   *
   * **Note:** Unlike [stop], changing this property to `false` preserves the current frame's elapsed time and the `backwards` flag of the current [animation] (if it was previously set by [play]).
   *
   * **Note:** After a non-looping animation finishes, the property still remains `true`.
   */
  public var playing: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_IS_PLAYING, BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(`value`) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_SET_PLAYING, NIL)
    }

  public override fun new(scriptIndex: Int): Boolean {
    callConstructor(ENGINECLASS_ANIMATEDSPRITE3D, scriptIndex)
    return true
  }

  /**
   * Plays the animation named [anim]. If no [anim] is provided, the current animation is played. If [backwards] is `true`, the animation is played in reverse.
   *
   * **Note:** If [speedScale] is negative, the animation direction specified by [backwards] will be inverted.
   */
  public fun play(anim: StringName = StringName(""), backwards: Boolean = false): Unit {
    TransferContext.writeArguments(STRING_NAME to anim, BOOL to backwards)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_PLAY, NIL)
  }

  /**
   * Stops the current [animation] at the current [frame].
   *
   * **Note:** This method resets the current frame's elapsed time and removes the `backwards` flag from the current [animation] (if it was previously set by [play]). If this behavior is undesired, set [playing] to `false` instead.
   */
  public fun stop(): Unit {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ANIMATEDSPRITE3D_STOP, NIL)
  }

  public companion object
}
