package pe.bsanchez.visora.repository;

import java.util.ArrayList;

import pe.bsanchez.visora.R;
import pe.bsanchez.visora.model.Evento;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterEventos extends BaseAdapter {

	protected Activity visoraGeoPoiActivityClick;
	protected ArrayList<Evento> eventos;

	public AdapterEventos(Activity visoraGeoPoiActivityClick, ArrayList<Evento> eventos) {
		this.visoraGeoPoiActivityClick = visoraGeoPoiActivityClick;
		this.eventos = eventos;
	}

	@Override
	public int getCount() {
		return eventos.size();
	}

	@Override
	public Object getItem(int position) {
		return eventos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return Integer.valueOf(eventos.get(position).getCategoriaId());
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		if (convertView == null) {
			LayoutInflater inf = (LayoutInflater) visoraGeoPoiActivityClick
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inf.inflate(R.layout.visora_item_list, null);
		}

		Evento evento = eventos.get(position);
		ImageView afiche = (ImageView) v.findViewById(R.id.afiche);
		afiche.setImageDrawable(evento.getAfiche());
		TextView nombre = (TextView) v.findViewById(R.id.titulo);
		nombre.setText(evento.getTitulo());
		TextView cargo = (TextView) v.findViewById(R.id.descripcion);
		cargo.setText(evento.getDescripcion());

		return v;
	}

}
