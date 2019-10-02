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
public class Flow {
    String[] inputfile;
    public Flow(String[] inputfile) {
        this.inputfile = inputfile;
    }

    public void run() {
        try {
            
            
            System.out.println("@relation Protein");

            for(int i = 1;i<=188;i++){
               String tmp ="@attribute Feature"+String.valueOf(i)+" real";
               System.out.println(tmp);
           }
           System.out.print("@attribute class {class1");
           for(int i=2;i<=inputfile.length;i++) {
        	   System.out.print(", class"+String.valueOf(i)); 
           }
           System.out.println("}");
           System.out.println("@data");
           
           for(int i=0;i<inputfile.length;i++) {
        	   BufferedReader br = new BufferedReader(new FileReader(inputfile[i]));

        	   String line = br.readLine();
               while (br.ready()) {
                   if (line.length() != 0 && line.charAt(0) == '>') {
                       @SuppressWarnings("unused")
   					String name = line;
                       StringBuffer sb = new StringBuffer();
                       line = br.readLine().trim();
                       while(br.ready()&&line.length()==0)
                           line = br.readLine().trim();
                       while (line.length() != 0 && line.charAt(0) != '>') {
                           sb.append(line);
                           if (br.ready()) {
                               line = br.readLine().trim();
                           } else {
                               break;
                           }
                       }
                       String seq = sb.toString();
                       Sequence s = new Sequence(seq);
                       System.out.print(s.run());
                       System.out.println("class"+String.valueOf(i+1));

                   } else {
                       line = br.readLine();
                   }
               }

        	   br.close();      	   
           }

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            System.exit(0);
        }
    }
}

