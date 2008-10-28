 // Construct data
 // try to get the http response in grails
        def data = URLEncoder.encode("userid", "UTF-8") + "=" + URLEncoder.encode("admin")
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode("grailsagogo")
            data += "&" + URLEncoder.encode("url", "UTF-8") + "=" + URLEncoder.encode("https://maven.atlassian.com/public//com/atlassian/studio/studio-fireball/1.4.1-rc3/studio-fireball-1.4.1-rc3-all.zip")
    
        // Send data
        URL url = new URL("http://localhost:8555/JSAM/uploadedJar/uploadRemoteJar")
        URLConnection conn = url.openConnection()
        conn.setDoOutput(true)
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream())
        wr.write(data)
        wr.flush()
    
        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))
        
        println rd.readLine()

        wr.close()
        rd.close()

