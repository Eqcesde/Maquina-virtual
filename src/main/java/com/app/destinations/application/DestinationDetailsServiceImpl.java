// package com.app.destinations.application;

// import java.util.ArrayList;

// import org.springframework.security.core.destinationdetails.DestinationDetails;
// import org.springframework.security.core.destinationdetails.DestinationDetailsService;
// import org.springframework.security.core.destinationdetails.DestinationnameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.app.destinations.domain.IDestinationsRepository;
// import com.app.destinations.domain.Destinations;

// @Service
// public class DestinationDetailsServiceImpl implements DestinationDetailsService {

//     private final IDestinationRepository destinationRepository;

//     public DestinationDetailsServiceImpl(IDestinationRepository destinationRepository) {
//         this.destinatioRepository = destinationRepository;
//     }

//     @Override
//     public DestinationDetails loadDestinationByDestinationname(String name) throws DestinationnameNotFoundException {
//         Destinations destination = destinatioRepository.findByName(name)
//                 .orElseThrow(() -> new DestinationnameNotFoundException("Destinatio not found with name: " + name));

//         return new org.springframework.security.core.destinationdetails.Destination(
//                 destination.getId(),
//                 destination.getName(),
//                 new ArrayList<>());
//     }
// } 