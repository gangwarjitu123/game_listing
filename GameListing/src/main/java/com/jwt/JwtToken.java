package com.jwt;

import java.util.Date;

public class JwtToken {
private String issuer;
private String userId;
private Date date;
/**
 * @return the issuer
 */
public String getIssuer() {
	return issuer;
}
/**
 * @param issuer the issuer to set
 */
public void setIssuer(String issuer) {
	this.issuer = issuer;
}
/**
 * @return the userId
 */
public String getUserId() {
	return userId;
}
/**
 * @param userId the userId to set
 */
public void setUserId(String userId) {
	this.userId = userId;
}
/**
 * @return the date
 */
public Date getDate() {
	return date;
}
/**
 * @param date the date to set
 */
public void setDate(Date date) {
	this.date = date;
}


}
