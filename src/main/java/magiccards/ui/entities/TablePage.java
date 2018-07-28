package magiccards.ui.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TablePage<T> {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
}
