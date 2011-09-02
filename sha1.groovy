#!/usr/bin/env groovy
import java.security.MessageDigest

def stringToHash =  "abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq"
def messageDigest = MessageDigest.getInstance("SHA1")
messageDigest.update( stringToHash.getBytes() );
def sha1Hex = new BigInteger(1, messageDigest.digest()).toString(16).padLeft( 40, '0' )


assert sha1Hex == "84983e441c3bd26ebaae4aa1f95129e5e54670f1"

