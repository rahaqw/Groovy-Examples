#!/usr/bin/env groovy

import groovy.util.slurpersupport.GPathResult
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.TEXT
import static groovyx.net.http.ContentType.URLENC
import static groovyx.net.http.Method.GET

// Initialze a new builder and give a default URL
def http = new HTTPBuilder( 'http://www.google.com/search' )

http.request(GET,TEXT) { req ->
    uri.path = '/mail/help/tasks/' // overrides any path in the default URL
    headers.'User-Agent' = 'Mozilla/5.0'

    response.success = { resp, reader ->
        assert resp.statusLine.statusCode == 200
            println "My response handler got response: ${resp.statusLine}"
            println "Response length: ${resp.headers.'Content-Length'}"
            System.out << reader // print response stream
    }

    // called only for a 401 (access denied) status code:
    response.'404' = { resp -> 
        println 'Not found'
    }
}

def twitter = new RESTClient( 'https://twitter.com/statuses/' )
twitter.auth.basic 'NateNeff', 'OneMoreIi~3'
try { // expect an exception from a 404 response:
    twitter.head path : 'public_timeline'
    assert false, 'Expected exception'
}
// The exception is used for flow control but has access to the response as well:
catch( ex ) { assert ex.response.status == 404 }
 
assert twitter.head( path : 'public_timeline.json' ).status == 200   
