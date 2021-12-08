package com.epam.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @NotBlank
    private String bookName;

}
