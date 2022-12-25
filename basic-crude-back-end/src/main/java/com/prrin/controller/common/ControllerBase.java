package com.prrin.controller.common;

import com.prrin.controller.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ControllerBase<T> {

  public ResponseEntity<?> getById(T t) {
    return t == null
      ? new ResponseEntity<SuccessResponse<String>>(
        new SuccessResponse<String>(
          204,
          "information",
          "Record not Found.",
          "No Content",
          "Ok.",
          null
        ),
        HttpStatus.NOT_FOUND
      )
      : new ResponseEntity<T>(t, HttpStatus.OK);
  }

  public ResponseEntity<SuccessResponse<T>> success(T t) {
    return new ResponseEntity<SuccessResponse<T>>(
      new SuccessResponse<T>(
        201,
        "success",
        "Record Created",
        "Record Created Susscessfuly.!",
        "Ok",
        t
      ),
      HttpStatus.CREATED
    );
  }

  public ResponseEntity<SuccessResponse<Integer>> success(
    Integer t,
    String action
  ) {
    return new ResponseEntity<SuccessResponse<Integer>>(
      new SuccessResponse<Integer>(
        200,
        "success",
        "Record " + action,
        "Record " + action + " Susscessfuly.!",
        "Ok",
        t
      ),
      HttpStatus.OK
    );
  }

  public ResponseEntity<SuccessResponse<String>> no_content() {
    return new ResponseEntity<SuccessResponse<String>>(
      new SuccessResponse<String>(
        204,
        "information",
        "Record not Found.",
        "No Content",
        "Ok.",
        null
      ),
      HttpStatus.NO_CONTENT
    );
  }

  public ResponseEntity<SuccessResponse<String>> acepted() {
    return new ResponseEntity<SuccessResponse<String>>(
      new SuccessResponse<String>(
        202,
        "information",
        "Transaction Not Realized",
        "This Transaccion was acepted, but not realized.",
        "Ok.",
        null
      ),
      HttpStatus.ACCEPTED
    );
  }
}
