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

	protected Activity visoraGeoPoiClickActivity;
	protected ArrayList<Evento> items;

	public AdapterEventos(Activity activity, ArrayList<Evento> items) {
		this.visoraGeoPoiClickActivity = activity;
		this.items = items;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int arg0) {
		return items.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		return items.get(position).getId();
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;

		if (convertView == null) {
			LayoutInflater inf = (LayoutInflater) visoraGeoPoiClickActivity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inf.inflate(R.layout.visora_item_list, null);
		}

		Evento dir = items.get(position);
		ImageView afiche = (ImageView) v.findViewById(R.id.afiche);
		afiche.setImageDrawable(dir.getAfiche());
		TextView titulo = (TextView) v.findViewById(R.id.titulo);
		titulo.setText(dir.getTitulo());
		TextView descripcion = (TextView) v.findViewById(R.id.descripcion);
		descripcion.setText(dir.getDescripcion());

		return v;
	}
}