package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.Mail;
import com.hotelpremier.Hotel.Premier.domain.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/correo")
public class MailController {

    @Autowired
    public MailService mailService;

    @PostMapping("/enviar")
    public String envioCorreo(@RequestBody Mail oCorreoDTO) {
        return mailService.enviarCorreo(
                oCorreoDTO.getCorreosAEnviar(),
                oCorreoDTO.getAsunto(),
                oCorreoDTO.getContenido(),
                oCorreoDTO.getNombresArchivos(),
                oCorreoDTO.getListabyte()
        );
    }

}
