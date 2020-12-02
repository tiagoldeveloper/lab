package br.com.lab.util;

import br.com.lab.domain.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UsuarioUtil {


    public String geraNovaSenha(Usuario usuario){

        //TODO: cria uma nova senha e encriptar
        String novaSenha = "123";




        //TODO: chamar classe de e-mail para envio da nova senha.


        return novaSenha;
    }
}
