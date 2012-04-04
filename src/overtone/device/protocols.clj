(ns overtone.device.protocols)

(defprotocol Grid
  "A generic representation of a grid of buttons which are also
  lights such as a monome or launchpad."
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
     the coords of the button being pressed.")
  (led-set [this x y colour]
    "Set the LED at position [x y] to the given colour. Color 0 is
    off, > 0 represents a specific palette colour. Subject to
    change.")
  (led-set-all [this colour]
    "Sets all LEDs to a single colour or off if 0.")
  (led-frame [this leds]
    "Update the entire field of LEDs. The rows arg is a map of coords
    to colour values, the same as in led-set. Any unspecified coords
    should default to 0.

    For example, if you have a 2x2 grid, you could update all of the
    LEDs like this:

    (led-frame grid {[0 0] 1 [1 0] 0
                     [0 1] 0 [1 1] 1})"))
