package ro.fasttrackit.tema15.payment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ro.fasttrackit.enums.StatusEnum;
import ro.fasttrackit.tema15.invoice.events.InvoiceEvent;
import ro.fasttrackit.tema15.payment.model.PaymentEntity;

import static ro.fasttrackit.tema15.invoice.events.InvoiceEventType.ADDED;


@Slf4j
@Component
@RequiredArgsConstructor
public class InvoiceEventListener {
    private final PaymentService paymentService;

    @RabbitListener(queues = "#{invoiceQueue.name}")
    void processPaymentEvent(InvoiceEvent event) {
        if (event.getType() == ADDED) {
            PaymentEntity addedPayment = paymentService.addPayment(
                    PaymentEntity.builder()
                            .invoiceId(event.getInvoice().getId())
                            .status(event.getInvoice().getReceiver() != null ? StatusEnum.PENDING : StatusEnum.REJECT)
                            .amountPayable(event.getInvoice().getAmount())
                            .build()
            );
            log.info("Added payment " + addedPayment);
        }
    }
}
