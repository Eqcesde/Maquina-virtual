package com.app.placeType.application;
// package com.app.placeType.application;

// import java.util.ArrayList;

// import org.springframework.security.core.placeTypedetails.PlaceTypeDetails;
// import org.springframework.security.core.placeTypedetails.PlaceTypeDetailsService;
// import org.springframework.security.core.placeTypedetails.PlaceTypenameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.app.placeType.domain.IPlaceTypeRepository;
// import com.app.placeType.domain.PlaceType;

// @Service
// public class PlaceTypeDetailsServiceImpl implements PlaceTypeDetailsService {

//     private final IPlaceTypeRepository placeTypeRepository;

//     public PlaceTypeDetailsServiceImpl(IPlaceTypeRepository placeTypeRepository) {
//         this.placeTypeRepository = placeTypeRepository;
//     }

//     @Override
//     public PlaceTypeDetails loadPlaceTypeByPlaceTypeName(String name) throws PlaceTypenameNotFoundException {
//         PlaceType placeType = placeTypeRepository.findByTypeName(namel)
//                 .orElseThrow(() -> new PlaceTypenameNotFoundException("User not found with email: " + email));

//         return new org.springframework.security.core. placeTypedetails.PlaceType(
//             placeType.getId(),
//             placeType.getTypeName(),
//                 new ArrayList<>());
//     }
// } 