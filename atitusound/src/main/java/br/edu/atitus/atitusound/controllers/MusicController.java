package br.edu.atitus.atitusound.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.atitusound.dtos.MusicDTO;
import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.entities.MusicEntity;
import br.edu.atitus.atitusound.services.GenericService;
import br.edu.atitus.atitusound.services.MusicService;


@RestController
@RequestMapping("/music")
public class MusicController extends GenericController<MusicEntity, MusicDTO>{

	
	private final MusicService musicService;
	
	public MusicController(MusicService musicService) {
		this.musicService = musicService;
	}
	

	@Override
	protected MusicEntity convertDTO2Entity(MusicDTO dto) {
		ArtistEntity artist = new ArtistEntity();
		artist.setUuid(dto.getArtist().getUuid());
		
		MusicEntity entidade = new MusicEntity();
		BeanUtils.copyProperties(dto, entidade);
		entidade.setArtist(artist);
		return entidade;
	}
	
	@Override
	public GenericService<MusicEntity> getService() {
		return musicService;
	}
	

}
