(ns overtone.device.protocols)

(defprotocol GridInput
  "A generic representation of a grid of buttons."
  (width [this]
    "Returns the number of elements of the grid width-wise. This value
    is not expected to change.")
  (height [this]
    "Returns the number of elements of the grid height-wise. This
    value is not expected to change.")
  (on-action [this f]
    "Registers a callback fn, to be called whenever one of the buttons
     is pressed or released. If a handler has already been registered
     replace the old handler with this new one.

     The handler fn should take three args: [action x y], where action
     is a keyword from the set #{:pressed :released} and x and y are
     the coords of the button being pressed."))

(defprotocol GridDisplay
  "A generic representation of a grid of lights."
  (width [this]
    "Returns the number of elements of the grid width-wise. This value
    is not expected to change.")
  (height [this]
    "Returns the number of elements of the grid height-wise. This
    value is not expected to change.")
  (light-set [this x y colour]
    "Set the light at position [x y] to the given colour. Color 0 is
    off, > 0 represents a specific palette colour. Subject to
    change.")
  (light-set-all [this colour]
    "Sets all light to a single colour or off if 0.")
  (light-frame [this leds]
    "Update the entire field of lights. The rows arg is a map of coords
    to colour values, the same as in led-set. Any unspecified coords
    should default to 0.

    For example, if you have a 2x2 grid, you could update all of the
    lights like this:

    (light-frame grid {[0 0] 1 [1 0] 0
                       [0 1] 0 [1 1] 1})"))

(defprotocol Button
  (on-action [this f]
    "Registers a callback fn, to be called when the button is pressed
    or released. If a handler has already been registered, replace the
    old handler with this new one.

   The handler fn should take one arg [action], where action is a
   keyword from the set #{:pressed :released}"))

(defprotocol Light
  (light-set [this colour]
    "Set the light to the given colour. Color 0 is off, > 0 represents a
    specific palette colour. Subject to change."))

(defprotocol RangedInput
  (min-val [this]
    "Returns the minimum value the slider will output. This value is
    not expected to change.")
  (max-val [this]
    "Returns the maximum value the slider will output. This value is
    not expected to change.")
  (on-action [this f]
    "Registers a callback fn, to be called when the slider is
    moved. If a handler has already been registered, replace the old
    handler with this new one."))
