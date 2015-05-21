package com.paar.ch2;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

public class ProAndroidAR2Activity extends Activity {

	TextView xAxisValue;
	TextView yAxisValue;
	TextView zAxisValue;
	TextView headingValue;
	TextView pitchValue;
	TextView rollValue;
	TextView altitudeValue;
	TextView latitudeValue;
	TextView longitudeValue;

	SurfaceView cameraPreview;
	SurfaceHolder previewHolder;
	Camera camera;
	boolean inPreview;

	final static String TAG = "PAAR";
	SensorManager sensorManager;

	int orientationSensor;
	float headingAngle;
	float pitchAngle;
	float rollAngle;

	int accelerometerSensor;
	float xAxis;
	float yAxis;
	float zAxis;

	LocationManager locationManager;
	double latitude;
	double longitude;
	double altitude;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		inPreview = false;

		cameraPreview = (SurfaceView) findViewById(R.id.cameraPreview);
		previewHolder = cameraPreview.getHolder();
		previewHolder.addCallback(surfaceCallback);
		previewHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				2000, 2, locationListener);

		orientationSensor = Sensor.TYPE_ORIENTATION;
		accelerometerSensor = Sensor.TYPE_ACCELEROMETER;

		sensorManager.registerListener(sensorEventListener,
				sensorManager.getDefaultSensor(orientationSensor),
				SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(sensorEventListener,
				sensorManager.getDefaultSensor(accelerometerSensor),
				SensorManager.SENSOR_DELAY_NORMAL);

		xAxisValue = (TextView) findViewById(R.id.xAxisValue);
		yAxisValue = (TextView) findViewById(R.id.yAxisValue);
		zAxisValue = (TextView) findViewById(R.id.zAxisValue);
		headingValue = (TextView) findViewById(R.id.headingValue);
		pitchValue = (TextView) findViewById(R.id.pitchValue);
		rollValue = (TextView) findViewById(R.id.rollValue);
		altitudeValue = (TextView) findViewById(R.id.altitudeValue);
		longitudeValue = (TextView) findViewById(R.id.longitudeValue);
		latitudeValue = (TextView) findViewById(R.id.latitudeValue);
	}

	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				2000, 2, locationListener);

		sensorManager.registerListener(sensorEventListener,
				sensorManager.getDefaultSensor(orientationSensor),
				SensorManager.SENSOR_DELAY_NORMAL);

		sensorManager.registerListener(sensorEventListener,
				sensorManager.getDefaultSensor(accelerometerSensor),
				SensorManager.SENSOR_DELAY_NORMAL);
		camera = Camera.open();
	};

	@Override
	protected void onPause() {
		if (inPreview) {
			camera.stopPreview();
		}
		locationManager.removeUpdates(locationListener);
		sensorManager.unregisterListener(sensorEventListener);
		camera.release();
		camera = null;
		inPreview = false;

		super.onPause();
	};

	final SensorEventListener sensorEventListener = new SensorEventListener() {

		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
				headingAngle = event.values[0];
				pitchAngle = event.values[1];
				rollAngle = event.values[2];

				Log.d(TAG, "Heading: " + String.valueOf(headingAngle));
				Log.d(TAG, "Pitch: " + String.valueOf(pitchAngle));
				Log.d(TAG, "Roll: " + String.valueOf(rollAngle));

				headingValue.setText(String.valueOf(headingAngle));
				pitchValue.setText(String.valueOf(pitchAngle));
				rollValue.setText(String.valueOf(rollAngle));
			} else if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				xAxis = event.values[0];
				yAxis = event.values[1];
				zAxis = event.values[2];

				Log.d(TAG, "X Axis: " + String.valueOf(xAxis));
				Log.d(TAG, "Y Axis: " + String.valueOf(yAxis));
				Log.d(TAG, "Z Axis: " + String.valueOf(zAxis));

				xAxisValue.setText(String.valueOf(xAxis));
				yAxisValue.setText(String.valueOf(yAxis));
				zAxisValue.setText(String.valueOf(zAxis));
			}
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub

		}
	};

	LocationListener locationListener = new LocationListener() {

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			latitude = location.getLatitude();
			longitude = location.getLongitude();
			altitude = location.getAltitude();

			Log.d(TAG, "Latitude: " + String.valueOf(latitude));
			Log.d(TAG, "Longitude: " + String.valueOf(longitude));
			Log.d(TAG, "Altitude: " + String.valueOf(altitude));

			latitudeValue.setText(String.valueOf(latitude));
			longitudeValue.setText(String.valueOf(longitude));
			altitudeValue.setText(String.valueOf(altitude));
		}
	};

	SurfaceHolder.Callback surfaceCallback = new SurfaceHolder.Callback() {

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			// camera.stopPreview();
			// camera.release();
			// camera = null;
		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			try {
				camera.setPreviewDisplay(previewHolder);
			} catch (Throwable t) {
				// TODO: handle exception
				Log.e("ProAndroidAR2Activity",
						"Exception in setPreviewDisplay()", t);
			}
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			// TODO Auto-generated method stub
			Camera.Parameters parameters = camera.getParameters();
			Camera.Size size = getBestPreviewSize(width, height, parameters);

			if (size != null) {
				parameters.setPreviewSize(size.width, size.height);
				camera.setParameters(parameters);
				camera.startPreview();
				inPreview = true;
			}
		}
	};

	private Camera.Size getBestPreviewSize(int width, int height,
			Camera.Parameters parameters) {
		Camera.Size result = null;

		for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
			if (size.width <= width && size.height <= height) {
				if (result == null) {
					result = size;
				} else {
					int resultArea = result.width * result.height;
					int newArea = size.width * size.height;

					if (newArea > resultArea) {
						result = size;
					}
				}
			}
		}

		return (result);
	}
}
