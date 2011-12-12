#!/usr/bin/env groovy

/* 
 *  Script: xmlParser.groovy
 *   Usage: xmlParser.groovy
 * Purpose: show how to use XmlParser
 *  Author: Crazy Nate
 * History: 
 */

def xmlText = """<?xml version="1.0" encoding="UTF-8"?>
<dataroot xmlns:od="urn:schemas-microsoft-com:officedata" xmlns:xsi="http://www.w3.org/2000/10/XMLSchema-instance"  xsi:noNamespaceSchemaLocation="Student.xsd">
<Student>
<StudentID>188</StudentID>
<ParentID>136</ParentID>
<LastName>Jackson</LastName>
<FirstName>Viviano123^^^</FirstName>
<BirthDate>1997-01-07T00:00:00</BirthDate>
<Grade>10</Grade>
<ClassID>13</ClassID>
<GraduateDate>2007-08-18T00:00:00</GraduateDate>
<DropOut>0</DropOut>
<SystemReceivedID>0</SystemReceivedID>
<email>Vavoom123@s1p2a3x4.com</email>
</Student>
</dataroot>
"""

// Xml parser doesn't need the root/parent element
// In other words, xml.dataroot.children() blows up
def xml = new XmlParser().parseText(xmlText)
assert xml.children().size() == 1

def student = xml.Student[0]
assert student.FirstName.text() == 'Viviano123^^^'

// ************ Another test, with multiple students *****************
def multipleStudentsXML = """<?xml version="1.0" encoding="UTF-8"?>
<dataroot xmlns:od="urn:schemas-microsoft-com:officedata" xmlns:xsi="http://www.w3.org/2000/10/XMLSchema-instance"  xsi:noNamespaceSchemaLocation="Student.xsd">
<Student>
<StudentID>188</StudentID>
<ParentID>136</ParentID>
<LastName>Jackson</LastName>
<FirstName>FirstStudentFirstNameBlecch!</FirstName>
<BirthDate>1997-01-07T00:00:00</BirthDate>
<Grade>10</Grade>
<ClassID>13</ClassID>
<GraduateDate>2007-08-18T00:00:00</GraduateDate>
<DropOut>0</DropOut>
<SystemReceivedID>0</SystemReceivedID>
<email>Vavoom123@s1p2a3x4.com</email>
</Student>
<Student>
<StudentID>188</StudentID>
<ParentID>136</ParentID>
<LastName>SecondLastName</LastName>
<FirstName>SecondStudentFirstName</FirstName>
<BirthDate>1997-01-07T00:00:00</BirthDate>
<Grade>10</Grade>
<ClassID>13</ClassID>
<GraduateDate>2007-08-18T00:00:00</GraduateDate>
<DropOut>0</DropOut>
<SystemReceivedID>0</SystemReceivedID>
<email>Vavoom123@s1p2a3x4.com</email>
</Student>
</dataroot>
"""

// Xml parser doesn't need the root/parent element
// In other words, xml.dataroot.children() blows up
def xmlMultiple = new XmlParser().parseText(multipleStudentsXML)
assert xmlMultiple.children().size() == 2

def firstNames = xmlMultiple.Student.FirstName
assert firstNames.size() == 2

assert firstNames[0].text() == 'FirstStudentFirstNameBlecch!'
assert firstNames[1].text() == 'SecondStudentFirstName'
