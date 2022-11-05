package it.prova.gestionebigliettiweb.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.model.Biglietto;

public class UtilityBigliettoForm {

	public static Biglietto createBigliettoFromParams(String idParam, String provenienzaParam, String destinazioneParam,
			String dataParam, String prezzoParam) {
		Biglietto result = new Biglietto(provenienzaParam, destinazioneParam);

		result.setData(parseDataFromString(dataParam));

		if(NumberUtils.isCreatable(idParam)) {
			result.setId(Long.parseLong(idParam));
		}
		
		if (NumberUtils.isCreatable(prezzoParam)) {
			result.setPrezzo(Integer.parseInt(prezzoParam));
		}

		return result;

	}
	
	public static Biglietto createBigliettoFromParams(String provenienzaParam, String destinazioneParam,
			String dataParam, String prezzoParam) {
		Biglietto result = new Biglietto(provenienzaParam, destinazioneParam);

		result.setData(parseDataFromString(dataParam));

		if (NumberUtils.isCreatable(prezzoParam)) {
			result.setPrezzo(Integer.parseInt(prezzoParam));
		}

		return result;

	}

	public static boolean validateBigliettoBean(Biglietto bigliettoToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(bigliettoToBeValidated.getProvenienza())
				|| StringUtils.isBlank(bigliettoToBeValidated.getDestinazione())
				|| bigliettoToBeValidated.getData() == null 
				|| bigliettoToBeValidated.getPrezzo() == null
				|| bigliettoToBeValidated.getPrezzo() < 1) {
			return false;
		}
		return true;
	}

	public static Date parseDataFromString(String dataParam) {
		if (StringUtils.isBlank(dataParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
