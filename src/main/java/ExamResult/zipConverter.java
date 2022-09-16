package ExamResult;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ExamResult.Main.zipPath;

public interface zipConverter {

    static void saveToZIP(List<String> records) throws IOException {
        for (String record : records) {
            File file = new File(record);

            try (FileInputStream inputStream = new FileInputStream(file);
                 ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath));) {
                int bytesRead;
                byte[] buffer = new byte[1024];
                CRC32 crc = new CRC32();
                try (BufferedInputStream bufferInput = new BufferedInputStream(new FileInputStream(file));) {
                    crc.reset();
                    while ((bytesRead = bufferInput.read(buffer)) != -1) {
                        crc.update(buffer, 0, bytesRead);
                    }
                }
                ZipEntry entry = new ZipEntry(file.getName());
                entry.setMethod(ZipEntry.STORED);
                entry.setCompressedSize(file.length());
                entry.setSize(file.length());
                entry.setCrc(crc.getValue());

                zipOutputStream.putNextEntry(entry);
                while ((bytesRead = inputStream.read(buffer)) >= 0) {
                    zipOutputStream.write(buffer, 0, bytesRead);
                }
                zipOutputStream.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
