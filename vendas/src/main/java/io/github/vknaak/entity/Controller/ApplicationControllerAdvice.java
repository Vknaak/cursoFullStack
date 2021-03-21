package io.github.vknaak.entity.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErros handleValidationErros(MethodArgumentNotValidException ex) {
		BindingResult bindResult = ex.getBindingResult();
		List<String> messages = bindResult.getAllErrors()
				.stream()
				.map( ObjectError -> ObjectError.getDefaultMessage())
				.collect(Collectors.toList());
		return new ApiErros(messages);
	}
	
	public ResponseEntity<ApiErros> handleResponseStatusException(ResponseStatusException ex) {
		
		String  mensagemErro = ex.getMessage();
		HttpStatus codigoStatus = ex.getStatus();
		
		ApiErros apiErros = new ApiErros((mensagemErro));
		return new ResponseEntity<ApiErros>(apiErros,codigoStatus);
	}

}
