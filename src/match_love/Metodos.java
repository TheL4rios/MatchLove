package match_love;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 *
 * @author Larios
 */
public class Metodos {

    // Separa una cadena en 3 partes, quedando el caracter  indicado (mediante el índice "index") en la 2da parte
    public static String[] splitForCharacter(String str, int index) {
        String[] splits = new String[3];
        if (str.length() == 1) {
            splits[0] = "";
            splits[1] = str;
            splits[2] = "";
        }
        if (index == 0) {
            splits[0] = "";
            splits[1] = str.substring(0, 1);
            splits[2] = str.substring(1, str.length());
        } else if (index == str.length() - 1) {
            splits[0] = str.substring(0, index);
            splits[1] = str.substring(index, index + 1);
            splits[2] = "";
        } else {
            splits[0] = str.substring(0, index);
            splits[1] = str.substring(index, index + 1);
            splits[2] = str.substring(index + 1, str.length());
        }

        return splits;
    }

    // Método para cambiar el tamaño de una imagen
    public static Image scaleImage(Image image, int width, int height) {
        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    // Multiplicar n veces una cadena
    public static String multStr(String str, int n) {
        if (n <= 0) {
            return "";
        }
        String strT = "";
        for (int i = 0; i < n; i++) {
            strT += str;
        }
        return strT;
    }

    // Convertir un ArrayList de String a un Arreglo de String
    public static String[] ArrayListToArray(ArrayList<String> arrayList) {
        String[] array = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }

    // Remplazar espacios por guiones bajos con cada palabra iniciando con mayúscula después del "_"
    public static String getNameWithPrologFormat(String name) {
        String namePreFormatProlog = name.replaceAll(" ", "_").toLowerCase(),
                nameFormatProlog = "";
        for (int i = 0; i < namePreFormatProlog.length(); i++) {
            String character = String.valueOf(namePreFormatProlog.charAt(i)),
                    nextCharacter = i != namePreFormatProlog.length()-1?String.valueOf(namePreFormatProlog.charAt(i+1)):"";
            if (character.equals("_")) {
                nameFormatProlog += character + nextCharacter.toUpperCase();
                i++;
            } else {
                nameFormatProlog += character;
            }
        }
        return nameFormatProlog;
    }

    // Obtener el nombre en formato normal, quitando los guiones bajos y capitalizando cad palabra
    public static String getNameWithNormalFormat(String name) {
        String strFormat = "";
        String[] splitWords = name.split("_");
        for (int i = 0; i < splitWords.length; i++) {
            String word = splitWords[i];
            strFormat += capitalize(word);
            if (i != splitWords.length - 1) {
                strFormat += " ";
            }
        }
        return strFormat;
    }

    // Poner únicamente la primer letra de una cadena en mayúscula
    public static String capitalize(String word) {
        if (word.length() == 1) {
            return word.toUpperCase();
        } else {
            return word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
        }
    }

    //Sobresccribir un determinado archivo (Tiene bugs si es formato ASCCI)
    public static void addTextToFile(String directory, String fileName, String addText) {
        String directoryFile = directory + "\\" + fileName;
        try {
            FileWriter fstream = new FileWriter(directoryFile, true);
            try (BufferedWriter out = new BufferedWriter(fstream)) {
                out.write(addText);
                out.close();
            }
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo \"" + fileName + "\": " + e.getMessage());
        }
    }

    // Codificar un archivo a otro formato
    public static void encodeFile(String directory, String fileName, Charset formatIn, Charset formatOut) {
        encodeFile(directory, fileName, formatIn, formatOut, null, ADD_DATA.NONE);
    }

    // Codificar un archivo a otro formato, agregando más datos al final
    public static void encodeFile(String directory, String fileName, Charset formatIn, Charset formatOut, String addData) {
        encodeFile(directory, fileName, formatIn, formatOut, addData, ADD_DATA.FINAL);
    }

    // Codificar un archivo a otro formato, agregando más datos ya sea al inicio o al final
    public static void encodeFile(String directory, String fileName, Charset formatIn, Charset formatOut, String addData, ADD_DATA addDataType) {
        String data = decodeTextOfFile(directory, fileName, formatIn);
        if (addData != null) {
            switch (addDataType) {
                case INICIO:
                    data = addData + data;
                    break;
                case FINAL:
                    data += addData;
                    break;
            }
        }
        exportFileEncoding(directory, fileName, data, formatOut);
    }

    // Decodificar texto de un archivo, especificando su codificación
    public static String decodeTextOfFile(String directory, String fileName, Charset encoding) {
        String directoryFile = directory + "\\" + fileName, decode = "";
        try {
            BufferedReader buffer = new BufferedReader(
                    new InputStreamReader(new FileInputStream(directoryFile), encoding));

            while (true) {
                String line = buffer.readLine();
                if (line != null) {
                    decode += line + "\n";
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error al encontrar el archivo: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al decodificar el archivo: " + ex.getMessage());

        }
        return decode;
    }

    // Exportar un archivo con datos en un determinado formato
    public static void exportFileEncoding(String directory, String fileName, String data, Charset format) {
        String directoryFile = directory + "\\" + fileName;
        Writer out;
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(directoryFile), format));
            out.write(data);
            out.close();
        } catch (IOException ex) {
            System.out.println("Error al codificar el archivo: " + ex.getMessage());
        }
    }

    // Método que devuelve si una cadena contiene otra cadena
    public static boolean strContains(String str, String str2) {
        return str.contains(str2);
    }

    // Método que devuelve si una cadena contiene a alguna d elas cadenas del arreglo
    public static boolean strContains(String str, String[] str2) {
        for (String st : str2) {
            if (strContains(str, st)) {
                return true;
            }
        }
        return false;
    }

    public enum ADD_DATA {
        INICIO, FINAL, NONE
    }
}
