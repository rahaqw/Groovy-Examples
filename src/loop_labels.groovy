#!/usr/bin/env groovy 
// This is not a loop label thing, because I don't think
// that loop labels exist in groovy?
// use return to get out of the innermost closure
officers = [ 'lt. dangle', 'officer garcia', 'trudy' ]
officers.each {
    println it
}


snipes = [ 'is dumb', 'is funny', 'is a character on Reno 911' ]

officers.each { off->
    snipes.each { snipe-> 
        // every character is dumb, except for dangle
	if (snipe =~ /dumb/ && off =~ /dangle/) {
	    return
	}
	else {
	    println off + " " + snipe
	}
    }
}

