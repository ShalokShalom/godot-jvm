extends "res://addons/gut/test.gd"

func test_signal_connection_script_instantiation():
	var invocation_script = godot_tests_Invocation.new()
	get_tree().root.add_child(invocation_script)
	yield(get_tree().create_timer(1), "timeout")
	assert_eq(invocation_script.is_connected("no_param", invocation_script.invocation, "hook_no_param"), true, "signal \"no_param\" should be connected to \"invocation_script.invocation::hook_no_param\"")
	invocation_script.free()

func test_signal_connection_scene_instantiation():
	var invocation_script = load("res://Spatial.tscn").instance()
	get_tree().root.add_child(invocation_script)
	yield(get_tree().create_timer(1), "timeout")
	assert_eq(invocation_script.is_connected("no_param", invocation_script.invocation, "hook_no_param"), true, "signal \"no_param\" should be connected to \"invocation_script.invocation::hook_no_param\"")
	invocation_script.free()

func test_signal_connection_code():
	var invocation_script = load("res://Spatial.tscn").instance()
	get_tree().root.add_child(invocation_script)
	yield(get_tree().create_timer(1), "timeout")
	assert_eq(invocation_script.get_node("CanvasLayer/Button").is_connected("pressed", invocation_script.invocation, "hook_no_param"), true, "signal \"pressed\" of button should be connected to \"invocation_script.invocation::hook_no_param\"")
	invocation_script.free()
