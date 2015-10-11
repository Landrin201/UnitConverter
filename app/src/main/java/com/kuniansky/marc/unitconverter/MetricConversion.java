package com.kuniansky.marc.unitconverter;
import java.math.*;
/*
    Modifications
    Created 10/4/2015 by Marc Kuniansky. Refactored the convertMetric method from the Converter class to this one.
                                         I felt this would allow me to better use it both in the metricConvert activity
                                         and in other areas of the converter class, as I could have several constructors for it.
 */

/**
 * Contains methods which allow a user to convert between metric units. All metric units from Yotta (10^24) to yocto (10^-24) 
 * are able to be converted.
 * Created by Marc Kuniansky on 10/4/2015.
 */
public class MetricConversion
{ //Begin class
    //Instance variables
    private BigDecimal num1;
    private String originalU;
    private String newU;

    //Constructors
    /**
     * Constructor which takes a double to be converted and two strings to represent the units beinf converted from/to.
     * @param originalNumber a double, the number to be converted
     * @param originalUnit a string, the unit to convert from
     * @param newUnit a string, the unit to convert to
     */
    public MetricConversion(String originalNumber, String originalUnit, String newUnit)
    { //Begin constructor
        //Converting a double to a BigDecimal actually causes a slight error. Instead of doing that, convert from a string to a BigDecimal instead.
        //Capture the number the user input
        num1 = new BigDecimal(originalNumber);

        //If the string from the MetricActivity spinners is passed, there will be a space. Remove everything after the space,
        //it is unimportant. If the method is being used elsewhere, there is no space.
        if(originalUnit.contains(" "))
        {
            originalU = originalUnit.substring(0, originalUnit.indexOf(" ")).toLowerCase();
        }
        else
        {
            originalU = originalUnit.toLowerCase();
        }
        //Do the same for the unit to convert to
        if(newUnit.contains(" "))
        {
            newU = newUnit.substring(0, newUnit.indexOf(" ")).toLowerCase();
        }
        else
        {
            newU = newUnit.toLowerCase();
        }
    } //End constructor

    /**
     * Constructor which takes a BigDecimal to be converted and two strings to represent the units beinf converted from/to.
     * @param originalNumber a BigDecimal, the number to be converted
     * @param originalUnit a string, the unit to convert from
     * @param newUnit a string, the unit to convert to
     */
    public MetricConversion(BigDecimal originalNumber, String originalUnit, String newUnit)
    { //Begin constructor

        //Capture the number the user input
        num1 = originalNumber;

        //If the string from the MetricActivity spinners is passed, there will be a space. Remove everything after the space,
        //it is unimportant. If the method is being used elsewhere, there is no space.
        if(originalUnit.contains(" "))
        {
            originalU = originalUnit.substring(0, originalUnit.indexOf(" ")).toLowerCase();
        }
        else
        {
            originalU = originalUnit.toLowerCase();
        }

        //If the string from the MetricActivity spinners is passed, there will be a space. Remove everything after the space.
        if(newUnit.contains(" "))
        {
            newU = newUnit.substring(0, newUnit.indexOf(" ")).toLowerCase();
        }
        else
        {
            newU = newUnit.toLowerCase();
        }
    } //End constructor


    //Other methods
    /**
     * Converts between metric prefixes. The type of unit is unimportant- the metric system operates on a base 10 system
     * and so converting between, say, millimeters and meters is exactly the same as converting between milliliters and liters. 
     * </br></br>
     * Accepted prefixes: yotta, zeta, exa, peta, tera, giga, mega, kilo, hecto, deka, UNIT,
     * deci, centi, milli, micro, nano, pico, femto, atto, zepto, yocto
     */
    public BigDecimal metricConvert()
    { //Begin metricConvert
        
	/*
    	This can use a slightly different, and much easier, algorithm than the others.
    	Because metric is so well organized, it doesn't matter what number is input- the conversion factors are the same.
    	So if I take the original number and convert it to UNITS (which is x*10^0) then convert from UNITS to the new unit,
        I can very easily do these conversions with very little work. I will heavily utilize the math class here, I need to
        use exponents quite a bit to simplify life.
	*/

        //I need three more BigDecimals: one that will hold the conversion to 10^0, one to hold the final result, and one to hold
        //the power of 10.
        BigDecimal unitNum = new BigDecimal("0");
        BigDecimal finalNum = new BigDecimal("0");
        BigDecimal tenP;

        //Next, I use the first of two switch statements. This converts the original number to UNITS, or x*10^0.
        switch(originalU)
        { //Begin conversion table converting to units (10^0)
            case "yotta":
                //Yotta is 10^24 units
                tenP = allExponents(24d);
                unitNum = num1.multiply(tenP);
                break;
            case "zeta":
                //Zeta is 10^21
                tenP = allExponents(21d);
                unitNum = num1.multiply(tenP);
                break;
            case "exa":
                //Exa is 10^18
                tenP = allExponents(18d);
                unitNum = num1.multiply(tenP);
                break;
            case "peta":
                //Peta is 10^15
                tenP = allExponents(15d);
                unitNum = num1.multiply(tenP);
                break;
            case "tera":
                //Tera is 10^12
                tenP = allExponents(12d);
                unitNum = num1.multiply(tenP);
                break;
            case "giga":
                //Giga is 10^9
                tenP = allExponents(9d);
                unitNum = num1.multiply(tenP);
                break;
            case "mega":
                //Mega is 10^6
                tenP = allExponents(6d);
                unitNum = num1.multiply(tenP);
                break;
            case "kilo":
                //Kilo is 10^3
                tenP = allExponents(3d);
                unitNum = num1.multiply(tenP);
                break;
            case "hecto":
                //Hecto is 10^2
                tenP = allExponents(2d);
                unitNum = num1.multiply(tenP);
                break;
            case "deka":
                //Deka is 10^1
                tenP = allExponents(1d);
                unitNum = num1.multiply(tenP);
                break;
            case "unit":
                //UNIT is the target, 10^0
                tenP = allExponents(0d);
                unitNum = num1.multiply(tenP);
                break;
            case "deci":
                //Deci is 10^-1
                tenP = allExponents(-1d);
                unitNum = num1.multiply(tenP);
                break;
            case "centi":
                //Centi is 10^-2
                tenP = allExponents(-2d);
                unitNum = num1.multiply(tenP);
                break;
            case "milli":
                //Milli is 10^-3
                tenP = allExponents(-3d);
                unitNum = num1.multiply(tenP);
                break;
            case "micro":
                //Micro is 10^-6
                tenP = allExponents(-6d);
                unitNum = num1.multiply(tenP);
                break;
            case "nano":
                //Nano is 10^-9
                tenP = allExponents(-9d);
                unitNum = num1.multiply(tenP);
                break;
            case "pico":
                //Pico is 10^-12
                tenP = allExponents(-12d);
                unitNum = num1.multiply(tenP);
                break;
            case "femto":
                //Femto is 10^-15
                tenP = allExponents(-15d);
                unitNum = num1.multiply(tenP);
                break;
            case "atto":
                //Atto is 10^-18
                tenP = allExponents(-18d);
                unitNum = num1.multiply(tenP);
                break;
            case "zepto":
                //Zepto is 10^-21
                tenP = allExponents(-21d);
                unitNum = num1.multiply(tenP);
                break;
            case "yocto":
                //Yocto is 10^-24
                tenP = allExponents(-24d);
                unitNum = num1.multiply(tenP);
                break;
        } //End conversion table converting to units (10^0)

        //Next is a switch statement for all possible cases of the new unit. It takes
        //the number given by the first switch, unitNum, and converts it to the new unit
        //using math.
        switch(newU)
        { //Begin converting from base units (10^0) to new units.
            case "yotta":
                //Yotta is 10^24 units
                tenP = allExponents(24d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "zeta":
                //Zeta is 10^21
                tenP = allExponents(21d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "exa":
                //Exa is 10^18
                tenP = allExponents(18d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "peta":
                //Peta is 10^15
                tenP = allExponents(15d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "tera":
                //Tera is 10^12
                tenP = allExponents(12d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "giga":
                //Giga is 10^9
                tenP = allExponents(9d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "mega":
                //Mega is 10^6
                tenP = allExponents(6d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "kilo":
                //Kilo is 10^3
                tenP = allExponents(3d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "hecto":
                //Hecto is 10^2
                tenP = allExponents(2d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "deka":
                //Deka is 10^1
                tenP = allExponents(1d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "unit":
                //UNIT is the target, 10^0
                tenP = allExponents(0d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "deci":
                //Deci is 10^-1
                tenP = allExponents(-1d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "centi":
                //Centi is 10^-2
                tenP = allExponents(-2d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "milli":
                //Milli is 10^-3
                tenP = allExponents(-3d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "micro":
                //Micro is 10^-6
                tenP = allExponents(-6d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "nano":
                //Nano is 10^-9
                tenP = allExponents(-9d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "pico":
                //Pico is 10^-12
                tenP = allExponents(-12d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "femto":
                //Femto is 10^-15
                tenP = allExponents(-15d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "atto":
                //Atto is 10^-18
                tenP = allExponents(-18d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "zepto":
                //Zepto is 10^-21
                tenP = allExponents(-21d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
            case "yocto":
                //Yocto is 10^-24
                tenP = allExponents(-24d);
                finalNum = unitNum.divide(tenP, 200, RoundingMode.HALF_EVEN);
                break;
        } //End converting from base units (10^0) to new units.

        //Finally, return the final number
        return finalNum;
    } //End metricConvert

    /**
     * Helping method which will allow an exponent to be either positive or negative, unlike the math pow() method. 
     * Thanks to this page for the idea to do this, and for the skeleton code- http://stackoverflow.com/questions/4364634/calculate-the-power-of-any-exponent-negative-or-positive
     *
     * @param exponent must be a valid double
     * @return the resulting number
     */
    private BigDecimal allExponents(double exponent)
    { //Begin allExponents
        //A string representation of the number generated by math.pow; used to convert a double value to a BigDecimal value without error.

        //I need a big decimal value for one for negative exponents
        BigDecimal one = new BigDecimal("1");
        double e = Math.abs(exponent);

        //The final number to be returned
        BigDecimal finalNum;

        //A string representation of the number generated by math.pow; used to convert a double value to a BigDecimal value without error.
        //Use math.pow to raise the base to the e power, and convert that to a string.
        String stringRep = new String(""+Math.pow(10, e));
        //This method needs to work for positive and negative exponents
        if (exponent > 0)
        { //Begin positive exponents
            //Convert that string to a BigDecimal value. Converting from a double directly to BigDecimal causes a small amount of error,
            //which becomes significant with many decimal places. Using strings avoids this.
            finalNum = new BigDecimal(""+stringRep);
        } //End positive exponents
        else if (exponent < 0)
        { //Begin negative exponents
            BigDecimal p = new BigDecimal(stringRep);
            finalNum = one.divide(p, 200, RoundingMode.HALF_EVEN);
        } //End positive exponents
        else
        { //Begin exponent = 0
            finalNum = one;
        } //End exponent = 0

        //Return the result
        return finalNum;
    } //End allExponents




} //End class
