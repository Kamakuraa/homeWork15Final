package ro.fasttrackit.tema15.invoice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.tema15.invoice.model.InvoiceEntity;

public interface InvoiceRepository extends MongoRepository<InvoiceEntity, String> {
}
