package com.kmsoft.memoire.alimentation.dw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="dim_geographie")
public class DimGeographie {
	
	@Id
	@SequenceGenerator(name = "seq_id_dim_geographie", sequenceName = "seq_id_dim_geographie", allocationSize = 1)
	@GeneratedValue(generator = "seq_id_dim_geographie", strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false, updatable = false)
	private Integer id;
	
	private String codeGeo;
	private String ileGeo;
	private String villeGeo;
	
	public DimGeographie() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIleGeo() {
		return ileGeo;
	}

	public void setIleGeo(String ileGeo) {
		this.ileGeo = ileGeo;
	}

	public String getVilleGeo() {
		return villeGeo;
	}

	public void setVilleGeo(String villeGeo) {
		this.villeGeo = villeGeo;
	}

	
	@Override
	public String toString() {
		return "Geographie [ileGeo=" + ileGeo + ", villeGeo=" + villeGeo + "]";
	}

	public String getCodeGeo() {
		return codeGeo;
	}

	public void setCodeGeo(String codeGeo) {
		this.codeGeo = codeGeo;
	}

	

}
