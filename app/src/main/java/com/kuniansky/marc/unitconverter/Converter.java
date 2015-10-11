package com.kuniansky.marc.unitconverter;
import java.math.*;

/*
 * Modifications:
 * 9/18/2015 by Marc Kuniansky, Created the class and implemented the lengthConvert method.
 * After the implementation of the lengthConvert, we stopped adding modification tags- because this was a copy/paste/edit job,
 * no major changes were made that we felt the need to document.
 *
 * 9/28-10/3 2015 by Marc Kuniansky, Changed all if/else statements to switch statements to simplify the code.
 *
 * 10/4/2015 by Marc Kuniansky changed the lengthConvert, tempConvert, massConvert, volumeConvert methods to use BigDecimal numbers instead of double to allow
 * larger numbers to be converted. Also refactored the metricConvert method to a new class, MetricConversion.
 */

/**
 * This class contains methods used for converting units of length, temperature, volume, mass, pressure, time,
 * force, speed, area, and metric.
 *
 * Created by Marc Kuniansky on September 17, 2015
 *
 * @author Marc Kuniansky and Noah Getz
 */
public class Converter { // Begin converter class

    //Constructor

    /**
     * Constructor with no parameters
     */
    public Converter() { //Begin constructor
        //There are no instance variables for the class, so this can be blank.
    } //End constructor

    /**
     * Takes a number, a length unit, and a new unit and converts the number to the new unit.
     * <p/>
     * Accepted units: inches, feet, yards, miles, millimeters, centimeters, meters, kilometers
     * Marc Kuniansky
     *
     * @param originalNum  must be a valid double.
     * @param originalUnit must be a string
     * @param newUnit  must be a string
     * @return the new BigDecimal
     */
    public BigDecimal lengthConvert(String originalNum, String originalUnit, String newUnit) {
        //Converting from a double to a BigDecimal can generate a small error with large numbers. To fix this, convert the
        //user-input double to a string first.
        //Make two variable doubles, one the original double and one the new one
        BigDecimal num1 = new BigDecimal(originalNum);
        BigDecimal num2 = new BigDecimal("0.0");

        //Make a BigDouble to hold the conversion factor for the conversion to be done.
        BigDecimal factor;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        MetricConversion metrics;
        //Now to the actual conversions
        switch (originalU) {
            case "inches": { //Begin converting from inches
                switch (newU) {
                    case "inches":
                        num2 = num1;
                        break;
                    case "feet":
                        //12 inches in a foot, so divide by 12
                        factor = new BigDecimal("12.0");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "yards":
                        //36 inches in a yard, so divide by 36
                        factor = new BigDecimal("36.0");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "miles":
                        //63,360 inches in a mile
                        factor = new BigDecimal("63360.0");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "millimeters":
                        //There are 25.4 millimeters in an inch, so multiply inches by 25.4
                        factor = new BigDecimal("25.4");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "centimeters":
                        //2.54cm in an inch, multiply inches by 2.54
                        factor = new BigDecimal("2.54");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "meters":
                        //0.0254 meters to an inch, so multiply inches by 0.0254
                        factor = new BigDecimal("0.0254");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers":
                        //0.0000254km in an inch
                        factor = new BigDecimal("0.0254");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                }
                break;
            } //End converting from inches

            //Next, converting from feet
            case "feet": { //Begin conversions from feet
                switch (newU) {
                    case "inches":
                        //12 inches in a foot, multiply by 12
                        factor = new BigDecimal("12.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "feet":
                        num2 = num1;
                        break;
                    case "yards":
                        //3 feet in a yard
                        factor = new BigDecimal("3.0");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "miles":
                        //5,280 feet in a mile
                        factor = new BigDecimal("5280.0");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "millimeters":
                        //304.8 millimeters in a foot
                        factor = new BigDecimal("304.8");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "centimeters":
                        //30.48 Centimeters in a foot
                        factor = new BigDecimal("30.48");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "meters":
                        //0.3048 meters in a foot
                        factor = new BigDecimal("0.3048");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers":
                        //0.0003048 kilometers in a meter
                        factor = new BigDecimal("0.0003048");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                }
                break;
            } //End conversions from feet

            //Next, conversions from yards
            case "yards": { //Begin conversions from yards
                switch (newU) {
                    case "inches":
                        //36 inches in a yard
                        factor = new BigDecimal("36.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "feet":
                        //3 feet to a yard
                        factor = new BigDecimal("3.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "yards":
                        num2 = num1;
                        break;
                    case "miles":
                        //1760 yards in a mile
                        factor = new BigDecimal("1760.0");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "millimeters":
                        //914.4 millimeters in a yard
                        factor = new BigDecimal("914.4");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "centimeters":
                        //91.44 centimeters in a yard
                        factor = new BigDecimal("91.44");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "meters":
                        factor = new BigDecimal("0.9144");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers":
                        //1,093.61 yards in a kilometer
                        factor = new BigDecimal("1093.61");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                }
                break;
            } //End conversions from yards

            //Next, convert from miles
            case "miles": { //Begin conversions from miles
                switch (newU) {
                    case "inches":
                        //6330 inches in a mile
                        factor = new BigDecimal("6330.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "feet":
                        //5280 feet in a mile
                        factor = new BigDecimal("5280.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "yards":
                        //1760 yards in a mile
                        factor = new BigDecimal("1760.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "miles":
                        //1 mile in a mile
                        num2 = num1;
                        break;
                    case "millimeters":
                        //1,609,000 millimeters in a mile
                        factor = new BigDecimal("1609340.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "centimeters":
                        //16,0934 centimeters in a miles
                        factor = new BigDecimal("160934.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "meters":
                        //1609.34 meters in a mile
                        factor = new BigDecimal("1609.34");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers":
                        //1.60934 kilometers in a mile
                        factor = new BigDecimal("1.60934");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                }
                break;
            } //End converting from miles

            //Next, convert from millimeters
            case "millimeters": { //Begin converting from millimeters
                switch (newU) {
                    case "inches":
                        factor = new BigDecimal("25.4");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "feet":
                        factor = new BigDecimal("304.8");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "yards":
                        factor = new BigDecimal("914.4");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "miles":
                        factor = new BigDecimal("1609000.0");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "millimeters":
                        num2 = num1;
                        break;
                    case "centimeters":
                        metrics = new MetricConversion(num1, "milli", "centi");
                        num2 = metrics.metricConvert();
                        break;
                    case "meters":
                        metrics = new MetricConversion(num1, "milli", "unit");
                        num2 = metrics.metricConvert();
                        break;
                    case "kilometers":
                        metrics = new MetricConversion(num1, "milli", "kilo");
                        num2 = metrics.metricConvert();
                        break;
                }
                break;
            } //End converting from millimeters

            //Next, convert from centimeters
            case "centimeters": { //Begin converting from centimeters
                switch (newU) {
                    case "inches":
                        factor = new BigDecimal("2.54");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "feet":
                        factor = new BigDecimal("30.48");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "yards":
                        factor = new BigDecimal("91.44");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "miles":
                        factor = new BigDecimal("160934.0");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "millimeters":
                        metrics = new MetricConversion(num1, "centi", "milli");
                        num2 = metrics.metricConvert();
                        break;
                    case "centimeters":
                        num2 = num1;
                        break;
                    case "meters":
                        metrics = new MetricConversion(num1, "centi", "unit");
                        num2 = metrics.metricConvert();
                        break;
                    case "kilometers":
                        metrics = new MetricConversion(num1, "centi", "kilo");
                        num2 = metrics.metricConvert();
                        break;
                }
                break;
            } //End converting from centimeters

            //Next, convert from meters
            case "meters": { //Begin converting from meters
                switch (newU) {
                    case "inches":
                        factor = new BigDecimal("39.3701d\"");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "feet":
                        factor = new BigDecimal("3.28084");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "yards":
                        factor = new BigDecimal("1.09361");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "miles":
                        factor = new BigDecimal("1609.34");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "millimeters":
                        metrics = new MetricConversion(num1, "unit", "milli");
                        num2 = metrics.metricConvert();
                        break;
                    case "centimeters":
                        metrics = new MetricConversion(num1, "unit", "centi");
                        num2 = metrics.metricConvert();
                        break;
                    case "meters":
                        num2 = num1;
                        break;
                    case "kilometers":
                        metrics = new MetricConversion(num1, "unit", "kilo");
                        num2 = metrics.metricConvert();
                        break;
                }
                break;
            } //End converting from meters

            //Finally, try converting from kilometers
            case "kilometers": { //Begin converting from kilometers
                switch (newU) {
                    case "inches":
                        factor = new BigDecimal("39370.1");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "feet":
                        factor = new BigDecimal("3280.84");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "yards":
                        factor = new BigDecimal("1093.61");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "miles":
                        factor = new BigDecimal("1.60934");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "millimeters":
                        metrics = new MetricConversion(num1, "kilo", "milli");
                        num2 = metrics.metricConvert();
                        break;
                    case "centimeters":
                        metrics = new MetricConversion(num1, "kilo", "centi");
                        num2 = metrics.metricConvert();
                        break;
                    case "meters":
                        metrics = new MetricConversion(num1, "kilo", "unit");
                        num2 = metrics.metricConvert();
                        break;
                    case "kilometers":
                        num2 = num1;
                        break;
                }
                break;
            } //End converting from kilometers
        }
        //num2 is the number we want; return it
        return num2;
    } // End lengthConvert

    /**
     * Takes a number, a temperature unit, and a new unit and converts the number to the new unit.
     * <p/>
     * Accepted units: Fahrenheit, Kelvin, Celsius
     * Noah Getz
     *
     * @param originalNum  must be a valid double.
     * @param originalUnit must be a string
     * @param newUnit  must be a string
     * @return the new BigDecimal
     */
    public BigDecimal tempConvert(String originalNum, String originalUnit, String newUnit)
    { //Begin tempConvert
        //Converting from a double to a BigDecimal can cause errors in large numbers. So do it from a string instead.
        BigDecimal num1 = new BigDecimal(originalNum);
        //Make two variable doubles, one the original double and one the new one
        BigDecimal num2 = new BigDecimal("0.0");
        BigDecimal num3;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String original = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        //BigDecimal math requires big decimal values to work properly. I know all the values I will need; they are made into BigDecimals below
        BigDecimal nine = new BigDecimal("9.0");
        BigDecimal five = new BigDecimal("5.0");
        BigDecimal thirtyTwo = new BigDecimal("32.0");
        BigDecimal twoSeventyThree = new BigDecimal("273.15");

        switch(original)
        { //Begin conversion table
            case "celsius":
            { //Begin converting from Celsius
                switch(newU)
                {
                    case "celsius":
                        //1 Degree C in 1 degree C
                        num2 = num1;
                        break;
                    case "fahrenheit":
                        //Conversion from C to F: (C*9/5)+32
                        //Divide 9/5
                        num3 = nine.divide(five, 200, RoundingMode.HALF_EVEN);
                        BigDecimal num4 = num3.multiply(num1);
                        num2 = num4.add(thirtyTwo);
                        break;
                    case "kelvin":
                        //Add 273.15+C to convert from C to K
                        num2 = num1.add(twoSeventyThree);
                        break;
                }
                break;
            } //End converting from Celsius
            case "fahrenheit":
            { //Begin converting from Fahrenheit
                switch(newU)
                { //Begin converting from Fahrenheit
                    case "celsius":
                        //Conversion from F to C: (F-32)*5/9
                        num3 = num1.subtract(thirtyTwo);
                        num2 = num3.multiply(five.divide(nine, 200, RoundingMode.HALF_EVEN));
                        break;
                    case "fahrenheit":
                        //1 degree F in 1 degree F
                        num2 = num1;
                        break;
                    case "kelvin":
                        //First, convert to Celsius as normal. then, convert to Kelvin.
                        //Subtract 32 from F
                        num3 = num1.subtract(thirtyTwo);

                        //Multiply F by 5/9
                        BigDecimal num4 = num3.multiply(five.divide(nine, 200, RoundingMode.HALF_EVEN));
                        num2 = num4.add(twoSeventyThree);
                        break;
                } //End converting from Fahrenheit
                break;
            } //End converting from Fahrenheit
            case "kelvin":
            { //Begin converting from Kelvin
                switch(newU)
                {
                    case "celsius":
                        //Subtract 273.15 from K to convert to C
                        num2 = num1.subtract(twoSeventyThree);
                        break;
                    case "fahrenheit":
                        //First convert to Celsius
                        num3 = num1.subtract(twoSeventyThree);
                        //Multiply C by 9/5
                        BigDecimal num4 = num3.multiply(nine.divide(five, 200, RoundingMode.HALF_EVEN));
                        //Add 32
                        num2 = num4.add(thirtyTwo);
                        break;
                    case "kelvin":
                        //1K in 1K
                        num2 = num1;
                        break;
                }
                break;
            }//End converting from Kelvin
        } //End conversion table

        //Return the final number, num2
        return num2;
    } //End tempConvert

    /**
         Takes a number, a volume unit, and a new unit and converts the number to the new unit.
         *
         * Accepted units: Milliliter, liter, kiloliter, pint, quart, gallon, cup.
         *
         * Noah Getz
         * @param originalNum must be a valid double.
         * @param originalUnit must be a string
         * @param newUnit must be a string
         * @return the new BigDecimal
         */
    public BigDecimal volumeConvert(String originalNum, String originalUnit, String newUnit) { //Begin volumeConvert

        //Make two variable doubles, one the original double and one the new one
        BigDecimal num1 = new BigDecimal(originalNum);
        BigDecimal num2 = new BigDecimal("0.0");
        BigDecimal factor;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        //Instantiate the MetricConversion class, as there are some metric conversions here
        MetricConversion metric;

        switch (originalU)
        { //Begin conversion table
            case "milliliters":
                switch (newU)
                { //Begin converting from milliliters
                    case "milliliters":
                        //One milliliter in a milliliter
                        num2 = num1;
                        break;
                    case "liters":
                        //1000 milliliters in a liter, use the MetricConversion class
                        metric = new MetricConversion(originalNum, "milli", "unit");
                        num2 = metric.metricConvert();
                        break;
                    case "kiloliters":
                        //Use the MetricConversion class to convert milliliters to kiloliters
                        metric = new MetricConversion(originalNum, "milli", "kilo");
                        num2 = metric.metricConvert();
                        break;
                    case "pints":
                        //There are 473.176473 mL in a pint
                        factor = new BigDecimal("473.176473");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "quarts":
                        //There are 946.352946 mL in a quart
                        factor = new BigDecimal("946.352946");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "gallons":
                        //There are 3785.41178 mL in a gallon
                        factor = new BigDecimal("3785.41178");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "cups":
                        //There are 236.588237 mL in a cup
                        factor = new BigDecimal("236.588237");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from milliliters
                break;

            case "liters":
                switch (newU)
                { //Begin converting from liters
                    case "milliliters":
                        //Use the MetricConversion class
                        metric = new MetricConversion(originalNum, "unit", "milli");
                        num2 = metric.metricConvert();
                        break;
                    case "liters":
                        //1 liter in a liter
                        num2 = num1;
                        break;
                    case "kiloliters":
                        //Use the MetricConversion class
                        metric = new MetricConversion(originalNum, "unit", "kilo");
                        num2 = metric.metricConvert();
                        break;
                    case "pints":
                        //There are 2.11337642 pints in a liter
                        factor = new BigDecimal("2.11337642");
                        num2 = num1.multiply(factor);
                        break;
                    case "quarts":
                        //There are 1.05668821 quarts in a liter
                        factor = new BigDecimal("1.05668821");
                        num2 = num1.multiply(factor);
                        break;
                    case "gallons":
                        //There are 3.7854118 liters in a gallon
                        factor = new BigDecimal("3.7854118");
                        num2 = num1.multiply(factor);
                        break;
                    case "cups":
                        //There are 4.2267528377 cups in a liter
                        factor = new BigDecimal("4.2267528377");
                        num2 = num1.multiply(factor);
                        break;
                } //End converting from liters
                break;

            case "kiloliters":
                switch (newU)
                { //Begin converting from Kiloliters
                    case "milliliters":
                        //Use the MetricConvert class
                        metric = new MetricConversion(originalNum, "kilo", "milli");
                        num2 = metric.metricConvert();
                        break;
                    case "liters":
                        //Use the MetricConvert class
                        metric = new MetricConversion(originalNum, "kilo", "unit");
                        num2 = metric.metricConvert();
                        break;
                    case "kiloliters":
                        //1 Kiloliter in a liter
                        num2 = num1;
                        break;
                    case "pints":
                        //There are 2113.374999944256615 pints in a kiloliter
                        factor = new BigDecimal("2113.374999944256615");
                        num2 = num1.multiply(factor);
                        break;
                    case "quarts":
                        //There are 1056.6874999721280801 quarts in a kiloliter
                        factor = new BigDecimal("1056.6874999721280801");
                        num2 = num1.multiply(factor);
                        break;
                    case "gallons":
                        //There are 264.171874993032 gallons in a kiloliter.
                        factor = new BigDecimal("264.171874993032");
                        num2 = num1.multiply(factor);
                        break;
                    case "cups":
                        //There are 4226.75 cups in a kiloliter
                        factor = new BigDecimal("4226.75");
                        num2 = num1.multiply(factor);
                        break;
                } //End converting from Kiloliters
                break;

            case "pints":
                switch (newU)
                { //Begin converting from pints
                    case "milliliter":
                        //There are 473.176473 milliliters in a pint.
                        factor = new BigDecimal("473.176473");
                        num2 = num1.multiply(factor);
                        break;
                    case "liters":
                        //There are 2.11337642 pints in a liter
                        factor = new BigDecimal("2.11337642");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "kiloliters":
                        //There are 1056.6874999721283075 pints in a kiloliter
                        factor = new BigDecimal("1056.6874999721283075");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "pints":
                        //There is one pint in a pint
                        num2 = num1;
                        break;
                    case "quarts":
                        //There are 2 pints in a quart
                        factor = new BigDecimal("2.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "gallons":
                        //There are 8 pints in a gallon
                        factor = new BigDecimal("8.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "cups":
                        //There are 2 cups in a pint
                        factor = new BigDecimal("2.0");
                        num2 = num1.multiply(factor);
                        break;
                } //End converting from pints
                break;

            case "quarts":
                switch (newU)
                { //Begin converting from quarts
                    case "milliliters":
                        //There are 946.352946 milliliters in a quart
                        factor = new BigDecimal("946.352946");
                        num2 = num1.multiply(factor);
                        break;
                    case "liters":
                        //There are 1.05668821 quarts in a liter
                        factor = new BigDecimal("1.05668821");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "kiloliters":
                        //There are 1056.6874999721280801 quarts in a kiloliter
                        factor = new BigDecimal("1056.6874999721280801");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "pints":
                        //There are 2 pints in a quart
                        factor = new BigDecimal("2.0");
                        num2 = num1.multiply(factor);
                        break;
                    case "quarts":
                        //There is one quart in a quart
                        num2 = num1;
                        break;
                    case "gallons":
                        //There are 4 quarts in a gallon
                        factor = new BigDecimal("4.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "cups":
                        //There are 4 cups in a quart
                        factor = new BigDecimal("4.0");
                        num2 = num1.multiply(factor);
                        break;
                } //End converting from quarts;
                break;

            case "gallons":
                switch (newU)
                { //Begin converting from gallons
                    case "milliliters":
                        //There are 3785.41178 mL in a gallon
                        factor = new BigDecimal("3785.41178");
                        num2 = num1.multiply(factor);
                        break;
                    case "liters":
                        //There are 3.7854118 liters in a gallon
                        factor = new BigDecimal("3.7854118");
                        num2 = num1.multiply(factor);
                        break;
                    case "kiloliters":
                        //There are 264.171874993032 gallons in a kiloliter.
                        factor = new BigDecimal("264.171874993032");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "pints":
                        //There are 8 pints in a gallon
                        factor = new BigDecimal("8.0");
                        num2 = num1.multiply(factor);
                        break;
                    case "quarts":
                        //There are 4 quarts in a gallon
                        factor = new BigDecimal("4.0");
                        num2 = num1.multiply(factor);
                        break;
                    case "gallons":
                        //There is one gallon in a gallon
                        num2 = num1;
                        break;
                    case "cups":
                        //There are 16 cups in a gallon
                        factor = new BigDecimal("16.0");
                        num2 = num1.multiply(factor);
                        break;
                } //end converting from gallons
                break;

            case "cups":
                switch (newU)
                { //Begin converting from cups
                    case "milliliters":
                        //There are 236.588237 mL in a cup
                        factor = new BigDecimal("236.588237");
                        num2 = num1.multiply(factor);
                        break;
                    case "liters":
                        //There are 4.2267528377 cups in a liter
                        factor = new BigDecimal("4.2267528377");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "kiloliters":
                        //There are 4226.75 cups in a kiloliter
                        factor = new BigDecimal("4226.75");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "pints":
                        //There are 2 cups in a pint
                        factor = new BigDecimal("2.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "quarts":
                        //There are 4 cups in a quart
                        factor = new BigDecimal("4.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "gallons":
                        //There are 16 cups in a gallon
                        factor = new BigDecimal("16.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "cups":
                        //There is one cup in a cup
                        num2 = num1;
                        break;
                } //End converting from cups
                break;
        } //End conversion table

        //Return the final number, num2
        return num2;
    } //End volume convert

    /**
     * Takes a number, a mass unit, and a new unit and converts the number to the new unit.
     * <p/>
     * Accepted units: pounds, kilograms, grams, milligrams
     * Noah Getz
     *
     * @param originalNum  must be a valid double.
     * @param originalUnit must be a string
     * @param newUnit  must be a string
     * @return the new BigDecimal
     */
    public BigDecimal massConvert(String originalNum, String originalUnit, String newUnit)
    { //Begin massConvert

        //Make two variable doubles, one the original double and one the new one
        BigDecimal num1 = new BigDecimal(originalNum);
        BigDecimal num2 = new BigDecimal("0.0");

        //Make a BigDouble to hold the conversion factor for the conversion to be done.
        BigDecimal factor;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        MetricConversion metrics;

        switch (originalU)
        { //Begin conversion table
            case "pounds":
                switch (newU)
                { //Begin converting from pounds
                    case "pounds":
                        //there is 1 pound in a pound
                        num2 = num1;
                        break;
                    case "kilograms":
                        //There are 2.20462262 pounds in a kilogram
                        factor = new BigDecimal("2.20462262");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "grams":
                        //There are 453.59237 grams in a pound
                        factor = new BigDecimal("453.59237");
                        num2 = num2.multiply(factor);
                        break;
                    case "milligrams":
                        //There are 453592 milligrams in a pound
                        factor = new BigDecimal("453592");
                        num2 = num2.multiply(factor);
                        break;
                } //End converting from pounds
                break;
            case "kilograms":
                switch (newU)
                { //Begin converting from kilograms
                    case "pounds":
                        //There are 2.20462262 pounds in a kilogram
                        factor = new BigDecimal("2.20462262");
                        num2 = num2.multiply(factor);
                        break;
                    case "kilograms":
                        //There is 1 kilogram in a kilogram
                        num2 = num1;
                        break;
                    case "grams":
                        //Use MetricConversion class
                        metrics = new MetricConversion(num1, "kilo", "unit");
                        num2 = metrics.metricConvert();
                        break;
                    case "milligrams":
                        //Use MetricConversion class
                        metrics = new MetricConversion(num1, "kilo", "milli");
                        num2 = metrics.metricConvert();
                        break;
                } //End converting from kilograms
                break;
            case "grams":
                switch (newU)
                { //End converting from grams
                    case "pounds":
                        //There are 453.59237 grams in a pound
                        factor = new BigDecimal("453.59237");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "kilograms":
                        //Use MetricConversion class
                        metrics = new MetricConversion(num1, "unit", "kilo");
                        num2 = metrics.metricConvert();
                        break;
                    case "grams":
                        //There is 1 gram in a gram
                        num2 = num1;
                        break;
                    case "milligrams":
                        //Use MetricConversion class
                        metrics = new MetricConversion(num1, "unit", "milli");
                        num2 = metrics.metricConvert();
                        break;
                } //End converting from grams
                break;
            case "milligrams":
                switch (newU)
                { //Begin converting from milliliters
                    case "pounds":
                        //There are 453592 milligrams in a pound
                        factor = new BigDecimal("453592");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "kilograms":
                        //Use MetricConversion class
                        metrics = new MetricConversion(num1, "milli", "kilo");
                        num2 = metrics.metricConvert();
                        break;
                    case "grams":
                        //Use MetricConversion class
                        metrics = new MetricConversion(num1, "milli", "unit");
                        num2 = metrics.metricConvert();
                        break;
                    case "milligrams":
                        //There is 1 milligram in a milligram
                        num2 = num1;
                        break;
                } //End converting from milliliters
                break;
        } //End conversion table

        //Return the final number
        return num2;
    } //End massConvert

    /**
     * Takes a number, a pressure unit, and a new unit and converts the number to the new unit.
     * <p/>
     * Accepted units: torr, atm, mmHg, barr
     * Noah Getz
     *
     * @param originalNum  must be a valid double.
     * @param originalUnit must be a string
     * @param newUnit  must be a string
     * @return the new BigDecimal
     */
    public BigDecimal pressureConvert(String originalNum, String originalUnit, String newUnit) {

        //Make two variable doubles, one the original double and one the new one
        BigDecimal num1 = new BigDecimal(originalNum);
        BigDecimal num2 = new BigDecimal("0.0");

        //Make a BigDouble to hold the conversion factor for the conversion to be done.
        BigDecimal factor;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();


        //Instantiate the metric converter
        MetricConversion metrics;

        //Begin the conversions
        switch(originalU)
        { //Begin conversion table
            case "torr":
                switch(newU)
                { //Begin converting from torr
                    case "torr":
                        //One torr in a torr
                        num2 = num1;
                        break;
                    case "atm":
                        //There are 760 torr in one atm
                        factor = new BigDecimal("760");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "bar":
                        //There are 750.061683 torr in one bar
                        factor = new BigDecimal("750.061683");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "pascal":
                        //There are 133.322368 pascals in one torr
                        factor = new BigDecimal("133.322368");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "kilopascal":
                        //There are 7.50061683 torr in a kilopascal
                        factor = new BigDecimal("7.50061683");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "megapascal":
                        //There are 7500.61683 torr in on MPa
                        factor = new BigDecimal("7500.61683");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from torr
                break;
            case "atm":
                switch(newU)
                { //Begin converting from atm
                    case "torr":
                        //760 Torr in 1 atm
                        factor = new BigDecimal("760");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "atm":
                        //One atm in one atm
                        num2 = num1;
                        break;
                    case "bar":
                        //There are 1.01325 bar in one atm
                        factor = new BigDecimal("1.01325");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "pascal":
                        //There are 101325 pascals in one atm
                        factor = new BigDecimal("101325");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "kilopascal":
                        //There are 101.325 kPa in one atm
                        factor = new BigDecimal("101.325");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "megapascal":
                        //There are 9.869232667 atm in one MPa
                        factor = new BigDecimal("9.869232667");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from atm
                break;
            case "bar":
                switch(newU)
                { //Begin converting from bar
                    case "torr":
                        //There are 750.061682704 torr in one bar
                        factor = new BigDecimal("750.061682704");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "atm":
                        //There are 1.01325 bar in one atm
                        factor = new BigDecimal("1.01325");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "bar":
                        //One bar in one bar
                        num2 = num1;
                        break;
                    case "pascal":
                        //There are 100000 pascals in 1 bar
                        factor = new BigDecimal("100000");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "kilopascal":
                        //There are 100 kPa in 1 bar
                        factor = new BigDecimal("100");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "megapascal":
                        //There are 10 bar in one MPa
                        factor = new BigDecimal("10");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from bar
                break;
            case "pascal":
                switch(newU)
                { //Begin converting from pascals
                    case "torr":
                        //There are 133.322368 pascals in one torr
                        factor = new BigDecimal("133.322368");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "atm":
                        //There are 101325 pascals in one atm
                        factor = new BigDecimal("101325");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "bar":
                        //There are 100000 pascals in 1 bar
                        factor = new BigDecimal("100000");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "pascal":
                        //One pascal in one pascal
                        num2 = num1;
                        break;
                    case "kilopascal":
                        //Use the MetricConversion class
                        metrics = new MetricConversion(num1, "unit", "kilo");
                        num2 = metrics.metricConvert();
                        break;
                    case "megapascal":
                        //Use the MetricConversion class
                        metrics = new MetricConversion(num1, "unit", "mega");
                        num2 = metrics.metricConvert();
                        break;
                } //End converting from pascals
                break;
            case "kilopascal":
                switch(newU)
                { //Begin converting from kilopascals
                    case "torr":
                        //There are 7.50061683 torr in a kilopascal
                        factor = new BigDecimal("7.50061683");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "atm":
                        //There are 101.325 kPa in one atm
                        factor = new BigDecimal("101.325");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "bar":
                        //There are 100 kPa in 1 bar
                        factor = new BigDecimal("100");
                        num2 = num1.divide(factor, 10, RoundingMode.HALF_EVEN);
                        break;
                    case "pascal":
                        //Use the MetricConversion class
                        metrics = new MetricConversion(num1, "kilo", "unit");
                        num2 = metrics.metricConvert();
                        break;
                    case "kilopascal":
                        //One kilopascal in one kilopascal
                        num2 = num1;
                        break;
                    case "megapascal":
                        //Use the MetricConversion class
                        metrics = new MetricConversion(num1, "kilo", "mega");
                        num2 = metrics.metricConvert();
                        break;
                } //End converting from kilopascals
                break;
            case "megapascal":
                switch(newU)
                { //Begin converting from megapascals
                    case "torr":
                        //There are 7500.61683 toor in one megapascal
                        factor = new BigDecimal("7500.61683");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "atm":
                        //There are 9.869232667 atm in one MPa
                        factor = new BigDecimal("9.869232667");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "bar":
                        //There are 10 bar in one MPa
                        factor = new BigDecimal("10");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "pascal":
                        //Use the MetricConversion class
                        metrics = new MetricConversion(num1, "mega", "unit");
                        num2 = metrics.metricConvert();
                        break;
                    case "kilopascal":
                        //Use the MetricConversion class
                        metrics = new MetricConversion(num1, "mega", "kilo");
                        num2 = metrics.metricConvert();
                        break;
                    case "megapascal":
                        //One megapascal in one megapascal
                        num2 = num1;
                        break;
                } //End converting from megapascals
                break;
        } //End conversion table

        //Return the result
        return num2;
    } //End pressureConvert

    /**
     * Converts a number from one unit of time to another
     * <p/>
     * Units of time supported: seconds, minutes, hours, days, weeks, months, years
     * <p/>
     * Marc Kuniansky
     *
     * @param originalNum must be a valid double
     * @param originalUnit must be a valid String matching one of the supported units
     * @param newUnit  must be a valid String matching one of the supported units
     * @return a BigDecimal, the converted number
     */
    public BigDecimal timeConvert(String originalNum, String originalUnit, String newUnit) { //Begin convertTime

        //Make two variable doubles, one the original double and one the new one
        BigDecimal num1 = new BigDecimal(originalNum);
        BigDecimal num2 = new BigDecimal("0.0");

        //Make a BigDouble to hold the conversion factor for the conversion to be done.
        BigDecimal factor;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        //Convert from seconds
        switch (originalU)
        { //Begin conversion chart
            case "seconds":
                switch (newU)
                { //Begin converting from seconds
                    case "seconds":
                        num2 = num1;
                        break;
                    case "minutes":
                        //There are 60 sconds in a minute
                        factor = new BigDecimal("60.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "hours":
                        //There are 3600 seconds in an hour
                        factor = new BigDecimal("3600.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "days":
                        //There are 86400 seconds in a day
                        factor = new BigDecimal("86400");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "weeks":
                        //There are 604800 seconds in a week
                        factor = new BigDecimal("604800");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "months":
                        //there are 2592000 seconds in a month
                        factor = new BigDecimal("2592000");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "years":
                        //There are 31556952 seconds in a year
                        factor = new BigDecimal("31556952");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from seconds
                break;

            case "minutes":
                switch (newU)
                { //Begin converting from minutes
                    case "minutes":
                        num2 = num1;
                        break;
                    case "seconds":
                        //There are 60 seconds in a minute
                        factor = new BigDecimal("60");
                        num2 = num2.multiply(factor);
                        break;
                    case "hours":
                        //There are 60 minutes in an hour
                        factor = new BigDecimal("60");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "days":
                        //There are 1440 hours in a day
                        factor = new BigDecimal("1440");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "weeks":
                        //There are 10080 hours in a week
                        factor = new BigDecimal("10080");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "months":
                        //There are 43829 hours in a month
                        factor = new BigDecimal("43829");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "years":
                        //There are 52949 minutes in a year
                        factor = new BigDecimal("52949");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                } //End converting from minutes
                break;

            case "hours":
                switch (newU)
                { //Begin converting from hours
                    case "hours":
                        num2 = num1;
                        break;
                    case "seconds":
                        //There are 3600 seconds in an hour
                        factor = new BigDecimal("3600");
                        num2 = num2.multiply(factor);
                        break;
                    case "minutes":
                        //There are 60 minutes in an hour
                        factor = new BigDecimal("60");
                        num2 = num2.multiply(factor);
                        break;
                    case "days":
                        //There are 24 hours in a day
                        factor = new BigDecimal("24");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "weeks":
                        //There are 168 hours in a week
                        factor = new BigDecimal("168");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "months":
                        //There are 730.484 hours in a month
                        factor = new BigDecimal("730.484");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "years":
                        //There are 8765.81 hours in a year
                        factor = new BigDecimal("8765.81");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from hours
                break;

            case "days":
                //Convert from days
                switch (newU)
                { //Begin converting from days
                    case "days":
                        num2 = num1;
                        break;
                    case "seconds":
                        //There are 86400 seconds in a day
                        factor = new BigDecimal("86400");
                        num2 = num2.multiply(factor);
                        break;
                    case "minutes":
                        //There are 1440 minutes in a day
                        factor = new BigDecimal("1440");
                        num2 = num2.multiply(factor);
                        break;
                    case "hours":
                        //There are 24 hours in a day
                        factor = new BigDecimal("24");
                        num2 = num2.multiply(factor);
                        break;
                    case "weeks":
                        //There are 7 days in a week
                        factor = new BigDecimal("7");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "months":
                        //There are 30.4638 days in a month
                        factor = new BigDecimal("30.4638");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "years":
                        //There are 365.242 days in a year
                        factor = new BigDecimal("365.242");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from days
                break;

            case "weeks":
                switch (newU)
                { //Begin converting from weeks
                    case "weeks":
                        num2 = num1;
                        break;
                    case "seconds":
                        //there are 604800
                        factor = new BigDecimal("604800");
                        num2 = num2.multiply(factor);
                        break;
                    case "minutes":
                        //There are 10080 minutes in a week
                        factor = new BigDecimal("10080");
                        num2 = num2.multiply(factor);
                        break;
                    case "hours":
                        //There are 168 hours in a week
                        factor = new BigDecimal("168");
                        num2 = num2.multiply(factor);
                        break;
                    case "days":
                        //There are 7 days in a week
                        factor = new BigDecimal("7");
                        num2 = num2.multiply(factor);
                        break;
                    case "months":
                        //There are 4.34812 weeks in a month
                        factor = new BigDecimal("4.34812");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "years":
                        //There are 52.1775 weeks in a year
                        factor = new BigDecimal("52.1775");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from weeks
                break;

            case "months":
                switch (newU)
                { //Begin converting from months
                    case "months":
                        num2 = num1;
                        break;
                    case "seconds":
                        //There are 2630000.0 seconds in a month
                        factor = new BigDecimal("2630000.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "minutes":
                        //There are 43829.1 minutes in a month
                        factor = new BigDecimal("43829.1");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "hours":
                        //There are 730.484 hours in a month
                        factor = new BigDecimal("730.484");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "days":
                        //There are 30.4368 days in a month
                        factor = new BigDecimal("30.4368");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "weeks":
                        //There are 4.34812 weeks in a month
                        factor = new BigDecimal("4.34812");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "years":
                        //There are 12 months in a year
                        factor = new BigDecimal("12");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from months
                break;

            case "years":
                switch (newU)
                { //Begin converting from years
                    case "years":
                        num2 = num1;
                        break;
                    case "seconds":
                        //There are 31560000 seconds in a year
                        factor = new BigDecimal("31560000");
                        num2 = num2.multiply(factor);
                        break;
                    case "minutes":
                        //There are 525949.0 minutes in a year
                        factor = new BigDecimal("525949.0");
                        num2 = num2.multiply(factor);
                        break;
                    case "hours":
                        //There are 8765.81 hours in a year
                        factor = new BigDecimal("8765.81");
                        num2 = num2.multiply(factor);
                        break;
                    case "days":
                        //There are 365.242 days in a year
                        factor = new BigDecimal("365.242");
                        num2 = num2.multiply(factor);
                        break;
                    case "weeks":
                        //There are 52.1775 weeks in a year
                        factor = new BigDecimal("52.1775");
                        num2 = num2.multiply(factor);
                        break;
                    case "months":
                        //There are 12 months in a year
                        factor = new BigDecimal("12");
                        num2 = num2.multiply(factor);
                        break;
                } //End converting from year
        }

        //Return the result
        return num2;
    } //End convertTime

    /**
     * Converts a number from one unit of force to another.
     * <p/>
     * Units accepted: Newtons, pound force
     * <p/>
     * Marc Kuniansky
     *
     * @param originalNum must be a valid double
     * @param originalUnit   must be a valid String matching one of the supported units
     * @param newUnit        must be a valid String matching one of the supported units
     * @return a BigDecimal, the converted unit.
     */
    public BigDecimal forceConvert(String originalNum, String originalUnit, String newUnit) { //Begin convertForce

        //Make two variable doubles, one the original double and one the new one
        BigDecimal num1 = new BigDecimal(originalNum);
        BigDecimal num2 = new BigDecimal("0.0");

        //Make a BigDouble to hold the conversion factor for the conversion to be done.
        BigDecimal factor;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        //The series of switch statements below figures out what unit to convert from/to, and does so.
        switch (originalU)
        { //Begin conversion table
            case "pound force":
                switch (newU)
                { //Begin converting from pound force
                    case "pound force":
                        //There is 1 pound force in a pound force
                        num2 = num1;
                        break;
                    case "newtons":
                        //There are 4.448222 newtons in a pound force
                        factor = new BigDecimal("4.448222");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from pound force
                break;
            case "newtons":
                switch (newU)
                { //Begin converting from newtons
                    case "newtons":
                        //There is one newton in a newton
                        num2 = num1;
                        break;
                    case "pound force":
                        //There are 4.448222 newtons in a pound force
                        factor = new BigDecimal("4.448222");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from newtons
        } //End conversion table

        //Return the result
        return num2;
    } //End convertForce

    /**
     * Converts a number from one unit of speed to another
     * <p/>
     * Recognized speed units: miles per hour, feet per second, meters per second,
     * kilometers per second, kilometers per hour.
     * <p/>
     * Marc Kuniansky
     *
     * @param originalNum must be a valid double
     * @param originalUnit must be a valid String recognized by the method
     * @param newUnit must be a valid String recognized by the method
     * @return BigDecimal, the converted unit.
     **/
    public BigDecimal speedConvert(String originalNum, String originalUnit, String newUnit) { //Begin convertSpeed

        //Make two variable doubles, one the original double and one the new one
        BigDecimal num1 = new BigDecimal(originalNum);
        BigDecimal num2 = new BigDecimal("0.0");

        //Make a BigDouble to hold the conversion factor for the conversion to be done.
        BigDecimal factor;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        switch (originalU) { //Begin conversion table
            case "miles per hour":
                switch (newU)
                { //Begin converting from miles per hour
                    case "miles per hour":
                        //One mile per hour in a mile per hour
                        num2 = num1;
                        break;
                    case "feet per second":
                        //1.4667 fps in 1 mph
                        factor = new BigDecimal("1.4667");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers per second":
                        //2236.94 mph per kps
                        factor = new BigDecimal("2236.94");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers per hour":
                        //1.60934 kph per mph
                        factor = new BigDecimal("1.60934");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "meters per second":
                        //2.23694 mph per meter per second
                        factor = new BigDecimal("2.23694");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from miles per hour
                break;
            case "feet per second":
                switch (newU)
                { //Begin converting from feet per second
                    case "miles per hour":
                        //1.4667 fps per mph
                        factor = new BigDecimal("1.4667");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "feet per second":
                        //1 fps in 1 fps
                        num2 = num1;
                        break;
                    case "kilometers per second":
                        //3280.84 fps per kps
                        factor = new BigDecimal("3280.84");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers per hour":
                        //1.09728 kph per fps
                        factor = new BigDecimal("1.09728");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "meters per second":
                        //3.28084 fps per mps
                        factor = new BigDecimal("3.28084");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from feet per second
                break;
            case "kilometers per second":
                switch (newU)
                { //Begin converting from kilometers per second
                    case "miles per hour":
                        //2236.94 mph per kps
                        factor = new BigDecimal("2236.94");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "feet per second":
                        //3280.84 fps per kps
                        factor = new BigDecimal("3280.84");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers per second":
                        //1 kps in 1 kps
                        num2 = num1;
                        break;
                    case "kilometers per hour":
                        //3600 kph per kps
                        factor = new BigDecimal("3600");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "meters per second":
                        ///1000 mps per kmps
                        factor = new BigDecimal("1000");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from kilometers per second
                break;
            case "kilometers per hour":
                switch (newU)
                { //Begin converting from kilometers per hour
                    case "miles per hour":
                        //1.60934 kph per mph
                        factor = new BigDecimal("1.60934");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "feet per second":
                        //1.09728 kph per fps
                        factor = new BigDecimal("1.09728");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers per second":
                        //3600 kph per kps
                        factor = new BigDecimal("3600");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers per hour":
                        //1 kph in 1 kph
                        num2 = num1;
                        break;
                    case "meters per second":
                        //3.6 kph per mph
                        factor = new BigDecimal("3.6");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //end converting from kilometers per hour
                break;
            case "meters per second":
                switch (newU)
                { //Begin converting from meters per second
                    case "miles per hour":
                        //2.23694 mph per meter per second:
                        factor = new BigDecimal("2.23694");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "feet per second":
                        //3.28084 fps per mps
                        factor = new BigDecimal("3.28084");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers per second":
                        ///1000 mps per kmps
                        factor = new BigDecimal("1000");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "kilometers per hour":
                        //3.6 kph per mph
                        factor = new BigDecimal("3.6");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "meters per second":
                        //1 mps in 1 mps
                        num2 = num1;
                        break;
                } //End converting from meters per second
                break;
        } //End conversion table

        //Return the result
        return num2;
    } //End convertSpeed

    /**
     * Converts a number from one unit of speed to another.
     * <p/>
     * Accepted units: square inches, square feet, square yards, square miles, square meters, square kilometers, acres
     * <p/>
     * Marc Kuniansky
     *
     * @param originalNum must be a valid double
     * @param originalUnit must be a valid String matching one of the supported units
     * @param newUnit must be a valid String matching one of the supported units
     * @return a BigDecimal, the converted unit.
     **/
    public BigDecimal areaConvert(String originalNum, String originalUnit, String newUnit) { //Begin areaConvert

        //Make two variable doubles, one the original double and one the new one
        BigDecimal num1 = new BigDecimal(originalNum);
        BigDecimal num2 = new BigDecimal("0.0");

        //Make a BigDouble to hold the conversion factor for the conversion to be done.
        BigDecimal factor;

        //Store the units into new strings. I find this to be safer, as I can't override the originals this way.
        //Also convert them to lower case
        String originalU = originalUnit.toLowerCase();
        String newU = newUnit.toLowerCase();

        switch (originalU) {
            //Begin unit conversions
            case "square inches":
                switch (newU) { //Begin converting from square inches
                    case "square inches":
                        //One square inch in a square inch
                        num2 = num1;
                        break;
                    case "square feet":
                        //There are 144 square inches in a square foot
                        factor = new BigDecimal("144.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square yards":
                        //There are 1296.0 square inches in a square yard
                        factor = new BigDecimal("1296.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square miles":
                        //There are 4014000000.0 square inches in a square mile
                        factor = new BigDecimal("4014000000.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "acres":
                        //There are 6273000.0 square inches in an acre
                        factor = new BigDecimal("6273000.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square kilometers":
                        //There are 1550000000.0 square inches in a square kilometer
                        factor = new BigDecimal("1550000000.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square meters":
                        //There are 1550.0 square inches in a square meter
                        factor = new BigDecimal("1550.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from square inches
                break;
            case "square feet":
                switch (newU) { //Begin converting from square feet
                    case "square inches":
                        //There are 144.0 square inches in a square foot
                        factor = new BigDecimal("144.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square feet":
                        num2 = num1;
                        break;
                    case "square yards":
                        //There are 9 square feet in a square yard
                        factor = new BigDecimal("9");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square miles":
                        //There are 27880000.0 square feet in a square mile
                        factor = new BigDecimal("27880000.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "acres":
                        //There are 43560.0 square feet in an acre
                        factor = new BigDecimal("43560.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square kilometers":
                        //There are 10760000.0 square feet in a square kilometer
                        factor = new BigDecimal("10760000.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square meters":
                        //There are 10.7639 square feet in a square meter
                        factor = new BigDecimal("10.7639");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from square feet
                break;
            case "square yards":
                switch (newU) { //Begin converting from square yards
                    case "square inches":
                        //There are 1296.0 square inches in a square yard
                        factor = new BigDecimal("1296.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square feet":
                        //There are 9 square feet in a square yard
                        factor = new BigDecimal("9");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square yards":
                        //There is one square yard in a square yard
                        num2 = num1;
                        break;
                    case "square miles":
                        //There are 3098000.0 square yards in a square mile
                        factor = new BigDecimal("3098000.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "acres":
                        //There are 4840.0 square yards in an acre
                        factor = new BigDecimal("4840.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square kilometers":
                        //There are 1196000.0 square yards in a square kilometer
                        factor = new BigDecimal("1196000.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square meters":
                        //There are 1.19599 square yards in a square meter
                        factor = new BigDecimal("1.19599");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                }//End converting from square yards
                break;
            case "square miles":
                switch (newU) { //Begin converting from square miles
                    case "square inches":
                        //There are 4014000000.0 square inches in a square mile
                        factor = new BigDecimal("4014000000.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square feet":
                        //There are 27880000.0 square feet in a square mile
                        factor = new BigDecimal("27880000.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square yards":
                        //There are 3098000.0 square yards in a square mile
                        factor = new BigDecimal("3098000.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square miles":
                        //There is one square mile in a square mile
                        num2 = num1;
                        break;
                    case "acres":
                        //There are 640.0 acres in a square mile
                        factor = new BigDecimal("640.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square kilometers":
                        //There are 2.58999 square kilometers in a square mile
                        factor = new BigDecimal("2.58999");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square meters":
                        //There are 2590000.0 square meters in a square mile
                        factor = new BigDecimal("2590000.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                }//End converting from square miles
                break;
            case "acres":
                switch (newU) {//Begin converting from acres
                    case "square inches":
                        //There are 6273000.0 square inches in an acre
                        factor = new BigDecimal("6273000.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square feet":
                        //There are 43560.0 square feet in an acre
                        factor = new BigDecimal("43560.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square yards":
                        //There are 4840.0 square yards in an acre
                        factor = new BigDecimal("4840.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square miles":
                        //There are 640.0 acres in a square mile
                        factor = new BigDecimal("640.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "acres":
                        //There is one acre in an acre
                        num2 = num1;
                        break;
                    case "square kilometers":
                        //There are 247.105 acres in a square kilometer
                        factor = new BigDecimal("247.105");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square meters":
                        //There are 4046.86 square meters in an acre
                        factor = new BigDecimal("4046.86");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from acres
                break;
            case "square kilometers":
                switch (newU) { //Begin converting from square kilometers
                    case "square inches":
                        //There are 1550000000.0 square inches in a square kilometer
                        factor = new BigDecimal("1550000000.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square feet":
                        //There are 10760000.0 square feet in a square kilometer
                        factor = new BigDecimal("10760000.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square yards":
                        //There are 1196000.0 square yards in a square kilometer
                        factor = new BigDecimal("1196000.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square miles":
                        //There are 2.58999 square kilometers in a square mile
                        factor = new BigDecimal("2.58999");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "acres":
                        //There are 247.105 acres in a square kilometer
                        factor = new BigDecimal("247.105");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square kilometers":
                        //There is one square kilometer in a square kilometer
                        num2 = num1;
                        break;
                    case "square meters":
                        //There are 1000000.0 square meters in a square kilometer
                        factor = new BigDecimal("1000000.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                } //End converting from square kilometers
                break;
            case "square meters":
                switch (newU) { //Begin converting from square meters
                    case "square inches":
                        //There are 1550.0 square inches in a square meter
                        factor = new BigDecimal("1550.0");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square feet":
                        //There are 10.7639 square feet in a square meter
                        factor = new BigDecimal("10.7639");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square yards":
                        //There are 1.19599 square yards in a square meter
                        factor = new BigDecimal("1.19599");
                        num2 = num1.multiply(factor).setScale(10, RoundingMode.HALF_EVEN);
                        break;
                    case "square miles":
                        //There are 2590000.0 square meters in a square mile
                        factor = new BigDecimal("2590000.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "acres":
                        //There are 4046.86 square meters in an acre
                        factor = new BigDecimal("4046.86");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square kilometers":
                        //There are 1000000.0 square meters in a square kilometer
                        factor = new BigDecimal("1000000.0");
                        num2 = num1.divide(factor, 200, RoundingMode.HALF_EVEN);
                        break;
                    case "square meters":
                        //There is one square meter in a square meter
                        num2 = num1;
                        break;
                } //End converting from square meters
        } //End conversion table

        //Return the resulting number from the conversion table above
        return num2;
    } //End areaConvert

} //End converter class
