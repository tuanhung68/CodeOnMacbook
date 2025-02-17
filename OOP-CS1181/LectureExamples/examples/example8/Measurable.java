/**
*   Describes any class whose objects can be measured.
*/
public interface Measurable
{
   /**
    *  Computes the measure of the object.
    *  @return the measure
   */
   double getMeasure();

   /**
   *   Computes the average of the measures of the given objects.
   *   @param objects an array of Measurable objects
   *   @return the average of the measuables
   */
   public static double average(Measurable[] objects)
   {
      double sum = 0;
      for (Measurable obj : objects)
      {
         sum = sum + obj.getMeasure();
      }
      if (objects.length > 0) { return sum / objects.length; }
      else { return 0; }
   }
}
