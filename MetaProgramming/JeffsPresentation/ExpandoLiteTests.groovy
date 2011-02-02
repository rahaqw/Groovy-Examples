class ExpandoLiteTests extends GroovyTestCase {
    void testPropertyAccess() {
        def el = new ExpandoLite()
        // setProperty method is called when you try to set a property
        el.favoriteLanguage = 'Groovy'
        assertEquals 'Groovy', el.favoriteLanguage
    }
}

