package com.mycompany.invoice.api.controller;

import com.mycompany.invoice.web.entity.Customer;
import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.service.IInvoiceService;
import com.mycompany.invoice.web.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceControllerRest {

    /**
     * ATTRIBUTS
     */
    private IInvoiceService invoiceService;
    private ICustomerService customerService;

    /**
     * CONSTRUCTEUR
     */
    @Autowired
    public InvoiceControllerRest(IInvoiceService invoiceService, ICustomerService customerService){
        this.invoiceService = invoiceService;
        this.customerService = customerService;
    }

    /**
     * METHODS
     */
    @GetMapping
    public Iterable<Invoice> getAllInvoices(){
        System.out.println(" ----- InvoiceControllerRest/getAllInvoices ----- ");

        // Récupérer les données depuis le service
        Iterable<Invoice> listInvoice = invoiceService.getListInvoice();

        // Retourner les données
        return listInvoice;
    }

    @GetMapping("/customers")
    public Iterable<Customer> getAllCustomers() {
        return customerService.getListCustomer();
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable("id") String number){
        System.out.println(" ----- InvoiceControllerRest/getInvoiceById ----- ");

        // Récupérer les données depuis le service
        Invoice invoice = invoiceService.getInvoiceByNumber(number);

        // Retourner les données
        return invoice;
    }

    // @RequestBody : Convertir  le format JSON En objet Java
    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice){
        System.out.println(" ----- InvoiceControllerRest/createInvoice ----- ");

        invoiceService.create(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoice);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") String number, @RequestBody Invoice updatedInvoice) {
        System.out.println(" ----- updateInvoice ----- ");

        Invoice existingInvoice = invoiceService.getInvoiceByNumber(number);

        if (existingInvoice != null) {
            existingInvoice.setCustomerName(updatedInvoice.getCustomerName());
            existingInvoice.setOrderNumber(updatedInvoice.getOrderNumber());
            invoiceService.create(existingInvoice); // Utiliser un service update si disponible
            return ResponseEntity.ok(existingInvoice);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }*/

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable("id") String number) {
        System.out.println(" ----- deleteInvoice ----- ");

        Invoice existingInvoice = invoiceService.getInvoiceByNumber(number);

        if (existingInvoice != null) {
            invoiceService.delete(existingInvoice);
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }*/

    /**
     * GETTERS/SETTERS
     */
    public IInvoiceService getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
}