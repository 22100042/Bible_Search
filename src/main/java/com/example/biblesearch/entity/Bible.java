package com.example.biblesearch.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "bible2")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    private Integer cate;
    private Integer book;
    private Integer chapter;
    private Integer paragraph;

    @Column(columnDefinition = "TINYTEXT")
    private String sentence;

    private String testament;

    @Column(name="long_label")
    private String longLabel;

    @Column(name="short_label")
    private String shortLabel;
}
