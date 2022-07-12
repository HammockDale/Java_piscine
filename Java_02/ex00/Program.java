import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Program {

	public static HashMap<StringBuilder, StringBuilder> parsing(HashMap<StringBuilder, StringBuilder> mapa) {
		StringBuilder type = new StringBuilder();
		StringBuilder signature = new StringBuilder();
		int k = 0;

		try (FileInputStream fileInputStream = new FileInputStream("./src/signatures.txt")) {
			while ((k = fileInputStream.read()) != -1) {
				if (k == ',')  {
					while ((k = fileInputStream.read()) != -1 && k != '\n') {
						signature.append((char)k);
					}
					mapa.put(signature, type);
					type = new StringBuilder();
					signature = new StringBuilder();
					continue;
				}
				type.append((char)k);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapa;
	}

	public static int foundSign(String addres, HashMap<StringBuilder, StringBuilder> mapa, FileOutputStream fileIn) {
		int k = 0;
		String file = "";
		int m = -1;
		StringBuilder sbr = new StringBuilder();

		try (FileInputStream fileInputStream = new FileInputStream(addres)) {
			while ((k = fileInputStream.read()) != -1 && m < 16) {
				++m;
				if (Integer.toHexString(k).length() == 1) {
					sbr.append('0');
				}
				sbr.append(Integer.toHexString(k));
				file = sbr.toString();
				for (Map.Entry<StringBuilder, StringBuilder> entry : mapa.entrySet()) {
					if (file.equals(entry.getKey().substring(1).toString().toLowerCase())) {
						for (int i = 0; i < entry.getValue().length(); i++) {
							fileIn.write(entry.getValue().charAt(i));
						}
						fileIn.write('\n');
						System.out.println("PROCESSED");
						return 1;
					}
				}
				sbr.append(' ');
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return  0;
	}

	public static void main(String[] args) {
		HashMap<StringBuilder, StringBuilder> mapa = new HashMap<>();
		parsing(mapa);
		String addres = "";

		try (FileOutputStream fileIn = new FileOutputStream("result.txt")) {
			while ((addres = ft_readline()) != null) {
				if (addres.equals("42"))
					return;
				if (foundSign(addres, mapa, fileIn) == 0) {
					System.out.println("UNDEFINED");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public static String ft_readline() {
		StringBuilder sb = new StringBuilder();
		try {
			int read = System.in.read();
			if (read == -1) {
				return null;
			}
			while (read != -1 && read != '\n') {
				sb.append((char) read);
				read = System.in.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
