class ExpandoLiteTests extends GroovyTestCase {
    void testPropertyAccess() {
        def el = new ExpandoLite()
        // setProperty method is called when you try to set a property
        el.favoriteLanguage = 'Groovy'
        assertEquals 'Groovy', el.favoriteLanguage
    }

    void testMethodInvocation() {
        def el = new ExpandoLite()
        el.addNumbers = { x, y ->
            x + y
        }

        assertEquals 100, el.addNumbers(60,40)
    }
}

