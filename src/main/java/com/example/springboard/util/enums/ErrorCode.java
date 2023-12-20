package com.example.springboard.util.enums;

public enum ErrorCode {
  NOT_FOUND(404, "PAGE NOT FOUND"),
  INTERNAL_SERVER_ERROR(500, "INTERNAL SERVER ERROR"),
  NO_SUCH_ENTITY(500, "NO SUCH ENTITY"),
  BAD_REQUEST(400, "BAD REQUEST"),
  FORBIDDEN(403, "FORBIDDEN: ACCESS DENIED"),
  InValid_Token_Exception(400, "InValid Token Exception"),
  UNAUTHORIZED(401, "UNAUTHORIZED");

  private int status;
  private String message;

  ErrorCode(int status, String message) {
    this.status = status;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
