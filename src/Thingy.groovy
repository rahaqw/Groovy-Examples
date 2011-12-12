package nate.testing
class Thingy {
    def someMethod() {
        return someCalledMethod()
    }
    
    def someCalledMethod() {
        return true
    }
}