(ns rp.reflect-test
  (:require [clojure.test :refer :all]
            [rp.reflect :refer :all])
  (:import [java.nio.file Files LinkOption Paths]
           [java.text Bidi]
           [java.time Month]))

(deftest test-invoke-constructor
  (is (= 32
         (invoke-constructor Long "32")))
  (is (.isLeftToRight
       ^Bidi (invoke-constructor Bidi "A paragraph of text" Bidi/DIRECTION_LEFT_TO_RIGHT))))

(deftest test-invoke-static-method
  (is (= 32
         (invoke-static-method Long "parseLong" "32")))
  (is (Files/exists (invoke-static-method Paths "get" "." (into-array String ["project.clj"]))
                    (into-array java.nio.file.LinkOption []))
      "Doesn't magically handle constructors with Java varargs"))

(deftest test-get-static-field
  (is (= Long/MAX_VALUE
         (get-static-field Long "MAX_VALUE")))
  (is (= 4
         (.getValue ^Month (get-static-field Month "APRIL")))))

(deftest test-invoke-instance-method
  (is (= 2
         (invoke-instance-method "piebald"
                                 "indexOf"
                                 [Integer/TYPE]
                                 (int \e))))
  (is (= (str #"true|false")
         (str (invoke-instance-method (java.util.Scanner. "") "boolPattern" [])))))
