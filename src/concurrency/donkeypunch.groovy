#!/usr/bin/env groovy -w
import org.gparallelizer.*
//multiply numbers asynchronously
Asynchronizer.withAsynchronizer(5) {
     Collection<Future> result = [1, 2, 3, 4, 5].collectAsync{it * 10}
     assertEquals(new HashSet([10, 20, 30, 40, 50]), new HashSet((Collection)result*.get()))
}

//run multiple closures in parallel
Asynchronizer.withAsynchronizer {
    assertEquals([10, 20], AsyncInvokerUtil.doInParallel({calculateA()}, {calculateB()}))
}