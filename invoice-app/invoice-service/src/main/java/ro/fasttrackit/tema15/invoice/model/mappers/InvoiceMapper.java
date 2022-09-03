package ro.fasttrackit.tema15.invoice.model.mappers;

import org.springframework.stereotype.Component;
import ro.fasttrackit.tema15.invoice.dto.Invoice;
import ro.fasttrackit.tema15.invoice.model.InvoiceEntity;

import ro.fasttrackit.utils.ModelMappers;

@Component
public class InvoiceMapper implements ModelMappers<Invoice, InvoiceEntity> {

    public Invoice toApi(InvoiceEntity source) {
        return Invoice.builder()
                .id(source.getId())
                .description(source.getDescription())
                .amount(source.getAmount())
                .sender(source.getSender())
                .receiver(source.getReceiver())
                .payed(source.getPayed())
                .build();
    }

    public InvoiceEntity toDb(Invoice source) {
        return InvoiceEntity.builder()
                .id(source.getId())
                .description(source.getDescription())
                .amount(source.getAmount())
                .sender(source.getSender())
                .receiver(source.getReceiver())
                .payed(source.isPayed())
                .build();
    }

}
