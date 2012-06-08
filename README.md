# resistance-utils

I'm an app. Or maybe I'm a library? I haven't decided yet.

The choice is up to you!

## Usage

### basic

Compute the resistance of a resistor.

``` clj
user> (resistor [:brown :black :orange])
10000
```

### Advanced (Not yet implemented)

Given a resistance, returns the possible resistor combination.

``` clj
user> (resistor 10000 :ohms)
[[:brown :black :orange]
 ...]
```

## License

Copyright © 2012 commiters

Distributed under the Eclipse Public License, the same as Clojure.
