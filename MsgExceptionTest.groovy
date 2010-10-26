//test Java code

class MsgExceptionTest extends GroovyTestCase {
    void testMsgExceptionTest() {
        def msg = shouldFail(Exception) {
            throw new Exception("Your Mom")
        }
        assertEquals "Your Mom", msg
    }
}
