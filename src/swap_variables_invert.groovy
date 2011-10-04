def (firstName, lastName) = [ "bob", "jones" ]
(firstName, lastName) = [lastName, firstName]
assert firstName == "jones"
assert lastName == "bob"