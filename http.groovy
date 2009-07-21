#!/usr/bin/env groovy
// Send 'successful' request, and make sure it works!

// Watch out -- java 1.4.2 documentation but it works!
// http://java.sun.com/j2se/1.4.2/docs/api/java/net/HttpURLConnection.html
URL url = new URL("http://google.com")
// No params for now
def params = [:]
def data = ""
params.each {
    data += encodeField(it.key, it.value) + "&"
}
// Send 'successful' request, and make sure it works!
URLConnection conn = url.openConnection()
conn.setDoOutput(true)
OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream())
wr.write(data)
wr.flush()

println "the response code was: " + conn.getResponseCode().toString()

// Get the response
BufferedReader rd
try {
    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))
} catch (java.io.IOException e) {
    println e
}

def thisLine
while((thisLine = rd?.readLine()) != null) {
    println thisLine
}

wr.close()
rd?.close()
// methods
String encodeField(fieldName, fieldValue) {
     return URLEncoder.encode(fieldName, "UTF-8") + "=" + URLEncoder.encode(fieldValue)
}
// The below code seems to be a bit young, and a pain in the
// ass to install.
// http://groovy.codehaus.org/modules/http-builder/download.html
// http://www.coderanch.com/t/446927/Groovy/do-install-rd-party-module

// import groovyx.net.http.HTTPBuilder
// import static groovyx.net.http.Method.HEAD
// import static groovyx.net.http.ContentType.TEXT

// // create a new builder
// def http = new HTTPBuilder( 'http://www.apache.org/' )

// http.request( HEAD, TEXT ) {req ->
//  response.success = { resp, reader ->
//    resp.allHeaders.each {println it}
//  }
//  response.failure = { resp, reader ->
//    println "Server Response:  ${resp.statusLine}"
//  }
// }
