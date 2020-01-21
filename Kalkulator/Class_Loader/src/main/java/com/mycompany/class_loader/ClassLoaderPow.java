package com.mycompany.class_loader;



public class ClassLoaderPow extends JavaClassLoader {

	public static double OdpalanieCL(float arglist[]) {
		JavaClassLoader javaClassLoader = new JavaClassLoader();
		javaClassLoader.invokeClassMethod("com.mycompany.class_loader.New_feature", "potega", arglist[0], arglist[1] );
		double wynik=Math.pow(arglist[1],arglist[0]);
		return wynik;

		
	}
	
}