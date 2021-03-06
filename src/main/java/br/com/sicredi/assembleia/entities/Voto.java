package br.com.sicredi.assembleia.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Voto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "resposta")
	private boolean resposta;
	
	@Column(name = "data_voto")
	private LocalDateTime data;
	
	@JoinColumn(name = "id_associado")
	@OneToOne(fetch = FetchType.LAZY)
	private Associado associado;
	
	@JoinColumn(name = "id_votacao")
	@ManyToOne(fetch = FetchType.LAZY)
	private Votacao votacao;
	
	
}
