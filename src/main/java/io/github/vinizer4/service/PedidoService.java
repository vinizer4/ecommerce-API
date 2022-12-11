package io.github.vinizer4.service;

import io.github.vinizer4.domain.entity.Pedido;
import io.github.vinizer4.domain.enums.StatusPedido;
import io.github.vinizer4.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}