package ro.fasttrackit.tema15.payment.events;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;
import ro.fasttrackit.tema15.payment.dto.Payment;

@Value
@Builder
@JsonDeserialize(builder = PaymentEvent.PaymentEventBuilder.class)
public class PaymentEvent {
    Payment payment;
    PaymentEventType type;

    @JsonPOJOBuilder(withPrefix = "")
    public static class PaymentEventBuilder {
    }
}
