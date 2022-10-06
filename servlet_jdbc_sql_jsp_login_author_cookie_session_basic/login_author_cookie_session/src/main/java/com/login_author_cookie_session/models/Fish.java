package com.login_author_cookie_session.models;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Fish {
    int id;
    Integer price;
    String name;
    String type;
    Boolean gender;
    String avatar;
}
