#!/usr/bin/env groovy
// Just a script to see what hash output looks like
def hashMap = [ foo:'bar',
                baz:'quk',
                ipaddress:'192.168.10.1',
                url:'http://crazynate.com/all/your/bases?are&belong=to&amp;us'
                ]
println hashMap

println "=" * 10

hashMap.each {
    println "${it.key}=${it.value}"
}
