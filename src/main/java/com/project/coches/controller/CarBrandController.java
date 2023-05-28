package com.project.coches.controller;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.service.ICarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de Marca Coche
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/marcas-coches")
public class CarBrandController {

    /**
     * Servicio de marca coche
     */
    private final ICarBrandService iCarBrandService;


    /**
     * Devuelve lista de marca coche
     * @return HttpCode OK con lista de marcas coches
     */
    @GetMapping()
    public ResponseEntity<List<CarBrandPojo>> getAll() {
        return ResponseEntity.ok(iCarBrandService.getAll());
        //return ResponseEntity.status(HttpStatus.OK).body(iCarBrandService.getAll());
    }


    /**
     * Devuelve una marca coche dada su id
     * @param id Id de la marca coche a buscar
     * @return HttpCode OK si la encuentra, de lo contrario HttpCode NOT_FOUND
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandPojo> getCarBrand(@PathVariable Integer id) {
        return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }


    /**
     * Crea una nueva marca coche
     * @param newCarBrandPojo Marca coche a crear
     * @return HttpCode CREATED si lo guarda correctamente, de lo contrario BAD_REQUEST
     */
    @PostMapping()
    public ResponseEntity<CarBrandPojo> save(@RequestBody CarBrandPojo newCarBrandPojo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCarBrandService.save(newCarBrandPojo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    /**
     * Actualiza una marca coche
     * @param carBrandPojoUpdate Marca coche a actualizar
     * @return Http Code OK si lo actualza correctamente
     */
     @PatchMapping
    public ResponseEntity<CarBrandPojo> update(@RequestBody CarBrandPojo carBrandPojoUpdate) {
         return ResponseEntity.of(iCarBrandService.update(carBrandPojoUpdate));
    }


    /**
     * Elimina una marca coche dado su id
     * @param id Id de la marca coche a eliminar
     * @return HttpCode si elimina correctamente, de lo contrario HttpCode NOT_FOUND
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(this.iCarBrandService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
