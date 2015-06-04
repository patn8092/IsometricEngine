package dev.isometric.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataSerializer {
	
	public static void writeData(Object o, String path) {
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(o);
			out.close();
			fileOut.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object loadData(String path) {
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			Object o = in.readObject();
			
			in.close();
			fileIn.close();
			
			return o;
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}	
}
