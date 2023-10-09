package mx.com.angeldev.marvelapi.security;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import mx.com.angeldev.marvelapi.dao.UserRepositoryDAO;
import mx.com.angeldev.marvelapi.dao.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	//@Autowired
	//private UserRepositoryDAO repositoryDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//User usuario = repositoryDAO.findOneByEmail(username).orElseThrow(()-> new UsernameNotFoundException("No se encontró al usuario " + username));
		
		
		User usuario = new User();
		usuario.setEmail("angel-blas@outlook.com");
		usuario.setId(1L);
		usuario.setNombre("Jose Angel");
		usuario.setPassword("$2a$10$06/zIM6YQG6oXoHu1PYzeOSS3L64z6X0WRo9IF31JkYw1QMDmUgJ.");
		
		return new UserDetailsImpl(usuario);
		
		
	}
	
}
