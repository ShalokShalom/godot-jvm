// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.Callable
import godot.core.Color
import godot.core.NodePath
import godot.core.Rect2
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantType.ANY
import godot.core.VariantType.BOOL
import godot.core.VariantType.CALLABLE
import godot.core.VariantType.COLOR
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.JVM_INT
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import godot.core.VariantType.NODE_PATH
import godot.core.VariantType.OBJECT
import godot.core.VariantType.RECT2
import godot.core.VariantType.STRING
import godot.core.VariantType.STRING_NAME
import godot.core.VariantType.VECTOR2
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.memory.TransferContext
import godot.signals.Signal0
import godot.signals.Signal1
import godot.signals.signal
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

/**
 * All user interface nodes inherit from Control. A control's anchors and offsets adapt its position and size relative to its parent.
 *
 * Tutorials:
 * [https://github.com/godotengine/godot-demo-projects/tree/master/gui](https://github.com/godotengine/godot-demo-projects/tree/master/gui)
 *
 * Base class for all UI-related nodes. [godot.Control] features a bounding rectangle that defines its extents, an anchor position relative to its parent control or the current viewport, and offsets relative to the anchor. The offsets update automatically when the node, any of its parents, or the screen size change.
 *
 * For more information on Godot's UI system, anchors, offsets, and containers, see the related tutorials in the manual. To build flexible UIs, you'll need a mix of UI elements that inherit from [godot.Control] and [godot.Container] nodes.
 *
 * **User Interface nodes and input**
 *
 * Godot propagates input events via viewports. Each [godot.Viewport] is responsible for propagating [godot.InputEvent]s to their child nodes. As the [godot.SceneTree.root] is a [godot.Window], this already happens automatically for all UI elements in your game.
 *
 * Input events are propagated through the [godot.SceneTree] from the root node to all child nodes by calling [godot.Node.Input]. For UI elements specifically, it makes more sense to override the virtual method [_guiInput], which filters out unrelated input events, such as by checking z-order, [mouseFilter], focus, or if the event was inside of the control's bounding box.
 *
 * Call [acceptEvent] so no other node receives the event. Once you accept an input, it becomes handled so [godot.Node.UnhandledInput] will not process it.
 *
 * Only one [godot.Control] node can be in focus. Only the node in focus will receive events. To get the focus, call [grabFocus]. [godot.Control] nodes lose focus when another node grabs it, or if you hide the node in focus.
 *
 * Sets [mouseFilter] to [MOUSE_FILTER_IGNORE] to tell a [godot.Control] node to ignore mouse or touch events. You'll need it if you place an icon on top of a button.
 *
 * [godot.Theme] resources change the Control's appearance. If you change the [godot.Theme] on a [godot.Control] node, it affects all of its children. To override some of the theme's parameters, call one of the `add_theme_*_override` methods, like [addThemeFontOverride]. You can override the theme with the Inspector.
 *
 * **Note:** Theme items are *not* [godot.Object] properties. This means you can't access their values using [godot.Object.get] and [godot.Object.set]. Instead, use the `get_theme_*` and `add_theme_*_override` methods provided by this class.
 */
@GodotBaseType
public open class Control : CanvasItem() {
  /**
   * Emitted when the control changes size.
   */
  public val resized: Signal0 by signal()

  /**
   * Emitted when the node receives an [godot.InputEvent].
   */
  public val guiInput: Signal1<InputEvent> by signal("event")

  /**
   * Emitted when the mouse enters the control's `Rect` area, provided its [mouseFilter] lets the event reach it.
   *
   * **Note:** [mouseEntered] will not be emitted if the mouse enters a child [godot.Control] node before entering the parent's `Rect` area, at least until the mouse is moved to reach the parent's `Rect` area.
   */
  public val mouseEntered: Signal0 by signal()

  /**
   * Emitted when the mouse leaves the control's `Rect` area, provided its [mouseFilter] lets the event reach it.
   *
   * **Note:** [mouseExited] will be emitted if the mouse enters a child [godot.Control] node, even if the mouse cursor is still inside the parent's `Rect` area.
   *
   * If you want to check whether the mouse truly left the area, ignoring any top nodes, you can use code like this:
   *
   * ```
   * 				func _on_mouse_exited():
   * 				    if not Rect2(Vector2(), size).has_point(get_local_mouse_position()):
   * 				        # Not hovering over area.
   * 				```
   */
  public val mouseExited: Signal0 by signal()

  /**
   * Emitted when the node gains focus.
   */
  public val focusEntered: Signal0 by signal()

  /**
   * Emitted when the node loses focus.
   */
  public val focusExited: Signal0 by signal()

  /**
   * Emitted when one of the size flags changes. See [sizeFlagsHorizontal] and [sizeFlagsVertical].
   */
  public val sizeFlagsChanged: Signal0 by signal()

  /**
   * Emitted when the node's minimum size changes.
   */
  public val minimumSizeChanged: Signal0 by signal()

  /**
   * Emitted when the [NOTIFICATION_THEME_CHANGED] notification is sent.
   */
  public val themeChanged: Signal0 by signal()

  /**
   * Enables whether rendering of [godot.CanvasItem] based children should be clipped to this control's rectangle. If `true`, parts of a child which would be visibly outside of this control's rectangle will not be rendered and won't receive input.
   */
  public var clipContents: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_IS_CLIPPING_CONTENTS,
          BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(`value`) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_CLIP_CONTENTS, NIL)
    }

  /**
   * The minimum size of the node's bounding rectangle. If you set it to a value greater than (0, 0), the node's bounding rectangle will always have at least this size, even if its content is smaller. If it's set to (0, 0), the node sizes automatically to fit its content, be it a texture or child nodes.
   */
  public var customMinimumSize: Vector2
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_CUSTOM_MINIMUM_SIZE,
          VECTOR2)
      return TransferContext.readReturnValue(VECTOR2, false) as Vector2
    }
    set(`value`) {
      TransferContext.writeArguments(VECTOR2 to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_CUSTOM_MINIMUM_SIZE,
          NIL)
    }

  /**
   * Controls layout direction and text writing direction. Right-to-left layouts are necessary for certain languages (e.g. Arabic and Hebrew).
   */
  public var layoutDirection: LayoutDirection
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_LAYOUT_DIRECTION,
          LONG)
      return Control.LayoutDirection.values()[TransferContext.readReturnValue(JVM_INT) as Int]
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_LAYOUT_DIRECTION, NIL)
    }

  /**
   * Controls the direction on the horizontal axis in which the control should grow if its horizontal minimum size is changed to be greater than its current size, as the control always has to be at least the minimum size.
   */
  public var growHorizontal: GrowDirection
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_H_GROW_DIRECTION,
          LONG)
      return Control.GrowDirection.values()[TransferContext.readReturnValue(JVM_INT) as Int]
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_H_GROW_DIRECTION, NIL)
    }

  /**
   * Controls the direction on the vertical axis in which the control should grow if its vertical minimum size is changed to be greater than its current size, as the control always has to be at least the minimum size.
   */
  public var growVertical: GrowDirection
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_V_GROW_DIRECTION,
          LONG)
      return Control.GrowDirection.values()[TransferContext.readReturnValue(JVM_INT) as Int]
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_V_GROW_DIRECTION, NIL)
    }

  /**
   * The size of the node's bounding rectangle, in pixels. [godot.Container] nodes update this property automatically.
   */
  public val size: Vector2
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_SIZE, VECTOR2)
      return TransferContext.readReturnValue(VECTOR2, false) as Vector2
    }

  /**
   * The node's position, relative to its parent. It corresponds to the rectangle's top-left corner. The property is not affected by [pivotOffset].
   */
  public val position: Vector2
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_POSITION, VECTOR2)
      return TransferContext.readReturnValue(VECTOR2, false) as Vector2
    }

  /**
   * The node's global position, relative to the world (usually to the [godot.CanvasLayer]).
   */
  public val globalPosition: Vector2
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_GLOBAL_POSITION,
          VECTOR2)
      return TransferContext.readReturnValue(VECTOR2, false) as Vector2
    }

  /**
   * The node's rotation around its pivot, in radians. See [pivotOffset] to change the pivot's position.
   */
  public var rotation: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_ROTATION, DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_ROTATION, NIL)
    }

  /**
   * Helper property to access [rotation] in degrees instead of radians.
   */
  public var rotationDegrees: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_ROTATION_DEGREES,
          DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_ROTATION_DEGREES, NIL)
    }

  /**
   * The node's scale, relative to its [size]. Change this property to scale the node around its [pivotOffset]. The Control's [tooltipText] will also scale according to this value.
   *
   * **Note:** This property is mainly intended to be used for animation purposes. Text inside the Control will look pixelated or blurry when the Control is scaled. To support multiple resolutions in your project, use an appropriate viewport stretch mode as described in the [documentation]($DOCS_URL/tutorials/rendering/multiple_resolutions.html) instead of scaling Controls individually.
   *
   * **Note:** If the Control node is a child of a [godot.Container] node, the scale will be reset to `Vector2(1, 1)` when the scene is instantiated. To set the Control's scale when it's instantiated, wait for one frame using `await get_tree().process_frame` then set its [scale] property.
   */
  public var scale: Vector2
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_SCALE, VECTOR2)
      return TransferContext.readReturnValue(VECTOR2, false) as Vector2
    }
    set(`value`) {
      TransferContext.writeArguments(VECTOR2 to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_SCALE, NIL)
    }

  /**
   * By default, the node's pivot is its top-left corner. When you change its [rotation] or [scale], it will rotate or scale around this pivot. Set this property to [size] / 2 to pivot around the Control's center.
   */
  public var pivotOffset: Vector2
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_PIVOT_OFFSET, VECTOR2)
      return TransferContext.readReturnValue(VECTOR2, false) as Vector2
    }
    set(`value`) {
      TransferContext.writeArguments(VECTOR2 to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_PIVOT_OFFSET, NIL)
    }

  /**
   * Tells the parent [godot.Container] nodes how they should resize and place the node on the X axis. Use one of the [enum SizeFlags] constants to change the flags. See the constants to learn what each does.
   */
  public var sizeFlagsHorizontal: Long
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_H_SIZE_FLAGS, OBJECT)
      return TransferContext.readReturnValue(OBJECT, false) as Long
    }
    set(`value`) {
      TransferContext.writeArguments(OBJECT to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_H_SIZE_FLAGS, NIL)
    }

  /**
   * Tells the parent [godot.Container] nodes how they should resize and place the node on the Y axis. Use one of the [enum SizeFlags] constants to change the flags. See the constants to learn what each does.
   */
  public var sizeFlagsVertical: Long
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_V_SIZE_FLAGS, OBJECT)
      return TransferContext.readReturnValue(OBJECT, false) as Long
    }
    set(`value`) {
      TransferContext.writeArguments(OBJECT to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_V_SIZE_FLAGS, NIL)
    }

  /**
   * If the node and at least one of its neighbors uses the [SIZE_EXPAND] size flag, the parent [godot.Container] will let it take more or less space depending on this property. If this node has a stretch ratio of 2 and its neighbor a ratio of 1, this node will take two thirds of the available space.
   */
  public var sizeFlagsStretchRatio: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_STRETCH_RATIO, DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_STRETCH_RATIO, NIL)
    }

  /**
   * Toggles if any text should automatically change to its translated version depending on the current locale. Note that this will not affect any internal nodes (e.g. the popup of a [godot.MenuButton]).
   *
   * Also decides if the node's strings should be parsed for POT generation.
   */
  public var autoTranslate: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_IS_AUTO_TRANSLATING, BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(`value`) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_AUTO_TRANSLATE, NIL)
    }

  /**
   * If `true`, automatically converts code line numbers, list indices, [godot.SpinBox] and [godot.ProgressBar] values from the Western Arabic (0..9) to the numeral systems used in current locale.
   *
   * **Note:** Numbers within the text are not automatically converted, it can be done manually, using [godot.TextServer.formatNumber].
   */
  public var localizeNumeralSystem: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_CONTROL_IS_LOCALIZING_NUMERAL_SYSTEM, BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(`value`) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_CONTROL_SET_LOCALIZE_NUMERAL_SYSTEM, NIL)
    }

  /**
   * The default tooltip text. The tooltip appears when the user's mouse cursor stays idle over this control for a few moments, provided that the [mouseFilter] property is not [MOUSE_FILTER_IGNORE]. The time required for the tooltip to appear can be changed with the [godot.ProjectSettings.gui/timers/tooltipDelaySec] option. See also [getTooltip].
   *
   * The tooltip popup will use either a default implementation, or a custom one that you can provide by overriding [_makeCustomTooltip]. The default tooltip includes a [godot.PopupPanel] and [godot.Label] whose theme properties can be customized using [godot.Theme] methods with the `"TooltipPanel"` and `"TooltipLabel"` respectively. For example:
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * var style_box = StyleBoxFlat.new()
   *
   * style_box.set_bg_color(Color(1, 1, 0))
   *
   * style_box.set_border_width_all(2)
   *
   * # We assume here that the `theme` property has been assigned a custom Theme beforehand.
   *
   * theme.set_stylebox("panel", "TooltipPanel", style_box)
   *
   * theme.set_color("font_color", "TooltipLabel", Color(0, 1, 1))
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * var styleBox = new StyleBoxFlat();
   *
   * styleBox.SetBgColor(new Color(1, 1, 0));
   *
   * styleBox.SetBorderWidthAll(2);
   *
   * // We assume here that the `Theme` property has been assigned a custom Theme beforehand.
   *
   * Theme.SetStyleBox("panel", "TooltipPanel", styleBox);
   *
   * Theme.SetColor("font_color", "TooltipLabel", new Color(0, 1, 1));
   *
   * [/csharp]
   *
   * [/codeblocks]
   */
  public var tooltipText: String
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_TOOLTIP_TEXT, STRING)
      return TransferContext.readReturnValue(STRING, false) as String
    }
    set(`value`) {
      TransferContext.writeArguments(STRING to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_TOOLTIP_TEXT, NIL)
    }

  /**
   * Tells Godot which node it should give focus to if the user presses [kbd]Tab[/kbd] on a keyboard by default. You can change the key by editing the [godot.ProjectSettings.input/uiFocusNext] input action.
   *
   * If this property is not set, Godot will select a "best guess" based on surrounding nodes in the scene tree.
   */
  public var focusNext: NodePath
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_FOCUS_NEXT, NODE_PATH)
      return TransferContext.readReturnValue(NODE_PATH, false) as NodePath
    }
    set(`value`) {
      TransferContext.writeArguments(NODE_PATH to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_FOCUS_NEXT, NIL)
    }

  /**
   * Tells Godot which node it should give focus to if the user presses [kbd]Shift + Tab[/kbd] on a keyboard by default. You can change the key by editing the [godot.ProjectSettings.input/uiFocusPrev] input action.
   *
   * If this property is not set, Godot will select a "best guess" based on surrounding nodes in the scene tree.
   */
  public var focusPrevious: NodePath
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_FOCUS_PREVIOUS,
          NODE_PATH)
      return TransferContext.readReturnValue(NODE_PATH, false) as NodePath
    }
    set(`value`) {
      TransferContext.writeArguments(NODE_PATH to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_FOCUS_PREVIOUS, NIL)
    }

  /**
   * The focus access mode for the control (None, Click or All). Only one Control can be focused at the same time, and it will receive keyboard, gamepad, and mouse signals.
   */
  public var focusMode: FocusMode
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_FOCUS_MODE, LONG)
      return Control.FocusMode.values()[TransferContext.readReturnValue(JVM_INT) as Int]
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_FOCUS_MODE, NIL)
    }

  /**
   * Controls whether the control will be able to receive mouse button input events through [_guiInput] and how these events should be handled. Also controls whether the control can receive the [mouseEntered], and [mouseExited] signals. See the constants to learn what each does.
   */
  public var mouseFilter: MouseFilter
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_MOUSE_FILTER, LONG)
      return Control.MouseFilter.values()[TransferContext.readReturnValue(JVM_INT) as Int]
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_MOUSE_FILTER, NIL)
    }

  /**
   * When enabled, scroll wheel events processed by [_guiInput] will be passed to the parent control even if [mouseFilter] is set to [MOUSE_FILTER_STOP]. As it defaults to true, this allows nested scrollable containers to work out of the box.
   *
   * You should disable it on the root of your UI if you do not want scroll events to go to the [godot.Node.UnhandledInput] processing.
   */
  public var mouseForcePassScrollEvents: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_CONTROL_IS_FORCE_PASS_SCROLL_EVENTS, BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(`value`) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_CONTROL_SET_FORCE_PASS_SCROLL_EVENTS, NIL)
    }

  /**
   * The default cursor shape for this control. Useful for Godot plugins and applications or games that use the system's mouse cursors.
   *
   * **Note:** On Linux, shapes may vary depending on the cursor theme of the system.
   */
  public var mouseDefaultCursorShape: CursorShape
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_DEFAULT_CURSOR_SHAPE,
          LONG)
      return Control.CursorShape.values()[TransferContext.readReturnValue(JVM_INT) as Int]
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_DEFAULT_CURSOR_SHAPE,
          NIL)
    }

  /**
   * The [godot.Node] which must be a parent of the focused [godot.Control] for the shortcut to be activated. If `null`, the shortcut can be activated when any control is focused (a global shortcut). This allows shortcuts to be accepted only when the user has a certain area of the GUI focused.
   */
  public var shortcutContext: Node?
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_SHORTCUT_CONTEXT,
          OBJECT)
      return TransferContext.readReturnValue(OBJECT, true) as Node?
    }
    set(`value`) {
      TransferContext.writeArguments(OBJECT to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_SHORTCUT_CONTEXT, NIL)
    }

  /**
   * The [godot.Theme] resource this node and all its [godot.Control] and [godot.Window] children use. If a child node has its own [godot.Theme] resource set, theme items are merged with child's definitions having higher priority.
   *
   * **Note:** [godot.Window] styles will have no effect unless the window is embedded.
   */
  public var theme: Theme?
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME, OBJECT)
      return TransferContext.readReturnValue(OBJECT, true) as Theme?
    }
    set(`value`) {
      TransferContext.writeArguments(OBJECT to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_THEME, NIL)
    }

  /**
   * The name of a theme type variation used by this [godot.Control] to look up its own theme items. When empty, the class name of the node is used (e.g. `Button` for the [godot.Button] control), as well as the class names of all parent classes (in order of inheritance).
   *
   * When set, this property gives the highest priority to the type of the specified name. This type can in turn extend another type, forming a dependency chain. See [godot.Theme.setTypeVariation]. If the theme item cannot be found using this type or its base types, lookup falls back on the class names.
   *
   * **Note:** To look up [godot.Control]'s own items use various `get_theme_*` methods without specifying `theme_type`.
   *
   * **Note:** Theme items are looked for in the tree order, from branch to root, where each [godot.Control] node is checked for its [theme] property. The earliest match against any type/class name is returned. The project-level Theme and the default Theme are checked last.
   */
  public var themeTypeVariation: StringName
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME_TYPE_VARIATION,
          STRING_NAME)
      return TransferContext.readReturnValue(STRING_NAME, false) as StringName
    }
    set(`value`) {
      TransferContext.writeArguments(STRING_NAME to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_THEME_TYPE_VARIATION,
          NIL)
    }

  public override fun new(scriptIndex: Int): Boolean {
    callConstructor(ENGINECLASS_CONTROL, scriptIndex)
    return true
  }

  /**
   * Virtual method to be implemented by the user. Returns whether the given [position] is inside this control.
   *
   * If not overridden, default behavior is checking if the point is within control's Rect.
   *
   * **Note:** If you want to check if a point is inside the control, you can use `get_rect().has_point(point)`.
   */
  public open fun _hasPoint(position: Vector2): Boolean {
    throw NotImplementedError("_has_point is not implemented for Control")
  }

  /**
   * User defined BiDi algorithm override function.
   *
   * Returns an [godot.Array] of [godot.Vector2i] text ranges, in the left-to-right order. Ranges should cover full source [text] without overlaps. BiDi algorithm will be used on each range separately.
   */
  public open fun _structuredTextParser(args: VariantArray<Any?>, text: String):
      VariantArray<Vector2i> {
    throw NotImplementedError("_structured_text_parser is not implemented for Control")
  }

  /**
   * Virtual method to be implemented by the user. Returns the minimum size for this control. Alternative to [customMinimumSize] for controlling minimum size via code. The actual minimum size will be the max value of these two (in each axis separately).
   *
   * If not overridden, defaults to [godot.Vector2.ZERO].
   *
   * **Note:** This method will not be called when the script is attached to a [godot.Control] node that already overrides its minimum size (e.g. [godot.Label], [godot.Button], [godot.PanelContainer] etc.). It can only be used with most basic GUI nodes, like [godot.Control], [godot.Container], [godot.Panel] etc.
   */
  public open fun _getMinimumSize(): Vector2 {
    throw NotImplementedError("_get_minimum_size is not implemented for Control")
  }

  /**
   * Godot calls this method to get data that can be dragged and dropped onto controls that expect drop data. Returns `null` if there is no data to drag. Controls that want to receive drop data should implement [_canDropData] and [_dropData]. [atPosition] is local to this control. Drag may be forced with [forceDrag].
   *
   * A preview that will follow the mouse that should represent the data can be set with [setDragPreview]. A good time to set the preview is in this method.
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * func _get_drag_data(position):
   *
   *     var mydata = make_data() # This is your custom method generating the drag data.
   *
   *     set_drag_preview(make_preview(mydata)) # This is your custom method generating the preview of the drag data.
   *
   *     return mydata
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * public override object GetDragData(Vector2 position)
   *
   * {
   *
   *     object mydata = MakeData(); // This is your custom method generating the drag data.
   *
   *     SetDragPreview(MakePreview(mydata)); // This is your custom method generating the preview of the drag data.
   *
   *     return mydata;
   *
   * }
   *
   * [/csharp]
   *
   * [/codeblocks]
   */
  public open fun _getDragData(atPosition: Vector2): Any? {
    throw NotImplementedError("_get_drag_data is not implemented for Control")
  }

  /**
   * Godot calls this method to test if [data] from a control's [_getDragData] can be dropped at [atPosition]. [atPosition] is local to this control.
   *
   * This method should only be used to test the data. Process the data in [_dropData].
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * func _can_drop_data(position, data):
   *
   *     # Check position if it is relevant to you
   *
   *     # Otherwise, just check data
   *
   *     return typeof(data) == TYPE_DICTIONARY and data.has("expected")
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * public override bool CanDropData(Vector2 position, object data)
   *
   * {
   *
   *     // Check position if it is relevant to you
   *
   *     // Otherwise, just check data
   *
   *     return data is Godot.Collections.Dictionary && (data as Godot.Collections.Dictionary).Contains("expected");
   *
   * }
   *
   * [/csharp]
   *
   * [/codeblocks]
   */
  public open fun _canDropData(atPosition: Vector2, `data`: Any): Boolean {
    throw NotImplementedError("_can_drop_data is not implemented for Control")
  }

  /**
   * Godot calls this method to pass you the [data] from a control's [_getDragData] result. Godot first calls [_canDropData] to test if [data] is allowed to drop at [atPosition] where [atPosition] is local to this control.
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * func _can_drop_data(position, data):
   *
   *     return typeof(data) == TYPE_DICTIONARY and data.has("color")
   *
   * func _drop_data(position, data):
   *
   *     var color = data["color"]
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * public override bool CanDropData(Vector2 position, object data)
   *
   * {
   *
   *     return data is Godot.Collections.Dictionary && (data as Godot.Collections.Dictionary).Contains("color");
   *
   * }
   *
   * public override void DropData(Vector2 position, object data)
   *
   * {
   *
   *     Color color = (Color)(data as Godot.Collections.Dictionary)["color"];
   *
   * }
   *
   * [/csharp]
   *
   * [/codeblocks]
   */
  public open fun _dropData(atPosition: Vector2, `data`: Any): Unit {
  }

  /**
   * Virtual method to be implemented by the user. Returns a [godot.Control] node that should be used as a tooltip instead of the default one. The [forText] includes the contents of the [tooltipText] property.
   *
   * The returned node must be of type [godot.Control] or Control-derived. It can have child nodes of any type. It is freed when the tooltip disappears, so make sure you always provide a new instance (if you want to use a pre-existing node from your scene tree, you can duplicate it and pass the duplicated instance). When `null` or a non-Control node is returned, the default tooltip will be used instead.
   *
   * The returned node will be added as child to a [godot.PopupPanel], so you should only provide the contents of that panel. That [godot.PopupPanel] can be themed using [godot.Theme.setStylebox] for the type `"TooltipPanel"` (see [tooltipText] for an example).
   *
   * **Note:** The tooltip is shrunk to minimal size. If you want to ensure it's fully visible, you might want to set its [customMinimumSize] to some non-zero value.
   *
   * **Note:** The node (and any relevant children) should be [godot.CanvasItem.visible] when returned, otherwise, the viewport that instantiates it will not be able to calculate its minimum size reliably.
   *
   * **Example of usage with a custom-constructed node:**
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * func _make_custom_tooltip(for_text):
   *
   *     var label = Label.new()
   *
   *     label.text = for_text
   *
   *     return label
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * public override Godot.Control _MakeCustomTooltip(String forText)
   *
   * {
   *
   *     var label = new Label();
   *
   *     label.Text = forText;
   *
   *     return label;
   *
   * }
   *
   * [/csharp]
   *
   * [/codeblocks]
   *
   * **Example of usage with a custom scene instance:**
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * func _make_custom_tooltip(for_text):
   *
   *     var tooltip = preload("res://some_tooltip_scene.tscn").instantiate()
   *
   *     tooltip.get_node("Label").text = for_text
   *
   *     return tooltip
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * public override Godot.Control _MakeCustomTooltip(String forText)
   *
   * {
   *
   *     Node tooltip = ResourceLoader.Load<PackedScene>("res://some_tooltip_scene.tscn").Instantiate();
   *
   *     tooltip.GetNode<Label>("Label").Text = forText;
   *
   *     return tooltip;
   *
   * }
   *
   * [/csharp]
   *
   * [/codeblocks]
   */
  public open fun _makeCustomTooltip(forText: String): Object? {
    throw NotImplementedError("_make_custom_tooltip is not implemented for Control")
  }

  /**
   * Virtual method to be implemented by the user. Use this method to process and accept inputs on UI elements. See [acceptEvent].
   *
   * **Example usage for clicking a control:**
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * func _gui_input(event):
   *
   *     if event is InputEventMouseButton:
   *
   *         if event.button_index == MOUSE_BUTTON_LEFT and event.pressed:
   *
   *             print("I've been clicked D:")
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * public override void _GuiInput(InputEvent @event)
   *
   * {
   *
   *     if (@event is InputEventMouseButton)
   *
   *     {
   *
   *         var mb = @event as InputEventMouseButton;
   *
   *         if (mb.ButtonIndex == (int)ButtonList.Left && mb.Pressed)
   *
   *         {
   *
   *             GD.Print("I've been clicked D:");
   *
   *         }
   *
   *     }
   *
   * }
   *
   * [/csharp]
   *
   * [/codeblocks]
   *
   * The event won't trigger if:
   *
   * * clicking outside the control (see [_hasPoint]);
   *
   * * control has [mouseFilter] set to [MOUSE_FILTER_IGNORE];
   *
   * * control is obstructed by another [godot.Control] on top of it, which doesn't have [mouseFilter] set to [MOUSE_FILTER_IGNORE];
   *
   * * control's parent has [mouseFilter] set to [MOUSE_FILTER_STOP] or has accepted the event;
   *
   * * it happens outside the parent's rectangle and the parent has either [clipContents] enabled.
   *
   * **Note:** Event position is relative to the control origin.
   */
  public open fun _guiInput(event: InputEvent): Unit {
  }

  /**
   * Marks an input event as handled. Once you accept an input event, it stops propagating, even to nodes listening to [godot.Node.UnhandledInput] or [godot.Node.UnhandledKeyInput].
   */
  public fun acceptEvent(): Unit {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_ACCEPT_EVENT, NIL)
  }

  /**
   * Returns the minimum size for this control. See [customMinimumSize].
   */
  public fun getMinimumSize(): Vector2 {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_MINIMUM_SIZE, VECTOR2)
    return TransferContext.readReturnValue(VECTOR2, false) as Vector2
  }

  /**
   * Returns combined minimum size from [customMinimumSize] and [getMinimumSize].
   */
  public fun getCombinedMinimumSize(): Vector2 {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_COMBINED_MINIMUM_SIZE,
        VECTOR2)
    return TransferContext.readReturnValue(VECTOR2, false) as Vector2
  }

  /**
   * Sets the anchors to a [preset] from [enum Control.LayoutPreset] enum. This is the code equivalent to using the Layout menu in the 2D editor.
   *
   * If [keepOffsets] is `true`, control's position will also be updated.
   */
  public fun setAnchorsPreset(preset: LayoutPreset, keepOffsets: Boolean = false): Unit {
    TransferContext.writeArguments(LONG to preset.id, BOOL to keepOffsets)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_ANCHORS_PRESET, NIL)
  }

  /**
   * Sets the offsets to a [preset] from [enum Control.LayoutPreset] enum. This is the code equivalent to using the Layout menu in the 2D editor.
   *
   * Use parameter [resizeMode] with constants from [enum Control.LayoutPresetMode] to better determine the resulting size of the [godot.Control]. Constant size will be ignored if used with presets that change size, e.g. [PRESET_LEFT_WIDE].
   *
   * Use parameter [margin] to determine the gap between the [godot.Control] and the edges.
   */
  public fun setOffsetsPreset(
    preset: LayoutPreset,
    resizeMode: LayoutPresetMode = Control.LayoutPresetMode.PRESET_MODE_MINSIZE,
    margin: Long = 0
  ): Unit {
    TransferContext.writeArguments(LONG to preset.id, LONG to resizeMode.id, LONG to margin)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_OFFSETS_PRESET, NIL)
  }

  /**
   * Sets both anchor preset and offset preset. See [setAnchorsPreset] and [setOffsetsPreset].
   */
  public fun setAnchorsAndOffsetsPreset(
    preset: LayoutPreset,
    resizeMode: LayoutPresetMode = Control.LayoutPresetMode.PRESET_MODE_MINSIZE,
    margin: Long = 0
  ): Unit {
    TransferContext.writeArguments(LONG to preset.id, LONG to resizeMode.id, LONG to margin)
    TransferContext.callMethod(rawPtr,
        ENGINEMETHOD_ENGINECLASS_CONTROL_SET_ANCHORS_AND_OFFSETS_PRESET, NIL)
  }

  /**
   * Sets the anchor for the specified [enum Side] to [anchor]. A setter method for [anchorBottom], [anchorLeft], [anchorRight] and [anchorTop].
   *
   * If [keepOffset] is `true`, offsets aren't updated after this operation.
   *
   * If [pushOppositeAnchor] is `true` and the opposite anchor overlaps this anchor, the opposite one will have its value overridden. For example, when setting left anchor to 1 and the right anchor has value of 0.5, the right anchor will also get value of 1. If [pushOppositeAnchor] was `false`, the left anchor would get value 0.5.
   */
  public fun setAnchor(
    side: Side,
    anchor: Double,
    keepOffset: Boolean = false,
    pushOppositeAnchor: Boolean = true
  ): Unit {
    TransferContext.writeArguments(LONG to side.id, DOUBLE to anchor, BOOL to keepOffset, BOOL to pushOppositeAnchor)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_ANCHOR, NIL)
  }

  /**
   * Returns the anchor for the specified [enum Side]. A getter method for [anchorBottom], [anchorLeft], [anchorRight] and [anchorTop].
   */
  public fun getAnchor(side: Side): Double {
    TransferContext.writeArguments(LONG to side.id)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_ANCHOR, DOUBLE)
    return TransferContext.readReturnValue(DOUBLE, false) as Double
  }

  /**
   * Sets the offset for the specified [enum Side] to [offset]. A setter method for [offsetBottom], [offsetLeft], [offsetRight] and [offsetTop].
   */
  public fun setOffset(side: Side, offset: Double): Unit {
    TransferContext.writeArguments(LONG to side.id, DOUBLE to offset)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_OFFSET, NIL)
  }

  /**
   * Returns the anchor for the specified [enum Side]. A getter method for [offsetBottom], [offsetLeft], [offsetRight] and [offsetTop].
   */
  public fun getOffset(offset: Side): Double {
    TransferContext.writeArguments(LONG to offset.id)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_OFFSET, DOUBLE)
    return TransferContext.readReturnValue(DOUBLE, false) as Double
  }

  /**
   * Works the same as [setAnchor], but instead of `keep_offset` argument and automatic update of offset, it allows to set the offset yourself (see [setOffset]).
   */
  public fun setAnchorAndOffset(
    side: Side,
    anchor: Double,
    offset: Double,
    pushOppositeAnchor: Boolean = false
  ): Unit {
    TransferContext.writeArguments(LONG to side.id, DOUBLE to anchor, DOUBLE to offset, BOOL to pushOppositeAnchor)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_ANCHOR_AND_OFFSET, NIL)
  }

  /**
   * Sets [offsetLeft] and [offsetTop] at the same time. Equivalent of changing [position].
   */
  public fun setBegin(position: Vector2): Unit {
    TransferContext.writeArguments(VECTOR2 to position)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_BEGIN, NIL)
  }

  /**
   * Sets [offsetRight] and [offsetBottom] at the same time.
   */
  public fun setEnd(position: Vector2): Unit {
    TransferContext.writeArguments(VECTOR2 to position)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_END, NIL)
  }

  /**
   * Sets the [position] to given [position].
   *
   * If [keepOffsets] is `true`, control's anchors will be updated instead of offsets.
   */
  public fun setPosition(position: Vector2, keepOffsets: Boolean = false): Unit {
    TransferContext.writeArguments(VECTOR2 to position, BOOL to keepOffsets)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_POSITION, NIL)
  }

  /**
   * Sets the size (see [size]).
   *
   * If [keepOffsets] is `true`, control's anchors will be updated instead of offsets.
   */
  public fun setSize(size: Vector2, keepOffsets: Boolean = false): Unit {
    TransferContext.writeArguments(VECTOR2 to size, BOOL to keepOffsets)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_SIZE, NIL)
  }

  /**
   * Resets the size to [getCombinedMinimumSize]. This is equivalent to calling `set_size(Vector2())` (or any size below the minimum).
   */
  public fun resetSize(): Unit {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_RESET_SIZE, NIL)
  }

  /**
   * Sets the [globalPosition] to given [position].
   *
   * If [keepOffsets] is `true`, control's anchors will be updated instead of offsets.
   */
  public fun setGlobalPosition(position: Vector2, keepOffsets: Boolean = false): Unit {
    TransferContext.writeArguments(VECTOR2 to position, BOOL to keepOffsets)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_GLOBAL_POSITION, NIL)
  }

  /**
   * Returns [offsetLeft] and [offsetTop]. See also [position].
   */
  public fun getBegin(): Vector2 {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_BEGIN, VECTOR2)
    return TransferContext.readReturnValue(VECTOR2, false) as Vector2
  }

  /**
   * Returns [offsetRight] and [offsetBottom].
   */
  public fun getEnd(): Vector2 {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_END, VECTOR2)
    return TransferContext.readReturnValue(VECTOR2, false) as Vector2
  }

  /**
   * Returns the width/height occupied in the parent control.
   */
  public fun getParentAreaSize(): Vector2 {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_PARENT_AREA_SIZE,
        VECTOR2)
    return TransferContext.readReturnValue(VECTOR2, false) as Vector2
  }

  /**
   * Returns the position of this [godot.Control] in global screen coordinates (i.e. taking window position into account). Mostly useful for editor plugins.
   *
   * Equals to [globalPosition] if the window is embedded (see [godot.Viewport.guiEmbedSubwindows]).
   *
   * **Example usage for showing a popup:**
   *
   * ```
   * 				popup_menu.position = get_screen_position() + get_local_mouse_position()
   * 				popup_menu.reset_size()
   * 				popup_menu.popup()
   * 				```
   */
  public fun getScreenPosition(): Vector2 {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_SCREEN_POSITION,
        VECTOR2)
    return TransferContext.readReturnValue(VECTOR2, false) as Vector2
  }

  /**
   * Returns the position and size of the control relative to the top-left corner of the parent Control. See [position] and [size].
   */
  public fun getRect(): Rect2 {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_RECT, RECT2)
    return TransferContext.readReturnValue(RECT2, false) as Rect2
  }

  /**
   * Returns the position and size of the control relative to the [godot.CanvasLayer]. See [globalPosition] and [size].
   */
  public fun getGlobalRect(): Rect2 {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_GLOBAL_RECT, RECT2)
    return TransferContext.readReturnValue(RECT2, false) as Rect2
  }

  /**
   * Returns `true` if this is the current focused control. See [focusMode].
   */
  public fun hasFocus(): Boolean {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_FOCUS, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Steal the focus from another control and become the focused control (see [focusMode]).
   *
   * **Note**: Using this method together with [godot.Callable.callDeferred] makes it more reliable, especially when called inside [godot.Node.Ready].
   */
  public fun grabFocus(): Unit {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GRAB_FOCUS, NIL)
  }

  /**
   * Give up the focus. No other control will be able to receive input.
   */
  public fun releaseFocus(): Unit {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_RELEASE_FOCUS, NIL)
  }

  /**
   * Finds the previous (above in the tree) [godot.Control] that can receive the focus.
   */
  public fun findPrevValidFocus(): Control? {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_FIND_PREV_VALID_FOCUS,
        OBJECT)
    return TransferContext.readReturnValue(OBJECT, true) as Control?
  }

  /**
   * Finds the next (below in the tree) [godot.Control] that can receive the focus.
   */
  public fun findNextValidFocus(): Control? {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_FIND_NEXT_VALID_FOCUS,
        OBJECT)
    return TransferContext.readReturnValue(OBJECT, true) as Control?
  }

  /**
   * Prevents `*_theme_*_override` methods from emitting [NOTIFICATION_THEME_CHANGED] until [endBulkThemeOverride] is called.
   */
  public fun beginBulkThemeOverride(): Unit {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_BEGIN_BULK_THEME_OVERRIDE,
        NIL)
  }

  /**
   * Ends a bulk theme override update. See [beginBulkThemeOverride].
   */
  public fun endBulkThemeOverride(): Unit {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_END_BULK_THEME_OVERRIDE,
        NIL)
  }

  /**
   * Creates a local override for a theme icon with the specified [name]. Local overrides always take precedence when fetching theme items for the control. An override can be removed with [removeThemeIconOverride].
   *
   * See also [getThemeIcon].
   */
  public fun addThemeIconOverride(name: StringName, texture: Texture2D): Unit {
    TransferContext.writeArguments(STRING_NAME to name, OBJECT to texture)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_ADD_THEME_ICON_OVERRIDE,
        NIL)
  }

  /**
   * Creates a local override for a theme [godot.StyleBox] with the specified [name]. Local overrides always take precedence when fetching theme items for the control. An override can be removed with [removeThemeStyleboxOverride].
   *
   * See also [getThemeStylebox].
   *
   * **Example of modifying a property in a StyleBox by duplicating it:**
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * # The snippet below assumes the child node MyButton has a StyleBoxFlat assigned.
   *
   * # Resources are shared across instances, so we need to duplicate it
   *
   * # to avoid modifying the appearance of all other buttons.
   *
   * var new_stylebox_normal = $MyButton.get_theme_stylebox("normal").duplicate()
   *
   * new_stylebox_normal.border_width_top = 3
   *
   * new_stylebox_normal.border_color = Color(0, 1, 0.5)
   *
   * $MyButton.add_theme_stylebox_override("normal", new_stylebox_normal)
   *
   * # Remove the stylebox override.
   *
   * $MyButton.remove_theme_stylebox_override("normal")
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * // The snippet below assumes the child node MyButton has a StyleBoxFlat assigned.
   *
   * // Resources are shared across instances, so we need to duplicate it
   *
   * // to avoid modifying the appearance of all other buttons.
   *
   * StyleBoxFlat newStyleboxNormal = GetNode<Button>("MyButton").GetThemeStylebox("normal").Duplicate() as StyleBoxFlat;
   *
   * newStyleboxNormal.BorderWidthTop = 3;
   *
   * newStyleboxNormal.BorderColor = new Color(0, 1, 0.5f);
   *
   * GetNode<Button>("MyButton").AddThemeStyleboxOverride("normal", newStyleboxNormal);
   *
   * // Remove the stylebox override.
   *
   * GetNode<Button>("MyButton").RemoveThemeStyleboxOverride("normal");
   *
   * [/csharp]
   *
   * [/codeblocks]
   */
  public fun addThemeStyleboxOverride(name: StringName, stylebox: StyleBox): Unit {
    TransferContext.writeArguments(STRING_NAME to name, OBJECT to stylebox)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_ADD_THEME_STYLEBOX_OVERRIDE,
        NIL)
  }

  /**
   * Creates a local override for a theme [godot.Font] with the specified [name]. Local overrides always take precedence when fetching theme items for the control. An override can be removed with [removeThemeFontOverride].
   *
   * See also [getThemeFont].
   */
  public fun addThemeFontOverride(name: StringName, font: Font): Unit {
    TransferContext.writeArguments(STRING_NAME to name, OBJECT to font)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_ADD_THEME_FONT_OVERRIDE,
        NIL)
  }

  /**
   * Creates a local override for a theme font size with the specified [name]. Local overrides always take precedence when fetching theme items for the control. An override can be removed with [removeThemeFontSizeOverride].
   *
   * See also [getThemeFontSize].
   */
  public fun addThemeFontSizeOverride(name: StringName, fontSize: Long): Unit {
    TransferContext.writeArguments(STRING_NAME to name, LONG to fontSize)
    TransferContext.callMethod(rawPtr,
        ENGINEMETHOD_ENGINECLASS_CONTROL_ADD_THEME_FONT_SIZE_OVERRIDE, NIL)
  }

  /**
   * Creates a local override for a theme [godot.core.Color] with the specified [name]. Local overrides always take precedence when fetching theme items for the control. An override can be removed with [removeThemeColorOverride].
   *
   * See also [getThemeColor].
   *
   * **Example of overriding a label's color and resetting it later:**
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * # Given the child Label node "MyLabel", override its font color with a custom value.
   *
   * $MyLabel.add_theme_color_override("font_color", Color(1, 0.5, 0))
   *
   * # Reset the font color of the child label.
   *
   * $MyLabel.remove_theme_color_override("font_color")
   *
   * # Alternatively it can be overridden with the default value from the Label type.
   *
   * $MyLabel.add_theme_color_override("font_color", get_theme_color("font_color", "Label"))
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * // Given the child Label node "MyLabel", override its font color with a custom value.
   *
   * GetNode<Label>("MyLabel").AddThemeColorOverride("font_color", new Color(1, 0.5f, 0))
   *
   * // Reset the font color of the child label.
   *
   * GetNode<Label>("MyLabel").RemoveThemeColorOverride("font_color")
   *
   * // Alternatively it can be overridden with the default value from the Label type.
   *
   * GetNode<Label>("MyLabel").AddThemeColorOverride("font_color", GetThemeColor("font_color", "Label"))
   *
   * [/csharp]
   *
   * [/codeblocks]
   */
  public fun addThemeColorOverride(name: StringName, color: Color): Unit {
    TransferContext.writeArguments(STRING_NAME to name, COLOR to color)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_ADD_THEME_COLOR_OVERRIDE,
        NIL)
  }

  /**
   * Creates a local override for a theme constant with the specified [name]. Local overrides always take precedence when fetching theme items for the control. An override can be removed with [removeThemeConstantOverride].
   *
   * See also [getThemeConstant].
   */
  public fun addThemeConstantOverride(name: StringName, constant: Long): Unit {
    TransferContext.writeArguments(STRING_NAME to name, LONG to constant)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_ADD_THEME_CONSTANT_OVERRIDE,
        NIL)
  }

  /**
   * Removes a local override for a theme icon with the specified [name] previously added by [addThemeIconOverride] or via the Inspector dock.
   */
  public fun removeThemeIconOverride(name: StringName): Unit {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_REMOVE_THEME_ICON_OVERRIDE,
        NIL)
  }

  /**
   * Removes a local override for a theme [godot.StyleBox] with the specified [name] previously added by [addThemeStyleboxOverride] or via the Inspector dock.
   */
  public fun removeThemeStyleboxOverride(name: StringName): Unit {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr,
        ENGINEMETHOD_ENGINECLASS_CONTROL_REMOVE_THEME_STYLEBOX_OVERRIDE, NIL)
  }

  /**
   * Removes a local override for a theme [godot.Font] with the specified [name] previously added by [addThemeFontOverride] or via the Inspector dock.
   */
  public fun removeThemeFontOverride(name: StringName): Unit {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_REMOVE_THEME_FONT_OVERRIDE,
        NIL)
  }

  /**
   * Removes a local override for a theme font size with the specified [name] previously added by [addThemeFontSizeOverride] or via the Inspector dock.
   */
  public fun removeThemeFontSizeOverride(name: StringName): Unit {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr,
        ENGINEMETHOD_ENGINECLASS_CONTROL_REMOVE_THEME_FONT_SIZE_OVERRIDE, NIL)
  }

  /**
   * Removes a local override for a theme [godot.core.Color] with the specified [name] previously added by [addThemeColorOverride] or via the Inspector dock.
   */
  public fun removeThemeColorOverride(name: StringName): Unit {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_REMOVE_THEME_COLOR_OVERRIDE,
        NIL)
  }

  /**
   * Removes a local override for a theme constant with the specified [name] previously added by [addThemeConstantOverride] or via the Inspector dock.
   */
  public fun removeThemeConstantOverride(name: StringName): Unit {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr,
        ENGINEMETHOD_ENGINECLASS_CONTROL_REMOVE_THEME_CONSTANT_OVERRIDE, NIL)
  }

  /**
   * Returns an icon from the first matching [godot.Theme] in the tree if that [godot.Theme] has an icon item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun getThemeIcon(name: StringName, themeType: StringName = StringName("")): Texture2D? {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME_ICON, OBJECT)
    return TransferContext.readReturnValue(OBJECT, true) as Texture2D?
  }

  /**
   * Returns a [godot.StyleBox] from the first matching [godot.Theme] in the tree if that [godot.Theme] has a stylebox item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun getThemeStylebox(name: StringName, themeType: StringName = StringName("")): StyleBox? {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME_STYLEBOX, OBJECT)
    return TransferContext.readReturnValue(OBJECT, true) as StyleBox?
  }

  /**
   * Returns a [godot.Font] from the first matching [godot.Theme] in the tree if that [godot.Theme] has a font item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun getThemeFont(name: StringName, themeType: StringName = StringName("")): Font? {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME_FONT, OBJECT)
    return TransferContext.readReturnValue(OBJECT, true) as Font?
  }

  /**
   * Returns a font size from the first matching [godot.Theme] in the tree if that [godot.Theme] has a font size item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun getThemeFontSize(name: StringName, themeType: StringName = StringName("")): Long {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME_FONT_SIZE, LONG)
    return TransferContext.readReturnValue(LONG, false) as Long
  }

  /**
   * Returns a [godot.core.Color] from the first matching [godot.Theme] in the tree if that [godot.Theme] has a color item with the specified [name] and [themeType]. If [themeType] is omitted the class name of the current control is used as the type, or [themeTypeVariation] if it is defined. If the type is a class name its parent classes are also checked, in order of inheritance. If the type is a variation its base types are checked, in order of dependency, then the control's class name and its parent classes are checked.
   *
   * For the current control its local overrides are considered first (see [addThemeColorOverride]), then its assigned [theme]. After the current control, each parent control and its assigned [theme] are considered; controls without a [theme] assigned are skipped. If no matching [godot.Theme] is found in the tree, the custom project [godot.Theme] (see [godot.ProjectSettings.gui/theme/custom]) and the default [godot.Theme] are used (see [godot.ThemeDB]).
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * func _ready():
   *
   *     # Get the font color defined for the current Control's class, if it exists.
   *
   *     modulate = get_theme_color("font_color")
   *
   *     # Get the font color defined for the Button class.
   *
   *     modulate = get_theme_color("font_color", "Button")
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * public override void _Ready()
   *
   * {
   *
   *     // Get the font color defined for the current Control's class, if it exists.
   *
   *     Modulate = GetThemeColor("font_color");
   *
   *     // Get the font color defined for the Button class.
   *
   *     Modulate = GetThemeColor("font_color", "Button");
   *
   * }
   *
   * [/csharp]
   *
   * [/codeblocks]
   */
  public fun getThemeColor(name: StringName, themeType: StringName = StringName("")): Color {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME_COLOR, COLOR)
    return TransferContext.readReturnValue(COLOR, false) as Color
  }

  /**
   * Returns a constant from the first matching [godot.Theme] in the tree if that [godot.Theme] has a constant item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun getThemeConstant(name: StringName, themeType: StringName = StringName("")): Long {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME_CONSTANT, LONG)
    return TransferContext.readReturnValue(LONG, false) as Long
  }

  /**
   * Returns `true` if there is a local override for a theme icon with the specified [name] in this [godot.Control] node.
   *
   * See [addThemeIconOverride].
   */
  public fun hasThemeIconOverride(name: StringName): Boolean {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_ICON_OVERRIDE,
        BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a local override for a theme [godot.StyleBox] with the specified [name] in this [godot.Control] node.
   *
   * See [addThemeStyleboxOverride].
   */
  public fun hasThemeStyleboxOverride(name: StringName): Boolean {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_STYLEBOX_OVERRIDE,
        BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a local override for a theme [godot.Font] with the specified [name] in this [godot.Control] node.
   *
   * See [addThemeFontOverride].
   */
  public fun hasThemeFontOverride(name: StringName): Boolean {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_FONT_OVERRIDE,
        BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a local override for a theme font size with the specified [name] in this [godot.Control] node.
   *
   * See [addThemeFontSizeOverride].
   */
  public fun hasThemeFontSizeOverride(name: StringName): Boolean {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr,
        ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_FONT_SIZE_OVERRIDE, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a local override for a theme [godot.core.Color] with the specified [name] in this [godot.Control] node.
   *
   * See [addThemeColorOverride].
   */
  public fun hasThemeColorOverride(name: StringName): Boolean {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_COLOR_OVERRIDE,
        BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a local override for a theme constant with the specified [name] in this [godot.Control] node.
   *
   * See [addThemeConstantOverride].
   */
  public fun hasThemeConstantOverride(name: StringName): Boolean {
    TransferContext.writeArguments(STRING_NAME to name)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_CONSTANT_OVERRIDE,
        BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a matching [godot.Theme] in the tree that has an icon item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun hasThemeIcon(name: StringName, themeType: StringName = StringName("")): Boolean {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_ICON, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a matching [godot.Theme] in the tree that has a stylebox item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun hasThemeStylebox(name: StringName, themeType: StringName = StringName("")): Boolean {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_STYLEBOX, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a matching [godot.Theme] in the tree that has a font item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun hasThemeFont(name: StringName, themeType: StringName = StringName("")): Boolean {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_FONT, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a matching [godot.Theme] in the tree that has a font size item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun hasThemeFontSize(name: StringName, themeType: StringName = StringName("")): Boolean {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_FONT_SIZE, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a matching [godot.Theme] in the tree that has a color item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun hasThemeColor(name: StringName, themeType: StringName = StringName("")): Boolean {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_COLOR, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns `true` if there is a matching [godot.Theme] in the tree that has a constant item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public fun hasThemeConstant(name: StringName, themeType: StringName = StringName("")): Boolean {
    TransferContext.writeArguments(STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_HAS_THEME_CONSTANT, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Returns the default base scale value from the first matching [godot.Theme] in the tree if that [godot.Theme] has a valid [godot.Theme.defaultBaseScale] value.
   *
   * See [getThemeColor] for details.
   */
  public fun getThemeDefaultBaseScale(): Double {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr,
        ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME_DEFAULT_BASE_SCALE, DOUBLE)
    return TransferContext.readReturnValue(DOUBLE, false) as Double
  }

  /**
   * Returns the default font from the first matching [godot.Theme] in the tree if that [godot.Theme] has a valid [godot.Theme.defaultFont] value.
   *
   * See [getThemeColor] for details.
   */
  public fun getThemeDefaultFont(): Font? {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME_DEFAULT_FONT,
        OBJECT)
    return TransferContext.readReturnValue(OBJECT, true) as Font?
  }

  /**
   * Returns the default font size value from the first matching [godot.Theme] in the tree if that [godot.Theme] has a valid [godot.Theme.defaultFontSize] value.
   *
   * See [getThemeColor] for details.
   */
  public fun getThemeDefaultFontSize(): Long {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_THEME_DEFAULT_FONT_SIZE,
        LONG)
    return TransferContext.readReturnValue(LONG, false) as Long
  }

  /**
   * Returns the parent control node.
   */
  public fun getParentControl(): Control? {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_PARENT_CONTROL, OBJECT)
    return TransferContext.readReturnValue(OBJECT, true) as Control?
  }

  /**
   * Returns the tooltip text [atPosition] in local coordinates, which will typically appear when the cursor is resting over this control. By default, it returns [tooltipText].
   *
   * **Note:** This method can be overridden to customize its behavior. If this method returns an empty [godot.String], no tooltip is displayed.
   */
  public fun getTooltip(atPosition: Vector2 = Vector2(0, 0)): String {
    TransferContext.writeArguments(VECTOR2 to atPosition)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_TOOLTIP, STRING)
    return TransferContext.readReturnValue(STRING, false) as String
  }

  /**
   * Returns the mouse cursor shape the control displays on mouse hover. See [enum CursorShape].
   */
  public fun getCursorShape(position: Vector2 = Vector2(0, 0)): CursorShape {
    TransferContext.writeArguments(VECTOR2 to position)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_CURSOR_SHAPE, LONG)
    return Control.CursorShape.values()[TransferContext.readReturnValue(JVM_INT) as Int]
  }

  /**
   * Sets the anchor for the specified [enum Side] to the [godot.Control] at [neighbor] node path. A setter method for [focusNeighborBottom], [focusNeighborLeft], [focusNeighborRight] and [focusNeighborTop].
   */
  public fun setFocusNeighbor(side: Side, neighbor: NodePath): Unit {
    TransferContext.writeArguments(LONG to side.id, NODE_PATH to neighbor)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_FOCUS_NEIGHBOR, NIL)
  }

  /**
   * Returns the focus neighbor for the specified [enum Side]. A getter method for [focusNeighborBottom], [focusNeighborLeft], [focusNeighborRight] and [focusNeighborTop].
   */
  public fun getFocusNeighbor(side: Side): NodePath {
    TransferContext.writeArguments(LONG to side.id)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GET_FOCUS_NEIGHBOR,
        NODE_PATH)
    return TransferContext.readReturnValue(NODE_PATH, false) as NodePath
  }

  /**
   * Forces drag and bypasses [_getDragData] and [setDragPreview] by passing [data] and [preview]. Drag will start even if the mouse is neither over nor pressed on this control.
   *
   * The methods [_canDropData] and [_dropData] must be implemented on controls that want to receive drop data.
   */
  public fun forceDrag(`data`: Any, preview: Control): Unit {
    TransferContext.writeArguments(ANY to data, OBJECT to preview)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_FORCE_DRAG, NIL)
  }

  /**
   * Creates an [godot.InputEventMouseButton] that attempts to click the control. If the event is received, the control acquires focus.
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * func _process(delta):
   *
   *     grab_click_focus() #when clicking another Control node, this node will be clicked instead
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * public override void _Process(float delta)
   *
   * {
   *
   *     GrabClickFocus(); //when clicking another Control node, this node will be clicked instead
   *
   * }
   *
   * [/csharp]
   *
   * [/codeblocks]
   */
  public fun grabClickFocus(): Unit {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_GRAB_CLICK_FOCUS, NIL)
  }

  /**
   * Forwards the handling of this control's [_getDragData],  [_canDropData] and [_dropData] virtual functions to delegate callables.
   *
   * For each argument, if not empty, the delegate callable is used, otherwise the local (virtual) function is used.
   *
   * The function format for each callable should be exactly the same as the virtual functions described above.
   */
  public fun setDragForwarding(
    dragFunc: Callable,
    canDropFunc: Callable,
    dropFunc: Callable
  ): Unit {
    TransferContext.writeArguments(CALLABLE to dragFunc, CALLABLE to canDropFunc, CALLABLE to dropFunc)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_DRAG_FORWARDING, NIL)
  }

  /**
   * Shows the given control at the mouse pointer. A good time to call this method is in [_getDragData]. The control must not be in the scene tree. You should not free the control, and you should not keep a reference to the control beyond the duration of the drag. It will be deleted automatically after the drag has ended.
   *
   * [codeblocks]
   *
   * [gdscript]
   *
   * export (Color, RGBA) var color = Color(1, 0, 0, 1)
   *
   *
   *
   * func _get_drag_data(position):
   *
   *     # Use a control that is not in the tree
   *
   *     var cpb = ColorPickerButton.new()
   *
   *     cpb.color = color
   *
   *     cpb.size = Vector2(50, 50)
   *
   *     set_drag_preview(cpb)
   *
   *     return color
   *
   * [/gdscript]
   *
   * [csharp]
   *
   * [godot.Export]
   *
   * public Color Color = new Color(1, 0, 0, 1);
   *
   *
   *
   * public override object GetDragData(Vector2 position)
   *
   * {
   *
   *     // Use a control that is not in the tree
   *
   *     var cpb = new ColorPickerButton();
   *
   *     cpb.Color = Color;
   *
   *     cpb.RectSize = new Vector2(50, 50);
   *
   *     SetDragPreview(cpb);
   *
   *     return Color;
   *
   * }
   *
   * [/csharp]
   *
   * [/codeblocks]
   */
  public fun setDragPreview(control: Control): Unit {
    TransferContext.writeArguments(OBJECT to control)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_SET_DRAG_PREVIEW, NIL)
  }

  /**
   * Returns `true` if a drag operation is successful. Alternative to [godot.Viewport.guiIsDragSuccessful].
   *
   * Best used with [godot.Node.NOTIFICATION_DRAG_END].
   */
  public fun isDragSuccessful(): Boolean {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_IS_DRAG_SUCCESSFUL, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  /**
   * Moves the mouse cursor to [position], relative to [position] of this [godot.Control].
   */
  public fun warpMouse(position: Vector2): Unit {
    TransferContext.writeArguments(VECTOR2 to position)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_WARP_MOUSE, NIL)
  }

  /**
   * Invalidates the size cache in this node and in parent nodes up to top level. Intended to be used with [getMinimumSize] when the return value is changed. Setting [customMinimumSize] directly calls this method automatically.
   */
  public fun updateMinimumSize(): Unit {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_UPDATE_MINIMUM_SIZE, NIL)
  }

  /**
   * Returns `true` if layout is right-to-left.
   */
  public fun isLayoutRtl(): Boolean {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_CONTROL_IS_LAYOUT_RTL, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  public enum class FocusMode(
    id: Long
  ) {
    /**
     * The node cannot grab focus. Use with [focusMode].
     */
    FOCUS_NONE(0),
    /**
     * The node can only grab focus on mouse clicks. Use with [focusMode].
     */
    FOCUS_CLICK(1),
    /**
     * The node can grab focus on mouse click, using the arrows and the Tab keys on the keyboard, or using the D-pad buttons on a gamepad. Use with [focusMode].
     */
    FOCUS_ALL(2),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public enum class CursorShape(
    id: Long
  ) {
    /**
     * Show the system's arrow mouse cursor when the user hovers the node. Use with [mouseDefaultCursorShape].
     */
    CURSOR_ARROW(0),
    /**
     * Show the system's I-beam mouse cursor when the user hovers the node. The I-beam pointer has a shape similar to "I". It tells the user they can highlight or insert text.
     */
    CURSOR_IBEAM(1),
    /**
     * Show the system's pointing hand mouse cursor when the user hovers the node.
     */
    CURSOR_POINTING_HAND(2),
    /**
     * Show the system's cross mouse cursor when the user hovers the node.
     */
    CURSOR_CROSS(3),
    /**
     * Show the system's wait mouse cursor when the user hovers the node. Often an hourglass.
     */
    CURSOR_WAIT(4),
    /**
     * Show the system's busy mouse cursor when the user hovers the node. Often an arrow with a small hourglass.
     */
    CURSOR_BUSY(5),
    /**
     * Show the system's drag mouse cursor, often a closed fist or a cross symbol, when the user hovers the node. It tells the user they're currently dragging an item, like a node in the Scene dock.
     */
    CURSOR_DRAG(6),
    /**
     * Show the system's drop mouse cursor when the user hovers the node. It can be an open hand. It tells the user they can drop an item they're currently grabbing, like a node in the Scene dock.
     */
    CURSOR_CAN_DROP(7),
    /**
     * Show the system's forbidden mouse cursor when the user hovers the node. Often a crossed circle.
     */
    CURSOR_FORBIDDEN(8),
    /**
     * Show the system's vertical resize mouse cursor when the user hovers the node. A double-headed vertical arrow. It tells the user they can resize the window or the panel vertically.
     */
    CURSOR_VSIZE(9),
    /**
     * Show the system's horizontal resize mouse cursor when the user hovers the node. A double-headed horizontal arrow. It tells the user they can resize the window or the panel horizontally.
     */
    CURSOR_HSIZE(10),
    /**
     * Show the system's window resize mouse cursor when the user hovers the node. The cursor is a double-headed arrow that goes from the bottom left to the top right. It tells the user they can resize the window or the panel both horizontally and vertically.
     */
    CURSOR_BDIAGSIZE(11),
    /**
     * Show the system's window resize mouse cursor when the user hovers the node. The cursor is a double-headed arrow that goes from the top left to the bottom right, the opposite of [CURSOR_BDIAGSIZE]. It tells the user they can resize the window or the panel both horizontally and vertically.
     */
    CURSOR_FDIAGSIZE(12),
    /**
     * Show the system's move mouse cursor when the user hovers the node. It shows 2 double-headed arrows at a 90 degree angle. It tells the user they can move a UI element freely.
     */
    CURSOR_MOVE(13),
    /**
     * Show the system's vertical split mouse cursor when the user hovers the node. On Windows, it's the same as [CURSOR_VSIZE].
     */
    CURSOR_VSPLIT(14),
    /**
     * Show the system's horizontal split mouse cursor when the user hovers the node. On Windows, it's the same as [CURSOR_HSIZE].
     */
    CURSOR_HSPLIT(15),
    /**
     * Show the system's help mouse cursor when the user hovers the node, a question mark.
     */
    CURSOR_HELP(16),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public enum class LayoutPreset(
    id: Long
  ) {
    /**
     * Snap all 4 anchors to the top-left of the parent control's bounds. Use with [setAnchorsPreset].
     */
    PRESET_TOP_LEFT(0),
    /**
     * Snap all 4 anchors to the top-right of the parent control's bounds. Use with [setAnchorsPreset].
     */
    PRESET_TOP_RIGHT(1),
    /**
     * Snap all 4 anchors to the bottom-left of the parent control's bounds. Use with [setAnchorsPreset].
     */
    PRESET_BOTTOM_LEFT(2),
    /**
     * Snap all 4 anchors to the bottom-right of the parent control's bounds. Use with [setAnchorsPreset].
     */
    PRESET_BOTTOM_RIGHT(3),
    /**
     * Snap all 4 anchors to the center of the left edge of the parent control's bounds. Use with [setAnchorsPreset].
     */
    PRESET_CENTER_LEFT(4),
    /**
     * Snap all 4 anchors to the center of the top edge of the parent control's bounds. Use with [setAnchorsPreset].
     */
    PRESET_CENTER_TOP(5),
    /**
     * Snap all 4 anchors to the center of the right edge of the parent control's bounds. Use with [setAnchorsPreset].
     */
    PRESET_CENTER_RIGHT(6),
    /**
     * Snap all 4 anchors to the center of the bottom edge of the parent control's bounds. Use with [setAnchorsPreset].
     */
    PRESET_CENTER_BOTTOM(7),
    /**
     * Snap all 4 anchors to the center of the parent control's bounds. Use with [setAnchorsPreset].
     */
    PRESET_CENTER(8),
    /**
     * Snap all 4 anchors to the left edge of the parent control. The left offset becomes relative to the left edge and the top offset relative to the top left corner of the node's parent. Use with [setAnchorsPreset].
     */
    PRESET_LEFT_WIDE(9),
    /**
     * Snap all 4 anchors to the top edge of the parent control. The left offset becomes relative to the top left corner, the top offset relative to the top edge, and the right offset relative to the top right corner of the node's parent. Use with [setAnchorsPreset].
     */
    PRESET_TOP_WIDE(10),
    /**
     * Snap all 4 anchors to the right edge of the parent control. The right offset becomes relative to the right edge and the top offset relative to the top right corner of the node's parent. Use with [setAnchorsPreset].
     */
    PRESET_RIGHT_WIDE(11),
    /**
     * Snap all 4 anchors to the bottom edge of the parent control. The left offset becomes relative to the bottom left corner, the bottom offset relative to the bottom edge, and the right offset relative to the bottom right corner of the node's parent. Use with [setAnchorsPreset].
     */
    PRESET_BOTTOM_WIDE(12),
    /**
     * Snap all 4 anchors to a vertical line that cuts the parent control in half. Use with [setAnchorsPreset].
     */
    PRESET_VCENTER_WIDE(13),
    /**
     * Snap all 4 anchors to a horizontal line that cuts the parent control in half. Use with [setAnchorsPreset].
     */
    PRESET_HCENTER_WIDE(14),
    /**
     * Snap all 4 anchors to the respective corners of the parent control. Set all 4 offsets to 0 after you applied this preset and the [godot.Control] will fit its parent control. Use with [setAnchorsPreset].
     */
    PRESET_FULL_RECT(15),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public enum class LayoutPresetMode(
    id: Long
  ) {
    /**
     * The control will be resized to its minimum size.
     */
    PRESET_MODE_MINSIZE(0),
    /**
     * The control's width will not change.
     */
    PRESET_MODE_KEEP_WIDTH(1),
    /**
     * The control's height will not change.
     */
    PRESET_MODE_KEEP_HEIGHT(2),
    /**
     * The control's size will not change.
     */
    PRESET_MODE_KEEP_SIZE(3),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public enum class SizeFlags(
    id: Long
  ) {
    /**
     * Tells the parent [godot.Container] to align the node with its start, either the top or the left edge. It is mutually exclusive with [SIZE_FILL] and other shrink size flags, but can be used with [SIZE_EXPAND] in some containers. Use with [sizeFlagsHorizontal] and [sizeFlagsVertical].
     *
     * **Note:** Setting this flag is equal to not having any size flags.
     */
    SIZE_SHRINK_BEGIN(0),
    /**
     * Tells the parent [godot.Container] to expand the bounds of this node to fill all the available space without pushing any other node. It is mutually exclusive with shrink size flags. Use with [sizeFlagsHorizontal] and [sizeFlagsVertical].
     */
    SIZE_FILL(1),
    /**
     * Tells the parent [godot.Container] to let this node take all the available space on the axis you flag. If multiple neighboring nodes are set to expand, they'll share the space based on their stretch ratio. See [sizeFlagsStretchRatio]. Use with [sizeFlagsHorizontal] and [sizeFlagsVertical].
     */
    SIZE_EXPAND(2),
    /**
     * Sets the node's size flags to both fill and expand. See [SIZE_FILL] and [SIZE_EXPAND] for more information.
     */
    SIZE_EXPAND_FILL(3),
    /**
     * Tells the parent [godot.Container] to center the node in the available space. It is mutually exclusive with [SIZE_FILL] and other shrink size flags, but can be used with [SIZE_EXPAND] in some containers. Use with [sizeFlagsHorizontal] and [sizeFlagsVertical].
     */
    SIZE_SHRINK_CENTER(4),
    /**
     * Tells the parent [godot.Container] to align the node with its end, either the bottom or the right edge. It is mutually exclusive with [SIZE_FILL] and other shrink size flags, but can be used with [SIZE_EXPAND] in some containers. Use with [sizeFlagsHorizontal] and [sizeFlagsVertical].
     */
    SIZE_SHRINK_END(8),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public enum class MouseFilter(
    id: Long
  ) {
    /**
     * The control will receive mouse button input events through [_guiInput] if clicked on. And the control will receive the [mouseEntered] and [mouseExited] signals. These events are automatically marked as handled, and they will not propagate further to other controls. This also results in blocking signals in other controls.
     */
    MOUSE_FILTER_STOP(0),
    /**
     * The control will receive mouse button input events through [_guiInput] if clicked on. And the control will receive the [mouseEntered] and [mouseExited] signals. If this control does not handle the event, the parent control (if any) will be considered, and so on until there is no more parent control to potentially handle it. This also allows signals to fire in other controls. If no control handled it, the event will be passed to [godot.Node.UnhandledInput] for further processing.
     */
    MOUSE_FILTER_PASS(1),
    /**
     * The control will not receive mouse button input events through [_guiInput]. The control will also not receive the [mouseEntered] nor [mouseExited] signals. This will not block other controls from receiving these events or firing the signals. Ignored events will not be handled automatically.
     */
    MOUSE_FILTER_IGNORE(2),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public enum class GrowDirection(
    id: Long
  ) {
    /**
     * The control will grow to the left or top to make up if its minimum size is changed to be greater than its current size on the respective axis.
     */
    GROW_DIRECTION_BEGIN(0),
    /**
     * The control will grow to the right or bottom to make up if its minimum size is changed to be greater than its current size on the respective axis.
     */
    GROW_DIRECTION_END(1),
    /**
     * The control will grow in both directions equally to make up if its minimum size is changed to be greater than its current size.
     */
    GROW_DIRECTION_BOTH(2),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public enum class Anchor(
    id: Long
  ) {
    /**
     * Snaps one of the 4 anchor's sides to the origin of the node's `Rect`, in the top left. Use it with one of the `anchor_*` member variables, like [anchorLeft]. To change all 4 anchors at once, use [setAnchorsPreset].
     */
    ANCHOR_BEGIN(0),
    /**
     * Snaps one of the 4 anchor's sides to the end of the node's `Rect`, in the bottom right. Use it with one of the `anchor_*` member variables, like [anchorLeft]. To change all 4 anchors at once, use [setAnchorsPreset].
     */
    ANCHOR_END(1),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public enum class LayoutDirection(
    id: Long
  ) {
    /**
     * Automatic layout direction, determined from the parent control layout direction.
     */
    LAYOUT_DIRECTION_INHERITED(0),
    /**
     * Automatic layout direction, determined from the current locale.
     */
    LAYOUT_DIRECTION_LOCALE(1),
    /**
     * Left-to-right layout direction.
     */
    LAYOUT_DIRECTION_LTR(2),
    /**
     * Right-to-left layout direction.
     */
    LAYOUT_DIRECTION_RTL(3),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public enum class TextDirection(
    id: Long
  ) {
    /**
     * Text writing direction is the same as layout direction.
     */
    TEXT_DIRECTION_INHERITED(3),
    /**
     * Automatic text writing direction, determined from the current locale and text content.
     */
    TEXT_DIRECTION_AUTO(0),
    /**
     * Left-to-right text writing direction.
     */
    TEXT_DIRECTION_LTR(1),
    /**
     * Right-to-left text writing direction.
     */
    TEXT_DIRECTION_RTL(2),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public companion object {
    /**
     * Sent when the node changes size. Use [size] to get the new size.
     */
    public final const val NOTIFICATION_RESIZED: Long = 40

    /**
     * Sent when the mouse pointer enters the node.
     */
    public final const val NOTIFICATION_MOUSE_ENTER: Long = 41

    /**
     * Sent when the mouse pointer exits the node.
     */
    public final const val NOTIFICATION_MOUSE_EXIT: Long = 42

    /**
     * Sent when the node grabs focus.
     */
    public final const val NOTIFICATION_FOCUS_ENTER: Long = 43

    /**
     * Sent when the node loses focus.
     */
    public final const val NOTIFICATION_FOCUS_EXIT: Long = 44

    /**
     * Sent when the node needs to refresh its theme items. This happens in one of the following cases:
     *
     * - The [theme] property is changed on this node or any of its ancestors.
     *
     * - The [themeTypeVariation] property is changed on this node.
     *
     * - One of the node's theme property overrides is changed.
     *
     * - The node enters the scene tree.
     *
     * **Note:** As an optimization, this notification won't be sent from changes that occur while this node is outside of the scene tree. Instead, all of the theme item updates can be applied at once when the node enters the scene tree.
     */
    public final const val NOTIFICATION_THEME_CHANGED: Long = 45

    /**
     * Sent when this node is inside a [godot.ScrollContainer] which has begun being scrolled.
     */
    public final const val NOTIFICATION_SCROLL_BEGIN: Long = 47

    /**
     * Sent when this node is inside a [godot.ScrollContainer] which has stopped being scrolled.
     */
    public final const val NOTIFICATION_SCROLL_END: Long = 48

    /**
     * Sent when control layout direction is changed.
     */
    public final const val NOTIFICATION_LAYOUT_DIRECTION_CHANGED: Long = 49
  }
}
