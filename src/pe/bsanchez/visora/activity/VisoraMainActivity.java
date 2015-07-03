package pe.bsanchez.visora.activity;

import pe.bsanchez.visora.R;
import pe.bsanchez.visora.core.LoadDataTask;
import pe.bsanchez.visora.core.VisoraARManager;
import pe.bsanchez.visora.core.VisoraModelManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

import com.geomobile.arcore.VisionConfiguration;
import com.geomobile.arcore.VisionCore;

public class VisoraMainActivity extends Activity implements OnClickListener {

	public static ProgressBar progreso;
	private Button bt_lanzamiento;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visora_activity_main);

		progreso = (ProgressBar) findViewById(R.id.progreso);

		bt_lanzamiento = (Button) findViewById(R.id.lanzamiento);
		bt_lanzamiento.setOnClickListener(this);
	}

	@SuppressWarnings("unused")
	@Override
	public void onClick(View v) {
		VisionCore vs = new VisionCore(this.getApplicationContext(), true);
		VisionCore.core.ar = new VisoraARManager(false, true, false);
		VisionCore.core.ar.setPrefixForImages("visora_");
		VisionCore.core.model = new VisoraModelManager();
		VisionCore.core.configuration.setRadarPosition(VisionConfiguration.RADAR_POSITION_LEFT);
		VisionCore.core.configuration.showAppLogo(true);

		new LoadDataTask(VisoraMainActivity.this).execute();
	}

}
