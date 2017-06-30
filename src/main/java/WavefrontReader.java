import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by softish on 2017-06-30.
 */
public class WavefrontReader {
    public static ModelAttributes getObjInfo(String name) {
        Path path = FileSystems.getDefault().getPath("files", name + ".obj");

        ModelAttributes modelAttributes = new ModelAttributes();
        try {
            List<String> linesOfFile = Files.lines(path).collect(Collectors.toList());

            for (String line : linesOfFile) {
                String type = line.substring(0,2);
                switch (type) {
                    case "v ":
                        modelAttributes.incrementPositions();
                        break;
                    case "vt":
                        modelAttributes.incrementTexels();
                        break;
                    case "vn":
                        modelAttributes.incrementNormals();
                        break;
                    case "f ":
                        modelAttributes.incrementFaces();
                        break;
                    default:
                        break;
                }
            }

            modelAttributes.setVertices(modelAttributes.getFaces() * 3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return modelAttributes;
    }


    public static ModelData extractObjData(String name) {
        Path path = FileSystems.getDefault().getPath("files", name + ".obj");

        ModelData modelData = new ModelData();

        try {
            List<String> linesOfFile = Files.lines(path).collect(Collectors.toList());

            for (String line: linesOfFile) {
                String type = line.substring(0,2);
                switch (type) {
                    case "v ":
                        Vector3D position = parseVector3D(line);
                        modelData.addPosition(position);
                        break;
                    case "vt":
                        Vector2D texel = parseVector2D(line);
                        modelData.addTexel(texel);
                        break;
                    case "vn":
                        Vector3D normal = parseVector3D(line);
                        modelData.addNormal(normal);
                        break;
                    case "f ":
                        modelData.addFaces(parseFaces(line));
                        break;
                    default:
                        break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return modelData;
    }

    public static Vector2D parseVector2D(String line) {
        line = line.replaceAll("v |vt |vn |f ", "");
        String[] values = line.split(" ");

        double[] numbers = new double[values.length];

        for(int i = 0; i < values.length; i++) {
            numbers[i] = Double.parseDouble(values[i]);
        }

        return new Vector2D(numbers);
    }

    public static Vector3D parseVector3D(String line) {
        line = line.replaceAll("v |vt |vn |f ", "");
        String[] values = line.split(" ");
        double[] numbers = new double[values.length];

        for(int i = 0; i < values.length; i++) {
            numbers[i] = Double.parseDouble(values[i]);
        }

        return new Vector3D(numbers);
    }

    public static List<Vector3D> parseFaces(String line) {
        line = line.replaceAll("v |vt |vn |f ", "");
        List<Vector3D> faces = new ArrayList<>();

        String[] chunks = line.split(" ");
        for (int i = 0; i < chunks.length; i++) {
            String values = chunks[i].replace("/", " ");
            faces.add(parseVector3D(values));
        }

        return faces;
    }
}
