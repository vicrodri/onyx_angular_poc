/**
 * 
 */
package com.vicrodri.angularpoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vrodriguezgu
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

    private static final long serialVersionUID = 7610649562916713888L;

	public ResourceNotFoundException(String message){
        super(message);
    }
}