#!
// From http://satish.name/?p=16
class Author {
    String name
    Book[] books
}
 
class Book {
    String name
}
 
def authors = []
def authorA = new Author(name:"GroovyGuy" ,books: [new Book(name:"groovy"), new Book(name:"grails")])
def authorB = new Author(name:"RubyGuy" ,books: [new Book(name:"ruby"), new Book(name:"rails")])
 
authors << authorA << authorB
 
//I want book names by authorA
println authorA.books*.name
// --> ["groovy", "grails"]
 
//I want all books names by all authors
println authors*.books*.name.flatten()
// --> ["groovy", "grails", "ruby", "rails"]
 
println authors*.name
// --> ["GroovyGuy", "RubyGuy"]
 
//we can also get list of books by doing this. but if we have a null object in either authors or books
//we get an null pointer exception. so spread takes cares
//of safe navigation on collection
println authors.books.name.flatten()
// --> ["groovy", "grails", "ruby", "rails"]
// Rockstar "Elvis" operator is like ruby's ||= operator?
def rockstar
def defaultrockstar = rockstar?:"Elvis Presley"
println defaultrockstar
// -->"Elvis Presley"

