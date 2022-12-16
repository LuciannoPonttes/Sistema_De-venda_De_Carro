package br.atos.xlo.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.atos.xlo.dto.VeiculoDTO;
import br.atos.xlo.enums.StatusVeiculoEnum;
import br.atos.xlo.model.Arquivo;
import br.atos.xlo.model.Veiculo;
import br.atos.xlo.model.VeiculoItem;
import br.atos.xlo.repository.ArquivoRepository;
import br.atos.xlo.repository.VeiculoItemRepository;
import br.atos.xlo.repository.VeiculoRepository;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;

	@Autowired
	VeiculoItemRepository veiculoItemRepository;

	@Autowired
	ArquivoRepository arquivoRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public VeiculoDTO adicionar(VeiculoDTO veiculoDTO) {

		List<VeiculoItem> itens = veiculoDTO.getItemsVeiculo().stream()
				.map(item -> modelMapper.map(item, VeiculoItem.class)).collect(Collectors.toList());

		List<Arquivo> arquivos = veiculoDTO.getArquivosVeiculo().stream()
				.map(item -> modelMapper.map(item, Arquivo.class)).collect(Collectors.toList());

		veiculoDTO.setStatusVeiculo(StatusVeiculoEnum.ATIVO);

		// TODO - salvar de acordo com o que vier da api
		veiculoDTO.setCategoria(null);
		veiculoDTO.setModelo(null);
		veiculoDTO.setMarca(null);
		veiculoDTO.setArquivosVeiculo(null);
		veiculoDTO.setItemsVeiculo(null);

		Veiculo veiculo = veiculoRepository.save(modelMapper.map(veiculoDTO, Veiculo.class));

		itens.stream().forEach(item -> item.setVeiculos(Arrays.asList(veiculo)));
		veiculoItemRepository.saveAll(itens);

		arquivos.stream().forEach(arq -> arq.setVeiculos(Arrays.asList(veiculo)));
		arquivoRepository.saveAll(arquivos);

		return modelMapper.map(veiculo, VeiculoDTO.class);
	}

	@Override
	public List<VeiculoDTO> listar() {
		List<Veiculo> veiculos = veiculoRepository.findAll();
		return veiculos.stream().map(user -> modelMapper.map(user, VeiculoDTO.class)).collect(Collectors.toList());

	}

	@Override
	public void excluir(Integer id) {
		Veiculo veiculo = veiculoRepository.findById(id).orElse(null);

		if (veiculo == null) {
			throw new EmptyResultDataAccessException("Id de veículo não encontrado" + id, 1);
		} else {
			veiculo.setStatusVeiculo(StatusVeiculoEnum.INATIVO);
			veiculoRepository.save(veiculo);
		}

	}

	@Override
	public VeiculoDTO editar(VeiculoDTO veiculoDTO) {

		veiculoDTO.setDataAtualizacao(new Date());

		VeiculoItem itens = modelMapper.map(veiculoDTO.getItemsVeiculo(), VeiculoItem.class);
		Arquivo arquivos = modelMapper.map(veiculoDTO.getArquivosVeiculo(), Arquivo.class);

		Veiculo veiculo = veiculoRepository.save(modelMapper.map(veiculoDTO, Veiculo.class));

		itens.setVeiculos(Arrays.asList(veiculo));
		veiculoItemRepository.save(itens);

		arquivos.setVeiculos(Arrays.asList(veiculo));
		arquivoRepository.save(arquivos);

		return modelMapper.map(veiculo, VeiculoDTO.class);
	}

	@Override
	public Page<VeiculoDTO> listarVeiculos(Pageable pageable, Integer status) {

		Page<Veiculo> veiculos = veiculoRepository.listarVeiculosPaginados(status, pageable);
		return veiculos.map(user -> modelMapper.map(user, VeiculoDTO.class));
	}

}
