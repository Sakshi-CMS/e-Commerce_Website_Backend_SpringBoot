//package Harsh.Singh.VehicleInfo.Services;
//
//import Harsh.Singh.VehicleInfo.Domain.Vehicle;
//import Harsh.Singh.VehicleInfo.Repository.VehicleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class VehicleServiceImpl implements VehicleService {
//
//    private VehicleRepository vehicleRepository;
//    @Autowired
//    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
//        this.vehicleRepository = vehicleRepository;
//    }
//
//    @Override
//    public Vehicle saveVehicleDetail(Vehicle vehicle) throws Exception {
//        if(vehicleRepository.findById(vehicle.getVehicleName()).isPresent())
//        {
//            throw new Exception();
//        }
//        else
//        {
//            vehicleRepository.save(vehicle);
//        }
//        return vehicle;
//    }
//
//    @Override
//    public List<Vehicle> getAllVehicleDetail() {
//        return vehicleRepository.findAll();
//    }
//
//
//
//    @Override
//    public Vehicle updateVehicle(Vehicle vehicle) {
//        Optional<Vehicle> userObject = vehicleRepository.findById(vehicle.getVehicleName());
//        if(userObject.isPresent()) {
//            Vehicle vehicleResult = userObject.get();
//            vehicleResult.setVehicleName(vehicle.getVehicleName());
//            vehicleResult.setVehicleModel(vehicle.getVehicleModel());
//            vehicleResult.setVehiclePrice(vehicle.getVehiclePrice());
//            vehicleResult.setImage(vehicleResult.getImage());
//            return vehicleRepository.save(vehicleResult);
//        }
//        return null;
//    }
//
//    @Override
//    public Vehicle deleteVehicle(Vehicle vehicle, byte[] bytes) {
//        if(vehicleRepository.findById(vehicle.getVehicleName()).isPresent())
//        {
//            vehicle.setImage(bytes);
//            vehicleRepository.delete(vehicle);
//        }
//
//        return null;
//    }
//
//
//    @Override
//    public Vehicle registervehicle(Vehicle vehicle) {
//        if(vehicleRepository.findById(vehicle.getVehicleName()).isPresent())
//        {
//            return null;
//        }
//
//        return vehicleRepository.save(vehicle);
//
//    }
//    @Override
//    public Vehicle findByVehicleName(String vehicleName)
//    {
//        Optional<Vehicle> vehicle=vehicleRepository.findById(vehicleName);
//        return vehicle.get();
//    }
//
//}