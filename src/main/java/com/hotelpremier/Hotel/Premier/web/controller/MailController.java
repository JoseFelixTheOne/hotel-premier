package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.Mail;
import com.hotelpremier.Hotel.Premier.domain.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("mail")
public class MailController {

    @Autowired
    public MailService mailService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String sendMail(@RequestBody Mail mail) {
        return mailService.enviarCorreo(
                mail.getCorreosAEnviar(),
                mail.getAsunto(),
                mail.getContenido(),
                mail.getNombresArchivos(),
                mail.getListabyte()
        );
    }

}
