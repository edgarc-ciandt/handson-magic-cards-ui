package magiccards.ui.entities;

import java.util.List;
import lombok.Data;

@Data
public class TablePage<T> {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
}
