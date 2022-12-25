package com.prrin.controller;

import com.prrin.controller.common.ControllerBase;
import com.prrin.controller.response.PageableResponse;
import com.prrin.model.TransformersFaction;
import com.prrin.model.TransformersFactionId;
import com.prrin.services.ITransformerFactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

@RestController
@RequestMapping("/api/v1/tranformers-faction")
public class TranformersFactionsController {

	@Autowired
	private ITransformerFactionService service;

	@Autowired
	private ControllerBase<TransformersFaction> base;

	@GetMapping("/")
	public ResponseEntity<?> get(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
			throws Exception {
		return new ResponseEntity<PageableResponse<TransformersFaction>>(
				new PageableResponse<>(service.getByEnabled(true, PageRequest.of(page, size))), HttpStatus.OK);
	}

	@GetMapping("/{id_transformer}/{id_faction}")
	public ResponseEntity<?> getById(@PathVariable("id_transformer") int id_transformer,
			@PathVariable("id_faction") int id_faction) throws Exception {
		return base.getById(service.getById(new TransformersFactionId(id_faction, id_transformer)));
	}

	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody TransformersFaction ob) throws Exception {
		return base.success(service.create(ob));
	}

	@PutMapping("/{id_transformer}/{id_faction}")
	public ResponseEntity<?> update(@RequestBody TransformersFaction ob,
			@PathVariable("id_transformer") int id_transformer, @PathVariable("id_faction") int id_faction)
			throws Exception {
		switch (service.update(ob, new TransformersFactionId(id_faction, id_transformer))) {
		case 200:
			return base.success(200, "updated");
		case 204:
			return base.no_content();
		default:
			return base.acepted();
		}
	}

	@DeleteMapping("/{id_transformer}/{id_faction}")
	public ResponseEntity<?> delete(@PathVariable("id_transformer") int id_transformer,
			@PathVariable("id_faction") int id_faction) throws Exception {
		return base.success(service.delete(new TransformersFactionId(id_faction, id_transformer)), "deleted");
	}
}
