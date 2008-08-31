import groovy.sql.Sql

class Book {
	String author
	String title
}

url = "jdbc:hsqldb:mem:testDB"
driver = "org.hsqldb.jdbcDriver"
user = "sa"
pass = ""
sql = Sql.newInstance(url,user,pass, driver)
sql.execute('''
CREATE TABLE book 
(
author varchar,
title varchar
)
''')
sql.execute("insert into book (author, title) values (?,?)", ["Dierk Koenig", "Groovy in Action"])
sql.execute("insert into book (author, title) values (?,?)", ["Scott Davis", "Groovy Recipes"])
sql.execute("insert into book (author, title) values (?,?)", ["Venkat", "Programming Groovy"])
sql.execute("insert into book (author, title) values (?,?)", ["Graeme Rocher", "The Definitive Guide to Grails"])
sql.execute("insert into book (author, title) values (?,?)", ["Christian Bauer", "Java Persistence with Hibernate"])


Book.metaClass.static.methodMissing = { String name, args ->
	// intercept method calls starting with findBy	
	if(name.startsWith("findBy") && args) { 
		// infer the name of the property from the method signature
	def desiredField = name[6 .. -1].toLowerCase()	
		def newMethod = { Object[] varArgs ->
			def results = []
			// Generate sql statement from property name
			// Use GroovySql's eachRow(String query, Closure resultIterator) to obtain results from db
			def qry = "select * from book where ${desiredField} = ?"
			println "select statemnt is: '${qry}' ${desiredField} ${varArgs[0]}"
			sql.eachRow(qry, [varArgs[0]]) {
			    results << new Book(title:it.title, author:it.author)
			}
			return results
		}
		// cache new behaviour
		Book.metaClass."$name" = newMethod // cache
		// invoke new method
		return newMethod.call(args) // invoke
	}
	else {
		throw new MissingMethodException(name, Book,args)
	}
}

books = Book.findByTitle("Groovy in Action")
books.each {
	println it.title
	println it.author
}

books = Book.findByAuthor("Stephen King")
books.each {
	println it.title
	println it.author
}
