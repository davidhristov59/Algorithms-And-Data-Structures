package cbht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

//koga imam poveke atributi .. - pravime posebna klasa za posle da mozam da napravam insert

class Period {
    private double maxTemperature;
    private Date startTime;
    private Date endTime;

    public Period() {
        this.maxTemperature = -1;
        this.startTime = null;
        this.endTime = null;
    }

    public void addInterval(Date start, Date end, double temperature) {
        if (temperature > maxTemperature) {
            this.maxTemperature = temperature;
            this.startTime = start;
            this.endTime = end;
        }
    }

    public double getHottestTemperature() {
        return maxTemperature;
    }

    @Override
    public String toString() {
        // Implement toString() method for printing the period
        return "";
    }
}

public class Temperatura {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        CBHT<String, Period> cities = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();

            String[] parts = line.split("\\s+");
            String city = parts[0];
            String startInterval = parts[1];
            String endInterval = parts[2];
            double temperature = Double.parseDouble(parts[3]);

            Period period = new Period();

            if(cities.search(city) == null){
                cities.insert(city,period);
            }
            else {
                SLLNode<MapEntry<String, Period>> node = cities.search(city);
                cities.insert(city, period);
            }
        }

        String city = bufferedReader.readLine();

        SLLNode<MapEntry<String, Period>> node = cities.search(city);


    }
}
