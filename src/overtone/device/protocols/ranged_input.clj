(ns overtone.device.protocols.ranged-input)

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
