#!/usr/bin/env groovy
mystr = '"1062","Incremental","Backup","ahha04_managed_contegix_com","File System","192","23 Jul 2008","04:00:00","23 Jul 2008","04:07:34","Backup Completed with warnings","1.8GB","7.1MB",'

mystr = mystr.replaceFirst(/\"/, '')
mystr = mystr.replaceFirst(/\",$/, '')
print mystr
