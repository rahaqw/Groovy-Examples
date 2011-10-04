//test Java code

class HashMapTest extends GroovyTestCase {
    void testHashtableRejectsNull() {
        shouldFail(NullPointerException) {
            new Hashtable()['KEY'] = null
        }
    }
}
