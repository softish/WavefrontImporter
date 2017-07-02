import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by softish on 2017-06-30.
 */
public class WavefrontReaderTest {
    @Test
    public void parseVector3D() throws Exception {
        Vector3D vector3D = WavefrontReader.parseVector3D("1.0 2.0 3.0");
        assertEquals(new Vector3D(1.0,2.0,3.0), vector3D);
    }

    @Test
    public void parseVector2D() throws Exception {
        Vector2D vector2D = WavefrontReader.parseVector2D("1.0 2.0");
        assertEquals(new Vector2D(1.0,2.0), vector2D);
    }

    @Test
    public void parseFaces() throws Exception {
        List<Vector3D> ref = new ArrayList<>();
        ref.add(new Vector3D(1,3,6));
        ref.add(new Vector3D(4,2,6));
        ref.add(new Vector3D(8,4,6));
        List<Vector3D> faces = WavefrontReader.parseFaces("1/3/6 4/2/6 8/4/6");
        assertArrayEquals(ref.toArray(), faces.toArray());
    }
}