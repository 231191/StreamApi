package utility;

import model.Booking;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kamalkumar_S01 on 12/4/2016.
 */
public class DoCalculation {
    public double average(List<Booking> bookings){
        return bookings.stream().mapToDouble(Booking::getStart).average().getAsDouble();
    }

    public double lowest(List<Booking> bookings){
        return bookings.stream().mapToDouble(Booking::getStart).min().getAsDouble();
    }

    public double maxium(List<Booking> bookings){
        return bookings.stream().mapToDouble(Booking::getStart).max().getAsDouble();
    }

    public double median(List<Booking> bookings){
        //List<double> difference = bookings.stream().mapToDouble(t -> t.getStart()).sorted((e1,e2) -> Integer.compare(e1,e2))
        List<Double> difference = bookings.stream().sorted((e1,e2) -> Integer.compare(e1.getStart(),e2.getStart())).mapToDouble(Booking::getStart).boxed().collect(Collectors.toList());
        return difference.get(Math.round(difference.size()/2));
    }
}
