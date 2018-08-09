package magiccards.ui.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Expansion {
    private String expansionId;
    private String name;
    private String portugueseName;
    private String linkName;
    private String code;
    private Date launchDate;
    private Integer expansionCategoryId;
    private Boolean promo;
    private Boolean legal;
}
