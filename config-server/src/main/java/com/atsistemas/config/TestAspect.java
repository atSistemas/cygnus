//package com.atsistemas.config;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
////@Aspect
////@Component
//public class TestAspect {
//
//	@SuppressWarnings("unchecked")
////	@Around("execution(* org.springframework.cloud.config.monitor.PropertyPathEndpoint.notifyByPath(..))")
//	public Object testAround(ProceedingJoinPoint  proceedingJoinPoint) throws Throwable {
//
//		System.out.println("--> notifyByPath interception - " + proceedingJoinPoint.getSignature().getName());
//		for(Object arg : proceedingJoinPoint.getArgs()){
//			System.out.println(arg.toString());
//		}
//		
//		Object[] args = proceedingJoinPoint.getArgs();
//		args[1] = getServiceNameMap((Map<String, Object>)args[1]);
//		
//		return proceedingJoinPoint.proceed(args);
//	}
//	
//	private Map<String, Object> getServiceNameMap(Map<String, Object> serviceNameMap){
//		
//		for(String key : serviceNameMap.keySet()){
//			System.out.println("--> key: " + key + " - value: " +serviceNameMap.get(key).toString());
//		}
//		
//		Map<String, Object> newServiceNameMap = new HashMap<String, Object>();
//		newServiceNameMap.put("path", "deneb-service");
//		
//		return newServiceNameMap;
//	}
//	
//}
