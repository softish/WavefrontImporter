import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
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
}
