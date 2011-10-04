/**
 * Created by IntelliJ IDEA.
 * User: jeff
 * Date: Nov 5, 2007
 * Time: 6:23:32 PM
 * To change this template use File | Settings | File Templates.
 */

class AddressBookTest extends GroovyTestCase {

    void testAddressBook() {
        def p1 = new Person(firstName:'Jeff', lastName:'Brown', id:'00001')
        def p2 = new Person(firstName:'Jake', lastName:'Brown', id:'00002')

        def ab = new AddressBook()
        ab += p1
        ab += p2

        assertSame 'expected p1', p1, ab['00001']
        assertSame 'expected p2', p2, ab['00002']

    }
}