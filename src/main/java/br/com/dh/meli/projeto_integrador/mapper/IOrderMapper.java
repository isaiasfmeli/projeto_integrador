package br.com.dh.meli.projeto_integrador.mapper;

import br.com.dh.meli.projeto_integrador.dto.OrderDTO;
import br.com.dh.meli.projeto_integrador.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IOrderMapper {
    IOrderMapper MAPPER = Mappers.getMapper(IOrderMapper.class);
    Order mappingDTOToModel(OrderDTO orderDTO);
    OrderDTO mappingModelToDTO(Order order);
}
