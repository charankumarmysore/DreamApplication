package com.ewaves;

import java.security.SecureRandom;

public class GenretaePassword {
	final String AB = "@#$&0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	SecureRandom rnd = new SecureRandom();
	String randomString( int len ){
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
		}
public static void main(String[] args) {
	
	GenretaePassword c=new GenretaePassword();
	System.out.println(c.randomString(7));
	
}
}
