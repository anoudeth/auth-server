package com.noh.authserver.config;

import com.noh.authserver.entity.AuthenticationToken;
import com.noh.authserver.entity.User;
import com.noh.authserver.model.UserSummery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class CustomTokenEnhancer extends JwtAccessTokenConverter {
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//		System.out.println("authentication : " + authentication.getPrincipal() + " - " + authentication.getUserAuthentication());

		Map<String, Object> info = new LinkedHashMap<String, Object>(accessToken.getAdditionalInformation());

		AuthenticationToken authenticationToken = new AuthenticationToken();
		authenticationToken.setPrincipal(authentication.getPrincipal());
		authenticationToken.setCredentials(authentication.getCredentials());
		authenticationToken.setGrantedAuthorities(authentication.getAuthorities());

		if (authentication.getUserAuthentication() != null) {
			// this one mean grant type password
			authenticationToken.setDetails(authentication.getUserAuthentication().getDetails());
			User user = (User) authentication.getPrincipal();

			UserSummery userSummery = new UserSummery();
			userSummery.setUsername(user.getUsername());
			userSummery.setEmail(user.getEmail());
			userSummery.setAddress(user.getAddress());

			info.put("user", userSummery);
			info.put("email", user.getEmail());
//			info.put("user", user);
		}

		DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
		customAccessToken.setAdditionalInformation(info);
		this.log.info("> User Authentication : {}", authenticationToken );
		return super.enhance(customAccessToken, authentication);
	}
}