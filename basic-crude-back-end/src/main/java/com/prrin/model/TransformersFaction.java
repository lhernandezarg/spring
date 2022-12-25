package com.prrin.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transformers_factions", schema = "public")
public class TransformersFaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransformersFactionId id;

	@ManyToOne
	@JoinColumn(name = "faction_id", insertable = false, updatable = false, referencedColumnName = "id")
	private Faction faction;

	@ManyToOne
	@JoinColumn(name = "transformer_id", insertable = false, updatable = false, referencedColumnName = "id")
	private Transformer transformer;

	@Column
	private boolean enabled;
}
