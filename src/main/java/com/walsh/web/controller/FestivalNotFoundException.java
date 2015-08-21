package com.walsh.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown by {@link BeerFestController#getFestival(Long)} when the festival id passed in was not found
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FestivalNotFoundException extends RuntimeException{


}
