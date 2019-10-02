package sequencetolibsvmvector;
import java.io.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author ×ÞÈ¨
 * @version 1.0
 */
public class Console {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("Usage:");
            
            System.out.println("java -jar 188.jar firstclass.fa secondclass.fa thirdclass.fa ... >result.arff");
        }
        else{
        	boolean flag =true;
            for (int i=0;i<args.length;i++) {
            	File f = new File(args[i]);
            	if(!f.exists()) {
            		System.out.println(args[i]+" is not a file");
       		flag=false;
            	}
            }
        	if(flag) {
                Flow f = new Flow(args);
                f.run();
        	}

        }
    }
}
