// package com.example.transportes.controllers.durandb;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.transportes.services.durandb.GetSubtotalCCPService;

// @RestController
// @RequestMapping("/getsubtotalccp")
// public class GetSubtotalCCPController {

// @Autowired
// GetSubtotalCCPService getSubtotalCCPService;

// @GetMapping("/calcular/{cpid}")
// public Float calcularSubtotalCCP(@PathVariable Integer cpid) {
// return getSubtotalCCPService.obtenerResultadoDeFuncion(cpid);
// }
// }
