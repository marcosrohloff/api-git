package br.com.apigit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.apigit.dto.GithubUserDto;
import br.com.apigit.dto.GithubUserPageDto;
import br.com.apigit.feign.GithubClient;
import br.com.apigit.util.Utils;

@RestController
public class GithubUserController {
	
	@Autowired
	private GithubClient githubClient;
	
	@GetMapping("/api/users")
	public GithubUserPageDto getUsers(@RequestParam(value = "since", defaultValue = "0") int since) {
		List<GithubUserDto> page = githubClient.getUsers(since);
		GithubUserPageDto result = new GithubUserPageDto();
		result.setPage(page);
		
		if(!page.isEmpty()) {
			Long lastId = page.getLast().getId();
			String url = Utils.getBaseUrl() + "/api/users?since=" + lastId;
			result.setNext(url);
		}		
		return result;
	}

}
