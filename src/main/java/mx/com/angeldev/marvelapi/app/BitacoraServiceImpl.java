package mx.com.angeldev.marvelapi.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.angeldev.marvelapi.dao.BitacoraEntity;
import mx.com.angeldev.marvelapi.dao.BitacoraRepositoryDAO;

@Service
public class BitacoraServiceImpl implements BitacoraService {
	
	@Autowired
	private BitacoraRepositoryDAO bitacoraRepository;

	@Override
	public List<BitacoraEntity> getAll() {
		return bitacoraRepository.findAll();
	}

	@Override
	public void saveBitacora(String service) {
		BitacoraEntity bitacoraEntity = new BitacoraEntity();
		bitacoraEntity.setDateOfConsult(new Date());
		bitacoraEntity.setServiceConsulted(service);
		bitacoraRepository.save(bitacoraEntity);
		
	}
	
}
