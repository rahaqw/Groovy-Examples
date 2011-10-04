listOfPeople = [new Person(firstName:'Boo', lastName:'Radley'),
			    new Person(firstName:'Binky', lastName:'Clown')]

firstNameLengths = listOfPeople*.firstName*.size()
assert 2 == firstNameLengths.size()

// These assertions make sure that firstNameLengths is an array containing the sizes of the
// firstnames in the people list.
assert 3 == firstNameLengths[0]
assert 5 == firstNameLengths[1]