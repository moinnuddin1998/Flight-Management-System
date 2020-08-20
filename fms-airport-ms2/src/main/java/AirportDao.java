

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.airport.entity.Airport;
@Repository
public interface AirportDao extends JpaRepository<Airport, String>{
	public Airport findByAirportName(String airportName);
}
