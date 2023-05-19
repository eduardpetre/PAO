package persistenta.util;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Audit {
    private static volatile Audit init;
    FileWriter fileWriter;

    private Audit() {
        try {
            this.fileWriter = new FileWriter("src/persistenta/util/AuditLog.csv", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Audit getInit() {
        if (init == null) {
            synchronized (Audit.class) {
                if (init == null) {
                    init = new Audit();
                }
            }
        }
        return init;
    }

    public void log(String line) {
        try {
            long datetime = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(datetime);

            this.fileWriter = new FileWriter("src/persistenta/util/AuditLog.csv", true);
            this.fileWriter.write((line + ", " + timestamp + "\n"));
            this.fileWriter.flush();
            this.fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            this.fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}