package example;

import java.io.*;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.StreamRequestHandler;
import com.aliyun.fc.runtime.FunctionInitializer;

/**
 * Hello world!
 *
 */
public class App implements StreamRequestHandler, FunctionInitializer {

    public void initialize(Context context) throws IOException {

    }

    @Override
    public void handleRequest(
            InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        Process process;
        process = Runtime.getRuntime()
                .exec("mvn --version");

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
//        try {
//            process.getOutputStream().wait();
//        } catch (Exception e) {
//            outputStream.write(e.getMessage().getBytes());
//        }
        outputStream.write(new String("hello world\n").getBytes());
    }
}
