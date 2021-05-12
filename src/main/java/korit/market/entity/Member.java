package korit.market.entity;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import korit.market.entity.Role;
import lombok.*;

import javax.persistence.*;

/**
 * userId      varchar(16)    not null primary key,
 * userPwd    varchar(16)   not null,
 * userName    varchar(30)    not null,
 * userPhon    varchar(20)    not null,
 * userEmail  varchar(50)    not null,
 * userAddr1   varchar(20)    null,
 * userAddr2   varchar(50)    null,
 * userAddr3   varchar(50)    null,
 */

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    private String memberId;

    private String memberPwd;

    private String memberName;

    private boolean fromSocial;

    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    private String address1;

    private String address2;

    private String address3;

    @Enumerated(EnumType.STRING) //JPA로 데이터베이스로 저장할 때 Enum 값을 어떤 형태로 저장할지 결정
    @Column(nullable = false)    //기본적으로 int로 된 숫자가 저장됨, 숫자로하면 의미를 알 수 없어 문자열로 수정
    private Role role;

    @Builder
    public Member(String name, String email, Role role) {
        this.memberName = name ;
        this.email = email ;
        this.role = role ;
    }

//    public String getRoleKey() {
//        return this.role.getKey();
//    }
//
}

