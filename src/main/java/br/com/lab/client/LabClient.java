package br.com.lab.client;

import br.com.lab.model.GrupoModel;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.UsuarioModel;
import br.com.lab.model.input.GrupoInput;
import br.com.lab.model.input.PermissaoInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LabClient {

    private static String url ="http://localhost:9000/v1";

    public static void main(String[] args) {

            //permissao = ok
            ResponseEntity<PermissaoModel[]> permissao = new RestTemplate().getForEntity(url.concat("/permissao?size=10"), PermissaoModel[].class);
            ResponseEntity<PermissaoModel> permissaox = new RestTemplate().getForEntity(url.concat("/permissao/1"), PermissaoModel.class);
            PermissaoInput permissaoInput = new PermissaoInput();
            permissaoInput.setNome("Permissao teste");
            PermissaoModel permissaoModel = new RestTemplate().postForObject(url.concat("/permissao"), permissaoInput, PermissaoModel.class);
            new RestTemplate().put(url.concat("/permissao/{permissaoId}"), permissaoInput, "14");
            new RestTemplate().delete(url.concat("/permissao/{permissaoId}"), "14");


            //grupo = ok
            ResponseEntity<GrupoModel[]> grupo = new RestTemplate().getForEntity(url.concat("/grupo?size=10"), GrupoModel[].class);
            ResponseEntity<GrupoModel> grupox = new RestTemplate().getForEntity(url.concat("/grupo/1"), GrupoModel.class);
            GrupoInput grupoInput = new GrupoInput();
            grupoInput.setDescricao("Grupo teste x");
            grupoInput.setNome("Grupo teste x");
            GrupoModel grupoModel = new RestTemplate().postForObject(url.concat("/grupo"), grupoInput, GrupoModel.class);
            new RestTemplate().put(url.concat("/grupo/{grupoId}"), grupoInput, "12");
            new RestTemplate().delete(url.concat("/grupo/{grupoId}"), "12");


            //usuario = ok
            ResponseEntity<UsuarioModel[]> usuario = new RestTemplate().getForEntity(url.concat("/usuario?size=2"), UsuarioModel[].class);
            ResponseEntity<UsuarioModel> usuariox = new RestTemplate().getForEntity(url.concat("/usuario/1"), UsuarioModel.class);

    }

}