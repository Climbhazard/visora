package pe.bsanchez.visora.model;

import android.graphics.drawable.Drawable;

public class Evento {

	private String categoriaId;
	private Drawable afiche;
	private String titulo;
	private String descripcion;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(String categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Drawable getAfiche() {
		return afiche;
	}

	public void setAfiche(Drawable afiche) {
		this.afiche = afiche;
	}

}
