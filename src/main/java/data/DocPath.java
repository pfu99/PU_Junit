package data;

import exceptions.BadPathException;

final public class DocPath {
    private final String path;
    public DocPath (String p) throws BadPathException {
        if (p == null) throw new NullPointerException("Path is null.");
        // Add validation to check if the file exists or if the path is a valid directory
        path = p;
    }
    public String getPath () { return path; }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocPath niff = (DocPath) o;
        return path.equals(niff.path);
    }
    @Override
    public int hashCode () { return path.hashCode(); }
    @Override
    public String toString () {
        return "DocPath{path='" + path + "', hashCode=" + hashCode() + "}";
    }
}