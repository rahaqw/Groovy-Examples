#!/usr/bin/env groovy

Closure fib = {n -> n > 1 ? fib(n - 1) + fib(n - 2) : n}.memoize()
fib(5)
