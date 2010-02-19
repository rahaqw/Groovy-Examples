#!/usr/bin/env groovy

import java.text.*

email = '++++foo@foo.com'
email = email.replaceFirst(/^\++/, '')
assert email == 'foo@foo.com'

mystr = "Female"
assert mystr.contains("F")
assert mystr.toLowerCase().contains("f")

mystr = "Male"
assert ! mystr.contains("F")

mystr = '"1062","Incremental","Backup","ahha04_managed_contegix_com","File System","192","23 Jul 2008","04:00:00","23 Jul 2008","04:07:34","Backup Completed with warnings","1.8GB","7.1MB",'
// positive assertion
assert mystr =~ /cont/
// negative assertion
assert (!(mystr =~ /zephyr/))
mystr = mystr.replaceFirst(/\"/, '')
mystr = mystr.replaceFirst(/\",$/, '')
// print mystr

// Parse date
mystr = "03 Aug 2007 02:00:03"
def m = mystr =~ /(\d{2})/
assert m[0][0] == "03"

df = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
dt = df.parse(mystr);
println dt;


mystr = "Running"
// Case insensitive
assert mystr =~ /(?i)running/

mystr = "1.8GB"
// Make sure that something matches by checking some property of the
// "Matcher" object
// Data comes in as "2GB", "2.3MB", etc.
m = mystr =~ /^([0-9.]+)/
def transferSize = 0
try {
    transferSize = m[0][0]
}
catch (Exception e) {
    // Nice empty try/catch clause here.
    // Need to research how to test for nullness of m and trap it, rather than try/catch
    System.out.println e.toString()
}
transferSize = transferSize.toBigDecimal()
if (mystr =~ /GB/) {
    transferSize *= 1000
}
println transferSize
assert 1800 == transferSize
