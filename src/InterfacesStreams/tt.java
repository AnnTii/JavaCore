package InterfacesStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tt {

    public static void main(String[] args) {

        List carList = new ArrayList<>();

//        Car<BMW> carBMW = new Car<>();
//        carBMW.setCarColor(carBMW.carColor);
//        carBMW.getCarcolor();
//        System.out.println(carBMW.getCarcolor());
//        Car<String> ss = new Car<>();

        Solution solution = new Solution();

        int[] nums = {2,7,11,15};
        int target = 9;

        solution.twoSum(nums,target);

    }

//    static class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            int[] newNums = new int[2];
//            for (int i = 0; i < nums.length; i++) {
//                for (int k = 0; k < nums.length; k++){
//                    if (nums[i] + nums[k] == target){
//                        newNums[i] = nums[i];
//                        newNums[k] = nums[k];
//                        System.out.println(nums[i] +","+ nums[k]);
//                        System.out.println(Arrays.toString(newNums));
//
//                        return newNums;
//                    }
//                }
//            }
//            return newNums;
//        }
//    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] newNums = new int[2];
            List<Integer> integers = new ArrayList<>();
            integers.add(2);
            integers.add(7);
            integers.add(11);
            integers.add(15);
            for (int i = 0; i < integers.size(); i++) {
                for (int k = 0; k < integers.size(); k++){
                    if (integers.get(i) + integers.get(k) == target){
//                        integers.set(i, nums[i]);
//                        integers.set(k, nums[k]);
                        System.out.println(integers.indexOf(i) +","+ integers.indexOf(k));
                        System.out.println(Arrays.asList(integers.size()));
                        return newNums;
                    }
                }
            }
            return newNums;
        }
    }
}

abstract class CarSpeed {

    int speedCount;

    abstract public int getSpeedCount(Auto ss);
}

interface Auto<T> {

    T getCarModel();

    T getCarcolor();

    T getCarPrice();
    T getMaxSpeed();

}

class Car<T> implements Auto {

    T carModel;
    T carColor;
    T carPrice;
    T maxSpeed;

    @Override
    public T getCarModel() {
        return carModel;
    }

    @Override
    public T getCarcolor() {
        return (T) carColor;
    }

    @Override
    public T getCarPrice() {
        return carPrice;
    }

    public T getMaxSpeed() {
        return maxSpeed;
    }

    public void setCarModel(T carModel) {
        this.carModel = carModel;
    }

    public void setCarColor(T carColor) {
        this.carColor = carColor;
    }

    public void setCarPrice(T carPrice) {
        this.carPrice = carPrice;
    }

    public void setCarMaxSpeed(T maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

class ModelsCar {

    class Mersedes extends CarSpeed implements Auto {

        private final String carModel;
        private final String carColor;
        private final int carPrice;
        private Integer maxSpeed;

        public Mersedes(String carModel, String carColor, int carPrice) {
            this.carModel = carModel;
            this.carColor = carColor;
            this.carPrice = carPrice;
        }

        @Override
        public String getCarModel() {
            return carModel;
        }

        @Override
        public String getCarcolor() {
            return carColor;
        }

        @Override
        public Integer getCarPrice() {
            return carPrice;
        }

        @Override
        public Integer getMaxSpeed() {
            return maxSpeed;
        }

        public void setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
        }

        @Override
        public int getSpeedCount(Auto auto) {
            return maxSpeed;
        }
    }

    class BMW extends CarSpeed implements Auto {

        private final String carModel;
        private final String carColor;
        private final int carPrice;
        private Integer maxSpeed;

        public BMW(String carModel, String carColor, int carPrice) {
            this.carModel = carModel;
            this.carColor = carColor;
            this.carPrice = carPrice;
        }


        @Override
        public String getCarModel() {
            return carModel;
        }

        @Override
        public String getCarcolor() {
            return carColor;
        }

        @Override
        public Integer getCarPrice() {
            return carPrice;
        }

        @Override
        public Integer getMaxSpeed() {
            return maxSpeed;
        }

        public void setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
        }

        @Override
        public int getSpeedCount(Auto auto) {
            return maxSpeed;
        }
    }
}


