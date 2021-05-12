package korit.market.security.service;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class OAuth2UserDetailsService {

    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        log.info("----------");
        log.info("userRequest: " + userRequest);

        String memberName = userRequest.getClientRegistration().getClientName();

        log.info("clientName" + memberName)
    }
}
