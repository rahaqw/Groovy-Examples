#!/usr/bin/env groovy

/* 
 *  Script: currentDir.groovy
 *
 * Purpose: <+purpose+>
 *
 *   Usage: groovy currentDir.groovy <+usage+> 
 *
 *  Author: <+author+>
 */

// Parse command line arguments
// Create temp file in current directory
def currentDir = System.getProperty('user.dir')
println currentDir
