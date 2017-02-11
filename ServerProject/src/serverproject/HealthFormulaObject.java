/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

/**
 *
 * @author Admin
 */
public class HealthFormulaObject 
{
    double PoundsToKilograms(int pounds)
    {
       return pounds/2.2;
    }
    double InchesToMeters(int inches)
    {
        return inches/39.370;
    }
    double CalculateBMI(int weight, int height, int age)
    {
      return PoundsToKilograms(weight)/(InchesToMeters(height)*InchesToMeters(height));
    }
}
