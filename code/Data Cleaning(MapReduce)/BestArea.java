import org.apache.hadoop.fs.Path;
import java.io.*;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import java.lang.*;
import org.apache.hadoop.conf.*;

public class BestArea {
	public static void main(String[] args) throws Exception {
	    if (args.length != 2) {
            System.err.println("Usage: bestarea <input path> <output path>");
            System.exit(-1);
        }
    
    	Job job = new Job();
	job.setJarByClass(BestArea.class);
	job.setJobName("bestarea");

	FileInputFormat.addInputPath(job, new Path(args[0]));
	FileOutputFormat.setOutputPath(job, new Path(args[1]));
	
	job.setMapperClass(BestAreaMapper.class);
	job.setReducerClass(BestAreaReducer.class);
	
	job.setOutputKeyClass(Text.class);
	job.setOutputValueClass(Text.class);
	
	//job.setNumReduceTasks();

	System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
