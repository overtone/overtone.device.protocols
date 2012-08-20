(ns overtone.device.protocols.button)

(defprotocol Button
  (on-action [this f]
    "Registers a callback fn, to be called when the button is pressed
    or released. If a handler has already been registered, replace the
    old handler with this new one.

   The handler fn should take one arg [action], where action is a
   keyword from the set #{:pressed :released}"))
