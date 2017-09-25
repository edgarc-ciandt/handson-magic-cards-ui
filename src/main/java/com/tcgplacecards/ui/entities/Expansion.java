package com.tcgplacecards.ui.entities;

/**
 * Created by edgarc on 8/4/17.
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Expansion {
    private Integer expasionId;
    private String name;
    private String portugueseName;
    private String linkName;
    private String code;
    private Date launchDate;
    private Integer expasionCategoryId;
    private  boolean isPromo;
    private  boolean isLegal;

}
