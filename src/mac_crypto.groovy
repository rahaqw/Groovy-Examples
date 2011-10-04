#!/usr/bin/env groovy
import java.security.*
import javax.crypto.*

// Generate secret key for HMAC-MD5
KeyGenerator kg = KeyGenerator.getInstance("HmacSHA1");
SecretKey sk = kg.generateKey();

// Get instance of Mac object implementing HMAC-MD5, and 
// initialize it with the above secret key
Mac mac = Mac.getInstance("HmacSHA1");
mac.init(new SecretKey("bboo"));
byte[] result = mac.doFinal("Hi There".getBytes());
println result.toString()
