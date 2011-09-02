class arrayBoundaries extends GroovyTestCase {
    void testBoundary() {
        def list = [ 1,2,3]
        assert list[0..1] == [ 1,2]
        // this fails

        shouldFail(IndexOutOfBoundsException) {
            list[0..5]
        }
    }
}
