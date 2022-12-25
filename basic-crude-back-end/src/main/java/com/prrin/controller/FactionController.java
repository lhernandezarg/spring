package com.prrin.controller;

import com.prrin.controller.common.ControllerBase;
import com.prrin.controller.response.PageableResponse;
import com.prrin.model.Faction;
import com.prrin.services.IFactionService;
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
@RequestMapping("/api/v1/faction")
public class FactionController {

	@Autowired
	private IFactionService service;

	@Autowired
	private ControllerBase<Faction> base;

	@GetMapping("/")
	public ResponseEntity<?> get(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
			throws Exception {
		return new ResponseEntity<PageableResponse<Faction>>(
				new PageableResponse<>(service.getByEnabled(true, PageRequest.of(page, size))), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) throws Exception {
		return base.getById(service.getById(id));
	}

	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody Faction ob) throws Exception {
		return base.success(service.create(ob));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Faction ob, @PathVariable("id") int id) throws Exception {
		switch (service.update(ob, id)) {
		case 200:
			return base.success(200, "updated");
		case 204:
			return base.no_content();
		default:
			return base.acepted();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws Exception {
		return base.success(service.delete(id), "deleted");
	}
}
