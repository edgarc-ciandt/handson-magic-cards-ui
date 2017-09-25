package magiccards.ui.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Card {
	private String gathererId;
	private Integer variation;
	private String searchName;
	private String ptBrSearchName;
	private String englishName;
	private String ptBrName;
	private String linkName;
	private Integer color;
	private String manaCost;
	private Integer collectionNumber;
	private Float convertedManaCost;
	private String rarity;
	private String rules;
	private String flavorText;
	private Integer superTypes;
	private Integer cardTypes;
	private String unseriousSubTypes;
	private String power;
	private String toughness;
	private String loyalty;
	private Integer expansionId;
	private Integer artistId;
	private String flipname;
	private String flipRules;
	private Integer flipSuperTypes;
	private Integer flipTypes;
	private String flipPower;
	private String flipToughness;
	private String flipGathererId;
	private String splitManaCost;
	private Float splitConvertedManaCost;
}
