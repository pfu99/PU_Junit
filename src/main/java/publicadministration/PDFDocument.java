package publicadministration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import data.DocPath;
import exceptions.BadPathException;


public class PDFDocument { // Represents a PDF document
    private final Date creatDate;
    private DocPath path;
    private File file;
    static final String DEFAULT_PATH = "src/main/res/informe.pdf";


    public PDFDocument() throws BadPathException {
        this.creatDate = new Date();
        this.path = new DocPath(DEFAULT_PATH);
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
        path = destPath;
        file = destFile;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PDFDocument that = (PDFDocument) o;
        return Objects.equals(creatDate, that.creatDate) && Objects.equals(path, that.path);
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
