package com.fullstack.streamutils.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TranslatorServicesTest {

    @Autowired
    private TranslatorServices services;

    @Test
    public void invertirTexto() throws IOException {
        services.ejecutarLab12();

        assertTrue(new File("files/estrofasEnOrdenInverso.txt").exists());
        assertTrue(new File("files/statistics.txt").exists());
        assertTrue(new File("files/finaloutput.txt").exists());

    }
}