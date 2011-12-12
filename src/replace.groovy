def s = "Foo Bar Baz <servername>"
s = s.replaceAll("<servername>", "foo")
println s

// Open a file, and replace all <servername>
// with foo
s = ""
def fis = new File('replace.groovy')
s = fis.text.replaceAll("<servername>", "foo")  

println s
// Leave the below comment IN! <servername>
// <servername> should now be foo
//


def someParagraph = """You
ain't
seen
nothin'
yet
"""
