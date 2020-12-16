package br.com.lab.mensagens;

import br.com.lab.repository.MensagemRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TODO: Inicialmente as mensagens irá ficar em um map, mas futuramente pode ser colocado em um servidor de cache.
@Component
public final class Mensagens {

    private static Mensagens instance;
    private static Map<String, String> mensagens;

    public Mensagens(){ }

    @Autowired
    public Mensagens(final MensagemRepository mensagemRepository){
        mensagens = mensagemRepository.recuperaMensagens();
    }

    public static Mensagens getInstance(){
         if (instance!=  null) {
            return instance;
        }
        instance = new Mensagens();
        return instance;
    }

    public String getMsg(String chave) {
        return  StringUtils.defaultString(mensagens.get(chave), mensagens.get("mensagem.nao.encontrada"));
    }

    public String getMsg(List<String> chaves){
        return chaves.stream().map(this::getMsg).collect(Collectors.joining(", "));
    }

    public String getMsg(String chave, Object[] parametros) {
        return null != parametros ?  java.text.MessageFormat.format(mensagens.get(chave), parametros) :
                mensagens.get(chave);
    }

}