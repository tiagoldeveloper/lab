package br.com.lab.teste;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        OffsetDateTime o = OffsetDateTime.now();
        System.out.println(o.format(formatter));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("usuariox123"));
    }
}
