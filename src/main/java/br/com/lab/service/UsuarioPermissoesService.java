package br.com.lab.service;

import br.com.lab.domain.model.Usuario;
import br.com.lab.model.MenuItemModel;
import br.com.lab.repository.UsuarioPermissoesRepository;
import br.com.lab.repository.UsuarioRepository;
import br.com.lab.types.TipoMenuItem;
import br.com.lab.util.LabUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioPermissoesService {

    private final UsuarioPermissoesRepository usuarioPermissoesRepository;
    private final UsuarioRepository usuarioRepository;

    public UsuarioPermissoesService(UsuarioPermissoesRepository usuarioPermissoesRepository, UsuarioRepository usuarioRepository) {
        this.usuarioPermissoesRepository = usuarioPermissoesRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<MenuItemModel> recuperaPermissoesMenuItem() {

        Long usuarioId = recuperaUsuario();
        List<MenuItemModel> menuItem = null;

        if(usuarioId !=null){
            List<MenuItemModel> menuItems = usuarioPermissoesRepository.recuperaPermissoesMenuItem(usuarioId);
            if (LabUtil.isNotEmpty(menuItems)) {
                menuItem = menuItems.stream().filter(umMenuItem -> umMenuItem.getTipoMenuItem().equals(TipoMenuItem.MENU_ITEM)).collect(Collectors.toList());
                menuItem.forEach((MenuItemModel umMenuItem) -> umMenuItem.setItemMenu(menuItems.stream()
                        .filter(umMenuItens -> (umMenuItens.getMenuItemId()
                                .equals(umMenuItem.getId()) && umMenuItens.getTipoMenuItem()
                                .equals(TipoMenuItem.ITEM_MENU)))
                        .collect(Collectors.toList())));
            }
        }

        return menuItem;
    }

    private Long recuperaUsuario(){
        Long usuarioId = null;
        if(SecurityContextHolder.getContext() !=null && SecurityContextHolder.getContext().getAuthentication() !=null &&
                SecurityContextHolder.getContext().getAuthentication().getPrincipal() !=null){
            UserDetails usuarioDetais = null;
            Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if(userDetails instanceof UserDetails){
                usuarioDetais = (UserDetails) userDetails;
            }

            if(usuarioDetais !=null && LabUtil.isNotBlank(usuarioDetais.getUsername())){
                Usuario usuario = usuarioRepository.logar(usuarioDetais.getUsername());

                if(usuario !=null){
                    usuarioId = usuario.getId();
                }
            }
        }
        return  usuarioId;
    }
}