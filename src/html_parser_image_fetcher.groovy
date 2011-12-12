#!/usr/bin/env groovy
import org.cyberneko.html.parsers.SAXParser

def url = 'http://java.sun.com'
def html = new XmlSlurper(new SAXParser()).parse(url)

def bolded = html.'**'.findAll{it.name() == 'B' }
def out = bolded.A*.text().collect{ it.trim() }

out.removeAll([''])
out.each{ println it }
