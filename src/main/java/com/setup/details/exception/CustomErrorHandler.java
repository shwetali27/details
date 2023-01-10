//package com.setup.details.exception;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
//import org.springframework.web.server.MissingRequestValueException;
//import org.springframework.web.server.ServerWebExchange;
//
//import reactor.core.publisher.Mono;
//
//@ControllerAdvice
//public class CustomErrorHandler extends ResponseEntityExceptionHandler{
//
//	@Override
//	protected Mono<ResponseEntity<Object>> handleMissingRequestValueException(
//			MissingRequestValueException ex, HttpHeaders headers, HttpStatusCode status,
//			ServerWebExchange exchange) {
//		System.out.println("Inside");
//		
//		return handleExceptionInternal(ex, null, headers, HttpStatus.INTERNAL_SERVER_ERROR, exchange);
//	}
//	
//}
