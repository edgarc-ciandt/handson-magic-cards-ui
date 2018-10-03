package magiccards.ui.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Expansion {

	private Integer expasionId;
	private String name;
	private String portugueseName;
	private String linkName;
	private String code;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date launchDate;
	private Integer expasionCategoryId;
	private boolean promo;
	private boolean legal;
}
