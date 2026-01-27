package com.novidades.gestaodeprojetos.service;


import com.novidades.gestaodeprojetos.model.MensagemEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarEmail(MensagemEmail mensagemEmail) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"UTF-8");



        helper.setFrom(mensagemEmail.getRemetente());

        helper.setSubject(mensagemEmail.getAssunto());
        helper.setText(mensagemEmail.getCorpo(), true);
        helper.setTo(mensagemEmail.getDestinatario().toArray(
                new String[mensagemEmail.getDestinatario().size()]));

        javaMailSender.send(mimeMessage);

    }


}
