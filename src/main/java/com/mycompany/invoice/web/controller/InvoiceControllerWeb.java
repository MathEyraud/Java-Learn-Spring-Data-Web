package com.mycompany.invoice.web.controller;


import com.mycompany.invoice.web.entity.Address;
import com.mycompany.invoice.web.entity.Customer;
import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.service.customer.ICustomerService;
import com.mycompany.invoice.web.service.IInvoiceService;
import com.mycompany.invoice.form.InvoiceForm;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class InvoiceControllerWeb {

    /**
     * ATTRIBUTS
     */
    private IInvoiceService invoiceService;
    private ICustomerService customerService;

    /**
     * CONSTRUCTEUR
     */
    @Autowired
    public InvoiceControllerWeb(IInvoiceService invoiceService, ICustomerService customerService){
        this.invoiceService = invoiceService;
        this.customerService = customerService;
    }

    /**
     * METHODS
     */
    @GetMapping("/home")
    public String displayHome(){
        System.out.println(" ----- displayHome ----- ");
        return "index";
    }

    @GetMapping("/local-country")
    public String displayLocalCountry(){
        System.out.println(" ----- displayLocalCountry ----- ");
        return "local-country";
    }

    @GetMapping("/invoice/invoice-list")
    public String displayInvoiceList(Model model){
        System.out.println(" ----- InvoiceControllerWeb/displayListInvoice ----- ");

        // Récupérer les données depuis le service
        Iterable<Invoice> listInvoice = invoiceService.getListInvoice();

        // Envoyer les données vers le fichier html
        model.addAttribute("invoice",listInvoice);

        return "invoice-list";
    }

    /*@GetMapping("/invoice/{id}")
    public String displayInvoiceDetail(@PathVariable("id") String number, Model model){
        System.out.println(" ----- displayInvoiceDetail ----- ");

        // Récupérer les données depuis le service
        Invoice invoice = invoiceService.getInvoiceByNumber(number);

        // Envoyer les données vers le fichier html
        model.addAttribute("invoice",invoice);

        return "invoice-detail";
    }*/

    @PostMapping("/invoice/add-new-invoice")
    public String createInvoice(
            @Valid
            @ModelAttribute("invoiceForm")
            InvoiceForm invoiceForm,
            BindingResult bindingResult,
            Model model
        ){

        if (bindingResult.hasErrors()) {
            System.out.println(" ----- bindingResult : " + bindingResult);
            return "invoice-add";
        }

        Invoice invoice = new Invoice();

        // Todo : Cf message suivant (gestion de création d'utilisateur)
        // Pour l'ajout d'un client il faut vérifier si le client n'existe pas déja
        // Dans notre cas on laissera l'utilisateur choisir s'il ajoute un nouveau client
        // ou s'il en utilise un dans la DB via une liste déroulante

        Customer customer;
        if (invoiceForm.isNewCustomer()) {

            // Création du nouveau client
            customer = new Customer();
            customer.setName(invoiceForm.getCustomerName());

            // Ajout de son adresse
            Address addressCustomer = new Address(
                    invoiceForm.getStreet(),
                    invoiceForm.getStreetNumber(),
                    invoiceForm.getCity(),
                    invoiceForm.getZipCode(),
                    invoiceForm.getCountry()
            );
            customer.setAddress(addressCustomer);
            customer = customerService.create(customer);

        } else {
            customer = customerService.getCustomerByNumber(invoiceForm.getCustomerId());
        }

        invoice.setCustomer(customer);
        invoice.setOrderNumber(invoiceForm.getOrderNumber());

        // Todo : Normalement il faut gérer les éventuelles erreurs
        invoiceService.create(invoice);
        model.addAttribute("message", "Invoice successfully submitted!");

        return "invoice-add-success";
    }

    @GetMapping("/invoice/add")
    public String addInvoice(Model model){
        System.out.println(" ----- addInvoice ----- ");
        model.addAttribute("invoiceForm", new InvoiceForm());
        return "invoice-add";
    }

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