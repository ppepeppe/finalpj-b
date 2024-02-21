package finalpjt.domain;

import finalpjt.domain.*;
import finalpjt.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private String customerId;
    private String status;
}
