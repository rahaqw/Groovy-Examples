 // Construct data
 // try to get the http response in grails
        def data = URLEncoder.encode("userid", "UTF-8") + "=" + URLEncoder.encode("admin")
            data += "&" + URLEncoder.encode("This is a multiline\nstring")
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode("grailsagogo")
            data += "&" + URLEncoder.encode("url", "UTF-8") + "=" + URLEncoder.encode("https://maven.atlassian.com/public//com/atlassian/studio/studio-fireball/1.4.1-rc3/studio-fireball-1.4.1-rc3-all.zip")
        println data
