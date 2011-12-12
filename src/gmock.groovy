#!/usr/bin/env groovy

/* 
 *  Script: gmock.groovy
 *
 * Purpose: <+purpose+>
 *
 *   Usage: groovy gmock.groovy <+usage+> 
 *
 *  Author: Nathan Neff
 */

import org.gmock.GMockTestCase

class LoaderTest extends GMockTestCase {
    void testLoader() {

        def mockLoader = mock()
        mockLoader.load("fruit").returns("apple")
        play {
            assertEquals "apple", mockLoader.load('fruit')
        }
    }
}
