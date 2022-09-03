package ro.fasttrackit.tema15.invoice.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.fasttrackit.tema15.invoice.dto.Invoice;

import java.util.List;

class InvoiceApiClientTestIT {
    private InvoiceApiClient invoiceApiClient;

    @BeforeEach
    void setup() {
        this.invoiceApiClient = new InvoiceApiClient("http://localhost:9011");
    }

    @Test
    void getAllInvoices() {
        List<Invoice> allInvoices = invoiceApiClient.getAllInvoices();

        System.out.println(allInvoices);
    }

//    @Test
//    void getInvoiceById() {
//        Optional<Invoice> invoice = invoiceApiClient.getById("60c267c6650fa97a1e3864ed");
//
//        System.out.println(invoice);
//    }

    @Test
    void deleteInvoice() {
        System.out.println(invoiceApiClient.deleteInvoice("60c276e39ae8e01170ba2dcc"));
    }

    @Test
    void addAInvoice() {
        invoiceApiClient.addInvoice(Invoice.builder()
                .description("description2")
                .amount(2)
                .receiver("receiver")
                .sender("sender")
                .payed(false)
                .build());
    }
}
