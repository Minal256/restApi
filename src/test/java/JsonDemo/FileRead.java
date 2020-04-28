package JsonDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileRead {
	
	public static String generateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	public static void main(String[] args) throws IOException {
		String s = generateStringFromResource("D:\\Eclipse programs\\RestTest.txt");
		System.out.println(s);
	}

}
