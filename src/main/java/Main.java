/**
 * Created by softish on 2017-06-30.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(args[0]);

        if(args.length < 1) {
            throw new IllegalArgumentException("Supply filename as program argument");
        }

        String filename = args[0];
        ModelAttributes modelAttributes = WavefrontReader.getObjInfo(filename);

        System.out.println(modelAttributes);
    }
}
