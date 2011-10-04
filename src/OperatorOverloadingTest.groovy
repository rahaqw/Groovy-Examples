class OperatorOverloadingTest extends GroovyTestCase {

    void testAddingEmployeesToDepartment() {
        def dept = new Department(name:'Some Department')
        def emp1 = new Employee(firstName: 'Jeff', lastName: 'Brown')
        def emp2 = new Employee(firstName: 'Cosmo', lastName: 'Kramer')

        dept += emp1
        dept += emp2

        assertEquals 'department had wrong number of employees', 2, dept.employees.size()
        assertSame emp1, dept.employees[0]
        assertSame emp2, dept.employees[1]
    }

    void testRemovingEmployeesFromDepartment() {
        def dept = new Department(name:'Some Department')
        def emp1 = new Employee(firstName: 'Jeff', lastName: 'Brown')
        def emp2 = new Employee(firstName: 'Cosmo', lastName: 'Kramer')

        dept += emp1
        dept += emp2
        dept -= emp1

        assertEquals 'department had wrong number of employees', 1, dept.employees.size()
        assertSame emp2, dept.employees[0]

    }

    void testAddingPeopleYieldsAGroup() {
        //def p1 = new Person()
        //def p2 = new Person()
        //def result = p1 + p2
        //assertEquals 'wrong type was returned', Group, result.class
        //assertTrue 'group should have contained p1', result.contains(p1)
        //assertTrue 'group should have contained p2', result.contains(p2)
        //assertEquals 'group had wrong number of people', 2, result.people.size()
    }

}

class Person {
def firstName
def lastName

}

class Employee extends Person {
}

class Department extends ArrayList {
def name
def employees = []

def plus(Employee emp) {
  employees += emp
  this
} 
def minus(Employee emp) {
	employees -= emp
	this
}
}