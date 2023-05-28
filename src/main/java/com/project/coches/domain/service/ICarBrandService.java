package com.project.coches.domain.service;

import com.project.coches.domain.pojo.CarBrandPojo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ICarBrandService {

    /**
     * Devuelve una lista con todas las marcas de coche
     * @return Lista con marcas de coches
     */
    List<CarBrandPojo> getAll();

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrada
     */
    Optional<CarBrandPojo> getCarBrand(Integer id);

    /**
     * Guarda una nueva marca de coche
     * @param newCarBrand Marca coche a guardar
     * @return Marca coche guardada
     */
    CarBrandPojo save(CarBrandPojo newCarBrand);

    /**
     * Actualiza una marca coche
     * @param carBrandPojo Marca coche a actualizar
     * @return Marca coche actualizado
     */
    Optional<CarBrandPojo> update(CarBrandPojo carBrandPojo);

    /**
     * Elimina una marca coche segun el id
     * @param idCarBrand Id del marca coche a eliminar
     */
    boolean delete(Integer idCarBrand);
}
