package br.com.apigit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.apigit.dto.GithubUserDto;
import br.com.apigit.feign.GithubClient;

@RestController
public class GithubUserController {
	
	@Autowired
	private GithubClient githubClient;
	
	@GetMapping("/api/users")
	public List<GithubUserDto> getUsers(@RequestParam(value = "since", defaultValue = "0") int since) {
		return githubClient.getUsers(since);
	}

}
