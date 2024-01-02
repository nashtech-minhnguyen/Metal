package com.softbank.app.gold.exception;

public class NetworkException extends RuntimeException{

  public NetworkException(String errorMessage){
    super(errorMessage);
  }
}
