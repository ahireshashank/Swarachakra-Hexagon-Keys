package iit.android.language.marathi;

import iit.android.language.ExceptionHandler;
import iit.android.language.Language;
import iit.android.swarachakraMarathi.KeyAttr;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.util.Log;

public class MainLanguageExceptionHandler implements ExceptionHandler {
	
	private ArrayList<KeyAttr> keyArray;
	private HashMap<Integer, KeyAttr> mKeys;
	private Language main;
	
	private static final String RA = "\u0930";	
	private static final String HALANT = "\u094D";
	private static final String EYELASHRA = "\u0931\u094d\u200d";
	
	private static final int RAFARCODE = 53;
	private static final int TRAKARCODE = 52;
	private static final int EYELASHRACODE = 51;
	
	public MainLanguageExceptionHandler(Language lang){
		main = lang;
		initializeKeyArray();
	}
	
	@SuppressLint("UseSparseArrays")
	public HashMap<Integer, KeyAttr> handleException(int keyCode){
		HashMap<Integer, KeyAttr> sKeys = new HashMap<Integer, KeyAttr>();
		switch(keyCode){
		case EYELASHRACODE:
			handleEyelashRa(sKeys);
			break;
		case TRAKARCODE:
			handleTrakar(sKeys);
			break;
		case RAFARCODE:
			handleRafar(sKeys);
			break;
		}
		initializeKeyArray();
		return sKeys;
	}
	
	private void initializeKeyArray(){
		keyArray = new ArrayList<KeyAttr>();
		int halantEnd = main.halantEnd;
		for(int i = 0; i < halantEnd; i++){
			KeyAttr key = new KeyAttr();
			key.code = i+1;
			keyArray.add(key);
			mKeys = main.hashThis();
		}
	}

	private void handleRafar(HashMap<Integer, KeyAttr> sKeys) {
		//Log.d("debug","rafar");
		for(KeyAttr key : keyArray){
			String newLabel = RA + HALANT + mKeys.get(key.code).label;
			key.label = newLabel;
			key.showChakra = true;
			sKeys.put(key.code, key);
		}
	}

	private void handleTrakar(HashMap<Integer, KeyAttr> sKeys) {
		//Log.d("debug","trakar");
		for(KeyAttr key : keyArray){
			String newLabel = mKeys.get(key.code).label + HALANT + RA;
			key.label = newLabel;
			key.showChakra = true;
			sKeys.put(key.code, key);
		}
	}

	private void handleEyelashRa(HashMap<Integer, KeyAttr> sKeys) {
		//Log.d("debug","eyelash");
		for(KeyAttr key : keyArray){
			String newLabel = EYELASHRA + mKeys.get(key.code).label;
			key.label = newLabel;
			key.showChakra = true;
			sKeys.put(key.code, key);
		}
	}
	
}
