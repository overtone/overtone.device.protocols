(ns overtone.device.protocols.grid-input)

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
