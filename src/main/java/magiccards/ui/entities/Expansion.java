package magiccards.ui.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Expansion {
    private Integer expansionId;
    private String name;
    private String ptBrName;
    private String linkName;
    private String code;
    private Date launchDate;
    private Integer expansionCategoryId;
    private Boolean isPromo;
    private Boolean isLegal;
}
