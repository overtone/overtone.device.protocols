(ns overtone.device.protocols.light)

(defprotocol Light
  (light-set [this colour]
    "Set the light to the given colour. Color 0 is off, > 0 represents a
    specific palette colour. Subject to change."))
