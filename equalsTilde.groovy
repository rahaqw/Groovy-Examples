#!/usr/bin/env groovy
def params = [:]
params['q'] = "b"
def results = [ "bob", "doug", "joe", "sprinkle" ].findAll {
    it =~ /${params['q']}/
}

println results
