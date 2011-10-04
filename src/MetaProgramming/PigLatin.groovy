#!/usr/bin/env groovy 
class PigLatin {
    static void main(String[] args) {
	// Every instance within this class loader will
	// have this method.
	String.metaClass.getPigLatin = {->
	    delegate[1..-1] + delegate[0]
	}
	def name = 'nate'
	println name.pigLatin

	name = "Smoochy"
	println name.pigLatin

    }
}
