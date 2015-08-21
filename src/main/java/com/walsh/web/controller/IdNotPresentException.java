package com.walsh.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown by {@link BeerFestController#getFestival(Long)} when festival id was not passed into the request
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IdNotPresentException extends RuntimeException {
}
