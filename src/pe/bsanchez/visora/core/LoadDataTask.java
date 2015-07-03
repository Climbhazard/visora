package pe.bsanchez.visora.core;

import pe.bsanchez.visora.activity.VisoraMainActivity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import com.geomobile.arcore.VisionCore;

public class LoadDataTask extends AsyncTask<Void, Void, Void> {

	private Context visoraMainActivity;

	public LoadDataTask(Context visoraMainActivity) {
		this.visoraMainActivity = visoraMainActivity;
	}

	protected void onPreExecute() {
		VisoraMainActivity.progreso.setVisibility(View.VISIBLE);
	}

	@Override
	protected void onPostExecute(Void response) {
		VisionCore.startAR(visoraMainActivity);
		VisoraMainActivity.progreso.setVisibility(View.GONE);
	}

	@Override
	protected Void doInBackground(Void... params) {
		generateData();
		return null;
	}

	@SuppressWarnings("static-access")
	private void generateData() {
		VisionCore.core.model = new VisoraModelManager();
		VisionCore.core.model.loadPoisContinouosly = true;
		VisionCore.core.loadData(visoraMainActivity);
	}

}