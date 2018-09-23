package magiccards.ui.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Expansion {
	private Integer expansionId;
	private String name;
	private String ptBrName;
	private String linkName;
	private String code;
	private Date launchDate;
	private Short expansionCategoryId;
	private boolean promo;
	private boolean legal;
}
