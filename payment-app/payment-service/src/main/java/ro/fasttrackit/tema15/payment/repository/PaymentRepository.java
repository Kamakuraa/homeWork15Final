package ro.fasttrackit.tema15.payment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.tema15.payment.model.PaymentEntity;

public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {
}
