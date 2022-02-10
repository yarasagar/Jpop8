package com.epam.libraryservice.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private int userId;
    private String userName;
    private String mail;
    private String phoneNumber;

}
