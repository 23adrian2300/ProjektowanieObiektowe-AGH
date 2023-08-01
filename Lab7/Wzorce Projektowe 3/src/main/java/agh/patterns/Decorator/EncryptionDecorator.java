package agh.patterns.Decorator;

import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String encodedData = encode(data);
        super.writeData(encodedData);
    }

    @Override
    public String readData() {
        String encodedData = super.readData();
        return decode(encodedData);
    }

    private String encode(String data) {
        try {
            return URLEncoder.encode(data, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
        }
    }

    private String decode(String data) {
        try {
            return URLDecoder.decode(data, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
        }
    }
}