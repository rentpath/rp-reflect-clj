(ns rp.reflect
  (:import clojure.lang.Reflector))

(defn- ^"[Ljava.lang.Object;" args-array
  [args]
  (into-array Object args))

(defn invoke-constructor
  "Given a Java `class` and a collection of `args`, invoke the constructor for the class with those arguments."
  [class & args]
  (Reflector/invokeConstructor class (args-array args)))

(defn invoke-static-method
  "Given a Java `class`, a String method named `method-name`, and a collection of `args`, invoke the static method of the given class with those arguments."
  [^Class class ^String method-name & args]
  (Reflector/invokeStaticMethod class method-name (args-array args)))

(defn get-static-field
  "Given a Java `class`, a String field named `field-name`, return the value of the static field on the given class."
  [^Class class ^String field-name]
  (Reflector/getStaticField class field-name))
