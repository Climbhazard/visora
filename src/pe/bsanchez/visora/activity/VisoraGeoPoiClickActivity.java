package pe.bsanchez.visora.activity;

import java.util.ArrayList;

import com.geomobile.arcore.VisionCore;

import pe.bsanchez.visora.R;
import pe.bsanchez.visora.core.VisoraGeoPoi;
import pe.bsanchez.visora.model.Evento;
import pe.bsanchez.visora.repository.AdapterEventos;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class VisoraGeoPoiClickActivity extends Activity implements OnClickListener {

	// private ProgressBar progreso;

	private ImageView buttonBack;
	private TextView poiTitle;
	private VisoraGeoPoi poi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visora_activity_poi_click3);

		buttonBack = (ImageView) findViewById(R.id.button_back);
		buttonBack.setOnClickListener(this);

		poi = (VisoraGeoPoi) VisionCore.core.model.getSelectedPoi();

		poiTitle = (TextView) findViewById(R.id.poi_title);
		poiTitle.setText(poi.getTitle());

		ListView listaEventos = (ListView) findViewById(R.id.list_eventos);
		ArrayList<Evento> arraydir = new ArrayList<Evento>();
		Evento evento;

		evento = new Evento(getResources().getDrawable(R.drawable.biologica_cultural),
				"Arianna Huffington", "Presidenta");
		arraydir.add(evento);
		evento = new Evento(getResources().getDrawable(R.drawable.biologica_social),
				"Princesa Corinna", "CEO");
		arraydir.add(evento);
		evento = new Evento(getResources().getDrawable(R.drawable.psicologia_cultural),
				"Hillary Clinton", "Tesorera");
		arraydir.add(evento);
		evento = new Evento(getResources().getDrawable(R.drawable.psicologia_social),
				"Bono el de U2", "Amenizador");
		arraydir.add(evento);
		evento = new Evento(getResources().getDrawable(R.drawable.educacion_deportiva),
				"Carmen de Mairena", "Directora RRHH");
		arraydir.add(evento);

		AdapterEventos adapter = new AdapterEventos(this, arraydir);

		listaEventos.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		if (v == buttonBack) {
			finish();
		}
	}
}
