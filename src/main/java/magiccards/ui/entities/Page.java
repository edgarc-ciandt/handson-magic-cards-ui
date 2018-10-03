package magiccards.ui.entities;

import java.util.List;

import lombok.Data;

@Data
public class Page<T> {
	private List<T> content;
	private boolean last;
	private int totalPages;
	private int totalElements;
	private boolean first;
	private int numberOfElements;
	private int size;
	private int number;
}
