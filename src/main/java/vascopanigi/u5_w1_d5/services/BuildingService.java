package vascopanigi.u5_w1_d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vascopanigi.u5_w1_d5.repositories.BuildingRepository;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    public List<String> getAllDistinctCities() {
        return buildingRepository.findAllDistinctCities();
    }
}
