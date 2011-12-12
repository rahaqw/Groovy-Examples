def list = ['_classSessions[3]:on', 'classSessions[23]:on', 'studentId:22', '_classSessions[13]:', 
'action:saveEnrollments', 'controller:course']

def enrollments = list.findAll {
    it =~ /^classSessions\[(\d+)\]:on/
}

enrollments.each {
    def classSessionId = (it =~ /\[(\d+)\]/)[0][1]
    println "Enrolling in class session: " + classSessionId
}

def disrollments = list.findAll {
    it =~ /_classSessions\[(\d+)\]:on/
}

disrollments.each {
    def classSessionId = (it =~ /\[(\d+)\]/)[0][1]
    println "Disrolling in class session: " + classSessionId
}