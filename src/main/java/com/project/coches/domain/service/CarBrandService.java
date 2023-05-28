package com.project.coches.domain.service;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.repository.ICarBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de marca coche
 */
@RequiredArgsConstructor
@Service
public class CarBrandService implements ICarBrandService{

    /**
     * Repositorio de marca coche
     */
    private final ICarBrandRepository iCarBrandRepository;

    /**
     * Devuelve una lista con todas las marcas de coche
     *
     * @return Lista con marcas de coches
     */
    @Override
    public List<CarBrandPojo> getAll() {
        return iCarBrandRepository.getAll();
    }

    /**
     * Devuelve una marca de coche dada su id
     *
     * @param id Id de marca coche
     * @return Optional del marca coche encontrada
     */
    @Override
    public Optional<CarBrandPojo> getCarBrand(Integer id) {
        return iCarBrandRepository.getCarBrand(id);
    }

    /**
     * Guarda una nueva marca de coche
     *
     * @param newCarBrand Marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public CarBrandPojo save(CarBrandPojo newCarBrand) {
        return iCarBrandRepository.save(newCarBrand);
    }

    /**
     * Actualiza una marca coche
     *
     * @param carBrandPojo Marca coche a actualizar
     * @return Marca coche actualizado
     */
    @Override
    public Optional<CarBrandPojo> update(CarBrandPojo carBrandPojo) {
        if (iCarBrandRepository.getCarBrand(carBrandPojo.getId()).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(iCarBrandRepository.save(carBrandPojo));
    }

    /**
     * Elimina una marca coche segun el id
     *
     * @param idCarBrand Id del marca coche a eliminar
     * @return Devuelve true o false dependiendo si se elimina.
     */
    @Override
    public boolean delete(Integer idCarBrand) {

        if (iCarBrandRepository.getCarBrand(idCarBrand).isEmpty()) {
            return false;
        }
        iCarBrandRepository.delete(idCarBrand);
        return true;

    }

}
