#!/usr/bin/env groovy

def xml = new XmlSlurper().parseText(fixtureMultipleStudents())

def students = xml.children()
students.each { xmlStu ->
        def sw = new StringWriter()
        new XmlNodePrinter(new PrintWriter(sw)).print(xmlStu)
        
        println xmlStu.toString()
}

    def fixtureMultipleStudents() {
        def xml = '''<?xml version="1.0" encoding="UTF-8"?>
            <dataroot xmlns:od="urn:schemas-microsoft-com:officedata" xmlns:xsi="http://www.w3.org/2000/10/XMLSchema-instance"  
            xsi:noNamespaceSchemaLocation="Student.xsd">
            '''

            // Smokey Bandit, dropped out, Parent is Tortenweasel, ClassID 13
            xml = xml + '''<Student> <StudentID>188</StudentID> <ParentID>8675309</ParentID> <LastName>Bandit</LastName> <FirstName>Smokey</FirstName> <Notes>Mentorship Interested</Notes>
            <BirthDate>1997-01-07T00:00:00</BirthDate> <Grade>10</Grade> <ClassID>13</ClassID> <DropOut>1</DropOut> <SystemReceivedID>0</SystemReceivedID> <email>smokeybandit@reynolds.com</email>
            </Student>
            '''

            // Totoro Tortenweasel, Class ID 13, Graduated, Parent Tortenweasel
            xml = xml + '''<Student> <StudentID>188</StudentID> <ParentID>1010101</ParentID> <LastName>Tortenweasel</LastName>
            <FirstName>Totoro</FirstName> <Gender>M</Gender> <BirthDate>1997-01-07T00:00:00</BirthDate> <Grade>10</Grade>
            <ClassID>13</ClassID> <GraduateDate></GraduateDate> <DropOut>0</DropOut> <SystemReceivedID>0</SystemReceivedID> <email>totoro@alum.bworks.org</email>
            </Student>
            '''

            // Nobodys Student, Non-existent class ID
            xml = xml + ''' <Student> <StudentID>188</StudentID> <ParentID>1</ParentID>
            <LastName>Nobodys</LastName> <FirstName>Iam</FirstName>
            <BirthDate>1996-01-07T00:00:00</BirthDate> <Grade>4</Grade> <ClassID>1</ClassID> <GraduateDate>2007-08-18T00:00:00</GraduateDate> <DropOut>0</DropOut>
            <SystemReceivedID>0</SystemReceivedID> <email></email> </Student> <Student>
            '''

            // Billy Tortenweasel, graduated Class 13
            xml = xml + '''
            <StudentID>188</StudentID>
            <ParentID>1010101</ParentID>
            <LastName>Tortenweasel</LastName>
            <FirstName>Billy</FirstName>
            <BirthDate>1997-01-07T00:00:00</BirthDate>
            <Grade>10</Grade>
            <ClassID>13</ClassID>
            <GraduateDate>2007-08-18T00:00:00</GraduateDate>
            <DropOut>0</DropOut>
            <SystemReceivedID>0</SystemReceivedID>
            <email>smokeybandit@reynolds.com</email>
            </Student>
            </dataroot>
            '''

            return xml

    }
