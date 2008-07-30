def xml = "<customers><customer><firstname>Bob</firstname></customer>"
xml += "\n<customer><firstname>Bill</firstname></customer>"
xml += "</customers>"
println "xml is: ${xml}"
def fos= new File('TestFile.xml')
fos.write(xml)
def xml2 = ''
new File('TestFile.xml').eachLine { line ->
  xml2 += line  
}
println "xml2 is: ${xml2}\n"
xmlslurp = new XmlSlurper().parseText(xml2);
// xmlslurp = new XmlSlurper().parseText(xml);
def customers = xmlslurp.customer
assert 2 == customers.size()
def cust = xmlslurp.customer[0]
assert cust.firstname.text() == 'Bob'
