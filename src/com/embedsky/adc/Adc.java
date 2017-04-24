package com.embedsky.adc;

import com.embedsky.led.R;

import android.app.Activity;
import android.app.AlertDialog;
//import android.content.Intent;
import android.os.Bundle;

public class Adc extends Activity {
	static {
		System.loadLibrary("adc");
	}
	
	//adc initial
	public static native boolean adcInit();
	
	//adc close
	public static native boolean adcClose();

	//set adc channel number
	public static native boolean adcSetChannel(int number);
	
	//设置 ADC 采样率,10 位或 12 位
	public static native boolean adcSetResol(int number);

	//read adc value
	public static native int adcReadValue();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Intent intent =this.getIntent();
		
		if(!adcInit()){
			new AlertDialog.Builder(this).setTitle("init adc fail").show();
		}else{
			adcSetChannel(4);
			adcSetResol(10);
		}
	} 


}
