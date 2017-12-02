package magiccards.ui.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Expansion {

    private int expansionId;
    private String name;
    private String ptBRName;
    private String linkName;
    private String code;
    private Date launchDate;
    private int expansionCategoryId;
    private boolean promo;
    private boolean legal;

}
