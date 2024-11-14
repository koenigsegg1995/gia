package iisi.example.gia.config;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import java.io.IOException;
import java.io.Writer;

public class ExportFlatFileHeaderCallbackImpl implements FlatFileHeaderCallback {

    private String header;

    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write("\uFEFF"); // UTF-8 標頭
        writer.write(header); // 輸入文字
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
