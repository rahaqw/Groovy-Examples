import org.gmock.GMockTestCase

class GMockExample extends GMockTestCase {

    void testSomething() {
        def loader = mock()
        loader.put("fruit").returns("arle")
        play {
            assertEquals "apple", loader.put("fruit")
        }
    }
}
