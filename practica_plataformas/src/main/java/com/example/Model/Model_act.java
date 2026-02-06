package com.example.Model;

public class Model_act {

    public static class User {
        public long id;
        public String name;
        public String carrera;

        public User() {
        }

        public User(long id, String name, String carrera) {
            this.id = id;
            this.name = name;
            this.carrera = carrera;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            
            
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name != null && name.matches(".*\\d.*")) {
                throw new IllegalArgumentException("El nombre no puede contener números");
            }
            this.name = name;
        }

        public String getCarrera() {
            return carrera;
        }

        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }
    }

}
