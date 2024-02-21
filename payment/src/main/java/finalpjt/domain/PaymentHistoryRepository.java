package finalpjt.domain;

import finalpjt.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "paymentHistories",
    path = "paymentHistories"
)
public interface PaymentHistoryRepository
    extends PagingAndSortingRepository<PaymentHistory, Long> {}
