package mx.com.angeldev.marvelapi.app;

import java.util.List;

import mx.com.angeldev.marvelapi.dao.BitacoraEntity;

public interface BitacoraService {

	List<BitacoraEntity> getAll();
	
	void saveBitacora(String service);
	
}
