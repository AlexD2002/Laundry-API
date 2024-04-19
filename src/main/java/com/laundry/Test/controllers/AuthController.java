package com.laundry.Test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laundry.Test.users.DadosAuth;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthController {
		@Autowired
		private AuthenticationManager manager;
	
		@PostMapping
		public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAuth dados){
			var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
			var auth = manager.authenticate(token);
				
			return ResponseEntity.ok().build();
		}
	
}

 