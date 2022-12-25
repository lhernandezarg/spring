package com.prrin.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class TransformersFactionId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "faction_id")
	private int idFaction;

	@Column(name = "transformer_id")
	private int idTransformers;
}
