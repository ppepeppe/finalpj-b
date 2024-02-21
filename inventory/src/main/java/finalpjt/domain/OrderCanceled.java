package finalpjt.domain;

import finalpjt.domain.*;
import finalpjt.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;
    private String customerId;
}
