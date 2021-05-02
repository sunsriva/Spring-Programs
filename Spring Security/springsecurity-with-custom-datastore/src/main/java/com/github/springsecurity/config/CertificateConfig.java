package com.github.springsecurity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Base64;

@Order(0)
@Configuration
public class CertificateConfig {

    @Value("${mongodb-cert-b64}")
    private String mongodbCertB64;

    @PostConstruct
    private void init() throws KeyStoreException {
        final String ks = System.getProperty("java.io.tmpdir") + File.separator + "bos";
        final String ksPwd = "changeit";
        final KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

        try (FileOutputStream fos = new FileOutputStream(ks)) {
            keyStore.load(null, null);
            keyStore.setCertificateEntry("mongodb", CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.getDecoder().decode(mongodbCertB64))));
            keyStore.store(fos, ksPwd.toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
        System.setProperty("javax.net.ssl.trustStore", ks);
        System.setProperty("javax.net.ssl.trustStorePassword", ksPwd);
    }

}
