package edu.buffalo.cse.datatypeinference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<String> lines = new ArrayList<String>();
        try{
	        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	        File file = new File(classLoader.getResource("recs2009_public.csv").getFile());
	        InputStream inputFS = new FileInputStream(file);
	        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	        lines = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
        } catch(FileNotFoundException fnf){
        	System.err.println("FileNotFound!");
        	fnf.printStackTrace();
        }
        System.out.println(lines.size()+" lines read");
    }
    
    // This function needs to be modified to include custom parsing code
    private static Function<String, String> mapToItem = (line) -> {
    	return line;
    };
}
