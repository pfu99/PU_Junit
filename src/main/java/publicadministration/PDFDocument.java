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
    static final String DEFAULT_PATH = "src/main/res/document.pdf";


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

    public void moveDoc(DocPath destPath) throws IOException, BadPathException {
        if (destPath == null) throw new NullPointerException("Path can't be NULL");
        if (!file.renameTo(new File(destPath.getPath())))
            throw new IOException("Unable to rename file");
        path = new DocPath(destPath.getPath());
        file = new File(destPath.getPath());
    }

    public void openDoc(DocPath path) throws IOException {
        if (path == null) throw new NullPointerException("Path can't be null");
        File toOpenFile = new File(path.getPath());
        Desktop.getDesktop().open(toOpenFile);
    }

}
