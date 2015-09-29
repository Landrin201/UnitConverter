package com.kuniansky.marc.unitconverter;
import java.math.*;
/*
 * Modifications:
 * 9/18/2015 by Marc Kuniansky, Created the class and implemented the lengthConvert method.
 * After the implementation of the lengthConvert, we stopped adding modification tags- because this was a copy/paste/edit job,
 * no major changes were made that we felt the need to document.
 */
/**
 * This class contains all of the code for the conversions that take place. Each conversion
 * has its own method, and is only called by one activity.
 *
 * Created by Marc Kuniansky on September 17, 2015
 *
 * @author Marc Kuniansky and Noah Getz
 */
public class Converter
{ // Begin converter class

    //Constructor
    /**
     * Constructor with no parameters
     */
    public Converter()
    {
        //Can just be empty, there are no global variables
    }

    /**
     * Takes a number, a length unit, and a new unit and converts the number to the new unit.
     *
     * Accepted units: inches, feet, yards, miles, millimeters, centimeters, meters, kilometers
     * Marc Kuniansky
     * @param originalNum must be a valid double.
     * @param originalUnit must be a string
     * @param desiredUnit must be a string
     * @return the new double
     */
    public double lengthConvert(double originalNum, String originalUnit, String desiredUnit)
    {
        //Make two variable doubles, one the original double and one the new one
        double num1 = originalNum;
        double num2 = 0.0d;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String original = originalUnit.toLowerCase();
        String newU = desiredUnit.toLowerCase();

        //Now there is a series of if statements to check which units are being converted from/to and
        //to do the proper operation

        if(original.equals("inches")) { //Begin converting from inches
            //First, what happens if the user sets both inputs to inches?
            if(newU.equals("inches")) { //Begin converting from inches to inches- nothing change
                num2 = originalNum;
            } //End converting from inches to inches

            //Next, inches to feet
            else if(newU.equals("feet")) { //Begin converting from inches to feet
                //12 inches in a foot, so divide by 12
                num2 = num1 / 12.0d;
            } //End converting from inches to feet

            //Next, inches to yards
            else if(newU.equals("yards")) { //Begin converting from inches to yards
                //36 inches in a yard, so divide by 36
                num2 = num1 / 36.0d;
            } //End converting from inches to yards

            //Next, inches to miles
            else if(newU.equals("miles")) { //Begin converting from inches to miles
                //63,360 inches in a mile
                num2 = num1 / 63360.0d;
            } //End converting from inches to miles

            //Next, inches to millimeters
            else if(newU.equals("millimeters")) { //Begin converting from inches to millimeters
                //There are 25.4 millimeters in an inch, so multiply inches by 25.4
                num2 = num1 * 25.4d;
            } //End converting from inches to millimeters

            //Next, inches to centimeters
            else if(newU.contains("centi")) { //Begin converting from inches to centimeters
                //2.54cm in an inch, multiply inches by 2.54
                num2 = num1 * 2.54d;
            } //End converting from inches to centimeters

            //Next, inches to meters
            else if(newU.equals("meters")) { //Begin converting from inches to meters
                //0.0254 meters to an inch, so multiply inches by 0.0254
                num2 = num1 * 0.0254d;
            } //End converting from inches to meters

            //Finally, if none of the others are true then convert inches to kilometers
            else { //Begin converting from inches to kilometers
                //0.0000254km in an inch
                num2 = num1 * 0.0000254d;
            } //End converting from inches to kilometers
        } //End converting from inches

        //Next, converting from feet
        else if(original.equals("feet"))
        { //Begin conversions from feet
            //First, what happens if the user converts feet to feet? Nothing.
            if(newU.equals("feet"))
            { //Begin converting feet to feet
                num2 = num1;
            } //End converting feet to feet

            //Next, how should we convert feet to other empirical units?
            //Feet to inches.
            else if(newU.equals("inches"))
            { //Begin converting feet to inches
                //12 inches in a foot, multiply by 12
                num2 = num1*12.0d;
            } //End converting feet to inches

            //Feet to yards
            else if(newU.equals("yards"))
            { //Begin feet to yards
                //3 feet in a yard
                num2 = num1/3.0d;
            } //End feet to yards

            //Feet to miles
            else if(newU.equals("miles"))
            { //Begin converting feet to miles
                //5,280 feet in a mile
                num2 = num1/5280.0d;
            } //End converting feet to miles

            //Now convert to metric units

            //Feet to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting feet to millimeters
                //304.8 millimeters in a foot
                num2 = num1*304.8d;
            } //End converting feet to millimeters

            //Feet to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting from feet to centimeters
                //30.48 Centimeters in a foot
                num2 = num1*30.48d;
            } //End converting from feet to centimeters

            //Feet to meters
            else if(newU.equals("meters"))
            { //Begin converting from feet to meters
                //0.3048 meters in a foot
                num2 = num1*0.3048d;
            } //End converting from feet to meters

            //Feet to kilometers
            else
            { //Begin converting from feet to kilometers
                //0.0003048 kilometers in a meter
                num2 = num1*0.0003048d;
            } //End converting from feet to kilometers
        } //End conversions from feet

        //Next, conversions from yards
        else if(original.equals("yards"))
        { //Begin conversions from yards

            //Yards to yards
            if(newU.equals("yards"))
            { //Begin converting from yards to yards
                num2 = num1;
            } //End converting from yards to yards

            //First, convert between empircal units

            //Yards to inches
            else if(newU.equals("inches"))
            { //Begin converting from yards to inches
                //36 inches in a yard
                num2 = num1*36.0d;
            } //End converting from yards to inches

            //Yards to feet
            else if(newU.equals("feet"))
            { //Begin converting from yards to feet
                //3 feet to a yard
                num2 = num1*3.0d;
            } //End converting from yards to feet

            //Yards to miles
            else if(newU.equals("miles"))
            { //Begin converting from yards to miles
                //1760 yards in a mile
                num2 = num1/1760.0d;
            } //End converting from yards to miles

            //Now metric units

            //Yards to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting yards to millimeters
                //914.4 millimeters in a yard
                num2 = num1*914.4d;
            } //End converting yards to millimeters

            //Yards to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting yards to centimeters
                //91.44 centimeters in a yard
                num2 = num1*91.44d;
            } //End converting yards to centimeters

            //Yards to meters
            else if(newU.equals("meters"))
            { //Begin conversion from yards to meters
                num2 = num1*0.9144d;
            } //End conversion from yards to meters

            //Yards to kilometers
            else
            { //Begin conversion from yards to kilometers
                //1,093.61 yards in a kilometer
                num2 = num1/1093.61d;
            } //End conversion from yards to kilometers
        } //End conversions from yards

        //Next, convert from miles
        else if(original.equals("miles"))
        { //Begin conversions from miles
            //First, miles to miles
            if(newU.equals("miles"))
            { //Begin converting from miles to miles
                num2 = num1;
            } //End converting from miles to miles

            //Now, convert to the rest of the empirical units
            //Miles to inches
            else if(newU.equals("inches"))
            { //Begin converting from miles to inches
                //6330 inches in a mile
                num2 = num1*6330.0d;
            } //End converting from miles to inches

            //Miles to feet
            else if(newU.equals("feet"))
            { //Begin converting from miles to feet
                //5280 feet in a mile
                num2 = num1*5280.0d;
            } //End converting from miles to feet

            //Miles to yards
            else if(newU.equals("yards"))
            { //Begin converting from miles to yards
                //1760 yards in a mile
                num2 = num1*1760.0d;
            } //End converting from miles to yards

            //Now do the metric conversions

            //Miles to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting from miles to millimeters
                //1,609,000 millimeters in a mile
                num2 = num1*1609340.0d;
            } //End converting from miles to millimeters

            //Miles to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting from miles to centimeters
                //16,0934 centemeters in a miles
                num2 = num1*160934.0d;
            } //End converting from miles to centimeters

            //Miles to meters
            else if(newU.equals("meters"))
            { //Begin converting from miles to meters
                //1609.34 meters in a mile
                num2 = num1*1609.34d;
            } //End converting from miles to meters

            //Miles to kilometers
            else
            { //Begin converting miles to kilometers
                //1.60934 kilometers in a mile
                num2 = num1*1.60934d;
            } //End converting miles to kilometers
        } //End conversions from miles

        //Next, convert from millimeters
        else if(original.equals("millimeters"))
        { //Begin converting from millimeters

            //Millimeters to millimeters
            if(newU.equals("millimeters"))
            { //Begin converting from millimeters to millimeters
                num2 = num1;
            } //End converting from millimeters to millimeters

            //Emperical units first

            //Millimeters to inches
            else if(newU.equals("inches"))
            { //Begin converting from millimeters to inches
                num2 = num1*25.4d;
            } //End converting from millimeters to inches

            //Millimeters to feet
            else if(newU.equals("feet"))
            { //Begin converting from millimeters to feet
                num2 = num1/304.8d;
            } //End converting from millimeters to feet

            //Millimeters to yards
            else if(newU.equals("yards"))
            { //Begin converting from millimeters to yards
                num2 = num1/914.4d;
            } //End converting from millimeters to yards

            //Millimeters to miles
            else if(newU.equals("miles"))
            { //Begin converting from millimeters to miles
                num2 = num1/1609000.0d;
            } //End converting from millimeters to miles

            //Now metric

            //Millimeters to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting from millimeters to centimeters
                num2 = num1/10.0d;
            } //End converting from millimeters to centimeters

            //Millimeters to meters
            else if(newU.equals("meters"))
            { //Begin converting from millimeters to meters
                num2 = num1/1000.0d;
            } //End converting from millimeters to meters

            //Millimeters to Kilomters
            else
            { //Begin converting from millimeters to kilometers
                num2 = num1/1000000.0d;
            } //End converting from millimeters to kilometers

        } //End converting from millimeters

        //Next, convert from centimeters
        else if(original.equals("centimeters"))
        { //Begin converting from centimeters

            //Centimeters to centimeters
            if(newU.equals("centimeters"))
             { //Begin converting from centimeters to centimeters
                 num2 = num1;
             } //End converting from centimeters to centimeters

            //Empirical units

            //Centimeters to inches
            else if(newU.equals("inch"))
            { //Begin converting from centimeters to inches
                num2 = num1/2.54d;
            } //End converting from centimeters to inches

            //Centimeters to feet
            else if(newU.equals("feet"))
            { //Begin converting from centimeters to feet
                num2=num1/30.48d;
            } //End converting from centimeters to feet

            //Centimeters to yards
            else if(newU.equals("inch"))
            { //Begin converting from centimeters to yards
                num2=num1/91.44d;
            } //End converting from centimeters to yards

            //Centimeters to miles
            else if(newU.equals("mile"))
            { //Begin converting from centimeters to miles
                num2 = num1/160934.0d;
            } //End converting from centimeters to miles

            //Metric units

            //Centimeters to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting from centimeters to millimeters
                num2 = num1*10.0d;
            } //End converting from centimeters to millimeters

            //Centimeters to meters
            else if(newU.equals("meters"))
            { //Begin converting from centimeters to meters
                num2 = num1/100.0d;
            } //End converting from centimeters to meters

            //Centimeters to kilometers
            else
            { //Begin converting from centimeters to kilometers
                num2 = num1/100000.0d;
            } //End converting from centimeters to kilometers
        } //End converting from centimeters

        //Next, convert from meters
        else if(original.equals("meters"))
        { //Begin converting from meters

            //Convert meters to meters
            if(newU.equals("meters"))
            { //Begin converting from meters to meters
                num2 = num1;
            } //End converting from meters to meters

            //Empirical units

            //Meters to inches
             else if(newU.equals("inches"))
             { //Begin converting from meters to inches
                 num2 = num1*39.3701d;
             } //End converting from meters to inches

            //Meters to feet
            else if(newU.equals("feet"))
            { //Begin converting from meters to feet
                num2 = num1*3.28084d;
            } //End converting from meters to feet

            //Meters to yards
            else if(newU.equals("yards"))
            { //Begin converting from meters to yards
                num2 = num1*1.09361d;
            } //End converting from meters to yards

            //Meters to miles
            else if(newU.equals("miles"))
            { //Begin converting from meters to miles
                num1 = num2/1609.34d;
            } //End converting from meters to miles

            //Metric units

            //Meters to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting from meters to millimeters
                num1 = num2*1000.0d;
            } //End converting from meters to millimeters

            //Meters to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting from meters to centimeters
                num2 = num1*100.0d;
            } //End converting from meters to centimeters

            //Meters to kilometers
            else
            { //Begin converting from meters to kilometers
                num2 =num1/1000.0d;
            } //End converting from meters to kilometers
        } //End converting from meters

        //Finally, try converting from kilometers
        else
        { //Begin converting from kilometers

            //Kilometers to kilometers
            if(newU.equals("kilometers"))
            { //Begin converting from kilometers to kilometers
                num2 = num1;
            } //End converting from kilometers to kilometers

            //Empirical units

            //Kilometers to inches
            else if(newU.equals("inches"))
            { //Begin converting from kilometers to inches
                num2 = num1*39370.1d;
            } //End converting from kilometers to inches

            //Kilometers to feet
            else if(newU.equals("feet"))
            { //Begin converting from kilometers to feet
                num2 = num1*3280.84d;
            } //End converting from kilometers to feet

            //Kilometers to yards
            else if(newU.equals("yards"))
            { //Begin converting from kilometers to yards
                num2 = num1*1093.61d;
            } //End converting from kilometers to yards

            //Kilometers to miles
            else if(newU.equals("miles"))
            { //Begin converting from kilometers to miles
                num2 = num1/1.60934d;
            } //End converting from kilometers to miles

            //Metric units

            //Kilometers to millimeters
            else if(newU.equals("millimeters"))
            { //Begin converting from kilometers to millimeters
                num2 = num1*1000000.0d;
            } //End converting from kilometers to millimeters

            //Kilometers to centimeters
            else if(newU.equals("centimeters"))
            { //Begin converting from kilometers to centimeters
                num2 = num1*100000.0d;
            } //End converting from kilometers to centimeters

            //Kilometers to meters
            else
            { //Begin converting from kilometers to meters
                num2 = num1*1000.0d;
            } //End converting from kilometers to meters
        } //End converting from kilometers

    //num2 is the number we want; return it
    return num2;
    } //End lengthConvert

    /**
     * Takes a number, a temperature unit, and a new unit and converts the number to the new unit.
     *
     * Accepted units: Fahrenheit, Kelvin, Celsius
     * Noah Getz
     * @param originalNum must be a valid double.
     * @param originalUnit must be a string
     * @param desiredUnit must be a string
     * @return the new double
     */
    public double tempConvert(double originalNum, String originalUnit, String desiredUnit){
        //Make two variable doubles, one the original double and one the new one
        double num1 = originalNum;
        double num2 = 0.0d;
        double num3 = 0.0d;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String original = originalUnit.toLowerCase();
        String newU = desiredUnit.toLowerCase();


        if(original.equals("celsius")){
            if(newU.equals("celsius")){
                num2 = originalNum;
            }
            else if(newU.equals("fahrenheit")){
                num2 = (originalNum * 1.8d) + 32d;
            }
            else{
                num2 = originalNum + 273.15d;
            }
        }

        else if(original.equals("fahrenheit")){
            if(newU.equals("fahrenheit")){
                num2 = originalNum;
            }

            else if(newU.equals("celsius")){
                num3 = (-originalNum - 32d);
                num2 = num3 * (5.0/9.0);
            }

            else{
                num2 = (originalNum - 32d) * (5.0/9.0) + 273.15d;
            }
        }

        else{
            if(newU.equals("kelvin")){
                num2 = originalNum;
            }

            else if(newU.equals("celsius")){
                num2 = originalNum - 273.15d;
            }

            else{
                num2 = ((originalNum - 273.15d) * 1.8d) + 32d;
            }
        }

        return num2;
    }

    /**
     * Takes a number, a volume unit, and a new unit and converts the number to the new unit.
     *
     * Accepted units: Milliliter, liter, kiloliter, pint, quart, gallon, cup.
     *
     * Noah Getz
     * @param originalNum must be a valid double.
     * @param originalUnit must be a string
     * @param desiredUnit must be a string
     * @return the new double
     */
    public double volumeConvert(double originalNum, String originalUnit, String desiredUnit){
        //Make two variable doubles, one the original double and one the new one
        double num1 = originalNum;
        double num2 = 0.0d;
        double num3 = 0.0d;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String original = originalUnit.toLowerCase();
        String newU = desiredUnit.toLowerCase();


        if(original.equals("milliliter")){
            if(newU.equals("milliliter")){
                num2 = originalNum;
            }

            else if(newU.equals("liter")){
                num2 = originalNum * .001d;
            }

            else if(newU.equals("kiloliter")){
                num2 = originalNum * .000001d;
            }

            else if(newU.equals("pint")){
                num2 = originalNum * .00211338d;
            }

            else if(newU.equals("quart")){
                num2 = originalNum * .00105669d;
            }

            else if(newU.equals("gallon")){
                num2 = originalNum * .000264172d;
            }

            else{
                num2 = originalNum * .00422675d;
            }
        }

        else if(original.equals("liter")){
            if(newU.equals("liter")){
                num2 = originalNum;
            }

            else if(newU.equals("mililiter")){
                num2 = originalNum * 1000d;
            }

            else if(newU.equals("kiloliter")){
                num2 = originalNum * .001d;
            }

            else if(newU.equals("pint")){
                num2 = originalNum * 2.11338d;
            }

            else if(newU.equals("quart")){
                num2 = originalNum * 1.05669d;
            }

            else if(newU.equals("gallon")){
                num2 = originalNum * 0.264172d;
            }

            else{
                num2 = originalNum * 4.22675d;
            }
        }

        else if(original.equals("kiloliter")){
            if(newU.equals("kiloliter")){
                num2 = originalNum;
            }

            else if(newU.equals("mililiter")){
                num2 = originalNum * 1000000.0d;
            }

            else if(newU.equals("liter")){
                num2 = originalNum * 1000.0d;
            }

            else if(newU.equals("pint")){
                num2 = originalNum * 2113.38d;
            }

            else if(newU.equals("quart")){
                num2 = originalNum * 1056.69d;
            }

            else if(newU.equals("gallon")){
                num2 = originalNum * 264.172d;
            }

            else{
                num2 = originalNum * 4226.75d;
            }
        }

        else if(original.equals("pint")){
            if(newU.equals("pint")){
                num2 = originalNum;
            }

            else if(newU.equals("mililiter")){
                num2 = originalNum * 473.176d;
            }

            else if(newU.equals("liter")){
                num2 = originalNum * 0.473176d;
            }

            else if(newU.equals("kiloliter")){
                num2 = originalNum * .00047176d;
            }

            else if(newU.equals("quart")){
                num2 = originalNum * .5d;
            }

            else if(newU.equals("gallon")){
                num2 = originalNum * .125d;
            }

            else{
                num2 = originalNum * 2d;
            }
        }

        else if(original.equals("quart")){
            if(newU.equals("quart")){
                num2 = originalNum;
            }

            else if(newU.equals("mililiter")){
                num2 = originalNum * 946.353d;
            }

            else if(newU.equals("liter")){
                num2 = originalNum * 0.946353d;
            }

            else if(newU.equals("kiloliter")){
                num2 = originalNum * .000946353d;
            }

            else if(newU.equals("pint")){
                num2 = originalNum * 2.0d;
            }

            else if(newU.equals("gallon")){
                num2 = originalNum * .25d;
            }

            else{
                num2 = originalNum * 4.0d;
            }
        }

        else if(original.equals("gallon")){
            if(newU.equals("gallon")){
                num2 = originalNum;
            }

            else if(newU.equals("mililiter")){
                num2 = originalNum * 3785.41d;
            }

            else if(newU.equals("liter")){
                num2 = originalNum * 3.78541d;
            }

            else if(newU.equals("kiloliter")){
                num2 = originalNum * .00378541d;
            }

            else if(newU.equals("pint")){
                num2 = originalNum * 8.0d;
            }

            else if(newU.equals("quart")){
                num2 = originalNum * 4.0d;
            }

            else{
                num2 = originalNum * 16.0d;
            }
        }

        else{
            if(newU.equals("cup")){
                num2 = originalNum;
            }

            else if(newU.equals("mililiter")){
                num2 = originalNum * 236.588d;
            }

            else if(newU.equals("liter")){
                num2 = originalNum * 0.236588d;
            }

            else if(newU.equals("kiloliter")){
                num2 = originalNum * .000236588d;
            }

            else if(newU.equals("pint")){
                num2 = originalNum * .5d;
            }

            else if(newU.equals("quart")){
                num2 = originalNum * .25d;
            }

            else{
                num2 = originalNum * .0625d;
            }
        }

        return num2;
    }

    /**
     * Takes a number, a mass unit, and a new unit and converts the number to the new unit.
     *
     * Accepted units: pounds, kilograms, grams, milligrams
     * Noah Getz
     * @param originalNum must be a valid double.
     * @param originalUnit must be a string
     * @param desiredUnit must be a string
     * @return the new double
     */
    public double massConvert(double originalNum, String originalUnit, String desiredUnit){
        //Make two variable doubles, one the original double and one the new one
        double num1 = originalNum;
        double num2 = 0.0d;


        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String original = originalUnit.toLowerCase();
        String newU = desiredUnit.toLowerCase();


        if(original.equals("pounds")){
            if(newU.equals("pounds")){
                num2 = originalNum;
            }

            else if(newU.equals("kilograms")){
                num2 = originalNum * 0.453592d;
            }

            else if(newU.equals("grams")){
                num2 = originalNum * 453.592d;
            }

            else{
                num2 = originalNum * 453592.0d;
            }
        }

        else if(original.equals("kilograms")){
            if(newU.equals("kilograms")){
                num2 = originalNum;
            }

            else if(newU.equals("pounds")){
                num2 = originalNum * 2.20462d;
            }

            else if(newU.equals("grams")){
                num2 = originalNum * 1000.0d;
            }

            else{
                num2 = originalNum * 1000000.0d;
            }
        }

        else if(original.equals("grams")){
            if(newU.equals("grams")){
                num2 = originalNum;
            }

            else if(newU.equals("pounds")){
                num2 = originalNum * 2.20462d;
            }

            else if(newU.equals("kilograms")){
                num2 = originalNum * .001d;
            }

            else{
                num2 = originalNum * 1000d;
            }
        }

        else{
            if(newU.equals("milligrams")){
                num2 = originalNum;
            }

            else if(newU.equals("pounds")){
                num2 = originalNum * .0000022046d;
            }

            else if(newU.equals("grams")){
                num2 = originalNum * .001d;
            }

            else{
                num2 = originalNum * .000001d;
            }
        }

        return num2;
    }

    /**
     * Takes a number, a pressure unit, and a new unit and converts the number to the new unit.
     *
     * Accepted units: torr, atm, mmHg, barr
     * Noah Getz
     * @param originalNum must be a valid double.
     * @param originalUnit must be a string
     * @param desiredUnit must be a string
     * @return the new double
     */
    public double pressureConvert(double originalNum, String originalUnit, String desiredUnit){
        //Make two variable doubles, one the original double and one the new one
        double num1 = originalNum;
        double num2 = 0.0d;


        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String original = originalUnit.toLowerCase();
        String newU = desiredUnit.toLowerCase();


        if(original.equals("torr")) {
            if (newU.equals("torr")) {
                num2 = originalNum;

            }
            else if (newU.equals("atm")) {
                num2 = originalNum * 0.0013157893594d;
            }

            else if (newU.equals("mmhg")) {
                num2 = originalNum * 0.99999984999d;
            }

            else{
                num2 = originalNum * 0.0013332237d;
            }
        }

        else if(original.equals("atm")) {
            if (newU.equals("atm")) {
                num2 = originalNum;

            }
            else if (newU.equals("torr")) {
                num2 = originalNum * 760.00006601d;
            }

            else if (newU.equals("mmhg")) {
                num2 = originalNum * 759.999952d;
            }

            else{
                num2 = originalNum * 1.0132501d;
            }
        }

        else if(original.equals("mmhg")) {
            if (newU.equals("mmhg")) {
                num2 = originalNum;

            }
            else if (newU.equals("torr")) {
                num2 = originalNum * 1.00000015d;
            }

            else if (newU.equals("atm")) {
                num2 = originalNum * 0.0013157895568d;
            }

            else{
                num2 = originalNum *  0.0013332239d;
            }
        }

        else{
            if (newU.equals("bar")) {
                num2 = originalNum;

            }
            else if (newU.equals("torr")) {
                num2 = originalNum * 750.06167382d;
            }

            else if (newU.equals("atm")) {
                num2 = originalNum * 0.98692316931d;
            }

            else{
                num2 = originalNum *  750.0615613d;
            }
        }
        return num2;
    }

    /**
     * Converts a number from one unit of time to another
     *
     * Units of time supported: seconds, minutes, hours, days, weeks, months, years
     *
     * Marc Kuniansky
     * @param originalNumber must be a valid double
     * @param originalUnit must be a valid String matching one of the supported units
     * @param newUnit must be a valid String matching one of the supported units
     * @return a double, the converted number
     */
    public double timeConvert(double originalNumber, String originalUnit, String newUnit)
    { //Begin convertTime
        //Make two doubles, one that holds the original and one that will be redefined where needed
        double num1 = originalNumber;
        double num2 = 0.0d;

        //Make two strings, capturing the units fed to the method
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        //The series of if statements below figures out what unit to convert from/to, and does so.

        //Convert from seconds
        if(originalU.equals("seconds"))
        { //Begin converting from seconds
            //Thanks Pam for the suggestion about switch statements- I realized far too late how easy they are to use and how much better they look.
            switch(newU)
            {
                case "seconds":
                    num2 = num1;
                    break;
                case "minutes":
                    num2 = num1/60.0d;
                    break;
                case "hours":
                    num2 = num1/3600.0d;
                    break;
                case "days":
                    num2 = num1*0.000011574d;
                    break;
                case "weeks":
                    num2 = num1*0.0000016534d;
                    break;
                case "months":
                    num2 = num1*0.00000038027d;
                    break;
                case "years":
                    num2 = num1*0.000000031689d;
                    break;
            }
        } //End converting from seconds

        //Convert from minutes
        else if(originalU.contains("minute"))
        { //Begin converting from minutes
            switch(newU)
            {
                case "minutes":
                    num2 = num1;
                    break;
                case "seconds":
                    num2 = num1*60.0d;
                    break;
                case "hours":
                    num2 = num1/60.0d;
                    break;
                case "days":
                    num2 = num1/1440.0d;
                    break;
                case "weeks":
                    num2 = num1/10080.0d;
                    break;
                case "months":
                    num2 = num1/43829.1d;
                    break;
                case "years":
                    num2 = num1/525949.0d;
            }
        } //End converting from minutes

        //Convert from hours
        else if(originalU.contains("hour"))
        { //Begin converting from hours
            switch(newU)
            {
                case "hours":
                    num2 = num1;
                    break;
                case "seconds":
                    num2 = num1*3600.0d;
                    break;
                case "minutes":
                    num2 = num1*60.0d;
                    break;
                case "days":
                    num2 = num1/24.0d;
                    break;
                case "weeks":
                    num2 = num1/168.0d;
                    break;
                case "months":
                    num2 = num1/730.484d;
                    break;
                case "years":
                    num2 = num1/8765.81d;
                    break;
            }
        } //End converting from hours

        //Convert from days
        else if(originalU.contains("day"))
        { //Begin converting from days
            switch(newU)
            {
                case "days":
                    num2 = num1;
                    break;
                case "seconds":
                    num2 = num1*86400.0d;
                    break;
                case "minutes":
                    num2 = num1*1440.0d;
                    break;
                case "hours":
                    num2 = num1*24.0d;
                    break;
                case "weeks":
                    num2 = num1/7.0d;
                    break;
                case "months":
                    num2 = num1/30.4368d;
                    break;
                case "years":
                    num2 = num1/365.242d;
                    break;
            }
        } //End converting from days

        else if(originalU.contains("week"))
        { //Begin converting from weeks
            switch(newU)
            {
                case "weeks":
                    num2 = num1;
                    break;
                case "seconds":
                    num2 = num1*604800.0d;
                    break;
                case "minutes":
                    num2 = num1*10080.0d;
                    break;
                case "hours":
                    num2 = num1*168.0d;
                    break;
                case "days":
                    num2 = num1*7.0d;
                    break;
                case "months":
                    num2 = num1/4.34812d;
                    break;
                case "years":
                    num2 = num1/52.1775d;
                    break;
            }
        } //End converting from weeks

        //Convert from months
        else if(originalU.contains("month"))
        { //Begin converting from months
            switch(newU)
            {
                case "months":
                    num2 = num1;
                    break;
                case "seconds":
                    num2 = num1*2630000.0d;
                    break;
                case "minutes":
                    num2 = num1*43829.1d;
                    break;
                case "hours":
                    num2 = num1*730.484d;
                    break;
                case "days":
                    num2 = num1*30.4368d;
                    break;
                case "weeks":
                    num2 = num1*4.34812d;
                    break;
                case "years":
                    num2 = num1/12.0d;
                    break;
            }
        } //End converting from months

        //Convert from years
        else
        { //Begin converting from years
            switch(newU)
            {
                case "years":
                    num2 = num1;
                    break;
                case "seconds":
                    num2 = num1*31560000.0d;
                    break;
                case "minutes":
                    num2 = num1*525949.0d;
                    break;
                case "hours":
                    num2 = num1*8765.81d;
                    break;
                case "days":
                    num2 = num1*365.242d;
                    break;
                case "weeks":
                    num2 = num1*52.1775d;
                    break;
                case "months":
                    num2 = num1*12.0d;
                    break;
            }
        } //End converting from years

        return num2;
    } //End convertTime

    /**
     * Converts a number from one unit of force to another.
     *
     * Units accepted: Newtons, pound force
     *
     * Marc Kuniansky
     * @param originalNumber must be a valid double
     * @param originalUnit must be a valid String matching one of the supported units
     * @param newUnit must be a valid String matching one of the supported units
     * @return a double, the converted unit.
     */
    public double forceConvert(double originalNumber, String originalUnit, String newUnit)
    { //Begin convertForce
        //Make two doubles, one that holds the original and one that will be redefined where needed
        double num1 = originalNumber;
        double num2 = 0.0d;

        //Make two strings, capturing the units fed to the method
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        //The series of if statements below figures out what unit to convert from/to, and does so.

        //Convert from pound force
        if(originalU.contains("pound"))
        {
            switch(newU)
            {
                case "pound force":
                    num2 = num1;
                    break;
                case "newtons":
                    num2 = num1*4.448222d;
                    break;
            }
        }

        //Convert from Newtons
        else
        {
            switch(newU)
            {
                case "newtons":
                    num1 = num2;
                    break;
                case "pound force":
                    num1=num2/4.448222d;
                    break;
            }
        }
        return num2;
    } //End convertForce

    /**
     * Converts a number from one unit of speed to another
     *
     * Recognized speed units: miles per hour, feet per second, meters per second,
     * kilometers per second, kilometers per hour.
     *
     * Marc Kuniansky
     * @param originalNumber must be a valid double
     * @param originalUnit must be a valid String recognized by the method
     * @param newUnit must be a valid String recognized by the method
     * @return double, the converted unit.
     */
    public double speedConvert(double originalNumber, String originalUnit, String newUnit)
    { //Begin convertSpeed
        //Make two doubles, one that holds the original and one that will be redefined where needed
        double num1 = originalNumber;
        double num2 = 0.0d;

        //Make two strings, capturing the units fed to the method
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        //The series of if statements below figures out what unit to convert from/to, and does so.

        //first, convert from miles per hour
        if(originalU.contains("miles"))
        { //Begin converting from Miles per Hour

            //First, convert to miles per hour
            if(newU.contains("miles"))
            {
                num2 = num1;
            }

            //Convert to feet per second
            else if(newU.contains("feet"))
            {
                num2 = num1*1.46667d;
            }

            //Convert to kilometers per...
            else if(newU.contains("kilo"))
            {
                //Convert to kilometers per second
                if(originalU.contains("Second"))
                {
                    num2 = num1*0.00044704d;
                }
                //Convert to kilometers per hour
                else
                {
                    num2 = num1*1.60934d;
                }
            }

            //Convert to meters per second
            else
            {
                num2 = num1*0.44704d;
            }
        } //End converting from miles per hour

        //Next, convert from feet per second
        else if(originalU.contains("feet"))
        { //Begin converting from feet per second
            //First, convert to feet per second
            if(newU.contains("feet"))
            {
                num2 = num1;
            }

            //Convert to miles per hour
            else if(newU.contains("miles"))
            {
                num2 = num1*0.681818d;
            }

            //Convert to kilometers per...
            else if(newU.contains("kilo"))
            {
                //Convert to kilometers per second
                if(newU.contains("second"))
                {
                    num2 = num1*0.0003048d;
                }

                //Convert to kilometers per hour
                else
                {
                    num2 = num1*1.09728d;
                }
            }

            //Convert to meters per second
            else
            {
                num2 = num1*0.3048d;
            }
        } //End converting from feet per second

        //Next convert from kilometers per...
        else if(originalU.contains("kilo"))
        { //Begin converting from kilometers per...

            //Kilometers per second is a very useful unit to know for orbital mechanics.
            if(originalU.contains("second"))
            { //Begin converting from kilometers per second
                //First, convert to kilometers per...
                if(newU.contains("kilo"))
                {
                    //Convert to kilometers per second
                    if(newU.contains("second"))
                    {
                        num2 = num1;
                    }

                    //Convert to kilometers per hour
                    else
                    {
                        num2 = num1*3600.0d;
                    }
                }

                //Convert to feet per second
                else if(newU.contains("feet"))
                {
                    num2 = num1*3280.8399d;
                }

                //Convert to miles per hour
                else if(newU.contains("miles"))
                {
                    num2 = num1*2236.93629d;
                }

                //Convert to meters per second
                else
                {
                    num2 = num1*1000.0d;
                }
            } //End converting from kilometers per second

            else
            { //Begin converting from kilometers per hour
                if(newU.contains("kilo"))
                {
                    //Convert to kilometers per hour
                    if(newU.contains("hour"))
                    {
                        num2 = num1;
                    }

                    //Convert to kilometers per second
                    else
                    {
                        num2 = num1*0.000277777778d;
                    }
                }

                //Convert to feet per second
                else if(newU.contains("feet"))
                {
                    num2 = num1*0.911344d;
                }

                //Convert to miles per hour
                else if(newU.contains("miles"))
                {
                    num2 = num1*0.621371d;
                }

                //Convert to meters per second
                else
                {
                    num2 = num1*0.277778d;
                }
            } //End converting from kilometers per hour
        } //End converting from kilometers per...

        //Finally, convert from meters per second
        else
        { //Begin converting from meters per second
            //First, convert to kilometers per...
            if(newU.contains("Kilo"))
            {
                //Convert to kilometers per second
                if(newU.contains("second"))
                {
                    num2 = num1*0.001d;
                }

                //Convert to kilometers per hour
                else
                {
                    num2 = num1*3.6d;
                }
            }

            //Convert to feet per second
            else if(newU.contains("feet"))
            {
                num2 = num1*3.28084d;
            }

            //Convert to miles per hour
            else if(newU.contains("miles"))
            {
                num2 = num1*2.23694d;
            }

            //Convert to meters per second
            else
            {
                num2 = num1;
            }
        } //End converting from meters per second

        //Return the result
        return num2;
    } //End convertSpeed

    /**
     * Converts a number from one unit of speed to another.
     *
     * Accepted units: square inches, square feet, square yards, square miles, square meters, square kilometers, acres
     *
     * Marc Kuniansky
     * @param originalNumber must be a valid double
     * @param originalUnit must be a valid String matching one of the supported units
     * @param newUnit must be a valid String matching one of the supported units
     * @return a double, the converted unit.
     */
    public double areaConvert(double originalNumber, String originalUnit, String newUnit)
    { //Begin convertArea
        //Make two doubles, one that holds the original and one that will be redefined where needed
        double num1 = originalNumber;
        double num2 = 0.0d;

        //Make two strings, capturing the units fed to the method
        String originalU = originalUnit.toLowerCase();

        //All of these values are "Square..." and the square part is totally unimportant for us. Throw it out.
        String substringNewU = new String(newUnit.substring(7));
        String newU = substringNewU.toLowerCase();

        //Begin unit conversions
        if(originalU.contains("inches"))
        { //Begin converting from square inches
            switch(newU)
            {
                case "inches":
                    num2 = num1;
                    break;
                case "feet":
                    num2 = num1/144.0d;
                    break;
                case "yards":
                    num2 = num1/1296.0d;
                    break;
                case "miles":
                    num2 = num1/4014000000.0d;
                    break;
                case "acres":
                    num2 = num1/6273000.0d;
                    break;
                case "kilometers":
                    num2 = num1/1550000000.0d;
                    break;
                case "meters":
                    num2 = num1/1550.0d;
                    break;
            }
        } //End converting from square inches
        else if(originalU.contains("feet"))
        { //Begin converting from square feet
            switch(newU)
            {
                case "inches":
                    num2 = num1*144.0d;
                    break;
                case "feet":
                    num2 = num1;
                    break;
                case "yards":
                    num2 = num1/9.0d;
                    break;
                case "miles":
                    num2 = num1/27880000.0d;
                    break;
                case "acres":
                    num2 = num1/43560.0d;
                    break;
                case "kilometers":
                    num2 = num1/10760000.0d;
                    break;
                case "meters":
                    num2 = num1/10.7639d;
                    break;
            }
        } //End converting from square feet
        else if(originalU.contains("yards"))
        { //Begin converting from square yards
            switch(newU)
            {
                case "inches":
                    num2 = num1*1296.0d;
                    break;
                case "feet":
                    num2 = num1*9.0d;
                    break;
                case "yards":
                    num2 = num1;
                    break;
                case "miles":
                    num2 = num1/3098000.0d;
                    break;
                case "acres":
                    num2 = num1/4840.0d;
                    break;
                case "kilometers":
                    num2 = num1/1196000.0d;
                    break;
                case "meters":
                    num2 = num1/1.19599d;
                    break;
            }
        } //End converting from square yards
        else if(originalU.contains("miles"))
        { //Begin converting from square miles
            switch(newU)
            {
                case "inches":
                    num2 = num1*4014000000.0d;
                    break;
                case "feet":
                    num2 = num1*27880000.0d;
                    break;
                case "yards":
                    num2 = num1*3098000.0d;
                    break;
                case "miles":
                    num2 = num1;
                    break;
                case "acres":
                    num2 = num1*640.0d;
                    break;
                case "kilometers":
                    num2 = num1*2.58999d;
                    break;
                case "meters":
                    num2 = num1*2590000.0d;
                    break;
            }
        } //End converting from square miles
        else if(originalU.contains("acre"))
        { //Begin converting from acres
            switch(newU)
            {
                case "inches":
                    num2 = num1*6273000.0d;
                    break;
                case "feet":
                    num2 = num1*43560.0d;
                    break;
                case "yards":
                    num2 = num1*4840.0d;
                    break;
                case "miles":
                    num2 = num1/640.0d;
                    break;
                case "acres":
                    num2 = num1;
                    break;
                case "kilometers":
                    num2 = num1/247.105d;
                    break;
                case "meters":
                    num2 = num1*4046.86d;
                    break;
            }
        } //End converting from acres
        else if(originalU.contains("kilo"))
        { //Begin converting from square kilometers
            switch(newU)
            {
                case "inches":
                    num2 = num1*1550000000.0d;
                    break;
                case "feet":
                    num2 = num1*10760000.0d;
                    break;
                case "yards":
                    num2 = num1*1196000.0d;
                    break;
                case "miles":
                    num2 = num1/2.58999d;
                    break;
                case "acres":
                    num2 = num1;
                    break;
                case "kilometers":
                    num2 = num1;
                    break;
                case "meters":
                    num2 = num1*1000000.0d;
                    break;
            }
        } //End converting from square kilometers
        else
        { //Begin converting from square meters
            switch(newU)
            {
                case "inches":
                    num2 = num1*1550.0d;
                    break;
                case "feet":
                    num2 = num1*10.7639d;
                    break;
                case "yards":
                    num2 = num1*1.19599d;
                    break;
                case "miles":
                    num2 = num1/2590000.0d;
                    break;
                case "acres":
                    num2 = num1/4046.86d;
                    break;
                case "kilometers":
                    num2 = num1/1000000.0d;
                    break;
                case "meters":
                    num2 = num1;
                    break;
            }
        } //End converting from square meters

        return num2;
    } //End convertArea

    /**
     * Converts between metric prefixes. The type of unit is unimportant- the metric system operates on a base 10 system
     * and so converting between, say, millimeters and meters is exactly the same as converting between milliliters and liters.
     *
     * Accepted prefixes: yotta, zeta, exa, peta, tera, giga, mega, kilo, hecto, deka, UNIT,
     * deci, centi, milli, micro, nano, pico, femto, atto, zepto, yocto
     *
     * Marc Kuniansky
     * @param originalNumber must be a valid double
     * @param originalUnit must be a valid String matching one of the supported units
     * @param newUnit must be a valid String matching one of the supported units
     * @return
     */
    public double metricConvert(double originalNumber, String originalUnit, String newUnit)
    { //Begin metricConvert
        //This can use a slightly different, and much easier, algorithm than the others.
        //Because metric is so well organized, it doesn't matter what number is input- the conversion factors are the same.
        //So if I take the original number and convert it to UNITS (which is x*10^0) then convert from UNITS to the new unit,
        //I can very easily do these conversions with very little work. I will heavily utilize the math class here, I need to
        //use exponents quite a bit to simplify life.

        //First, I will need four doubles: the original number, the UNIT number, the final number, and a variable with which to catch the
        //powers of 10.
        double num1 = originalNumber;
        double unitNum = 0d;
        double finalNum = 0d;
        double tenP = 0d;

        //I like to grab the two strings to prevent accidental editing/deletion. I also send them to lower case.
        String originalUn = originalUnit.toLowerCase();
        String newUn = newUnit.toLowerCase();

        String originalU = originalUn.substring(0, originalUn.indexOf(" "));
        String newU = newUn.substring(0, newUn.indexOf(" "));
        //Next, I use the first of two switch statements. This converts the original number to UNITS, or x*10^0.
        switch(originalU)
        {
            case "yotta":
                //Yotta is 10^24 units
                tenP = allExponents(10d, 24d);
                unitNum = tenP*num1;
                break;
            case "zeta":
                //Zeta is 10^21
                tenP = allExponents(10d, 21d);
                unitNum = tenP*num1;
                break;
            case "exa":
                //Exa is 10^18
                tenP = allExponents(10d, 18d);
                unitNum = tenP*num1;
                break;
            case "peta":
                //Peta is 10^15
                tenP = allExponents(10d, 15d);
                unitNum = tenP*num1;
                break;
            case "tera":
                //Tera is 10^12
                tenP = allExponents(10d, 12d);
                unitNum = tenP*num1;
                break;
            case "giga":
                //Giga is 10^9
                tenP = allExponents(10d, 9d);
                unitNum = tenP*num1;
                break;
            case "mega":
                //Mega is 10^6
                tenP = allExponents(10d, 6d);
                unitNum = tenP*num1;
                break;
            case "kilo":
                //Kilo is 10^3
                tenP = allExponents(10d, 3d);
                unitNum = tenP*num1;
                break;
            case "hecto":
                //Hecto is 10^2
                tenP = allExponents(10d, 2d);
                unitNum = tenP*num1;
                break;
            case "deka":
                //Deka is 10^1
                tenP = allExponents(10d, 1d);
                unitNum = tenP*num1;
                break;
            case "unit":
                //UNIT is the target, 10^0
                tenP = allExponents(10d, 0d);
                unitNum = tenP*num1;
                break;
            case "deci":
                //Deci is 10^-1
                tenP = allExponents(10d, -1d);
                unitNum = num1*tenP;
                break;
            case "centi":
                //Centi is 10^-2
                tenP = allExponents(10d, -2d);
                unitNum = num1*tenP;
                break;
            case "milli":
                //Milli is 10^-3
                tenP = allExponents(10d, -3d);
                unitNum = num1*tenP;
                break;
            case "micro":
                //Micro is 10^-6
                tenP = allExponents(10d, -6d);
                unitNum = num1*tenP;
                break;
            case "nano":
                //Nano is 10^-9
                tenP = allExponents(10d, -9d);
                unitNum = num1*tenP;
                break;
            case "pico":
                //Pico is 10^-12
                tenP = allExponents(10d, -12d);
                unitNum = num1*tenP;
                break;
            case "femto":
                //Femto is 10^-15
                tenP = allExponents(10d, -15d);
                unitNum = num1*tenP;
                break;
            case "atto":
                //Atto is 10^-18
                tenP = allExponents(10d, -18d);
                unitNum = num1*tenP;
                break;
            case "zepto":
                //Zepto is 10^-21
                tenP = allExponents(10d, -21d);
                unitNum = num1*tenP;
                break;
            case "yocto":
                //Yocto is 10^-24
                tenP = allExponents(10d, -24d);
                unitNum = num1*tenP;
                break;
        }

        //Next is a switch statement for all possible cases of the new unit. It takes
        //the number given by the first switch, unitNum, and converts it to the new unit
        //using math.
        switch(newU)
        { //Begin converting from base units (10^0) to new units.
            case "yotta":
                //Yotta is 10^24 units
                tenP = allExponents(10d, 24d);
                finalNum = unitNum/tenP;
                break;
            case "zeta":
                //Zeta is 10^21
                tenP = allExponents(10d, 21d);
                finalNum = unitNum/tenP;
                break;
            case "exa":
                //Exa is 10^18
                tenP = allExponents(10d, 18d);
                finalNum = unitNum/tenP;
                break;
            case "peta":
                //Peta is 10^15
                tenP = allExponents(10d, 15d);
                finalNum = unitNum/tenP;
                break;
            case "tera":
                //Tera is 10^12
                tenP = allExponents(10d, 12d);
                finalNum = unitNum/tenP;
                break;
            case "giga":
                //Giga is 10^9
                tenP = allExponents(10d, 9d);
                finalNum = unitNum/tenP;
                break;
            case "mega":
                //Mega is 10^6
                tenP = allExponents(10d, 6d);
                finalNum = unitNum/tenP;
                break;
            case "kilo":
                //Kilo is 10^3
                tenP = allExponents(10d, 3d);
                finalNum = unitNum;
                break;
            case "hecto":
                //Hecto is 10^2
                tenP = allExponents(10d, 2d);
                finalNum = unitNum/tenP;
                break;
            case "deka":
                //Deka is 10^1
                tenP = allExponents(10d, 1d);
                finalNum = unitNum/tenP;
                break;
            case "unit":
                //UNIT is the target, 10^0
                tenP = allExponents(10d, 0d);
                finalNum = unitNum/tenP;
                break;
            case "deci":
                //Deci is 10^-1
                tenP = allExponents(10d, -1d);
                finalNum = unitNum/tenP;
                break;
            case "centi":
                //Centi is 10^-2
                tenP = allExponents(10d, -2d);
                finalNum = unitNum/tenP;
                break;
            case "milli":
                //Milli is 10^-3
                tenP = allExponents(10d, -3d);
                finalNum = unitNum/tenP;
                break;
            case "micro":
                //Micro is 10^-6
                tenP = allExponents(10d, -6d);
                finalNum = unitNum/tenP;
                break;
            case "nano":
                //Nano is 10^-9
                tenP = allExponents(10d, -9d);
                finalNum = unitNum/tenP;
                break;
            case "pico":
                //Pico is 10^-12
                tenP = allExponents(10d, -12d);
                finalNum = unitNum/tenP;
                break;
            case "femto":
                //Femto is 10^-15
                tenP = allExponents(10d, -15d);
                finalNum = unitNum/tenP;
                break;
            case "atto":
                //Atto is 10^-18
                tenP = allExponents(10d, -18d);
                finalNum = unitNum/tenP;
                break;
            case "zepto":
                //Zepto is 10^-21
                tenP = allExponents(10d, -21d);
                finalNum = unitNum/tenP;
                break;
            case "yocto":
                //Yocto is 10^-24
                tenP = allExponents(10d, -24d);
                finalNum = unitNum/tenP;
                break;
        } //End converting from base units (10^0) to new units.

        //Finally, return the final number
        return finalNum;
    } //End metricConvert

    /**
     * Helping method which will allow an exponent to be either positive or negative, unlike the math pow() method.
     * Thanks to this page for the idea to do this, and for the skeleton code- http://stackoverflow.com/questions/4364634/calculate-the-power-of-any-exponent-negative-or-positive
     *
     * Marc Kuniansky
     * @param base must be a valid double
     * @param exponent must be a valid double
     * @return the resulting number
     */
    private double allExponents(double base, double exponent)
    { //Begin allExponents
        double b = base;
        double e = Math.abs(exponent);
        double finalNum;
        if (exponent > 0)
        {
            finalNum = Math.pow(b, e);
        }
        else if (exponent < 0)
        {
            double p = Math.pow(b, e);
            finalNum = 1/p;
        }
        else
        {
            finalNum = 1;
        }

        return finalNum;
    } //End allExponents


} //End converter class
