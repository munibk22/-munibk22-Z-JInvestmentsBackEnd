//package com.revature.util;
//
//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//
//public class Bcrypt {
//	private String password = "thomas123";
//	private String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
//	private Logger log = LoggerFactory.getLogger(Bcrypt.class);
//
//	public Bcrypt(String userPassword) {
//		this.password = userPassword;
//	}
//	
//	public Bcrypt () {
//		super();
//	}
//
//	public boolean checkPassword(String password) {
//		if (BCrypt.checkpw(password, hashedPassword)) {
//			log.info("User password match");
//			return true;
//		} else {
//			log.warn("Passwords do not match");
//			return false;
//		}
//	}
//
//}
