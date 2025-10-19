package lecture.livecoding;

public class UnitSquare extends Square {

    // private - ascunsa pentru alte clase
    // static - este unica pe clasa, accesibila din getInstance()
    private static UnitSquare instance;

    /**
     * Implementam sablonul de proiectare Singleton
     */
    private UnitSquare(int id, String name, int side) {
        super(id, name, side);
    }

    // FIXME De modificat ai sa fie "thread safe" (sa functioneze corect in cazul
    // mai multor fire de executie (eng. multi-thread)
    public static UnitSquare getInstance() {
        if (instance == null) {
            /*
            Crearea instantei de UnitSquare aici se numeste "lazy loading"
            Ideea e sa nu cream instanta inainte de a fi nevoie de ea
             */
            instance = new UnitSquare(1000, "Unit Square", 1);
        }
        return instance;
    }
}
