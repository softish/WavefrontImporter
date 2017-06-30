import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by softish on 2017-06-30.
 */
public class ModelAttributesTest {
    @Test
    public void incrementPositions() throws Exception {
        ModelAttributes m = new ModelAttributes();
        m.incrementPositions();
        assertEquals(1, m.getPositions());
    }

    @Test
    public void incrementTexels() throws Exception {
        ModelAttributes m = new ModelAttributes();
        m.incrementTexels();
        assertEquals(1, m.getTexels());
    }

    @Test
    public void incrementNormals() throws Exception {
        ModelAttributes m = new ModelAttributes();
        m.incrementNormals();
        assertEquals(1, m.getNormals());
    }

    @Test
    public void incrementFaces() throws Exception {
        ModelAttributes m = new ModelAttributes();
        m.incrementFaces();
        m.incrementFaces();
        assertEquals(2, m.getFaces());
    }

}