#!/usr/bin/env groovy
/* 
 *  Script: date_gmt.groovy
 *   Usage: date_gmt.groovy
 * Purpose:
 *  Author: Crazy Nate
 * History: 
 */

import java.text.SimpleDateFormat

def cal= new GregorianCalendar()
def stringDate = '7 Aug 2009 15:50:53 -0000'
def df = new SimpleDateFormat("dd MMM yyyy hh:mm:ss -SSSS")
def createDate = df.parse(stringDate)
def d = new Date(createDate.time + cal.get(Calendar.ZONE_OFFSET))

println "GMT Date: " + createDate
println "Local Date: " + d
