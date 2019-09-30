
public class VectorFunctions {
	public static void main(String[] args) {
		double[] array1 = {2.0,2.0};
		double[] array2 = {-4.0,-3.0};
		double magnitude = findMagnitude (array1);
		double[] normalVector = normaliseVector(array1);
		double dotProduct = determineDotProduct(array1, array2);
		double[] addedVector = vectorsAddition(array1, array2);
		
		System.out.println(magnitude);
		System.out.println(normalVector[0]+", "+normalVector[1]);
		System.out.println(dotProduct);
		System.out.println(addedVector[0]+", "+addedVector[1]);
	}
	public static double findMagnitude (double [] vectors)
	{
		double magnitude=0.0;
		double toBeRooted=0.0;
		for (int index=0; index<vectors.length; index++)
		{
			toBeRooted =+ vectors[index]*vectors[index];
		}
		magnitude = Math.sqrt(toBeRooted);
		return magnitude;
	}
	public static double[] normaliseVector (double[] vectors)
	{
		double magnitude=findMagnitude(vectors);
		double [] normaliseVector=new double[vectors.length];
		for (int index=0; index<vectors.length; index++)
		{
			normaliseVector[index] = vectors[index]/magnitude;
		}
		return normaliseVector;
	}
	public static double determineDotProduct(double [] vector1, double [] vector2)
	{
		double dotProduct=-1.0;
		if (vector1.length==vector2.length)
		{
			for (int index=0; index<vector1.length||index<vector2.length; index++)
			{
				dotProduct =+ vector1[index]*vector2[index];
			}
		}
		return dotProduct;
	}
	public static double[] vectorsAddition(double [] vector1, double[] vector2)
	{
		double [] newVector=new double[(vector1.length<vector2.length)?vector1.length:vector2.length];
		for (int index=0; index<newVector.length; index++)
		{
			newVector[index] = vector1[index]+vector2[index];
		}
		return newVector;
	}
}
