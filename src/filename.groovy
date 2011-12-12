#!/usr/bin/env groovy

/* 
 *  Script: filename.groovy
 *   Usage: filename.groovy
 * Purpose: Shows how to pull directory, name, extension from filenames
 *  Author: Crazy Nate
 * History: 
 */

// http://pleac.sourceforge.net/pleac_groovy/directories.html
//----------------------------------------------------------------------------------
// Splitting a Filename into Its Component Parts
path = new File('Pleac/src/pleac9.groovy')
assert path.parent == 'Pleac' + File.separator + 'src'
assert path.name == 'pleac9.groovy'
ext = path.name.tokenize('.')[-1]
assert ext == 'groovy'

