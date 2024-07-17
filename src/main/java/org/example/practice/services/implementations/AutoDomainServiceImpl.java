//package org.example.practice.services.implementations;
//
//import org.example.practice.DTO.AutoDTO;
//import org.example.practice.entities.Auto;
//import org.example.practice.entities.Client;
//import org.example.practice.repositories.AutoRepositoryJPA;
//import org.example.practice.repositories.ClientRepositoryJPA;
//import org.example.practice.services.interfaces.AutoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AutoServiceImpl  implements AutoService {
//    @Autowired
//    private ClientRepositoryJPA clientRepository;
//    @Autowired
//    private AutoRepositoryJPA autoRepository;
//    @Override
//    public AutoDTO createAuto(AutoDTO autoDTO) {
//        Optional<Client> client = clientRepository.findById(autoDTO.clientId);
//        if (client.isEmpty()){
//            System.out.println("No client");
//            return -1;
//        }
//        Auto auto = new Auto(autoDTO.number,autoDTO.brand,autoDTO.model,autoDTO.price,client.get());
//        auto = autoRepository.save(auto);
//        return auto.getId();
//    }
//
//    public int dd(AutoDTO autoDTO) {
//        Optional<Client> client = clientRepository.findById(autoDTO.clientId);
//        if (client.isEmpty()){
//            System.out.println("No client");
//            return -1;
//        }
//        Auto auto = new Auto(autoDTO.number,autoDTO.brand,autoDTO.model,autoDTO.price,client.get());
//        auto = autoRepository.save(auto);
//
//        return auto.getId();
//    }
//}
