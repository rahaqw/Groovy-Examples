#!/usr/bin/env groovy
def xml="""
<something>
furby
</something>
"""

def f = (xml =~ /furby/)[0]
assert f == 'furby'

def notExists = (xml =~ /jojo/)?[0]
assert notExists == ''
