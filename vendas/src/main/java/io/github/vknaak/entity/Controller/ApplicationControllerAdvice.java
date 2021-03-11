package io.github.vknaak.entity.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Object handleValidationErros(MethodArgumentNotValidException ex) {
		BindingResult bindResult = ex.getBindingResult();
		List<String> messages = bindResult.getAllErrors()
				.stream()
				.map( ObjectError -> ObjectError.getDefaultMessage())
				.collect(Collectors.toList());
	}

}
