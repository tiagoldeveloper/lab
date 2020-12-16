package br.com.lab.service;

import br.com.lab.domain.model.Grupo;
import br.com.lab.domain.model.Permissao;
import br.com.lab.dto.GrupoPermissaoModelDTO;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.PermissaoGrupoModel;
import br.com.lab.model.input.GrupoPermissaoInput;
import br.com.lab.repository.GrupoPermissaoRepository;
import br.com.lab.util.LabUtil;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoPermissaoService {

    private final GrupoPermissaoRepository grupoPermissaoRepository;
    private final GrupoPermissaoModelDTO grupoPermissaoModelDTO;

    public GrupoPermissaoService(GrupoPermissaoRepository grupoPermissaoRepository,GrupoPermissaoModelDTO grupoPermissaoModelDTO){
        this.grupoPermissaoRepository = grupoPermissaoRepository;
        this.grupoPermissaoModelDTO = grupoPermissaoModelDTO;
    }

    private static void setPermissao(PermissaoGrupoModel umaPermissao) {
        umaPermissao.setPermissaoGrupo(true);
    }

    public List<PermissaoModel> recuperaPermissoesGrupo(Long grupoId) {
        var grupo = grupoPermissaoRepository.recupera(Grupo.class, grupoId);
        return grupoPermissaoRepository.recuperaPermissoesGrupo(grupo.getId());
    }

    public List<PermissaoGrupoModel> recuperaTodasPermissoesComESemGrupo(Long grupoId) {

        var grupo = grupoPermissaoRepository.recupera(Grupo.class, grupoId);
        var permissoesSemGrupoModel = new ArrayList<PermissaoGrupoModel>();
        List<PermissaoGrupoModel> permissoesGrupoModels = grupoPermissaoRepository.recuperaPermissoesPorGrupo(grupo.getId());

        if(LabUtil.isNotEmpty(permissoesGrupoModels)){
            permissoesGrupoModels.forEach(GrupoPermissaoService::setPermissao);
            permissoesSemGrupoModel.addAll(permissoesGrupoModels);
            var permissoesIdsGrupo = permissoesGrupoModels.stream().map(PermissaoGrupoModel::getId).collect(Collectors.toList());
            var permissoesSemGrupo = grupoPermissaoRepository.recuperaNotIn(Permissao.class, permissoesIdsGrupo);
            if(LabUtil.isNotEmpty(permissoesSemGrupo)){
                permissoesSemGrupoModel.addAll(grupoPermissaoModelDTO.toPermissoesGrupoModelCollection(permissoesSemGrupo));
            }
        }else {
            List<Permissao> permissoes = grupoPermissaoRepository.recupera(Permissao.class);
            permissoesSemGrupoModel.addAll(grupoPermissaoModelDTO.toPermissoesGrupoModelCollection(permissoes));
        }

       return permissoesSemGrupoModel;
    }

    @Transactional
    public void associarDesassociaEmLote(Long grupoId, List<GrupoPermissaoInput> permissoesInput){

        var grupo = grupoPermissaoRepository.recupera(Grupo.class, grupoId);

        var permissoesIdsSelecionadas = permissoesInput.stream().filter(GrupoPermissaoInput::isPermissaoSelecionada)
                .map(GrupoPermissaoInput::getPermissaoId).collect(Collectors.toList());

        var permissoesIdsNaoSelecionadas = permissoesInput.stream().filter(GrupoPermissaoService::isPermissaoSelecionada)
                .map(GrupoPermissaoInput::getPermissaoId).collect(Collectors.toList());

        if(LabUtil.isNotEmpty(permissoesIdsNaoSelecionadas)){
            var permissoesNaoSelecionadas = grupoPermissaoRepository.recupera(Permissao.class, permissoesIdsNaoSelecionadas);
            permissoesNaoSelecionadas.forEach(grupo::removePermissao);
        }

        if(LabUtil.isNotEmpty(permissoesIdsSelecionadas)){
            var permissoesNovasSelecionadas = grupoPermissaoRepository.recupera(Permissao.class, permissoesIdsSelecionadas);
            permissoesNovasSelecionadas.forEach(grupo::adicionaPermissao);
        }
    }

    private static boolean isPermissaoSelecionada(GrupoPermissaoInput umPermissao) {
        return !umPermissao.isPermissaoSelecionada();
    }
}
