package com.fullstack.streamutils.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author arturo
 */
@Service
public class TranslatorServices {

    private final String original = "files/original.txt";

    public void ejecutarLab12() throws IOException {
        InputStream in = new FileInputStream(original);
        String content = StreamUtils.copyToString(in, StandardCharsets.UTF_8);

        imprimirTextoInverso(content);
        List<PalabraConteo> palabras = cuentaPalabras(content);
        imprimirPalabraRepetida(palabras);
        imprimirCambioPalabra(content, palabras.get(0).getPalabra());
    }

    private void imprimirTextoInverso(String content) throws FileNotFoundException {
        Stack<String> estrofas = new Stack<>();
        String[] inverso = content.split("\n\n");
        for (String s : inverso) {
            estrofas.push(s);
        }
        File outputFile = new File("files/estrofasEnOrdenInverso.txt");
        OutputStream out = new FileOutputStream(outputFile);
        PrintStream p = new PrintStream(out);
        while(!estrofas.empty()){
            p.println(estrofas.pop());
            p.println();
        }
        p.close();
    }

    private List<PalabraConteo> cuentaPalabras(String texto) {
        String delimitadores= "[ .,;?!¡¿\"\\[\\]\n]+";
        String[] lista = texto.split(delimitadores);
        TreeMap<String, Integer> palabras = new TreeMap<>();

        for (String p: lista) {
            if (!palabras.containsKey(p)) {
                palabras.put(p, 1);
            } else {
                palabras.put(p, palabras.get(p) + 1);
            }
        }

        List<PalabraConteo> res = new LinkedList<>();
        palabras.forEach((k, v) -> {
            res.add(new PalabraConteo(k, v));
        });
        Collections.sort(res);
        return res;
    }

    private void imprimirPalabraRepetida(List<PalabraConteo> palabras) throws IOException{
        File outputFile = new File("files/statistics.txt");
        OutputStream out = new FileOutputStream(outputFile);
        PrintStream p = new PrintStream(out);
        palabras.forEach(palabra -> p.println(palabra.toString()));
        p.close();
    }

    private void imprimirCambioPalabra(String content, String palabra) throws IOException{
        File outputFile = new File("files/finaloutput.txt");
        OutputStream out = new FileOutputStream(outputFile);
        content = content.replaceAll(palabra, " you ");
        PrintStream p = new PrintStream(out);
        p.println(content);
        p.close();
    }
}
