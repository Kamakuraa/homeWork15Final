package ro.fasttrackit.tema15.invoice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.exceptions.ResourceNotFoundException;
import ro.fasttrackit.tema15.invoice.dto.Invoice;
import ro.fasttrackit.tema15.invoice.model.mappers.InvoiceMapper;
import ro.fasttrackit.tema15.invoice.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService service;
    private final InvoiceMapper mapper;

    @GetMapping
    List<Invoice> getAll() {
        return mapper.toApi(service.getAll());
    }

    @GetMapping("{invoiceId}")
    Invoice getInvoice(@PathVariable String invoiceId) {
        return service.getInvoice(invoiceId)
                .map(mapper::toApi)
                .orElseThrow(() -> new ResourceNotFoundException ("Invoice with id " + invoiceId + " is not found"));
    }

    @PostMapping
    Invoice addInvoice(@RequestBody Invoice invoice) {
        return mapper.toApi(service.addInvoice(mapper.toDb(invoice)));
    }

    @DeleteMapping("{invoiceId}")
    Invoice deleteInvoice(@PathVariable String invoiceId) {
        return service.deleteInvoice(invoiceId)
                .map(mapper::toApi)
                .orElse(null);
    }
}
