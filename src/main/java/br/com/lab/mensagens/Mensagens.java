package br.com.lab.mensagens;

import br.com.lab.repository.MensagemRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Inicialmente as mensagens irá ficar em um map, mas futuramente pode ser colocada em um servidor de cache.
 */
@Component
public final class Mensagens {

    private MensagemRepository mensagemRepository;

    private static Mensagens instance;

    private static Map<String, String> mensagens;

    @Autowired
    public Mensagens(MensagemRepository mensagemRepository){
        this.mensagemRepository = mensagemRepository;
        mensagens = mensagemRepository.recuperaMensagens();
    }

    public Mensagens(){ }

    public static Mensagens getInstance(){
        if(instance ==null){
            instance = new Mensagens();
        }
        return instance;
    }

    public String getMsg(String chave) {
        return  StringUtils.defaultString(mensagens.get(chave), mensagens.get("mensagem.nao.encontrada"));
    }

    public String getMsg(List<String> chaves){
        return chaves.stream().map(umaChave -> getMsg(umaChave)).collect(Collectors.joining(", "));
    }

    public String getMsg(String chave, Object[] parametros) {
        if(parametros !=null){
            return java.text.MessageFormat.format(mensagens.get(chave), parametros);
        }
        return mensagens.get(chave);
    }


}
