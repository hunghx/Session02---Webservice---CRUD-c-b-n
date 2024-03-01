package ra.session02webservice.dto;

import lombok.*;
import org.springframework.data.domain.Sort;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PageDto {
    private Object data;
    private Boolean hasNext, hasPrev;
    private long pages;
    private long totalElements;
    private int number;
    private int size;
    private Sort sort;
}
