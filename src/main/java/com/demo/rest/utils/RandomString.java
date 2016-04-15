package com.demo.rest.utils;

import java.util.Random;

import com.demo.rest.models.UsersUidModel;
/**
 * generateRandomUid method generates a random string 
 * @author Padmaja Krishnakumar
 * @version 1.0
 * @since 12 April 2016
 */
public class RandomString {

	  private static final char[] symbols;

	  static {
	    StringBuilder tmp = new StringBuilder();
	    for (char ch = '0'; ch <= '9'; ++ch)
	      tmp.append(ch);
	    for (char ch = 'a'; ch <= 'z'; ++ch)
	      tmp.append(ch);
	    symbols = tmp.toString().toCharArray();
	  }   

	  private final Random random = new Random();

	  private final char[] buf= new char[32];

	 

	  public  String generateRandomUid() {
		boolean uniqueUid = false;
		while(!uniqueUid){
	    for (int idx = 0; idx < buf.length; ++idx) 
	      buf[idx] = symbols[random.nextInt(symbols.length)];
	    
	    if(!UsersUidModel.instance.getAllUsers().containsKey( new String(buf)))
	    	uniqueUid=true;
	    
		}
	    return new String(buf);
		}
	  
	}
