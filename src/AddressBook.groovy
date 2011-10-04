class AddressBook {
	def people = [:]
	def plus(Person p) {
		people[p.id] = p
		this
	}
	def getAt(String id) {
		people[id]
	}
}