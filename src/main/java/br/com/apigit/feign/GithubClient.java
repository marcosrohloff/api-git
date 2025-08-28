package br.com.apigit.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.apigit.dto.GithubUserDto;

@FeignClient(name = "github", url = "${github.client.url}")
public interface GithubClient {

    @GetMapping("/users")
    List<GithubUserDto> getUsers(@RequestParam("since") int since);
    
}