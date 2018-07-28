package magiccards.ui.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "expansionId")
public class Expansion implements Serializable {

    private Integer expansionId;
    private String name;
    private String portugueseName;
    private String linkName;
    private String code;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date launchDate;
    private Integer expansionCategoryId;
    private boolean promo;
    private boolean legal;

}
