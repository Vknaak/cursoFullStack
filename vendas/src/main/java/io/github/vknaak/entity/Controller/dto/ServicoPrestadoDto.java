package io.github.vknaak.entity.Controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ServicoPrestadoDto {
	
	private String descricao;
	private String preco;
	private String data;
	private Integer idCliente;

}
