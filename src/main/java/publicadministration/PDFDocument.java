package publicadministration;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class PDFDocument { // Represents a PDF document
    private final Date creatDate;
    private final DocPath path;
    private final File file;

    public PDFDocument() {
        this.creatDate = new Date();
        this.path = new DocPath("default/path/pdf.pdf");
        this.file = new File(this.path.getPath());
    }

    public PDFDocument(Date creatDate, DocPath path) {
        this.creatDate = creatDate;
        this.path = path;
        this.file = new File(this.path.getPath());
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public DocPath getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }

    public void moveDoc(DocPath destPath) throws IOException {
        File destFile = new File(destPath.getPath());
        if (!file.renameTo(destFile)) {
            throw new IOException("Unable to move file to destination path");
        }
        this.path = destPath;
        this.file = destFile;
    }

    public void openDoc(DocPath path) throws IOException {
        File file = new File(path.getPath());
        if (!file.exists()) {
            throw new IOException("File does not exist at specified path");
        }
        if (!Desktop.isDesktopSupported()) {
            throw new IOException("Desktop operations are not supported on this platform");
        }
        Desktop.getDesktop().open(file);
    }

    @Override
    public String toString() {
        return "PDFDocument{" +
                "creation date=" + creatDate +
                ", path='" + path + '\'' +
                ", file=" + file +
                '}';
    }
}
