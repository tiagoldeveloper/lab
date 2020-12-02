package br.com.lab.service;

import br.com.lab.mensagens.Mensagens;
import br.com.lab.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public final class MensagemService {

    private MensagemRepository mensagemRepository;

    private static Mensagens instance;

    private static Map<String, String> msg;

    @Autowired
    public MensagemService(MensagemRepository mensagemRepository){
        this.mensagemRepository = mensagemRepository;
        msg = mensagemRepository.recuperaMensagens();
    }

    public MensagemService(){ }

    public static Mensagens getInstance(){
        if(instance ==null){
            instance = new Mensagens();
        }
        return instance;
    }


    public static Map<String, String> getMsg() {
        return msg;
    }

    public static void setMsg(Map<String, String> msg) {
        MensagemService.msg = msg;
    }
}
