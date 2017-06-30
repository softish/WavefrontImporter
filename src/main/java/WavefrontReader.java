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

            for (int i = 0; i < linesOfFile.size(); i++) {
                String line = linesOfFile.get(i);
                String type = line.substring(0,2);
                line = line.replaceAll("v |vt |vn |f ", "");
                
                switch (type) {
                    case "v ":
                        modelData.addPosition(parseVector3D(line));
                        break;
                    case "vt":
                        modelData.addTexel(parseVector2D(line));
                        break;
                    case "vn":
                        modelData.addNormal(parseVector3D(line));
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
        String[] values = line.split(" ");

        double[] numbers = new double[values.length];

        for(int i = 0; i < values.length; i++) {
            numbers[i] = Double.parseDouble(values[i]);
        }

        return new Vector2D(numbers);
    }

    public static Vector3D parseVector3D(String line) {
        String[] values = line.split(" ");
        double[] numbers = new double[values.length];

        for(int i = 0; i < values.length; i++) {
            numbers[i] = Double.parseDouble(values[i]);
        }

        return new Vector3D(numbers);
    }

    public static List<Vector3D> parseFaces(String line) {
        List<Vector3D> faces = new ArrayList<>();

        String[] chunks = line.split(" ");
        for (int i = 0; i < chunks.length; i++) {
            String values = chunks[i].replace("/", " ");
            faces.add(parseVector3D(values));
        }

        return faces;
    }
}
