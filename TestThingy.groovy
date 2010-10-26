package nate.testing
class TestThingy extends GroovyTestCase {

    void testThingy() {
        def t = new Thingy()
        t.metaClass.someCalledMethod = {
            return false
        }
        assertTrue 'Some method should return true', t.someMethod()
    }
}

class Thingy {
    def someMethod() {
        return someCalledMethod()
    }
    
    def someCalledMethod() {
        return true
    }
}