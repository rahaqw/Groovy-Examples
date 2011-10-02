@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.5.1' )
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.URLENC

def http = new HTTPBuilder( 'http://localhost:8080/onevote-web/' )

def postBody = [ 
    add:true,
    name: "Joe Plubmbo" + new Date(),
    seoName: "joe-bplu" + new Date() 
] 

http.post( path: 'columnist/submitEdit', body: postBody, 
           requestContentType: URLENC ) { resp ->

  println "Tweet response status: ${resp.statusLine}"
  assert resp.statusLine.statusCode == 200
}
