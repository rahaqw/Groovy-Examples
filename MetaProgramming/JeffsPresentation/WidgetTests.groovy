class WidgetTests extends GroovyTestCase {
    void testSomething() {
        Widget.metaClass.methodMissing = { String methodName, args ->
            println "in methodMissing for ${methodName}"
            def impl = {
                methodName
            }
            Widget.metaClass."${ methodName }" = impl
            // invoke new method (closure)
            impl()
        }

        def w = new Widget()
        assertNotNull w
        println w.boo()
        println w.boo()
        println w.boo()
        println w.boo()
        println w.boo()

    }
}

