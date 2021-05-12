package korit.market.security.dto;

import korit.market.entity.Member;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthMemberDTO extends Member {

    private String email;
    private String memberName;
    private boolean fromSocial;

    public AuthMemberDTO(
            String memberName,
            String password,
            boolean fromSocial,
            Collection<? extends GrantedAuthority> authorities) {

        super(memberName, password, authorities);
        this.email = memberName;
        this.fromSocial = fromSocial;
    }
}
