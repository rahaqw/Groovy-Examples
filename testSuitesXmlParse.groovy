#!/usr/bin/env groovy
def ts = new XmlParser().parse(new File('TESTS-TestSuites.xml'))

def f1 = ts.testsuite.testcase.failure[0]
def f1className = f1.parent().attribute('classname')
assert f1className == 'MiscFunctionalTests'

def msg = f1.attribute('message')
assert msg == 'Expected HTTP status [200] but was [500]'

def matcher = f1.text() =~ /\((${f1className}.*)\)/
def fileNameWithErrorLine = matcher.find() ? matcher[0][1] : ''
assert fileNameWithErrorLine == "MiscFunctionalTests.groovy:17"

/*
    assert className == 'MiscFunctionalTests'

    def error = it.text()


    def noFileNameFound = error =~ /\((somethingthatdoesntexist.*)\)/
    def nothing = noFileNameFound.matches() ?  noFileNameFound[0][1] : "MiscFunctionalTests.groovy:17"
    assert nothing == "MiscFunctionalTests.groovy:17"
}
*/
def f2 = ts.testsuite.testcase.failure[1]
assert f2.attribute('message') == 'GC overhead limit exceeded'

def f2className = f2.parent().attribute('classname') 
assert f2className == 'SecurityFiltersFunctionalTests'

matcher = f2.text() =~ /\((${f2className}.*)\)/
fileNameWithErrorLine = matcher.find() ? matcher[0][1] : ''
assert fileNameWithErrorLine == ""


