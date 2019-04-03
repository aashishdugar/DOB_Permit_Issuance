import java.io.IOException;
import java.io.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.lang.*;

public class BestAreaMapper extends Mapper<LongWritable, Text, Text, Text> { 
    
    @Override
    public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
        String line = value.toString();
        String[] fields = line.split(",");
	String sc;
        String residential = fields[4]; //gives us the yes or no value from the residential column
	String zipcode = fields[3]; // get the zipcode from the column
	File file = new File("/home/ad4025/Topos/Most_Expensive_Zipcodes.csv");
	BufferedReader br = new BufferedReader (new FileReader(file));
	while((sc = br.readLine()) != null){
	    String[] fields2 = sc.split(",");
	    String rank = fields2[0];
	    String neighbor = fields2[2];
   	    String[] zips = fields2[6].replace("\"","").split(",");
	    for(String x:zips){
		if(x.equals(zipcode)){
		    context.write(value,new Text(rank+"-"+neighbor));
		}
	    }	
		
	}
    }	
}

