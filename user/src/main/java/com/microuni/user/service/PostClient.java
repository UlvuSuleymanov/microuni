package com.microuni.user.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "post",url = "http://localhost:8080" )
public interface PostClient {

 }
