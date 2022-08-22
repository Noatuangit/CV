package com.login_author_cookie_session.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Account {
    String username;
    String password;
    Decentralization decentralization;
}
