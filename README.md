# resistor

I'm an app. Or maybe I'm a library? I haven't decided yet.

The choice is up to you!

## Usage

### basic

Compute the resistance of a resistor.

``` clj
user> (resistor :brown :black :orange)
1000
```

### Advanced

Given a resistance, returns the possible combination for a resistance.

``` clj
user> (resistor 10000 :ohms)
[[:brown :black :orange]
 ...]
```

## License

Copyright © 2012 commiters

Distributed under the Eclipse Public License, the same as Clojure.
