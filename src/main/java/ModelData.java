import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by softish on 2017-06-30.
 */
public class ModelData {

    private List<Vector3D> positions;
    private List<Vector2D> texels;
    private List<Vector3D> normals;
    private List<List<Vector3D>> faces;

    public ModelData() {
        positions = new ArrayList<>();
        texels = new ArrayList<>();
        normals = new ArrayList<>();
        faces = new ArrayList<>();
    }

    public ModelData(List<Vector3D> positions, List<Vector2D> texels, List<Vector3D> normals, List<List<Vector3D>> faces) {
        this();
        this.positions = positions;
        this.texels = texels;
        this.normals = normals;
        this.faces = faces;
    }

    public List<Vector3D> getPositions() {
        return positions;
    }

    public void setPositions(List<Vector3D> positions) {
        this.positions = positions;
    }

    public List<Vector2D> getTexels() {
        return texels;
    }

    public void setTexels(List<Vector2D> texels) {
        this.texels = texels;
    }

    public List<Vector3D> getNormals() {
        return normals;
    }

    public void setNormals(List<Vector3D> normals) {
        this.normals = normals;
    }

    public List<List<Vector3D>> getFaces() {
        return faces;
    }

    public void setFaces(List<List<Vector3D>> faces) {
        this.faces = faces;
    }

    public void addPosition(Vector3D position) {
        positions.add(position);
    }

    public void addTexel(Vector2D texel) {
        texels.add(texel);
    }

    public void addNormal(Vector3D normal) {
        normals.add(normal);
    }

    public void addFaces(List<Vector3D> faces) {
        this.faces.add(faces);
    }

    @Override
    public String toString() {
        return "ModelData{" +
                "positions=" + positions +
                ", texels=" + texels +
                ", normals=" + normals +
                ", faces=" + faces +
                '}';
    }
}
