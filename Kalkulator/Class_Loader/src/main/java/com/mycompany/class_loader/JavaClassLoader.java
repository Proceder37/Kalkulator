package com.mycompany.class_loader;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class JavaClassLoader extends ClassLoader {

	public void invokeClassMethod(String classBinName, String methodName, float arglist1, float arglist2){
	
		try {
			
			// Create a new JavaClassLoader 
			ClassLoader classLoader = this.getClass().getClassLoader();
			
			// Load the target class using its binary name
	        Class<?> loadedMyClass = classLoader.loadClass(classBinName);
	        
	        System.out.println("Loaded class name: " + loadedMyClass.getName());
	        
	        // Create a new instance from the loaded class
	        Constructor<?> constructor = loadedMyClass.getConstructor();
	        Object myClassObject = constructor.newInstance();
	        
                
                Class partypes[] = new Class[2];
                partypes[0] = Float.TYPE;
                partypes[1] = Float.TYPE;
	        // Getting the target method from the loaded class and invoke it using its name
	        Method method = loadedMyClass.getMethod(methodName, partypes);
	        System.out.println("Invoked method name: " + method.getName()); 
                Object arglist5[] = new Object[2];
                arglist5[0]=arglist1;
                arglist5[1]=arglist2;

	        method.invoke(myClassObject, arglist5[0], arglist5[1]);

                

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(); // bledy do pliku nie na konsole (log4j)
		}
		
	}
}