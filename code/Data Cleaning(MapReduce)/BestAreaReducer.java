import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.lang.*;

public class BestAreaReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
	String val = "";
        for (Text value: values) {
	val = val + value.toString();
    	}
	context.write(key, new Text(val)); //print out in (key,value) form
    	
    }
}
