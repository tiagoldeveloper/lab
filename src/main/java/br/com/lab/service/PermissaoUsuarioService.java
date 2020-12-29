package br.com.lab.service;

import br.com.lab.model.MenuItemModel;
import br.com.lab.repository.PermissaoUsuarioRepository;
import br.com.lab.types.TipoMenuItem;
import br.com.lab.util.LabUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissaoUsuarioService {

    private final PermissaoUsuarioRepository permissaoUsuarioRepository;

    public PermissaoUsuarioService(PermissaoUsuarioRepository permissaoUsuarioRepository) {
        this.permissaoUsuarioRepository = permissaoUsuarioRepository;
    }

    public List<MenuItemModel> recuperaPermissoesPorMenuPorUsuario(Long usuarioId) {
        List<MenuItemModel> menuItems = permissaoUsuarioRepository.recuperaPermissoesPorMenuPorUsuario(usuarioId);
        List<MenuItemModel> menuItem = null;
        if (LabUtil.isNotEmpty(menuItems)) {
            menuItem = menuItems.stream().filter(umMenuItem -> umMenuItem.getTipoMenuItem().equals(TipoMenuItem.MENU_ITEM)).collect(Collectors.toList());
            menuItem.forEach((MenuItemModel umMenuItem) -> umMenuItem.setItemMenu(menuItems.stream()
                            .filter(umMenuItens -> (umMenuItens.getMenuItemId()
                                    .equals(umMenuItem.getId()) && umMenuItens.getTipoMenuItem()
                                    .equals(TipoMenuItem.ITEM_MENU)))
                            .collect(Collectors.toList())));
        }
        return menuItem;
    }
}