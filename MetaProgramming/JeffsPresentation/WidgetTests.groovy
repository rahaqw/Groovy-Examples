class WidgetTests extends GroovyTestCase {
    void testSomething() {
        Widget.metaClass.methodMissing = { String methodName, args ->
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

