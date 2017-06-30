/**
 * Created by softish on 2017-06-30.
 */
public class ModelAttributes {

    private int vertices;
    private int positions;
    private int texels;
    private int normals;
    private int faces;

    public ModelAttributes() {
    }

    public ModelAttributes(int vertices, int positions, int texels, int normals, int faces) {
        this.vertices = vertices;
        this.positions = positions;
        this.texels = texels;
        this.normals = normals;
        this.faces = faces;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int getPositions() {
        return positions;
    }

    public void setPositions(int positions) {
        this.positions = positions;
    }

    public int getTexels() {
        return texels;
    }

    public void setTexels(int texels) {
        this.texels = texels;
    }

    public int getNormals() {
        return normals;
    }

    public void setNormals(int normals) {
        this.normals = normals;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }


    public void incrementPositions() {
        positions++;
    }

    public void incrementTexels() {
        texels++;
    }

    public void incrementNormals() {
        normals++;
    }

    public void incrementFaces() {
        faces++;
    }

    @Override
    public String toString() {
        return "ModelAttributes{" +
                "vertices=" + vertices +
                ", positions=" + positions +
                ", texels=" + texels +
                ", normals=" + normals +
                ", faces=" + faces +
                '}';
    }
}
