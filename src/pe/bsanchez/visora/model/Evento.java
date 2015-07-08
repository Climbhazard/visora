package pe.bsanchez.visora.model;

import android.graphics.drawable.Drawable;

public class Evento {
	protected Drawable afiche;
	protected String titulo;
	protected String descripcion;
	protected long id;

	public Evento(Drawable afiche, String titulo, String descripcion) {
		super();
		this.afiche = afiche;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public Evento(Drawable afiche, String nombre, String cargo, long id) {
		super();
		this.afiche = afiche;
		this.titulo = nombre;
		this.descripcion = cargo;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Drawable getAfiche() {
		return afiche;
	}

	public void setAfiche(Drawable afiche) {
		this.afiche = afiche;
	}

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

}
