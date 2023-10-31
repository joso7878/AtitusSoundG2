package br.edu.atitus.atitusound.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.atitusound.dtos.MusicDTO;
import br.edu.atitus.atitusound.entities.MusicEntity;
import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.services.MusicService;
import br.edu.atitus.atitusound.services.GenericService;

@RestController
@RequestMapping("/musics")
public class MusicController extends GenericController<MusicEntity, MusicDTO>{

	private final MusicService musicService;

	public MusicController(MusicService musicService) {
		this.musicService = musicService;
	}

	protected MusicEntity convertDTO2Entity(MusicDTO dto){
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
