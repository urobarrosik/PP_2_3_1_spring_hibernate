package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImp implements CarService {

    private List<Car> cars = new ArrayList<>(5);

    @Override
    public List<Car> getListCars(int count) {
        cars.add(new Car("Audi", "11111", 2550999));
        cars.add(new Car("BMV", "22222", 3650999));
        cars.add(new Car("Volvo", "33333", 1350999));
        cars.add(new Car("Reno", "44444", 1990999));
        cars.add(new Car("Lada", "55555", 4770999));

        List<Car> countedCars = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            countedCars.add(cars.get(i));
        }

        return countedCars;
    }


}
