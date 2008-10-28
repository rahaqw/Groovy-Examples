#!/usr/bin/env groovy

def foo = new groovy.xml.MarkupBuilder()

foo.sports {
	baseball {
		league('My Value of the Element!', org: 'MLB', name: 'National') {
			cardinals()
		}
	}
}
